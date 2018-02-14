package spacecat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import spacecat.Background;

public class SpaceCat implements KeyListener
{
	Timer timer;
	public void keyTyped(KeyEvent e) {}

	//cat movements
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		   	   
		//cat moves up and down by 200 pixels unless threshold is reached
		if(!Background.rekt)
		{
			if (key == KeyEvent.VK_UP && Background.caty > 0) 
			{
				Background.caty += -50; 
			}

			if (key == KeyEvent.VK_DOWN && Background.caty < Game.HEIGHT - 300) 
			{
				Background.caty += 50;
			   		   
			}
		}
		
		else
		{
			//cannot move cat
		}
		
	}

	public void keyReleased(KeyEvent e) {}
	
}
    



