package org.usfirst.frc.team2643.robot;

public class Intake extends Robot{
	public Intake(){
	} 
	
	public static void intake(){
		int intake = 3;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(opStick.getRawButton(5)){
			intake = 1;
		}
		else if(opStick.getRawButton(6)){
			intake = 2;
		}
		else if(opStick.getRawButton(7)){
			intake = 3;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//if the opStick button 1 is pressed is true, then the robot intake motor will 
		//be set to the intake motor speed.
		if (intake == 1)
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_IN_SPEED);
			System.out.println("Intake set to 'IN'");
		} 
		//else if the opStick button 2 will make the intake motor preform outake.
		else if (intake == 2) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_OUT_SPEED);
			System.out.println("Intake set to 'OUT'");
		} 
		//else the intake motor will be set to no speed.
		else if(intake == 3) 
		{
			Robot.intakeMotor.set(RobotMap.INTAKE_NO_SPEED);
			System.out.println("Intake set to 'OFF'");
		}
	}
}
