package application;
import msg.ClientRequeste;
public class Client {

	private ClientConnection server=new ClientConnection();
	private ClientRequeste msg=null;
	/*********************************/

	public Client() {

	}


	/********************************/
	//add new client
	//if the user name exist in the data base return false
	//else add the new client and return true
	public boolean sign_up(String userid, String password) {

		server.OpenConnect();
		msg=new ClientRequeste();
		msg.userid=userid;
		msg.pass=password;
		msg.type='c';
		msg.option="connect";
		server.SendToServer(msg);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.seccess;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return false;
			}
			server.close();
			return msg.seccess;
		}

	}


	//check if UserID and password exist in the database
	//if exists return true, else return false; 
	public boolean connect(String userid, String password) {
		server=new ClientConnection();
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.userid=userid;
		msg.pass=password;
		msg.type='c';
		msg.option="login";
		server.SendToServer(msg);

		
		msg=server.RceveMassege();
		
		if(msg==null)
			return false;
		server.close();
		return msg.seccess;
		
	}


	//check if can parking in the wanted time and the wanted branch 
	//if the order ok return true , else return false
	public boolean parking_order(String userid,String carNumber, String startDate, String startTime, String endDate, String endTime, String requestedPark) {
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.carnumber=carNumber;
		msg.startdat=startDate;
		msg.enddate=endDate;
		msg.endtime=endTime;
		msg.requstedpark=requestedPark;
		msg.type='c';
		msg.option="parkingorder";
		server.SendToServer(msg);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.seccess;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return false;
			}
			server.close();
			return msg.seccess;
		}

	}

	//check if can parking in the wanted time and return string that have the result
	public String parkingOrderLocalPark(String userid,String carNumber, String startDate, String startTime, String endDate, String endTime) {  
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.carnumber=carNumber;
		msg.startdat=startDate;
		msg.enddate=endDate;
		msg.endtime=endTime;
		msg.type='c';
		msg.option="parkingorderlocalpark";
		server.SendToServer(msg);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}

	}

	public String oneTimeParkingOrder(String userid,String carNumber, String startDate, String startTime, String endDate, String endTime, String requestedPark) {
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.carnumber=carNumber;
		msg.startdat=startDate;
		msg.enddate=endDate;
		msg.endtime=endTime;
		msg.type='c';
		msg.option="onetimeparkingorder";
		server.SendToServer(msg);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}

	}


	//end date is 28 days after the start date
	public String subscribeMonthly(String userid,String carNumber, String startDate) {
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.carnumber=carNumber;
		msg.startdat=startDate;
		msg.type='c';
		msg.option="subscribemonthly";
		server.SendToServer(msg);

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}

	}



	//if there is no order with the car Number = "carNum" return string that there is no order for this carNum
	//if the car came before start time then say that YOU CAME EARLY Sorry!
	//if the car came in the time that is in the order then insert to the parking and say that the the car was parked successfully!
	public String insertTheCar(String carNum) {
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.carnumber=carNum;
		msg.type='c';
		msg.option="inserthecar";
		server.SendToServer(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}

	}


	//if there is no car with the same carNum then say that there is no car with the passed car number.
	//if the car is in the parking then exit it and say that the the car was exited  successfully!
	public String takeOutTheCar(String carNum) {

		server.OpenConnect();
		msg=new ClientRequeste();
		msg.carnumber=carNum;
		msg.type='c';
		msg.option="takeoutthecar";
		server.SendToServer(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}
	}

	//if there is no order with the id = "orderID" return string that says  there is no order by the orderID you passed
	//else calculate how much hours still for parking start and calculate how much compensation get and return string that 
	//show to the client how much compensation will get and the order is cancelled
	public String cancel_order(String orderID) {

		server.OpenConnect();
		msg=new ClientRequeste();
		msg.orderId=orderID;
		msg.type='c';
		msg.option="cancelorder";
		server.SendToServer(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}   
	}


	//if there is no order with the id = "orderID" return string that says  there is no order by the orderID you passed
	//else return the status of the parking
	//status contains : start time, end time, location in the parking...
	public String checkOrderStatus(String orderID) {
		server.OpenConnect();
		msg=new ClientRequeste();
		msg.orderId=orderID;
		msg.type='c';
		msg.option="checkorderstatus";
		server.SendToServer(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}  
	}


	//if there is no order with the id = "orderID" return string that says  there was no order by the orderID you passed
	//else return that the report will be in check
	public String send_report(String orderID) {

		server.OpenConnect();
		msg=new ClientRequeste();
		msg.orderId=orderID;
		msg.type='c';
		msg.option="sendreport";
		server.SendToServer(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg=server.RceveMassege();
		if(msg.Notemsg){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.close();
			return msg.respons;
		}
		else{
			msg=server.RceveMassege();
			if(msg.Notemsg){
				server.close();
				return msg.respons;
			}
			server.close();
			return msg.respons;
		}   
	}

}
