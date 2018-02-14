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

public class Lose implements Ending
{
	final ImageIcon lostPage;
	
	public Lose()
	{
		//removes everything on original Frame
		Menu.frame.getContentPane().removeAll();
		
		lostPage = new ImageIcon("Lose.png");
	}
	
	public JPanel createPanel()
	{
		//creates new JPanel
		JPanel lostPane = new JPanel()  
		{  
			public void paintComponent(Graphics g)  
			{  
				Graphics2D g2d = (Graphics2D) g.create();
				//displays final score
				lostPage.paintIcon(this, g2d, 0, 0);
				//creates font and text
				Font font = new Font("Comic Sans", Font.BOLD, 80);
				g2d.setFont(font);
				g2d.setColor(Color.CYAN);
				g2d.drawString( Menu.name + "'s final score: " + Background.score, 250, 800);  
			}
		};
		
		lostPane.setSize(300, 300);
		JPanel buttonPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel();
		JButton restartButton = new JButton("Restart");
		
		//adds everything to frame
		southPanel.add(restartButton);
		buttonPanel.add(southPanel, BorderLayout.SOUTH);
		lostPane.add(buttonPanel);
		Game.frame.add(lostPane);
		
		//add actionListener to restart Button
		restartButton.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//restarts the game
	        	Game.restart = true;
	        	Background background = new Background();
	        }
	    }); 
		
		return lostPane;
		
	}

	@Override
	public void showPanel(JPanel lostPane) 
	{
		// TODO Auto-generated method stub
		//set Visible
		lostPane.setVisible(true);
		Game.frame.setVisible(true);
		Game.frame.setLocationRelativeTo(null);		
		
	}
}