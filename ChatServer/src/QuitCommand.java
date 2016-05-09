
class QuitCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "QUIT";
	
	
	public void send(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			client.send("DISCONNECT");
		}
	}
	
	public void process(String message, IClient client, IServer server)
	{
		if(isCommand(message, COMMAND))
		{
			client.send("DISCONNECT");
			server.broadcast("REMOVE "+client.getHandle().length()+client.getHandle());
			server.remove(client);
			for(IClient c : server.getClients()){
				System.out.println(c.getHandle());
				c.process("LIST");
			}
			client.stop();
		}
	}
}