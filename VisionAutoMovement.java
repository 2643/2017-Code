package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class VisionAutoMovement
{
	private static int left = 1;
	private static int right = -1;
	private static Timer time = new Timer();

	private static double divisorCon = 36.81818; // average - 240 / ratio
	private static double divisorConCVR = 85.089141;
	private static double divisorConSVR;

	/**
	 * Turns robot in certain direction at a certain speed
	 * 
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
	 * Turns robot in certain direction at a certain left Speed and right speed
	 * 
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
	 * Moves robot forward at certain speed
	 * 
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
	 * Move robot forward at certain left and right speed
	 * 
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

	///////////////////////////////////////////// AUTO MOVEMENT
	///////////////////////////////////////////// CODE/////////////////////////////////////////////
	/*
	 * CODE MAY BE ALL WRONG DUE TO A PROBLEM IN RETURNING AN INTEGER WHICH WILL
	 * NOT CHANGE DUE TO IT NOT BEING CHANGED AT ALL
	 */

	/**
	 * Turns in a certain direction
	 * 
	 * @param amountOfObjects
	 * @param moveSpeedL
	 * @param moveSpeedR
	 * @param direction
	 * @param stateAuto
	 * @param nextState
	 */
	public static int autoTurnDirection(int amountOfObjects, double moveSpeedL, double moveSpeedR, int direction,
			int state, int nextState, int breakState)
	{
		boolean toggle = false;
		moveDirection(direction, moveSpeedL, moveSpeedR);

		if (VisionProvideData.lengthOfArray("Height") >= amountOfObjects
				&& VisionProvideData.lengthOfArray("Height") <= 2)
		{
			System.out.println("is Toggled!");
			toggle = true;
			moveDirection(direction, 0);
		}

		if (toggle)
		{
			return nextState;
		}
		return state;
	}

	/**
	 * Encoder based auton move forward command with only one speed
	 * 
	 * @param moveSpeed
	 * @param encoderDistanceL
	 * @param encoderDistanceR
	 * @param stateAuto
	 */
	public static int autoForward(double moveSpeed, int encoderDistanceL, int encoderDistanceR, int state,
			int nextState)
	{
		boolean toggle = false;

		moveForward(moveSpeed);
		// System.out.println(Robot.lEncoder.get() + " " +
		// Robot.rEncoder.get());
		if (RobotMap.leftEncoder.get() < encoderDistanceL || RobotMap.rightEncoder.get() > encoderDistanceR)
		{
			toggle = true;
			moveForward(0); // stop movement as second
							// parameter is 0 speed
		}

		if (toggle)
		{
			RobotMap.leftEncoder.reset();
			RobotMap.rightEncoder.reset();
			return nextState;
		}
		return state;
	}

	/**
	 * Auto Move forward at a left and right speed (in order to compensate for
	 * turning VALUES MAY CHANGE) The code is to move forward to heightL and
	 * then move to the next state
	 * 
	 * @param moveSpeedL
	 * @param moveSpeedR
	 * @param heightL
	 * @param nextState
	 */
	public static int autoForward(double moveSpeedL, double moveSpeedR, double heightL, int state, int nextState,
			int breakState)
	{
		boolean toggle = false;
		moveForward(moveSpeedL, moveSpeedR);
		double[] height = VisionProvideData.provideArray("Height");

		if (height.length == 0)
		{
			System.out.println("No values! going to end state");
			moveForward(0);
			return breakState;
		}
		else if (height.length < 2)
		{
			System.out.println("NOT ENOUGH!! turning!");
			if (height[0] < 240)
			{
				moveDirection(left, moveSpeedL, moveSpeedR);
			}
			else
			{
				moveDirection(right, moveSpeedL - 0.04, moveSpeedR + 0.025);
			}
		}
		else if (height.length > 2)
		{
			System.out.println("TOO MUCH NOISE");
			state = breakState;
			moveForward(0);
		}
		else
		{
			if (height[0] > heightL)
			{
				System.out.println("Height reached " + height[0]);
				toggle = true;

				moveForward(0);
			}
		}

		if (toggle)
		{
			VisionCameraStatus.autoModeStatus(1);
			return nextState;
		}
		return state;
	}

	/**
	 * Move forward under a timer
	 * 
	 * @param moveSpeedL
	 * @param moveSpeedR
	 * @param amountTime
	 * @param finalState
	 */

	public static int autoForwardTimed(double moveSpeedL, double moveSpeedR, double amountTime, int state,
			int finalState)
	{
		boolean toggle = false;
		time.start();

		while (!toggle)
		{
			moveForward(moveSpeedL, moveSpeedR);
			
			if (time.get() > amountTime)
			{
				time.stop();
				System.out.println("Time reached " + time.get());
				toggle = true;
				moveForward(0); // stop movement as
								// second parameter is 0
								// speed
			}
		}

		if (toggle)
		{
			time.reset();
			System.out.println("END");
			return finalState;
		}
		return state;
	}

	/**
	 * Auto Calibration with left and right speed Once in the ratio area solved
	 * by ((average - 240) / ratio) / divisor (36.81818) PRACTICE BOT
	 * 
	 * @param moveSpeedL
	 * @param moveSpeedR
	 * @param r2
	 * @param comp2
	 * @param nextState
	 */
	public static int autoCal(double moveSpeedL, double moveSpeedR, int state, int nextState, int breakState)
	{
		boolean toggle = false;

		double[] cenX = VisionProvideData.provideArray("CenterX");
		double[] ra = VisionProvideData.provideArray("Ratio");
		double[] height = VisionProvideData.provideArray("Height");
		double avg = VisionProvideData.provideNum("Average");

		int tmp = 0;

		if (cenX.length == 0)
		{
			moveForward(0);
			return breakState;
		}
		if (cenX.length < 2)
		{
			if (height[0] < 240)
			{
				moveDirection(left, moveSpeedL, moveSpeedR);
			}
			else
			{
				moveDirection(right, moveSpeedL, moveSpeedR);
			}
		}
		else if (cenX.length == 2)
		{
			if (cenX[0] - 240 < cenX[1] - 240 && cenX.length == 2)
				tmp = 0;
			else
				tmp = 1;

			double val = ((Math.abs(avg - 240) / ra[tmp]) / divisorConCVR);

			System.out.println(cenX[0] + "   " + cenX[1] + "    " + val);

			if (val > 1.25) // left
			{
				moveDirection(left, moveSpeedL, moveSpeedR);
			}
			else if (val < 1.0) // right
			{
				moveDirection(right, moveSpeedL - 0.05, moveSpeedR + 0.025);
			}
			else
			{
				System.out.println("CENTERED");
				moveForward(0);
				toggle = true;
			}
		}

		if (toggle)
		{
			return nextState;
		}
		return state;
	}
}