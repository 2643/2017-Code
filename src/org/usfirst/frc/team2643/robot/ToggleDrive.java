package org.usfirst.frc.team2643.robot;

public class ToggleDrive {
	public ToggleDrive(){
		  
	}
	public static void toggledrive(){

			// if you press the button, then driveToggle will be true
			if (Robot.driveStick.getRawButton(Robot.toggleOn)) {
				Robot.driveToggle = true;
			}
			// if you press the button for toggleOff, then driveToggle will be false
			else if (Robot.driveStick.getRawButton(Robot.toggleOff)) {
				Robot.driveToggle = false;
			}

			// if driveToggle is not on, then motors will be at the full speed
			// of the joystick
			if (!Robot.driveToggle) {
				Robot.lFrontMotor.set(Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
				Robot.lBackMotor.set(Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS));
				Robot.rFrontMotor.set(Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));
				Robot.rBackMotor.set(Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS));
			}
			// otherwise if driveToggle is true, then the motors will be at the half
			// speed
			// of the joystick
			else {
				Robot.lFrontMotor.set((Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS)) * Robot.slowMult);
				Robot.lBackMotor.set((Robot.driveStick.getRawAxis(RobotMap.LEFT_JOYSTICK_AXIS)) * Robot.slowMult);
				Robot.rFrontMotor.set((Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS)) * Robot.slowMult);
				Robot.rBackMotor.set((Robot.driveStick.getRawAxis(RobotMap.RIGHT_JOYSTICK_AXIS)) * Robot.slowMult);
			}

		

	}
}
