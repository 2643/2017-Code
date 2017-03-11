package org.usfirst.frc.team2643.robot;

public class VisionAutoMovement
{
	/**
	 * Turns RobotMap in certain direction at a certain speed
	 * @param direction
	 * @param speed
	 */
	public static void moveDirection(int direction, double speed)
	{
		RobotMap.lBackMotor.set(direction * speed);
		RobotMap.lFrontMotor.set(direction * speed);
		RobotMap.rBackMotor.set(direction * speed);
		RobotMap.rFrontMotor.set(direction * speed);
	}

	/**
	 * Turns RobotMap in certain direction at a certain left Speed and right speed
	 * @param direction
	 * @param speedL
	 * @param speedR
	 */
	public static void moveDirection(int direction, double speedL, double speedR)
	{
		RobotMap.lBackMotor.set(direction * speedL);
		RobotMap.lFrontMotor.set(direction * speedL);
		RobotMap.rBackMotor.set(direction * speedR);
		RobotMap.rFrontMotor.set(direction * speedR);
	}

	/**
	 * Moves RobotMap forward at certain speed
	 * @param speed
	 */
	public static void moveForward(double speed)
	{
		RobotMap.lBackMotor.set(speed);
		RobotMap.lFrontMotor.set(speed);
		RobotMap.rBackMotor.set(-speed);
		RobotMap.rFrontMotor.set(-speed);
	}

	/**
	 * Move RobotMap forward at certain left and right speed
	 * @param speedL
	 * @param speedR
	 */
	public static void moveForward(double speedL, double speedR)
	{
		RobotMap.lBackMotor.set(speedL);
		RobotMap.lFrontMotor.set(speedL);
		RobotMap.rBackMotor.set(-speedR);
		RobotMap.rFrontMotor.set(-speedR);
	}
}
