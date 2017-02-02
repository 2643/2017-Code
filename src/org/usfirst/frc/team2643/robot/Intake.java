package org.usfirst.frc.team2643.robot;

public class Intake {
	public Intake(){
		 
	} 
	
	public static void intake(){
		if (Robot.opStick.getRawButton(robotMap.INTAKE_IN_BUTTON) == true)
		{
			Robot.intakeMotor.set(robotMap.INTAKE_IN_SPEED);
		} 
		else if (Robot.opStick.getRawButton(robotMap.INTAKE_OUT_BUTTON)) 
		{
			Robot.intakeMotor.set(robotMap.INTAKE_OUT_SPEED);
		} 
		else 
		{
			Robot.intakeMotor.set(robotMap.INTAKE_NO_SPEED);
		}
	}
}
