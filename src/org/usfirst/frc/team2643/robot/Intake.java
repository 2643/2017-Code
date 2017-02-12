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
	 * 	  {@code RobotMap}: Intake variables
	 */
	public static void intake(){
		int intake = 3;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(opStick.getRawButton(RobotMap.INTAKE_IN_BUTTON)){
			intake = 1;
		}
		else if(opStick.getRawButton(RobotMap.INTAKE_OUT_BUTTON)){
			intake = 2;
		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//if the opStick button 1 is pressed is true, then the robot intake motor will 
		//be set to the intake motor speed.
		if (intake == 1)
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_IN_SPEED);
		} 
		//else if the opStick button 2 will make the intake motor preform outake.
		else if (intake == 2) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_OUT_SPEED);
		} 
		//else the intake motor will be set to no speed.
		else if(intake == 3) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_NO_SPEED);
		}
	}
}
