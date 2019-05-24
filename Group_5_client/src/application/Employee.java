package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import msg.ClientRequeste;

public class Employee {
	
	
	/**
	 * @param userID
	 * @param password
	 * @return : role of the employee that will sign in
	 */
	public String  signIn(String userID, String password) {		
		
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		msg.userid=userID;
		msg.pass=password;
		msg.option="login";
		server.SendToServer(msg);
		msg=server.RceveMassege();
		System.out.println(msg.role);
		server.close();
		if(msg==null)
			return "NN";
		return msg.role;
		
	}

	
	/**
	 * @param placeNum : Number of the wanted place to mark that has a problem
	 */
	//car parking employee mark a certain place in the parking that has a problem to tell the system
	//not to put cars in this place
	public void MarkProblemInCertainPark(String parkName,String floorNum, String rowNum, String placeNum){
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		System.out.println("aaaa");
		System.out.println(floorNum);
		System.out.println(Integer.parseInt(floorNum));
		msg.floor=Integer.parseInt(floorNum);
		msg.row=Integer.parseInt(rowNum);
		msg.place = Integer.parseInt(placeNum);
		msg.option="corib";
		msg.parkingName = parkName;
		server.SendToServer(msg);
		System.out.println(msg.option);
		msg=server.RceveMassege();
		server.close();
		
	}

	
	
	/**
	 * @param placeNum : Number of the wanted place to save 
	 */
	//the car parking employee want to save a certain place in the car parking
	public void SaveParkingPlace(String parkName,String floorNum, String rowNum, String placeNum){
		
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		msg.floor=Integer.parseInt(floorNum);
		msg.row=Integer.parseInt(rowNum);
		msg.place = Integer.parseInt(placeNum);
		msg.option="save";
		msg.parkingName = parkName;
		server.SendToServer(msg);
		System.out.println(msg.option);
		msg=server.RceveMassege();
		server.close();

	}



	/**
	 * @param parkingName : name of the new car parking branch
	 * @param depth : rows' number in each floor
	 * @param width : places' number in each row
	 * @param height : floors' number
	 * @return : result of setup, failed or succeeded
	 */
	//you have to check if there is a car parking branch with the name "parkingName", if it exist
	//return a string to the client that says that can't set up because the name is already exist
	//else return that the set-up done successfully
	public String SetUpForNewPark( String depth, String width, String height){
		
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		msg.option="setuppark";
		msg.depith=Double.parseDouble(depth);	
		msg.hight=Double.parseDouble(height);
		msg.width=Double.parseDouble(width);
		server.SendToServer(msg);
		msg=server.RceveMassege();
		if(msg==null)
			return "connection refused please check if you have internet connection!!";
		return msg.respons;
		
	}

	
	/**** new ***/
	public String SetUpNewParking(String parkingName, String depth, String width, String height) {
		EmployConnection connection = new EmployConnection();
		connection.OpenConnect();
		ClientRequeste request = new ClientRequeste();
		request.type = 'e';
		request.option = "setUpParking";
		request.parkingName = parkingName;
		request.depith = Double.parseDouble(depth);
		request.width = Double.parseDouble(width);
		request.hight = Double.parseDouble(height);
		connection.SendToServer(request);
		request = connection.RceveMassege();
		if(request == null)
			return "Connection refused, please check if you have internet connection!!";
		return request.respons;		
	}
	
	/**
	 * @param ClientID : Id of the client that will have the compensation
	 * @param compensationAmount : how much money will receive
	 */
	//compensate the client that send a report 
	//enter the compensation to the client account in the system
	public void CompensateClient(String ClientID, String compensationAmount){

	}

	
	/**
	 * @param casualParking : pay x shekels for hours
	 * @param oneTimeParking : pay x shekels for hours
	 * @param monthlySubsc : hours' number of "one time parking"
	 */
	//change the payment for each order's kind
	public void SettingTheRatesForPayment(String parkName, String casualParking, String oneTimeParking, String monthlySubsc){
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		msg.option="changeRatesForPayment";
		msg.causual=Double.parseDouble(casualParking); 
		msg.oneTime=Double.parseDouble(oneTimeParking); 
		msg.monthly=Double.parseDouble(monthlySubsc);  
		msg.parkingName = parkName;
		server.SendToServer(msg);
		msg=server.RceveMassege();
		
	}

	/**
	 * @param employee_id : employee id 
	 * @param FirstName
	 * @param LastNanme
	 * @param Email : employee_id@group5.cps
	 * @param Role : position in the company
	 * @param ParkingLot : name of the car parking  branch the the new employee will work in
	 */
	//check if the id already exist in the database, if it exist return false
	//else add the new employee to the database and return true;
	public boolean AddNewEmployee(String employee_id, String password,String role,String ParkingName){
		
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.option="sinup";
		msg.role=role;
		msg.userid=employee_id;
		msg.pass=password;
		msg.parkingName=ParkingName;
		msg.type='e';
		server.SendToServer(msg);
		msg=server.RceveMassege();
		
		if(msg==null)
			return false;
		return msg.seccess;

	}

	/**
	 * @param ParkingName : the name of the car parking branch
	 */
	public Vector<Vector<Integer>> currentParkingStatus(String parkingName){
		EmployConnection connection=new EmployConnection();
		connection.OpenConnect();
		ClientRequeste request = new ClientRequeste();
		request.option = "Status";
		request.type = 'e';
		request.parkingName = parkingName;
		connection.SendToServer(request);
		request = connection.RceveMassege();
		if(request == null)
			return null;
		return request.ParkingStatus;
		
	}

	public HashMap<String, String> GetRepo(){
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.option="getreport";
		msg.type='e';
		server.SendToServer(msg);
		msg=server.RceveMassege();
		if(msg==null) {
			HashMap< String, String>ss=new  HashMap<String,String>();
			ss.put("Connection error", "");
			return ss;
			 
		}
		return msg.report;		
		
	}


	public String getParkingNameOfEmployee(String userID) {
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.clientID=userID;
		msg.option = "getParkName";
		msg.type='e';
		server.SendToServer(msg);
		msg=server.RceveMassege();
		return msg.parkingName;
		
	}


	public void sendChangeRangesRequest(String parkManager,String parkName, String casualParking, String oneTimeParking, String monthlySubsc) {
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		msg.option="changeRatesRequest";
		msg.causual=Double.parseDouble(casualParking); 
		msg.oneTime=Double.parseDouble(oneTimeParking); 
		msg.monthly=Double.parseDouble(monthlySubsc);  
		msg.parkingName = parkName;
		msg.clientID = parkManager;
		server.SendToServer(msg);
		msg=server.RceveMassege();
		
	}


	public Vector<Vector<String>> getChangeRatesRequests() {
		EmployConnection server=new EmployConnection();
		server.OpenConnect();
		ClientRequeste msg=new ClientRequeste();
		msg.type='e';
		msg.option="getChangeRatesRequests";
		server.SendToServer(msg);
		msg=server.RceveMassege();
		return msg.ratesRequests;
	}
}

