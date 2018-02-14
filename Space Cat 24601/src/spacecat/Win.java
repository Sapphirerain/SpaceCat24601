package spacecat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import spacecat.Background;
import spacecat.Game;
import spacecat.Menu;

public class Win implements Ending
{
	final ImageIcon wonPage;
	
	public Win()
	{
		//removes everything on original Frame
		Menu.frame.getContentPane().removeAll();
		
		wonPage = new ImageIcon("Win.png");
	}		
	
	/**
	 * Returns a JPanel object that can then be added to the frame. 
	 * <p>
	 * This method creates a new JPanel with the image for the Win page 
	 * and the string displaying a final score on it. The JPanel is set 
	 * to a certain size and more JPanels for the restart button are added.
	 * An ActionListener is created for the restart button.
	 *
	 * @return JPanel	the JPanel shown when the game is won
	 */@Override
	
	public JPanel createPanel()
	{
		//creates new JPanel
		JPanel wonPane = new JPanel()  
		{  
			public void paintComponent(Graphics g)  
			{  
				Graphics2D g2d = (Graphics2D) g.create();
				
				//displays final score
				wonPage.paintIcon(this, g2d, 0, 0);
				
				//creates font and text
				Font font = new Font("Comic Sans", Font.BOLD, 50);
				g2d.setFont(font);
				g2d.setColor(Color.CYAN);
				g2d.drawString( Menu.name + "'s final score: " + Background.score, 150, 500);  
			}
		};
			
		//adds everything to frame
		wonPane.setSize(300, 300);
		JPanel buttonPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel();
		JButton restartButton = new JButton("Restart");
		
		//adds everything to frame
		southPanel.add(restartButton);
		buttonPanel.add(southPanel, BorderLayout.SOUTH);
		wonPane.add(buttonPanel);
		
		
		//add actionListener to restart Button
		restartButton.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//restarts the game
	        	Menu.restart = true;
	        	Background background = new Background();
	        }
	    }); 
		return wonPane;
	
	}
	
	/**
	 * Accepts a JPanel parameter that is added to the frame
	 * <p>
	 * This method adds the JPanel entered as a parameter to the main frame and makes 
	 * both the JPanel and main frame visible. 
	 *
	 * @param the JPanel
	 */@Override
	public void showPanel(JPanel wonPane) 
	{
		// TODO Auto-generated method stub
		Game.frame.add(wonPane);
		
		//set Visible
		wonPane.setVisible(true);
		Game.frame.setVisible(true);
		Game.frame.setLocationRelativeTo(null);	
		
	}
}