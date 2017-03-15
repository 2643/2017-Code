package org.usfirst.frc.team2643.robot;

public class Climber
{
	/**
	 * {@code climber()}: If the dPad is pressed up, then the climber motor will
	 * set to positive. Else if the dPad is pressed down, then the climber will
	 * set to negative. Else the climber will be set to 0.
	 */
	public static void climb()
	{
		if (RobotMap.opStick.getRawButton(5))
		{
			//System.out.println("RUNNING");
			RobotMap.climbMotor.set(1.0);
		}
		else
		{
			RobotMap.climbMotor.set(0);
		}
	}
}