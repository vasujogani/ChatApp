import java.net.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Server implements Runnable, IServer
{
	private int port;
	private boolean running;
	private List<IClient> clientList;
	private File file;
	private int id;
	
	public static void main(String[] args)
	{
		try{
			System.out.println("Beginning the server");
			Server server = new Server(19);
			Thread t = new Thread(server);
			t.start();
		}catch(Exception e){
			System.out.println("Server cannot used the current port.");
		}
	}
	
    public Server(int port) 
    {
    	this.port = port;
    	this.running = true;
    	clientList = new ArrayList<IClient>();
    	file = new File("login.txt");
    	this.id = 0;
    }
    
    public IClient[] getClients()
    {
    	return clientList.toArray(new IClient[]{});
    }
    
    public void broadcast(String data)
    {
    	System.out.println("Broadcasting: " + data);
    	for(int i = 0; i < clientList.size(); i++)
    		clientList.get(i).send(data);
    }
    
    public void remove(IClient c)
    {
    	for(int i = 0; i < clientList.size(); i++){
    		if(clientList.get(i).getId() == c.getId()){
    			clientList.remove(i);
    		}
    	}
    }

    public void run()
    {
    	try{
    		ServerSocket listener = new ServerSocket(port);
    		System.out.println("IP connected to: " + InetAddress.getLocalHost());
    		while(running){
    			Socket clientSocket = listener.accept();
    			IClient client = new ServerSideClient(this, clientSocket, nextID());
    			clientList.add(client);
    			this.addListener(client);
    		}
    	}catch(Exception e){
    		System.out.println("Error in the Server class is : " + e.getMessage());
    		e.printStackTrace();
    	}	
    }
    
    public void stop()
    {
    	running = false;
    }
    public void addListener(IClient c)
    {
    	System.out.println("Adding listeners");
    	c.addNetworkListener(new QuitCommand());
    	c.addNetworkListener(new SayCommand());
    	c.addNetworkListener(new ListCommand());
    	c.addNetworkListener(new SetHandleCommand());
    }
    public File getFile()
    {
    	return file;
    }
    public int nextID(){
    	return id++;
    }
}