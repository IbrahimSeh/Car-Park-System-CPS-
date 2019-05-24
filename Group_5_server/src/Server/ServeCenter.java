package Server;
import msg.ClientRequeste;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServeCenter implements Runnable{
	 private ObjectOutputStream output=null;
	 private ObjectInputStream  input=null;
	 private Socket Client=null;
	 private boolean isclient=true;
	 private String username=null;
	 private String pass=null;
	 private char type='c';
	 private ClientRequeste msg=null;
	private ArrayList<ClientRequeste >rceved=null;
	
	 public  ServeCenter(Socket toserve) {
       
       try {
    	   Client=toserve;  
         rceved=new ArrayList<ClientRequeste>();
    	 output=new ObjectOutputStream(Client.getOutputStream());
         input=new ObjectInputStream(Client.getInputStream());

       
   	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void kill() {
		try {
			Client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	synchronized public ClientRequeste RceveMassege() {
		System.out.println("ok line 44");
		ClientRequeste rec=null;
		System.out.println(rceved.size());
		if(rceved.size()<=0) {
		
			rec=new ClientRequeste();
			rec.Notemsg=true;
			System.out.println("adsad line 48");
		}else {
			System.out.println(rceved.size());
		 System.out.println( rceved.get(0));
			if(rec==null)
				System.out.println("eroor");
			System.out.println("aaa "+rec.option);
			rceved.remove(0);
		}
			return rec;
		
			
	}

	public void giveserver(ClientRequeste msg) {
			
		if(msg.Notemsg==false) {
		if(msg.type=='c') {
			ServeClient client=new ServeClient();
			SendToClient(client.execute(msg));
			
		}
			
		else if(msg.type=='e');
		  ServeEmploy employ=new ServeEmploy();
		  SendToClient(employ.execute(msg));
			
		}
		
		
		}
	
	public void SendToClient(ClientRequeste msg) {
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
	
	
	public void MassegeHandler(ClientRequeste msg) {
		rceved.add(msg);
	}
	
	@Override
	public void run() {
     while(Client.isConnected()) {
    	 try {
				
				ClientRequeste rc=(ClientRequeste) input.readObject();
			    giveserver(rc);
				
			} catch (ClassNotFoundException | IOException e) {
				// System.out.println("connection cloased by the client ");
			}
			
		}
		
     }
	}



