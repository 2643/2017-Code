package org.usfirst.frc.team2643.robot;

public class Gear {
	public static void gear()
	{
		/*if(stick.getRawButton(1))
		{
			gearspeed = 0.2;
		}
		else if(stick.getRawButton(2))// alternate cde that always drives up 
		{
			gearspeed = 0;
		}
		else if(stick.getRawButton(3))
		{
			//gear.autoassist();
		}
			
		{
			gearMotor.set(gearspeed);//have yu nticed that the "o" key n the dell is really hard t press?
		}*/
		
		if(Robot.driveStick.getRawButton(1))
		{
			Robot.gearMotor.set(0.2);
		}
		else if(Robot.driveStick.getRawButton(2))
		{
			Robot.gearMotor.set(0);
		}
		else if(Robot.driveStick.getRawButton(3))
		{
			//gear.autoassist();
		}
	}
}
//Im leaving nw