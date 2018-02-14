package spacecat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SpaceBird extends Projectile 
{
	public SpaceBird()
	{
		super();	
	}
	
	public void generateNumbers()
	{
		if (flying = true)
		{
			//timer delay for generating bird
			timer = new Timer(500, new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//random generator for bird
				generator = (int)(Math.random()*4);
				
					
				//stops timer and generator
				if (generator == 1)
				{
					flying = false;
					timer.stop();							
				}
			}					
		});
			
		//starts timer
		timer.start();
		}
	
		if (flying2 = true)
		{
			//timer delay for generating bird
			timer2 = new Timer(500, new ActionListener()
			{
		
				public void actionPerformed(ActionEvent arg0) 
				{
					//random generator for bird
					generator2 = (int)(Math.random()*4);
					
					
					//stops timer and generator
					if (generator2 == 2)
					{
						flying2 = false;
						timer2.stop();							
					}
				}					
			});
			
			//starts timer
			timer2.start();
		}
		
		if (flying3 = true)
		{
			//timer delay for generating bird
			timer3 = new Timer(500, new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					//random generator for bird
					generator3 = (int)(Math.random()*4);
					
					
					//stops timer and generator
					if (generator3 == 3)
					{
						flying3 = false;
						timer3.stop();							
					}
				}					
			});
			
			//starts timer
			timer3.start();
		}
	}
}