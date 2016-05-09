
class SayCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "SAY";
	
	
	public void send(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			client.send(message);
		}
	}
	
	public void process(String message, IClient client, IServer server)
	{
		if(isCommand(message, COMMAND))
		{
			server.broadcast("SAY "+client.getHandle().length()+" "+client.getHandle() + message.substring(4));
		}
	}
}