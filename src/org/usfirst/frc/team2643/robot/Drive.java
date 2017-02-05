package org.usfirst.frc.team2643.robot;

public class Drive {
	
	public Drive(){
		  
	}
	//making a new Drive
	public static void drive(){
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

