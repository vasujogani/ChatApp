
class SetHandleCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "SETHANDLE";
	
	//processing the sethandle
	public void process(String message, IClient client, IServer server)
	{
		if(isCommand(message, COMMAND))
		{
			boolean matched = false;
			for(IClient c : server.getClients())
				if((c.getHandle().equals(message.substring(10))))
					matched = true;
			if(!matched)
			{
				String oldhandle  = client.getHandle();
				client.setHandle(message.substring(10));
				for(IClient c : server.getClients())
					if(!(c.getHandle().equals(client.getHandle())))
						c.send("RENAME "+ oldhandle.length()+" "+oldhandle + ""+ client.getHandle().length() + " " + client.getHandle());
				client.process("LIST");
				client.send(message);
			}
			else
				client.send("BADHANDLE The name is already taken!");
		}
	}
}