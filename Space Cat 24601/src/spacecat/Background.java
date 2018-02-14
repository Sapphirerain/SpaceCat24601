package spacecat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import spacecat.SpaceCat;
import spacecat.Game;
import spacecat.Background;
import spacecat.SpaceBird;
import spacecat.Menu;

public class Background 
{		
	//variables for bird movement
	public static int bx = 2500;
	public static int by = Projectile.yposGenerator();
	public static int bx2 = 3000;
	public static int by2 = Projectile.yposGenerator();
	public static int bx3 = 2500;
	public static int by3 = Projectile.yposGenerator();
	public static int speed = 0;
	public static int speed2 = 0;
	public static int speed3 = 0;
	
	//variables for planet movement
	public static int px = 2500;
	public static int py = Projectile.yposGenerator();
	public static int px2 = 2500;
	public static int py2 = Projectile.yposGenerator();
	public static int pspeed = 0;
	public static int pspeed2 = 0;
	
	//variables for comet movement
	public static int comx = 2500;
	public static int comy = 0;
	public static int comspeed = 0;
	
	//variables for cat movement
	public static int catx = 20;
	public static int caty = 400;
	public static boolean move = true;
	
	//counter for score
	public static int score = 0;
	
	//creates ImageIcons
	public static ImageIcon spaceCat = new ImageIcon("kitty.png");
	public static ImageIcon bird = new ImageIcon("chicken.png");
	public static ImageIcon bird2 = new ImageIcon("chicken.png");
	public static ImageIcon bird3 = new ImageIcon("chicken.png");
	public static ImageIcon space = new ImageIcon("space.gif"); 
	public static ImageIcon planet = new ImageIcon("planet.png");
	public static ImageIcon planet2 = new ImageIcon("planet2.png");
	public static ImageIcon comet = new ImageIcon("comet.png");
	
	//creates hitboxes
	public static Rectangle chitbox;
	public static Rectangle bhitbox;
	public static Rectangle bhitbox2;
	public static Rectangle bhitbox3;
	
	public static boolean rekt = false;
	
