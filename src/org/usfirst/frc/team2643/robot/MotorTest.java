package org.usfirst.frc.team2643.robot;

public class MotorTest extends Robot{
	
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
	
	public static void teststuff()
	{
		//this prints the encoder or the potentiomter value
		if(driveStick.getRawAxis(5) > 0)
			System.out.println("Encoder Value: " + (Math.abs(RobotMap.leftEncoder.get() + RobotMap.rightEncoder.get())/2));
		else if(driveStick.getRawAxis(5) < 0)
			System.out.println("Potentiometer: " + pot.get());
		else 
			System.out.println("Neither being tested.");
	}

}
