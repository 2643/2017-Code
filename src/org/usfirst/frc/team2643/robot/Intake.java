package org.usfirst.frc.team2643.robot;

public class Intake extends Robot{
	public Intake(){
	} 
	/**
	 * This is the intake function
	 * {@code intake()}: if the intake in button is pressed, then the intakeMotor will be set to positive.
	 * Else if the intake out button is pressed, then the intakeMotor will be set to negative.
	 * Else the intake motor will set to 0.
	 * 
	 * @see 
	 * 	  {@code RobotMap}: intake variables
	 */
	public static void intake(){
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(driveStick.getRawButton(RobotMap.INTAKE_IN_BUTTON)){
			intake = 1;
		}
		else if(driveStick.getRawButton(RobotMap.INTAKE_OUT_BUTTON)){
			intake = 2;
		}
		else if(driveStick.getRawButton(RobotMap.INTAKE_NO_BUTTON)){
			intake = 3;
		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//if the driveStick button 1 is pressed is true, then the robot intake motor will 
		//be set to the intake motor speed.
		if (intake == 1)
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_IN_SPEED);
			//System.out.println("IN");
		} 
		//else if the driveStick button 2 will make the intake motor preform outake.
		else if (intake == 2) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_OUT_SPEED);
			//System.out.println("OUT");
		} 
		//else the intake motor will be set to no speed.
		else if(intake == 3) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_NO_SPEED);
			//System.out.println("NOTHING");
		}
	}
}
