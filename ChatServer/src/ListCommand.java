class ListCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "LIST";
	private String list = "";
	
	public void send(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			client.send(list);
		}
	}
	
	public void process(String message, IClient client, IServer server)
	{
		if(isCommand(message, COMMAND))
		{
			IClient[] temp = server.getClients();
			list = "LIST ";
			for(int i = 0; i < temp.length; i++)
			{
				list += temp[i].getHandle().length() +" "+ temp[i].getHandle();
			}
			System.out.println("Sending list" + list );
			client.send(list);
		}
	}
}