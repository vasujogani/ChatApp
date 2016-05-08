import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RemoveCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "REMOVE";
		JTextArea area;
	public RemoveCommand(JTextArea a)
	{
		area = a;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			//process the Remove command
			//REMOVE handle
			//Example: 
			//		REMOVE Ned Stark
			area.append(message.substring(8) + " left the chat room. "+"\n");
			client.send("LIST");
			
		}
	}
}