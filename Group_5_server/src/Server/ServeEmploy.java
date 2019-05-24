package Server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import msg.ClientRequeste;

public class ServeEmploy {
	private Connection  connection=null;
	private Statement  stat=null;
	private ResultSet   res=null;
	private String duser="cs316373562";
	private String dpass="NONE";

	public ServeEmploy() {
		try {
			connection= (Connection) DriverManager.getConnection("jdbc:mysql://cs.telhai.ac.il/Group_5", duser, dpass);
			stat=(Statement) connection.createStatement();
		} catch (SQLException e) {
			System.err.println("Can't connect to the database");

		}
	}

	public ClientRequeste execute(ClientRequeste requ) {
		if(requ.option.equals("login")) {
			login(requ);

			return requ;
		}
		if(requ.option.equals("Status")) {
			return getstat(requ);
		}
		if(requ.option.equals("getParkName")) {
			return getParkName(requ);
		}

		if(requ.option.equals("getreport")) {
			getreport(requ);
			return requ;
		}

		if(requ.option.equals("setUpParking")) {
			return setUpPark(requ); 	
		}

		if(requ.option.equals("corib"))
			setcorib(requ);

		if(requ.option.equals("save"))
			save(requ);

		if(requ.option.replaceAll("\n ", "").equals("sinup"))
			return addemploy(requ);

		if(requ.option.equals("changeRatesForPayment")){
			changeRatesForPayment(requ);		
		}
		if(requ.option.equals("changeRatesRequest")){
			changeRatesForPaymentRequest(requ);
		}
		if(requ.option.equals("getChangeRatesRequests")){
			return getchangeRatesRequests(requ);
		}
		
		return requ;


	}


