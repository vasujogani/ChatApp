import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Appender extends JTextArea
{
	
	JTextArea area;
	public Appender()
	{
		Appender frame = new Appender();
	//	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);	
		if(frame.isVisible())
			System.out.println("Frame is visible");
		area = new JTextArea();
	}
	public void append(String s)
	{
		area.append("\n"+s);
	}
	public JTextArea getarea()
	{
		return area;
	}
}