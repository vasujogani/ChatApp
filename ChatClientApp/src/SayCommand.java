import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SayCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "SAY";
	JTextArea area;
	public SayCommand(JTextArea a)
	{
		area = a;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			//process the Say comment
			//SAY # handle message
			//Example: 
			//		SAY 5 MrMayComputer Science!
			client.send("LIST");
			message = message.substring(4);
			int size = Integer.parseInt(message.substring(0,message.indexOf(" ")));
			message = message.substring(message.indexOf(" ")+1);
			String[] s = new String[2];
			String temp = "";
			for(int i = 0; i < size; i++)
				temp += message.substring(i,i+1);
			s[0] = temp;
			message  = message.substring(size);
			s[1] = message;
			String fin = s[0] +": "+ s[1];
			System.out.println("Received : " + fin);
			area.append(fin+ " \n");
		}
	}
}