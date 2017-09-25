/**
 * Contains all functions used for controlling the LED
 * @author Ramzi Saleh
 * @author Caiden Wilson
 */

package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class LEDController    //this class provides useful methods for controlling the leds. 
{
	LedStrip strip;           //this is the strip that the led controller
	Timer timer = new Timer();//this is a timer. It can be used to 
	private int currentColor; //the color of he bar
	private int lightNumber;  //the number of lights. 
	private int barHeight;    //the height of the bars of led.
	
	private int red;          //RGBs for all of the leds
	private int blue;
	private int green;
	
	private int rainbowMode;// which part of the rainbow it is in.
	
	public LEDController( int ln )//the constructor
	{
		lightNumber = ln;//the number
		strip = new LedStrip( ln , 1.0f );//defines a new led strip
	}
	
	public void initialize()
	{
		timer.start();//start timer
		strip.fill( 0 , 0 , 0 );//switch off all lights
	}
	
	public void reset()
	{
		currentColor = 1;//sets all leds to red
		barHeight = 0;//sets the bar height to 0
	}
	
	public void teleopInit()
	{
		rainbowMode = 0;//red
		
		red = 255;//red
		green = 0;
		blue = 0;
	}
	 
	public void hook( int n )//does stuff
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
		
		strip.fill( red , green , blue , 1 , n );//fill it with colors
		strip.fill( 0 , 0 , 0 , n + 1 , lightNumber );
		strip.update();
		
		if( timer.get() >= LEDV.timeInterval )//if it has been a certain amount of time
		{
			timer.reset();                    //reset timer
			
			switch( rainbowMode )             //changes colors slowly!
			{
				case 0:
					if( green < 125 ) 
					{
						green += 5;           //changes the LED to orange
					}                         //green = 125; red = 255; blue = 0;
					else
					{
						rainbowMode = 1; 
					}
					break;
				case 1:
					if(green < 255)
					{
						green += 5;           //changes the LED to yellow
					}                         //green = 255; red = 255; blue = 0;
					else 
					{
						rainbowMode = 2;
					}
				case 2:
					if( red > 0 )   
					{
						red -= 5;            //changes the LED to green
					}                        //green = 255; red = 0; blue = 0;
					else
					{
						rainbowMode = 3;
					}
					break;
				
				case 3:
					if( blue < 255 && green > 0 )
					{
						blue += 5;           //changes the LED to blue
						green -= 5;          //green = 0; red = 0; blue = 255;
					}
					else
					{
						rainbowMode = 4;
					}
					break;
					
				case 4:
					if( blue > 155)
					{
						blue -= 5;          //changes the LED to indigo
					}                       //green = 0; red = 0; blue = 155;
					else
					{
						rainbowMode = 4;
					}
					break;
				
				case 5:
					if( red < 125 && blue < 255 )
					{
						red += 5;    
						blue += 5;          //changes the LED to violet
					}                       //green = 0; red = 125; blue = 255;
					else
					{
						rainbowMode = 5;
					}
					break;
				
				case 6:
					if( red < 255 && blue > 0 )
					{
						blue -= 5;   
						red += 5;           //changes LED back to red
					}                       //green = 0; red = 255; blue = 0;
					else
					{
						rainbowMode = 0;    //repeats process again
					}
					break;
			}
		}
	}
	
	public void bars()//starts and updates bars.
	{
		if( timer.get() >= LEDV.timeInterval )//if the timer interval is more than the time interval
		{
			timer.reset();//reset timer 
			barHeight++;//increase the height of the bar
			if( barHeight > lightNumber * 2 )//if the barheight is greater than the number of lights
			{
				barHeight = 1;
				currentColor++;
				if( currentColor > 6 )//reset
				{
					currentColor = 1;
				}
				updateColor();
			}
			if( barHeight < lightNumber )//if the barheight is still less than the number of lights, move the bar of lights up
			{
				strip.fill( red , green , blue , 1 , barHeight );
				strip.fill( 0 , 0 , 0 , barHeight + 1 , lightNumber );
			}
			else if( barHeight > lightNumber )//if the barheight is greater than light number start moving the lights up from the bottom
			{
				strip.fill( red , green, blue , barHeight - lightNumber , lightNumber );
				strip.fill( 0 , 0 , 0 , 1 , barHeight - lightNumber );
			}
			else
			{
				strip.fill( red , green , blue );
			}
			strip.update();//update
		}
	}
	
	public void updateColor()//changes the color to whatever the current color is
	{
		switch( currentColor )//current color
		{
			case 1: //if current color is 1, make it red
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