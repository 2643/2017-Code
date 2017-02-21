package org.usfirst.frc.team2643.robot;

public class VisionAutoMovement
{
	private static int moveLeft = 1;
	private static int moveRight = -1;
	private static double speed = 0.2;
	private static int center = 220;

	public static void trackingRetro(double[] centerXVal, int compensation, boolean period)
	{
		double averageX = ((centerXVal[0] + centerXVal[1]) / 2.0);

		masterMove(averageX, compensation);
	}

	private static void masterMove(double averageX, int compensation)
	{
		while (!(averageX < center + compensation && averageX > center - compensation))
		{
			if (averageX < center + compensation && averageX > center - compensation)
			{
				moveForward(0.54, 0.46);
				System.out.println("MOVING FORWARD*");
				break;
			}
			else if (averageX > center + compensation)
			{
				moveDirection(moveLeft, 0.247, 0.25);
				System.out.println("MOVING LEFT*");
			}
			else if (averageX < center - compensation)
			{
				moveDirection(moveRight, 0.27, 0.265);
				System.out.println("MOVING RIGHT*");
			}
		}
	}

	public static void moveDirection(int direction, double speed)
	{
		RobotMap.lBackMotor.set(direction * speed);
		RobotMap.lFrontMotor.set(direction * speed);
		RobotMap.rBackMotor.set(direction * speed);
		RobotMap.rFrontMotor.set(direction * speed);
	}

	public static void moveDirection(int direction, double speedL, double speedR)
	{
		RobotMap.lBackMotor.set(direction * speedL);
		RobotMap.lFrontMotor.set(direction * speedL);
		RobotMap.rBackMotor.set(direction * speedR);
		RobotMap.rFrontMotor.set(direction * speedR);
	}

	public static void moveForward(double speed)
	{
		RobotMap.lBackMotor.set(speed);
		RobotMap.lFrontMotor.set(speed);
		RobotMap.rBackMotor.set(-speed);
		RobotMap.rFrontMotor.set(-speed);
	}

	public static void moveForward(double speedL, double speedR)
	{
		RobotMap.lBackMotor.set(speedL);
		RobotMap.lFrontMotor.set(speedL);
		RobotMap.rBackMotor.set(-speedR);
		RobotMap.rFrontMotor.set(-speedR);
	}
}
