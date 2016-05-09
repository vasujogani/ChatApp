import java.net.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class ServerSideClient  implements Runnable, IClient
{
	private static int id = 0;
	private int ID;
	private List<INetworkListener> listeners;
	private Socket socket;
	private IServer server;
	private boolean running;
	private BufferedReader reader;
	private String name;
	private PrintWriter out;
	private LoginInfo identity;
	private boolean checkedIn;
	
    public ServerSideClient(IServer server, Socket s, int i) throws IOException
    {
    	ID = i;
    	this.socket = s;
    	this.server = server;
    	this.running = true;
    	listeners = new ArrayList<INetworkListener>();
    	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	out = new PrintWriter(socket.getOutputStream(),true);
    	System.out.println("ID for this user is :  " + ID);
    	Thread t = new Thread(this);
		t.start();
    }
    public String getHandle()
    {
    	return name;
    }

    public void setHandle(String h)
    {
    	this.name = h;
    }
    
    public void addNetworkListener(INetworkListener listener)
	{
    	listeners.add(listener);
	}
    
    public void changeId()
    {
    	id++;
    }
    public int getId()
    {
    	return this.ID;
    }
    public void run()
    {
    	while(running){
    		try{
    		process(reader.readLine());
    		}catch(Exception e){
    			System.out.println("Error in Server Side Client" + e.getMessage());
    			stop();
    			server.remove(this);
    		}
    	}
    }
    
    public void stop()
    {
    	running = false;
    }
    
    //data from server (to client)
    public void send(String data)
    {
    	out.println(data);
    }
    
    //data from client (to server)
    public void process(String message)
    {
    	System.out.println("Message recieved is " + message);
    	if(message.contains("CHECK")){
    		if(this.check(message)) {
    			System.out.println("The user is Logined in the System!");
    			for(IClient c : server.getClients())
    			{
    				if(!(c.getHandle().equals(this.getHandle())))
    					c.send("ADD " + this.getHandle());
    			}
    		}
    		else{
    			this.stop();
    			server.remove(this);
    		}
    	}
    	for(int i = 0; i < listeners.size(); i++)
    		listeners.get(i).process(message, this, server);
    }
    
    public boolean check(String m)
    {
    	String[] s = m.split(" ");
    	int n = Integer.parseInt(s[1]);
    	if(n==1){
    		this.setLoginInfo(new LoginInfo(s[2],s[3]));
    		return true;
    	}
    	else if(n==0)
    	{
    		return this.findmatch(m);
    	}
    	return false;
    		
    }
    public void setLoginInfo(LoginInfo l)
    {
    	this.identity = l;
    	if(!server.getFile().exists()){
    		System.out.println("File cannot be accessed rn.");
    	}
    	else{
    		FileOutputStream fout;
    		
			try {
				fout = new FileOutputStream(server.getFile(), true);
				PrintWriter writer = new PrintWriter(fout);
				writer.println(l.save());
				writer.flush();
				writer.close();
				this.name = l.getUsername();
				System.out.println("Appending new stuff to file");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(IClient c : server.getClients())
				c.process("LIST");
    	}
    }
    public LoginInfo getLoginInfo()
    {
    	return identity;
    }
    
    public boolean findmatch(String s){
    	String[] todo = s.split(" ");
    	Scanner scanner;
		try {
			scanner = new Scanner(server.getFile());
	    	while(scanner.hasNextLine()){
	    		String temp = scanner.nextLine();
	    		String[] read = temp.split(" ");
	    		System.out.println("read is "+  read[0]  + " "  + read[1]);
	    		System.out.println("todo is "+ todo[2]  + " " + todo[3]);
	    		if((new LoginInfo(read[0],read[1])).compareTo(new LoginInfo(todo[2], todo[3]))==1)
	    		{
	    			this.name = read[0];
	    			System.out.println("Found match");
	    			return true;
	    		}
	    	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Username/password didn't match!");
		this.stop();
    	return false;
    }
    
}