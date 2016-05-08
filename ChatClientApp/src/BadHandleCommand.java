import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BadHandleCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "BADHANDLE";
		JTextArea area;
	public BadHandleCommand(JTextArea a)
	{
		area = a;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			//Notification that a previous SETHANDLE message resulted in an error on the server
			//BADHANDLE error message
			//Example: 
			//		BADHANDLE Something went wrong, could not set handle
			area.append(message.substring(10)+"\n");
		}
	}
}