	public Background()
	{
		//restarts values
		rekt = false;
		bx = 2500;
		by = Projectile.yposGenerator();
		bx2 = 3000;
		by2 = Projectile.yposGenerator();
		bx3 = 2500;
		by3 = Projectile.yposGenerator();
		speed = 0;
		speed2 = 0;
		speed3 = 0;
		px = 2500;
		py = Projectile.yposGenerator();
		px2 = 2500;
		py2 = Projectile.yposGenerator();
		pspeed = 0;
		pspeed2 = 0;
		comx = 2500;
		comy = 0;
		comspeed = 0;
		catx = 20;
		caty = 400;
		move = true;
		//counter for score
		score = 0;
		
		//removes everything on original Frame
		Menu.frame.getContentPane().removeAll();
		
		//creates new ImageIcons
		final JButton up = new JButton("Up");
		final JButton down = new JButton("Down");
		
		//new JPanel with images
		JPanel backGround = new JPanel()  
		{  
		   public void paintComponent(Graphics g)  
		   {  
			  Graphics2D g2d = (Graphics2D) g.create();
			  
			  
			  //draws images onto JFrame
			  space.paintIcon(this, g2d, 0, 0);
			  
			  //draws background images
		      planet.paintIcon(this, g2d, px, py); 
		      planet2.paintIcon(this, g2d, px2, py2); 
		      comet.paintIcon(this, g2d, comx, comy);
		      
		      //creates movement of the planet
		      if (px < 3000 && !rekt && SpaceObject.generator == 1)
			  {
		    	  px = 2000 - pspeed;
		    	  pspeed = pspeed + 30;
			  		
		    	  //restarts planet once off-screen
		    	  if (px < -500)
		    	  {
		    		  px = 2000;			
		    		  pspeed = 1;
		    		  py = Projectile.yposGenerator();
		    		  planet = new ImageIcon("planet.png");
		    	  }
			  }
		      
		    //creates movement of the planet
		      if (px2 < 6000 && !rekt && SpaceObject.generator2 == 2)
			  {
		    	  px2 = 5000 - pspeed2;
		    	  pspeed2 = pspeed2 + 40;
			  		
		    	  //restarts planet once off-screen
		    	  if (px2 < -500)
		    	  {
		    		  px2 = 2000;			
		    		  pspeed2 = 1;
		    		  py2 = Projectile.yposGenerator();
		    		  planet2 = new ImageIcon("planet2.png");
		    	  }
			  }
		      
		    //creates movement of the planet
		      if (comx < 3000 && !rekt && SpaceObject.generator3 == 3)
			  {
		    	  comx = 2000 - comspeed;
		    	  comspeed = comspeed + 10;
		    	  comy = (int) (-(50 * (Math.tan(comx * .005)) * 30 - 400));
			  		
		    	  
		    	  //restarts comet once off-screen
		    	  if (comx < -200)
		    	  {
		    		  comx = 2000;			
		    		  comspeed = 1;
		    		  
		    		  comet = new ImageIcon("comet.png");
		    	  }
			  }
		      
		      //draws cat
		      spaceCat.paintIcon(this, g2d, catx, caty);
		      
		      //sets color as transparent
		      int alpha = 0;
		      Color myColor = new Color(0, 0, 0, alpha);
		      g2d.setColor(myColor);
		      
		      //draw transparent hitboxes
		      chitbox = new Rectangle(catx + 50, caty + 50, 150, 100);
		      g2d.draw(chitbox);
		      
		      g.setColor(Color.WHITE);
		      g.drawString("SCORE: " + score, 1800, 30);
		      
		    //random generator for bird
		      if ( SpaceBird.generator == 1)
		      {
		    	  //draws bird
		    	  bird.paintIcon(this, g2d, bx, by);  
		    	  bhitbox = new Rectangle(bx + 25, by + 25, 200, 125);
		    	  g2d.draw(bhitbox);

		    	  //creates movement of the bird
		    	 if ( bx < 3000 && SpaceBird.generator == 1 && !rekt)
			     {
		    		 	bx = 2500 - speed;
		    		 	speed = speed + 60;
		    		 	by = (int) (Math.cos(bx * 0.01) * 200) + 300;
			    	  
			    	  	//checks if cat and bird are touching
		    		 	if (bhitbox.intersects(chitbox))
		    		 	{
		    		 		rekt = true;
		    		 	}
		    		 	
		    		 	//restarts bird once off-screen
			  			if (bx < -300)
			  			{
			  				bx = 2500;			
			  				speed = 6;
			  				by = Projectile.yposGenerator();
			  				bird = new ImageIcon("chicken.png");
			  				score += 10;
			  			}
			      }
		      }
		      
		      //random generator for bird
		      if ( SpaceBird.generator2 == 2)
		      {
		    	 //draws bird
		    	bird2.paintIcon(this, g2d, bx2, by2);  
		    	bhitbox2 = new Rectangle(bx2 + 25, by2 + 25, 200, 125);
		    	g2d.draw(bhitbox2);
		    	
		    	//creates movement of the bird
		    	 if ( bx2 < 5000 && SpaceBird.generator2 == 2 && !rekt)
			      {
		    		 	bx2 = 3000 - speed2;
		    		 	speed2 = speed2 + 60;
		    		 	by2 = (int) (Math.sin(bx2 * 0.01) * 200) + 750;
		    		 	
		    		 	//checks if cat and bird are touching
		    		 	if (bhitbox2.intersects(chitbox))
		    		 	{
		    		 		rekt = true;
		    		 	}
		    		 	
		    		 	//restarts bird once off-screen
			  			if (bx2 < -300)
			  			{
			  				bx2 = 3000;			
			  				speed2 = 1;
			  				by2 = Projectile.yposGenerator();
			  				bird2 = new ImageIcon("chicken.png");
			  				score += 10;
			  			}
			      }
		      }
		      
		      //random generator for bird
		      if ( SpaceBird.generator3 == 3)
		      {  
		    	//draws bird
		    	bird3.paintIcon(this, g2d, bx3, by3); 
		    	bhitbox3 = new Rectangle(bx3 + 25, by3 + 25, 200, 125);
		    	g2d.draw(bhitbox3);
		    	
		    	//creates movement of the bird
		    	if ( bx3 < 3000 && SpaceBird.generator3 == 3 && !rekt)
			    {
			  		bx3 = 2000 - speed3;
			  		speed3 = speed3 + 100;
			  		
			    	
			  		//checks if cat and bird are touching
	    		 	if (bhitbox3.intersects(chitbox))
	    		 	{
	    		 		rekt = true;
	    		 	}
			  		
			  		//restarts bird once off-screen
			  		if (bx3 < -300)
			  		{
			  			bx3 = 2000;			
			  			speed3 = 1;
			  			by3 = Projectile.yposGenerator();
			  			bird3 = new ImageIcon("chicken.png");
			  			score += 10;
			  		}
			     }
		      }	
		      
		      //goes to lose screen once lost
		      if (rekt)
		      {
		    	  Lose lose = new Lose();
		    	  lose.showPanel(lose.createPanel());
		      }
		      
		      //goes to win screen
		      if (score == 100)
		      {
		    	  Win win = new Win();
		    	  win.showPanel(win.createPanel());
		      }
		}
	};
	
	    //adds everything to frame and sets visible
				Game.frame.add(backGround);
				up.setVisible(true);
				down.setVisible(true);
				backGround.setVisible(true);
				Game.frame.setVisible(true);
				backGround.addKeyListener(new SpaceCat());
				
				//make sure the JPanel has the focus
		        backGround.requestFocusInWindow();
	}	
}