	private ClientRequeste getchangeRatesRequests(ClientRequeste requ) {
		try {
			requ.ratesRequests = new Vector<>();
			res=stat.executeQuery("select * from changeRatesRequest;");
			res.beforeFirst();
			while(res.next()) {
				Vector<String> v = new Vector<>();
				v.add(res.getString("ManagerName"));
				v.add("The parking manager: " + res.getString("ManagerName")
						+ " requested to change the rates for payment as follow: \n"
						+ "Causual: " + res.getString("Causual") +"\n"
						+ "OneTime: " + res.getString("OneTime") +"\n"
						+ "Monthly: " + res.getString("Monthly"));
				requ.ratesRequests.add(v);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requ;
	}

	private void changeRatesForPaymentRequest(ClientRequeste requ) {
		try {
			stat.executeUpdate("insert into changeRatesRequest (ManagerName,Causual,OneTime,Monthly)values(\""+requ.clientID+"\","+
								requ.causual +","+ requ.oneTime + ","+ requ.monthly +");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private ClientRequeste getParkName(ClientRequeste requ) {
		try {
			ResultSet parkingName = stat.executeQuery("select ParkingName from Employees where userid =  \"" + requ.clientID + "\";");
			parkingName.beforeFirst();
			parkingName.next();
			requ.parkingName = parkingName.getString("ParkingName");
			return requ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private ClientRequeste getstat(ClientRequeste requ) {

		try {

			requ.ParkingStatus = new Vector<Vector<Integer>>();
			ResultSet sizeInfo = stat.executeQuery("select Hieght,Width,Depth from ParkingBranchs where Name =  \"" + requ.parkingName + "\";");			
			sizeInfo.beforeFirst();
			sizeInfo.next();
			int Hieght = sizeInfo.getInt("Hieght");			
			int Width = sizeInfo.getInt("Width");
			int Depth = sizeInfo.getInt("Depth");
			ResultSet parkingVector = stat.executeQuery("select floor,row,place,carNumber,isProblem,isSaved from " + requ.parkingName+";");
			parkingVector.beforeFirst();

			while(parkingVector.next()) {
				int floor = parkingVector.getInt("floor");
				int row = parkingVector.getInt("row");
				int place = parkingVector.getInt("place");
				int status;
				String carExist = parkingVector.getString("carNumber");
				if(carExist == null) status = 0;
				else status = 1;
				if(parkingVector.getInt("isProblem") !=0 ) status = 2;
				else if(parkingVector.getInt("isSaved") !=0 ) status = 3;

				Vector<Integer> newPlace = new Vector<>();
				newPlace.add(Hieght);
				newPlace.add(Width);
				newPlace.add(Depth);
				newPlace.add(floor);
				newPlace.add(row);
				newPlace.add(place);
				newPlace.add(status);
				requ.ParkingStatus.add(newPlace);

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requ;
	}

	private void changeRatesForPayment(ClientRequeste requ) {

		try {
			stat.executeUpdate("update Payment set Causual="+requ.causual +", OneTime ="+requ.oneTime
					+", Monthly ="+requ.monthly+" where ParkingName= \"" + requ.parkingName +"\";");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private ClientRequeste addemploy(ClientRequeste requ) {
		String usr="'"+requ.userid+"'";	
		String pass="'"+requ.pass+"'";
		String role="'"+requ.role+"'";
		String parkName = "'" + requ.parkingName + "'";
		try {
			res=stat.executeQuery("select * from Employees where userid="+usr);
			if(res.next()) {
				requ.seccess=false;
				return requ;
			}else {
				try {
					stat.executeUpdate("insert into Employees (userid,pass,Role,Online,ParkingName)values("+usr+","+pass+","+role+ ","+ 0+ "," +parkName +");" );
					requ.seccess=true;
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
					requ.seccess=false;
				}

			}

		} catch (SQLException e) {
			try {
				System.out.println(e.getMessage());
				stat.executeUpdate("insert into Employees (userid,pass,Role)values("+usr+","+pass+","+role+");" );
				requ.seccess=true;
			} catch (SQLException e1) {
				requ.seccess=false;
			}
		}

		return requ;
	}

	private void save(ClientRequeste requ) {
		try {
			int floor=requ.floor;
			int row=requ.row;
			int place=requ.place;
			stat.executeUpdate("update " + requ.parkingName + " set isSaved=1 where floor = " + floor + " and row = " + 
					row +" and place = " + place + ";");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}



	private void setcorib(ClientRequeste requ) {
		try {
			int floor=requ.floor;
			int row=requ.row;
			int place=requ.place;
			stat.executeUpdate("update " +requ.parkingName +" set isProblem=1 where floor = " + floor + " and row = " + 
					row +" and place = " + place + ";");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}


	/***** NEW*****/
	public ClientRequeste setUpPark(ClientRequeste request)
	{
		res=null;
		try {		
			stat.executeUpdate("drop table " + request.parkingName + "Parking" );
			stat.executeUpdate("create table " + request.parkingName + "Parking(floor int , row int, place int ,carNumber varchar(16),userID varchar(80),isProblem int,isSaved int);");
		} catch (SQLException e) {
			try {
				stat.executeUpdate("create table " + request.parkingName + "Parking(floor int , row int, place int ,carNumber varchar(16),userID varchar(80),isProblem int,isSaved int);");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		request.respons="Setting up the parking \"" + request.parkingName + "\" done successfully";
		try {
			stat.executeUpdate("insert into ParkingBranchs(Name,Hieght,Width,Depth)values("+ "\"" + request.parkingName +"Parking\"" +"," +
					request.hight + "," + request.width + "," + request.depith +");");
			stat.execute("insert into Payment(ParkingName)values(\""+ request.parkingName + "\");");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		char c=64;
		for(int h=0;h<request.hight;h++) {
			c++;
			for(int d=0;d<request.depith;d++) {
				for(int w=0; w<request.width; w++) {
					try {
						stat.executeUpdate("insert into " + request.parkingName + "Parking" +"(floor,row,place,carNumber,userID,isProblem,isSaved)" + 
								"values("+h +","+ d +","+w +","+request.carnumber + ","+request.userid+","+0+","+0+");");
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		return request;
	}


	public void  getreport(ClientRequeste msg) {

		try {
			res=stat.executeQuery("select * from reports;");
			msg.report=new HashMap<String ,String>();
			while(res.next()) {
				msg.report.put(res.getString("userid"), res.getString("report"));
			}

			if(msg.report.size()==0)
				msg.report.put("No new Reports", "");
			else {
				stat.executeUpdate("delete from reports;");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public String login(ClientRequeste msg) {

		try {
			res=stat.executeQuery("select * from Employees;");
			while(res.next()) {

				if(res.getString("userid").replaceAll("\n ", "").equals(msg.userid.replaceAll("\n ", ""))) {		
					if(res.getString("pass").replaceAll("\n ", "").equals(msg.pass.replaceAll("\n ", ""))) {
						msg.role=res.getString("Role");
						msg.seccess=true;
						return "";
					}
				} }

		} catch (SQLException e) {
			System.out.println("Erorr sql error sentaxs\n"+e.getMessage());
		}
		msg.seccess=false;
		msg.role="NN";
		return "NN"; 
	}
}