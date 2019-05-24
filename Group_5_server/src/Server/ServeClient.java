package Server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import msg.ClientRequeste;

public class ServeClient {
 private Connection  connection=null;
 private Statement  stat=null;
 private ResultSet   res=null;
 private String duser="cs316373562";
 private String dpass="NONE";
 public ServeClient() {
	 try {
		connection= (Connection) DriverManager.getConnection("jdbc:mysql://cs.telhai.ac.il/Group_5", duser, dpass);
		stat=(Statement) connection.createStatement();
	} catch (SQLException e) {
	   System.err.println("Can't connect to the database");
	   
	}
 }
 
 public ClientRequeste execute(ClientRequeste requ) {
    System.out.println(requ.option);
	if(requ.option.equals("login")) {
		if(login(requ)) {
		requ.seccess=true;
		requ.respons="login seccess !!";
		return requ;}
	}
	
	requ.seccess=false;
	return requ;
		
	 
 }
 
 public boolean login(ClientRequeste msg) {
	 
	 try {
		res=stat.executeQuery("select * from UserData;");
			while(res.next()) {
			
		if(res.getString("username").replaceAll("\n ", "").equals(msg.userid.replaceAll("\n ", ""))) {		
			if(res.getString("pass").replaceAll("\n ", "").equals(msg.pass.replaceAll("\n ", "")));
					return true;
		} }
		
	 } catch (SQLException e) {
		System.out.println("Erorr sql error sentaxs");
	}
	 
	return false; 
 }
}
