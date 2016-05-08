import java.net.*;
import java.util.*;
import java.io.*;

public class ServerSideClient  implements Runnable, IClient
{
	
    public ServerSideClient(int id, IServer server, Socket socket) throws IOException
    {
    	
    }
    
    public String getHandle()
    {
    	return null;
    }
    
    public void setHandle(String h)
    {

    }
    
    public void addNetworkListener(INetworkListener listener)
	{
		
	}
    
    public int getId()
    {
    	return -1;
    }
    
    public void run()
    {
    	
    }
    
    public void stop()
    {

    }
    
    //data from server (to client)
    public void send(String data)
    {

    }
    
    //data from client (to server)
    public void process(String message)
    {
    	
    }
    
    
}