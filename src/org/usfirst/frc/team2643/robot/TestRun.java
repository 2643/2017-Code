package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

//public static balloons extends adena
public class TestRun {
	static Timer timer = new Timer();
	
	public static void manualTest(){
		if(Robot.opStick.getRawButton(1))
		{
			Robot.lFrontMotor.set(0.2);
		}
		else 
		{
			Robot.lFrontMotor.set(0);
		}
	
		if(Robot.opStick.getRawButton(2))
		{
			Robot.lBackMotor.set(0.2);
		}
		else 
		{
			Robot.lBackMotor.set(0);
		}
		
		if(Robot.opStick.getRawButton(3))
		{
			Robot.rFrontMotor.set(0.2);
		}
		else 
		{
			Robot.rFrontMotor.set(0);
		}
		
		if(Robot.opStick.getRawButton(4))
		{
			Robot.rBackMotor.set(0.2);
		}
		else 
		{
			Robot.rBackMotor.set(0);
		}
		
		if(Robot.opStick.getRawButton(5))
		{
			Robot.gearMotor.set(0.2);
		}
		else
		{
			Robot.gearMotor.set(0);
		}
		
		if(Robot.opStick.getRawButton(6))
		{
			Robot.dumpMotor.set(0.2);
		}
		else
		{
			Robot.dumpMotor.set(0);
		}
		
		if(Robot.opStick.getRawButton(7))
		{
			Robot.intakeMotor.set(0.2);
		}
		else
		{
			Robot.intakeMotor.set(0);
		}
	}
	
	public static void autoTest(){
		int state = 0;
		switch(state)
		{
			case 0: 
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
						Robot.lFrontMotor.set(0.2);
				}
				else
				{
					Robot.lFrontMotor.set(0);
					timer.stop();
					state = 2;
				}
				break;
			case 1:
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
					Robot.lBackMotor.set(0.2);
				}
				else 
				{
					Robot.lBackMotor.set(0);
					timer.stop();
					state = 3;
				}
				break;
			case 2:
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
					Robot.rFrontMotor.set(0.2);
				}
				else 
				{
					Robot.rFrontMotor.set(0);
					timer.stop();
					state = 4;
				}
				break;
			case 3:
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
					Robot.rBackMotor.set(0.2);
				}
				else 
				{
					Robot.rBackMotor.set(0);
					timer.stop();
					state = 5;
				}
				break;
			case 5:
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
					Robot.gearMotor.set(0.2);
				}
				else
				{
					Robot.gearMotor.set(0);
					timer.stop();
					state = 6;
				}
				break;
			case 6:
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
					Robot.dumpMotor.set(0.2);
				}
				else 
				{
					Robot.dumpMotor.set(0);
					timer.stop();
					state = 7;
				}
				break;
			case 7:
				timer.reset();
				timer.start();
				if(timer.get() < 3)
				{
					Robot.intakeMotor.set(0.2);
				}
				else 
				{
					Robot.intakeMotor.set(0);
					timer.stop();
				}
				break;
				
		}
	}
	public static void intakeTest(){
		if(Robot.driveStick.getRawButton(1))
			Robot.intakeMotor.set(0.5);
		else if(Robot.driveStick.getRawButton(2))
			Robot.intakeMotor.set(-0.5);
		else 
			Robot.intakeMotor.set(0);
	}
	
}
