package spacecat;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Sound 
{
	//creates new music file
	public static File backgroundMusic = new File( "music.wav");
		
	public void playSound() throws LineUnavailableException, IOException, UnsupportedAudioFileException 
	{
		Clip music = AudioSystem.getClip();
	    AudioInputStream ais = AudioSystem.getAudioInputStream( backgroundMusic );

	    //plays music
	    music.open(ais);
	    music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	
	//public static File backgroundMusic = new File( "music.wav" );
	/*File backgroundMusic = new File( "music.wav" );
		public void playSound() throws Exception
		{
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(backgroundMusic);
			Clip clip = AudioSystem.getClip();
		    clip.open(audioInputStream);
		 	clip.start();
		    //clip.loop(Clip.LOOP_CONTINUOUSLY);
		 	//SwingUtilities.invokeLater(new Runnable() {
		    //clip.setFramePosition(0);
		    //clip.start();
		 		/*public void run() 
		    	{
		    		JOptionPane.showMessageDialog(null, "Close to exit!");
		      	}*/
		        	
		 	/*);
		        
		}*/
		
		
		
		/*public void playMusic() throws LineUnavailableException, IOException, UnsupportedAudioFileException 
		{
			
		    AudioInputStream ais = AudioSystem.getAudioInputStream( backgroundMusic );
		    Clip music = AudioSystem.getClip();
		    //plays music
		    music.open(ais);
		    music.start();
		    music.loop(Clip.LOOP_CONTINUOUSLY);		
		}*/
}
