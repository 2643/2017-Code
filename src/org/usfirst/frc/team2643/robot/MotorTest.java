package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class MotorTest extends Robot{
	static Timer timer = new Timer();
	public static void testMotor()
	{
		//This tests the left front wheel motor
		if(RobotMap.driveStick.getRawButton(1)){RobotMap.lFrontMotor.set(RobotMap.driveStick.getRawAxis(1));}	
		else {RobotMap.lFrontMotor.set(0);}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//This tests the left back wheel motor
		if(RobotMap.driveStick.getRawButton(2)){RobotMap.lBackMotor.set(RobotMap.driveStick.getRawAxis(1));}	
		else {RobotMap.lBackMotor.set(0);}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the right front wheel motor
		if(RobotMap.driveStick.getRawButton(3)){RobotMap.rFrontMotor.set(RobotMap.driveStick.getRawAxis(1));}	
		else {RobotMap.rFrontMotor.set(0);}			
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//this thest the right back wheel motor
		if(RobotMap.driveStick.getRawButton(4)){RobotMap.rBackMotor.set(RobotMap.driveStick.getRawAxis(1));}
		else {RobotMap.rBackMotor.set(0);}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the gear motor
		if(RobotMap.driveStick.getRawButton(5)){RobotMap.gearMotor.set(RobotMap.driveStick.getRawAxis(1)*0.25);}
		else {RobotMap.gearMotor.set(0);}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the dump motor
		if(RobotMap.driveStick.getRawButton(6)){RobotMap.dumpMotor.set(RobotMap.driveStick.getRawAxis(1)*0.25);}
		else {RobotMap.dumpMotor.set(0);}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the intake motor
		if(RobotMap.driveStick.getRawButton(7)){RobotMap.intakeMotor.set(RobotMap.driveStick.getRawAxis(1));}
		else {RobotMap.intakeMotor.set(0);}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//this tests the climber motor
	//	if(RobotMap.driveStick.getRawButton(8)){RobotMap.climberMotor.set(RobotMap.driveStick.getRawAxis(1));}
	//	else {RobotMap.climberMotor.set(0);}
	}
	public static void encoderTest()
	{
		//this prints the encoder or the potentiomter value
	//	if(RobotMap.driveStick.getRawAxis(5) > 0)
	//		System.out.println("Encoder Value: " + (Math.abs(RobotMap.leftEncoder.get() + RobotMap.rightEncoder.get())/2));
	}
	public static void autoTest()
	{
		int state = 0;
		switch (state) {
		case 0:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.lFrontMotor.set(0.2);
			} else {
				RobotMap.lFrontMotor.set(0);
				timer.stop();
				state = 2;
			}
			break;
		case 1:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.lBackMotor.set(0.2);
			} else {
				RobotMap.lBackMotor.set(0);
				timer.stop();
				state = 3;
			}
			break;
		case 2:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.rFrontMotor.set(0.2);
			} else {
				RobotMap.rFrontMotor.set(0);
				timer.stop();
				state = 4;
			}
			break;
		case 3:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.rBackMotor.set(0.2);
			} else {
				RobotMap.rBackMotor.set(0);
				timer.stop();
				state = 5;
			}
			break;
		case 5:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.gearMotor.set(0.2);
			} else {
				RobotMap.gearMotor.set(0);
				timer.stop();
				state = 6;
			}
			break;
		case 6:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.dumpMotor.set(0.2);
			} else {
				RobotMap.dumpMotor.set(0);
				timer.stop();
				state = 7;
			}
			break;
		case 7:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				RobotMap.intakeMotor.set(0.2);
			} else {
				RobotMap.intakeMotor.set(0);
				timer.stop();
			}
			break;

		}
	}
	public static void intakeTest()
	{
		if(RobotMap.driveStick.getRawButton(1)){
			RobotMap.intakeMotor.set(1);
			System.out.println("Going out");
		}
		else if(RobotMap.driveStick.getRawButton(2));
		{
			RobotMap.intakeMotor.set(-1);
			System.out.println("Going in");
		}
	}
	public static void driveTest()
	{
		//The left front motor is set to the stick on the joystick, y axis (1).
		RobotMap.lFrontMotor.set(RobotMap.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
		//The left back motor is set to the stick on the joystick, y axis (1).
		RobotMap.lBackMotor.set(RobotMap.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
		//The right back motor is set to the stick on the joystick, y axis (5).
		RobotMap.rBackMotor.set(RobotMap.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));
		//The right front motor is set to the stick on the joystick, y axis (5).
		RobotMap.rFrontMotor.set(RobotMap.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));

	}
}