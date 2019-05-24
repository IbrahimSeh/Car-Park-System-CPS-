package Server;

public class Main2 {

		public static void main(String[] args) {
			if(args.length!=2) {
				System.err.println("Usage Error: please insert ip address and port# you want to bind to !!");
				System.exit(-1);
			}
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			   System.err.println("Error : Can't load thr jdvc Driver "
			   		+ "please make sure you add it to the projct ");
			   return ;
			}
			
			Server server=new Server(args[0], Integer.parseInt(args[1]));
			server.Listeining();
		}
}


