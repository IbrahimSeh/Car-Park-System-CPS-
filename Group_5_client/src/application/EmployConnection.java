package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import msg.ClientRequeste;

public class EmployConnection implements Runnable {
	 private Socket server=null;
	 //private String Serverip="11.1.2.147";
	 private String Serverip;
	 private int port=3000;//8888;
	 private List receved=null;
	 private ObjectInputStream input=null;
	 private ObjectOutputStream output=null;
	 private Thread runer=null;
	 private boolean close=true;
	 
	public  EmployConnection() {
	     runer=new Thread(this);
	     receved=new ArrayList<>();
	}
	
	public void OpenConnect() {
		try {
			Serverip = "127.0.0.1";
			server=new Socket(Serverip, port);
			int timer=0;

			while(!(server.isConnected())&&timer<500) 
				timer++;

			if(timer>=500)
            	throw new TimeoutException();
			
			output=new ObjectOutputStream(server.getOutputStream());
			output.flush();
			input=new ObjectInputStream(server.getInputStream());
			close=false;
			runer.start();
		}
		catch(TimeoutException to) {
			System.err.println("Error : Connection TimeOut the server is not "
					+ "response please try agine later ");
		}
		
		catch(IOException err) {
			System.out.println("Error : Can't open connection with the server  "+Serverip+" in port# "+port);
		}
	}
	
	public boolean isConnected() {
	return (server!=null)?server.isConnected()&(!(close)):false;	
	}
	
	public void close() {
		try {
		close=true;
		runer=null;
		input.close();
		output.close();
		if(server.isConnected())
		server.close();
		}catch(IOException e) {
			System.err.println("Error:Can't close connection ..");
		}
	}
	
	public void SendToServer(ClientRequeste msg) {
		if(output==null) {
			System.err.println("Error : please make sure you have connection to the server !!");
		    return;
		}
		
			try {
				output.writeObject(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ClientRequeste RceveMassege() {
		ClientRequeste rec=null;
		int total=0;
		while(total<10000&&receved.size()==0) {
			
		try {
			Thread.sleep(100);
			total+=100;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(receved.size()==0)
			return null;
			
		rec=(ClientRequeste) receved.get(0);
			receved.remove(0);
		
			return rec;
		
			
	}
	public void MassegeHandler(Object msg) {
		receved.add(msg);
	}
	
	@Override
	public void run() {
		
		while(close==false&&server.isConnected()) {
			try {
				Object rc=input.readObject();
				MassegeHandler(rc);
			} catch (ClassNotFoundException | IOException e) {
			}			
		}		
		close();
	}
}
