import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SetHandleCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "SETHANDLE";
	
	JTextArea area;
	public SetHandleCommand(JTextArea a)
	{
		area = a;		
	} 
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			area.append("Your name is " + message.substring(10)+"\n");
			client.send("LIST");
			//Set the handle of this client to the 
			//SETHANDLE handle
			//Example: 
			//		SETHANDLE Tad Cooper
			
		}
	}
}