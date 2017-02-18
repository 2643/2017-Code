package org.usfirst.frc.team2643.robot;



import edu.wpi.first.wpilibj.Timer;

public class MotorTest extends Robot{
	static Timer timer = new Timer();

	public static void testMotor()
	{
		//This tests the left front wheel motor
		if(driveStick.getRawButton(1)){lFrontMotor.set(driveStick.getRawAxis(1));}	
		else {lFrontMotor.set(0);}
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//This tests the left back wheel motor
		if(driveStick.getRawButton(2)){lBackMotor.set(driveStick.getRawAxis(1));}	
		else {lBackMotor.set(0);}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the right front wheel motor
		if(driveStick.getRawButton(3)){rFrontMotor.set(driveStick.getRawAxis(1));}	
		else {rFrontMotor.set(0);}			
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//this thest the right back wheel motor
		if(driveStick.getRawButton(4)){rBackMotor.set(driveStick.getRawAxis(1));}
		else {rBackMotor.set(0);}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the gear motor
		if(driveStick.getRawButton(5)){gearMotor.set(driveStick.getRawAxis(1)*0.25);}
		else {gearMotor.set(0);}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the dump motor
		if(driveStick.getRawButton(6)){dumpMotor.set(driveStick.getRawAxis(1)*0.25);}
		else {dumpMotor.set(0);}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//this tests the intake motor
		if(driveStick.getRawButton(7)){intakeMotor.set(driveStick.getRawAxis(1));}
		else {intakeMotor.set(0);}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//this tests the climber motor
		if(driveStick.getRawButton(8)){climberMotor.set(driveStick.getRawAxis(1));}
		else {climberMotor.set(0);}
	}
	public static void encoderTest()
	{
		//this prints the encoder or the potentiomter value
		if(driveStick.getRawAxis(5) > 0)
			System.out.println("Encoder Value: " + (Math.abs(RobotMap.leftEncoder.get() + RobotMap.rightEncoder.get())/2));
	}
	public static void autoTest()
	{
		int state = 0;
		switch (state) {
		case 0:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.lFrontMotor.set(0.2);
			} else {
				Robot.lFrontMotor.set(0);
				timer.stop();
				state = 2;
			}
			break;
		case 1:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.lBackMotor.set(0.2);
			} else {
				Robot.lBackMotor.set(0);
				timer.stop();
				state = 3;
			}
			break;
		case 2:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.rFrontMotor.set(0.2);
			} else {
				Robot.rFrontMotor.set(0);
				timer.stop();
				state = 4;
			}
			break;
		case 3:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.rBackMotor.set(0.2);
			} else {
				Robot.rBackMotor.set(0);
				timer.stop();
				state = 5;
			}
			break;
		case 5:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.gearMotor.set(0.2);
			} else {
				Robot.gearMotor.set(0);
				timer.stop();
				state = 6;
			}
			break;
		case 6:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.dumpMotor.set(0.2);
			} else {
				Robot.dumpMotor.set(0);
				timer.stop();
				state = 7;
			}
			break;
		case 7:
			timer.reset();
			timer.start();
			if (timer.get() < 3) {
				Robot.intakeMotor.set(0.2);
			} else {
				Robot.intakeMotor.set(0);
				timer.stop();
			}
			break;

		}
	}
	public static void intakeTest()
	{
		if(driveStick.getRawButton(1)){
			intakeMotor.set(1);
		}
		else if(driveStick.getRawButton(2));
		{
			intakeMotor.set(-1);
		}

	}
	public static void driveTest()
	{
		//The left front motor is set to the stick on the joystick, y axis (1).
		Robot.lFrontMotor.set(Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
		//The left back motor is set to the stick on the joystick, y axis (1).
		Robot.lBackMotor.set(Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
		//The right back motor is set to the stick on the joystick, y axis (5).
		Robot.rBackMotor.set(Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));
		//The right front motor is set to the stick on the joystick, y axis (5).
		Robot.rFrontMotor.set(Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));

	}
}