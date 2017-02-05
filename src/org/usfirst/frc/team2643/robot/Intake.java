package org.usfirst.frc.team2643.robot;

public class Intake {
	public Intake(){
		 
	} 
	
	public static void intake(){
		//if the opStick button 1 is pressed is true, then the robot intake motor will 
		//be set to the intake motor speed.
		if (Robot.opStick.getRawButton(RobotMap.INTAKE_IN_BUTTON) == true)
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_IN_SPEED);
		} 
		//else if the opStick button 2 will make the intake motor preform outake.
		else if (Robot.opStick.getRawButton(RobotMap.INTAKE_OUT_BUTTON)) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_OUT_SPEED);
		} 
		//else the intake motor will be set to no speed.
		else 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_NO_SPEED);
		}
	}
}
