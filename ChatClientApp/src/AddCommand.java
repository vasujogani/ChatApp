import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "ADD";
		JTextArea area;
	public AddCommand(JTextArea a)
	{
		area = a;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			//process the Add command
			//ADD handle
			//Example: 
			//		ADD Ned Stark
			
			area.append(message.substring(4) + " just connected."+"\n");
			client.send("LIST");
		}
	}
}