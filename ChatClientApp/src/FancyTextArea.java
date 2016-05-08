import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class FancyTextArea extends JTextArea implements KeyListener{
	private JTextArea area;
	private IClient client;
	public FancyTextArea()
	{
		addKeyListener(this);
	}
	public FancyTextArea(IClient c, JTextArea a)
	{
		area = a;
		client = c;
		addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyText(e.getKeyCode()).equals("Enter")){
			if(this.getText().contains("SETHANDLE")||this.getText().equals("LIST")||this.getText().equals("QUIT")){
	    		client.send(this.getText());
	    		this.setText("");
	    	}else{
	    	client.send("SAY " + this.getText());
	    	this.setText("");
	    	}
		}
	}
	public void keyReleased(KeyEvent e){if((e.getKeyText(e.getKeyCode()).equals("Enter"))) this.setText("");}
	public void keyTyped(KeyEvent e){}
}
