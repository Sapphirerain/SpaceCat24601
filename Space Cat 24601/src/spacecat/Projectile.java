package spacecat;

import javax.swing.Timer;

public abstract class Projectile 
{
	Timer timer;
	Timer timer2;
	Timer timer3;
	boolean flying = true;
	boolean flying2 = true;
	boolean flying3 = true;
	public static int generator;
	static public int generator2;
	static public int generator3;
	
	static public int[][] ypos = new int[5][5];
	
	public Projectile()
	{
		for(int row = 0; row < ypos.length; row++)
		{
			for( int col = 0; col < ypos[0].length; col++ )
			{
				ypos[row][col] = (int)(Math.random()*1000);
			}
		}
		
		for(int row[] : ypos)
		{
			for(int i : row)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static int yposGenerator()
	{
		return ypos[(int)(Math.random() * 5)][(int)(Math.random() * 5)];
	}
	
	abstract void generateNumbers();
	

}
