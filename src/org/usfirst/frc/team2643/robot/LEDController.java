/**
 * Contains all functions used for controlling the LED
 * @author Ramzi Saleh
 * @author Caiden Wilson
 */

package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class LEDController
{
	LedStrip strip;
	Timer timer = new Timer();
	private int currentColor;
	private int lightNumber;
	private int barHeight;
	
	private int red;
	private int blue;
	private int green;
	
	private int rainbowMode;
	
	public LEDController( int ln )
	{
		lightNumber = ln;
		strip = new LedStrip( ln , 1.0f );
	}
	
	public void initialize()
	{
		timer.start();
		strip.fill( 0 , 0 , 0 );
	}
	
	public void reset()
	{
		currentColor = 1;
		barHeight = 0;
	}
	
	public void teleopInit()
	{
		rainbowMode = 0;
		
		red = 255;
		green = 0;
		blue = 0;
	}
	
	public void hook( int n )
	{
		System.out.println( n );
		n = (int)( ( double )( n ) * LEDV.encoderFactor );
		
		if( n >= lightNumber )
		{
			n = lightNumber - 1;
		}
		else if( n < 1 )
		{
			n = 1;
		}
		
		strip.fill( red , green , blue , 1 , n );
		strip.fill( 0 , 0 , 0 , n + 1 , lightNumber );
		strip.update();
		
		if( timer.get() >= LEDV.timeInterval )
		{
			timer.reset();
			
			switch( rainbowMode )
			{
				case 0:
					if( green < 255 )
					{
						green += 5;
					}
					else
					{
						rainbowMode = 1;
					}
					break;
				
				case 1:
					if( red > 0 )
					{
						red -= 5;
					}
					else
					{
						rainbowMode = 2;
					}
					break;
				
				case 2:
					if( blue < 255 )
					{
						blue += 5;
					}
					else
					{
						rainbowMode = 3;
					}
					break;
					
				case 3:
					if( green > 0 )
					{
						green -= 5;
					}
					else
					{
						rainbowMode = 4;
					}
					break;
				
				case 4:
					if( red < 255 )
					{
						red += 5;
					}
					else
					{
						rainbowMode = 5;
					}
					break;
				
				case 5:
					if( blue > 0 )
					{
						blue -= 5;
					}
					else
					{
						rainbowMode = 0;
					}
					break;
			}
		}
	}
	
	public void bars()
	{
		if( timer.get() >= LEDV.timeInterval )
		{
			timer.reset();
			barHeight++;
			if( barHeight > lightNumber * 2 )
			{
				barHeight = 1;
				currentColor++;
				if( currentColor > 6 )
				{
					currentColor = 1;
				}
				updateColor();
			}
			if( barHeight < lightNumber )
			{
				strip.fill( red , green , blue , 1 , barHeight );
				strip.fill( 0 , 0 , 0 , barHeight + 1 , lightNumber );
			}
			else if( barHeight > lightNumber )
			{
				strip.fill( red , green, blue , barHeight - lightNumber , lightNumber );
				strip.fill( 0 , 0 , 0 , 1 , barHeight - lightNumber );
			}
			else
			{
				strip.fill( red , green , blue );
			}
			strip.update();
		}
	}
	
	public void updateColor()
	{
		switch( currentColor )
		{
			case 1: //Red
				red = 255;
				green = 0;
				blue = 0;
				break;
			
			case 2: //Orange
				red = 255;
				green = 255 / 2;
				blue = 0;
				break;
			
			case 3: //Yellow
				red = 255;
				green = 255;
				blue = 0;
				break;
			
			case 4: //Green
				red = 0;
				green = 255;
				blue = 0;
				break;
			
			case 5: //Blue
				red = 0;
				green = 0;
				blue = 255;
				break;
			
			case 6: //Purple
				red = 255;
				green = 0;
				blue = 255;
				break;
		}
	}
}