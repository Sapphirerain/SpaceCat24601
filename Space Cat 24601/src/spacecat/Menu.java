package spacecat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import spacecat.Background;
import spacecat.Game;
import spacecat.Instructions;
import spacecat.Menu;
import spacecat.SpaceBird;

public class Menu extends Game implements ActionListener
{
	public static JButton instructionButton = new JButton("Instructions");
	
	public static String name;

	public Menu()
	{
		//removes everything on original Frame
		Menu.frame.getContentPane().removeAll();
		
		//creates JPanels and JButton and JLabel
		JPanel buttonPanel = new JPanel(new BorderLayout());
		JPanel southPanel = new JPanel();
		JButton startButton = new JButton("Start!");
		JButton instructionButton = new JButton("Instructions");
		JLabel open = new JLabel(new ImageIcon("SpaceCat24601.png"));
		
		//adds everything to the frame
		Game.frame.add(buttonPanel);
		southPanel.add(startButton);
		southPanel.add(instructionButton);
		buttonPanel.add(southPanel, BorderLayout.SOUTH);
		buttonPanel.add(open);

		//set Visible
		startButton.setVisible(true);
		buttonPanel.setVisible(true);
		Game.frame.setVisible(true);
		Game.frame.setLocationRelativeTo(null);
		
		//add actionListener to instruction button
		startButton.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//goes to actual game
	        	Sound sound = new Sound();
	        	Background background = new Background();
	        	
	        	//JOptionPane pane = new JOptionPane();
	        	name = JOptionPane.showInputDialog("Enter your name");
	        	
	        	SpaceObject object = new SpaceObject();
	        	//object.generateNumbers();
	        	SpaceBird birb = new SpaceBird();	
	        	birb.generateNumbers();
	        	Background.rekt = false;
	        }
	    }); 
		
		//add actionListener to instruction button
		instructionButton.addActionListener(new ActionListener() 
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//goes to instruction page
	            Instructions instruction = new Instructions();
	        }
	    }); 
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	}
}