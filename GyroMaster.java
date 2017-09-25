package org.usfirst.frc.team2643.robot;

import java.text.ParseException;

public class GyroMaster
{
	private static double setSpeed = 0.75;
	
	public static void moveForward(double speed)
	{
		RobotMap.lFrontMotor.set(speed);
		RobotMap.rFrontMotor.set(-speed);
		RobotMap.lBackMotor.set(speed);
		RobotMap.rBackMotor.set(-speed);
	}
	
	public static void levelDrive(double speed, double leftSpeed, double rightSpeed)
	{
		RobotMap.lFrontMotor.set(leftSpeed);
		RobotMap.rFrontMotor.set(-rightSpeed);
		RobotMap.lBackMotor.set(leftSpeed);
		RobotMap.rBackMotor.set(-rightSpeed);
	}
	
	public static void gyroCompensation(double gyroVal, double speed,  double highBound, double lowBound)
	{
		RobotMap.tmp = RobotMap.tmp + gyroVal;
		
		if (RobotMap.tmp > highBound)
		{
			//System.out.println("MOVING RIGHT or LEFT?");
			levelDrive(speed, 0.35, 0.17);
		}
		else if (RobotMap.tmp < lowBound)
		{
			//System.out.println("MOVING LEFT or RIGHT?");
			levelDrive(speed, -0.2, 0.2);
		}
	}
	
	public static void gyroMaster(String val, double speed)
	{
		// System.out.println(val);
		if (val.equals("") || val.equals(" ") || val.substring(0, 1).equals("z") || val.equals("rz") || val.equals("c"))
		{
			moveForward(speed);
		}
		else
		{
			try
			{
				if (RobotMap.x == 0)
				{
					RobotMap.x++;
				}
				else
				{
					RobotMap.myNumber = RobotMap.f.parse(val).doubleValue();
					//System.out.println(Robot.myNumber);
					gyroCompensation(RobotMap.myNumber, speed, 0, 0);
				}
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
