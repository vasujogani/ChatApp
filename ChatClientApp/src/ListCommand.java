import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java. util.List;

class ListCommand extends NetworkListenerAdapter
{
	public static String COMMAND = "LIST";
		JTextArea area;
		JTextArea user;
	public ListCommand(JTextArea a, JTextArea b)
	{
		area = a;
		user = b;		
	}
	public void process(String message, IClient client)
	{
		if(isCommand(message, COMMAND))
		{
			//Process a list of all users connected to the server
			//# = length of handle
			//LIST # handle# handle#handle
			//Example: 
			//		LIST 5 MrMay2 Ed10 Tad Cooper
			//
			//There are 3 users in the above list:
			//	MrMay
			//	Ed
			//	Tad Cooper
		//	System.out.println("listing");
			List<String> list = new ArrayList<String>();			
			message = message.substring(message.indexOf(" ")+1);
		//	System.out.println("1) processing: " + message);
			int size = Integer.parseInt(message.substring(0,message.indexOf(" ")));
		//	System.out.println("2- size is:" + size);
			message = message.substring(message.indexOf(" ")+1);
			while(!message.isEmpty())
			{
				String temp = "";
				for(int i = 0; i < size; i++)
				{
					temp += message.substring(i,i+1);
				}
		//		System.out.println("TEMP IS :" + temp);
				message = message.substring(size);
		//		System.out.println("message is:" +message);
				list.add(temp);
				if(message.length()>0){
					size = Integer.parseInt(message.substring(0,message.indexOf(" ")));
					message = message.substring(message.indexOf(" ")+1);
				}
			}
		//	System.out.println("List is : " + list +".OVER ");
			String str = "";
			user.setText("");
			for(int i = 0; i < list.size(); i++)
				str+=list.get(i) + "\n";
			user.append(str);
		}
	}
}