package org.usfirst.frc.team2643.robot;

public class Climber {
	public Climber() {
	}

	/**
	 * {@code climber()}: 
	 * 		If the dPad is pressed up, then the climber motor will set to positive.
	 * 		Else if the dPad is pressed down, then the climber will set to negative.
	 * 		Else the climber will be set to 0.
	 */ 
	public static void climber() {
		if (Robot.opStick.getPOV() == 0)
			Robot.climberMotor.set(0.5);
		else if (Robot.opStick.getPOV() == 270)
			Robot.climberMotor.set(-0.5);
		else 
			Robot.climberMotor.set(0);
	}
}