package org.usfirst.frc.team2643.robot;

public class Drive {
	public Drive(){
		  
	}
	public static void drive(){
		 
			
			Robot.lFrontMotor.set(Robot.driveStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS));
			Robot.lBackMotor.set(Robot.driveStick.getRawAxis(robotMap.LEFT_JOYSTICK_AXIS));
			Robot.rBackMotor.set(Robot.driveStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS));
			Robot.rFrontMotor.set(Robot.driveStick.getRawAxis(robotMap.RIGHT_JOYSTICK_AXIS));
			
		
	}
}

