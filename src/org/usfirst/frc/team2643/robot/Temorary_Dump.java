package org.usfirst.frc.team2643.robot;

public class Temorary_Dump 
{
	public Temorary_Dump(){
		
	} 
	
	public static void dump(){
		if (Robot.opStick.getPOV() == 0) 
		{
			Robot.dumpMotor.set(RobotMap.DUMP_UP_FULL_SPEED);
		}
		
		else if (Robot.opStick.getPOV() == 90)
		{
			Robot.dumpMotor.set(RobotMap.DUMP_UP_HALF_SPEED);
		} 
		
		else if(Robot.opStick.getPOV() == 180)
		{
			Robot.dumpMotor.set(RobotMap.DUMP_DOWN_SPEED);
		}
		else 
		{
			Robot.dumpMotor.set(RobotMap.DUMP_NO_SPEED);
		}
	}
}

