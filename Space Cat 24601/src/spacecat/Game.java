package spacecat;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import spacecat.Menu;

public class Game extends Canvas implements Runnable 
{
	//variables for JFrame
	public static final String NAME = "Game";
	public static JFrame frame = new JFrame(NAME);
	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final int SCALE = 1;
		
	public static boolean restart;
		
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException
    { 	
    	//starts game
	    do
	    {
	    	//Sound sound = new Sound();
	    	//sound.playSound();
	    	Menu menu = new Menu();
	    	
	    }
	    while(restart);
	    	
    }

	public Game()
	{
		//sets Size for JFrame
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));

		//JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(1920, 1080);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub	
	}
}
