package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

//public static balloons extends adena
public class TestRun {


	public static void manualTest() {
		if (Robot.opStick.getRawButton(1)) {
			Robot.lFrontMotor.set(0.2);
		} else {
			Robot.lFrontMotor.set(0);
		}

		if (Robot.opStick.getRawButton(2)) {
			Robot.lBackMotor.set(0.2);
		} else {
			Robot.lBackMotor.set(0);
		}

		if (Robot.opStick.getRawButton(3)) {
			Robot.rFrontMotor.set(0.2);
		} else {
			Robot.rFrontMotor.set(0);
		}

		if (Robot.opStick.getRawButton(4)) {
			Robot.rBackMotor.set(0.2);
		} else {
			Robot.rBackMotor.set(0);
		}

		if (Robot.opStick.getRawButton(5)) {
			Robot.gearMotor.set(0.2);
		} else {
			Robot.gearMotor.set(0);
		}

		if (Robot.opStick.getRawButton(6)) {
			Robot.dumpMotor.set(0.2);
		} else {
			Robot.dumpMotor.set(0);
		}

		if (Robot.opStick.getRawButton(7)) {
			Robot.intakeMotor.set(0.2);
		} else {
			Robot.intakeMotor.set(0);
		}
	}

	

	public static void intakeTest() {
		if (Robot.driveStick.getRawButton(1))
			Robot.intakeMotor.set(0.5);
		else if (Robot.driveStick.getRawButton(2))
			Robot.intakeMotor.set(-0.5);
		else
			Robot.intakeMotor.set(0);
	}

}
