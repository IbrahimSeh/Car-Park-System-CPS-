package msg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

public class ClientRequeste implements Serializable{
	private static final long serialVersionUID = 1L;

	public char type='x';
	public String role=null;
	public boolean Notemsg=false;
	public String userid=null;
	public String pass=null;
	public String carnumber=null;
	public String startdat=null;
	public String enddate=null;
	public String starttime=null;
	public String endtime=null;
	public String requstedpark=null;
	public String orderId=null;
	public String option=null;
	public String respons=null;
	public String clientID = null;
	public Vector<Vector<String>> ratesRequests = null;
	public boolean seccess=false;
	public HashMap<String, String>report=null;
	public Integer floor=0;
	public Integer row=0;
	public Integer place=0;
	public double width=0;
	public double depith=0;
	public double hight=0;
	public double causual = 0;
	public double oneTime = 0;
	public double monthly = 0;
	public String parkingName = null;
	 public Vector<Vector<Integer>> ParkingStatus=null;
			
			
}
