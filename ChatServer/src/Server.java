import java.net.*;
import java.util.*;
import java.io.*;

public class Server implements Runnable, IServer
{
	public static void main(String[] args)
	{
		Server server = new Server();
		Thread t = new Thread(server);
		t.start();
	}
	
	
	
    public Server() 
    {
    	
    }
    
    public IClient[] getClients()
    {
    	return null;
    }
    
    public void broadcast(String data)
    {
    	
    }
    
    public void remove(IClient c)
    {
    
    }
    
    public void run()
    {
    	
    }
    
    public void stop()
    {
    	
    }
    
}