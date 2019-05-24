package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

	private ServerSocket server=null;
	private ArrayList<Thread> ActiveThreads=null;   // the working threads max 50 
	private ArrayList<ServeCenter> WaitingClients=null;
	private boolean ShutDown=true;
	private int TimeOut=500;
	private Socket Client=null;
	private String HostNmae=null;
	private int port=0;
	private Thread Runer=null;
	public Server(String hostname,int port) {
		this.port=port;
		this.HostNmae=hostname;
		this.ActiveThreads=new ArrayList<Thread>();
		this.WaitingClients=new ArrayList<ServeCenter>();
		this.Runer=new Thread(this);
		}
	public void Listeining() {
		try {
			server=new ServerSocket();
			server.bind(new InetSocketAddress(HostNmae, port));
			server.setSoTimeout(TimeOut);
			ActiveThreads.clear();
			WaitingClients.clear();
			ShutDown=false;
			Runer.start();
			listened();
		
		} catch (IOException e) {
			System.err.println("Error : Can't bind to address "+HostNmae+" with port "+port); 
		    System.exit(-1);
		}
		
			
		
	}
	
	public boolean islisteninig() {
	if(server!=null &&server.isBound()&&!ShutDown)
		return true;
	return false;
	}
	
	public void listened() {System.out.println("Server up in address"+server.getLocalSocketAddress().toString());}
	public void Shutdowned() {System.out.println("Server is Down ");}
	public void ShutDown() {CloseAll();Shutdowned();}
 	
	public void CloseAll()  {
		try {
		ShutDown=true;
	if(server!=null && !server.isClosed())
		server.close();
	 for(int i=0;i<ActiveThreads.size();i++) {
		ActiveThreads.get(i).interrupt();  // give the thread interrupt to kill him self
	for(int j=0;j<WaitingClients.size();j++)
		WaitingClients.get(j).kill();
	Runer=null;
	 }
	    
		}catch(IOException err) {
			
		}
	
	}
	
	
	@Override
	public void run() {
		ServeCenter center=null;
		int avilcount=0;
		while(!ShutDown ) {
			try {
				Client=server.accept();
				System.out.println("ACCEPT");
				center=new ServeCenter(Client);
			    WaitingClients.add(center);
			    
			    for(int i=0;i<ActiveThreads.size();i++) {  // remove dieth treads 
			    	if(!ActiveThreads.get(i).isAlive()) {
			    		ActiveThreads.remove(i);
			    	}
			    }
			     avilcount=50-ActiveThreads.size();          // new theads 
			     
			     for(int j=0;j<avilcount && !WaitingClients.isEmpty();j++) {
			    	 center=WaitingClients.get(0);
			    	 WaitingClients.remove(0);
			    	 Thread tmp=new Thread(center);
			    	 tmp.start();
			    	 ActiveThreads.add(tmp);
			    	
			     }
			
			  
			
			} catch (IOException e) {
			
			}
		}
		
		CloseAll();
	}
	

}
