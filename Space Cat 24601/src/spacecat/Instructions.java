package spacecat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import spacecat.Game;
import spacecat.Menu;

public class Instructions 
{
	public Instructions()
	{
		//removes everything on original Frame
		Menu.frame.getContentPane().removeAll();
		
		//creates new JLabel, JPanel, JButton
		JLabel instructionPage = new JLabel(new ImageIcon("Instructions.png"));
		JButton backButton = new JButton("Back");
		JPanel instructionPane = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel();
		
		//adds everything to frame
		southPanel.add(backButton);
		instructionPane.add(southPanel, BorderLayout.SOUTH);
		Game.frame.add(instructionPane);	
		instructionPane.add(instructionPage);
		
		//add actionListener to back Button
		backButton.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//goes back to Menu
	        	Menu menu = new Menu();
	        }
	    }); 
		
		//set Visible
		instructionPane.setVisible(true);
		Game.frame.setVisible(true);
		Game.frame.setLocationRelativeTo(null);	
	}
}
