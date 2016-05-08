
class QuitCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "QUIT";
	
	public void send(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{

		}
	}
	
	public void process(String message, IClient client, IServer server)
	{
		if(isCommand(message, COMMAND))
		{

		}
	}
}