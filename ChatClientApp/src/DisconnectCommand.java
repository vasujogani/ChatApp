import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DisconnectCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "DISCONNECT";
		JTextArea area;
	public DisconnectCommand(JTextArea a)
	{
		area = a;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			client.stop();
			area.append("You have disconnected\n");
		}
	}
}