package org.usfirst.frc.team2643.robot;

public class Climber {
	public Climber() {
	}

	public static void climber() {
		if (Robot.opStick.getPOV() == 0)
			Robot.climberMotor.set(0.5);
		else if (Robot.opStick.getPOV() == 270)
			Robot.climberMotor.set(-0.5);
	}
}