package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class VisionMoveCenter
{	
	private static int left = 1;
	private static int right = -1;
	private static Timer time = new Timer();
	private static int state = RobotMap.state;

	private static double divisorCon = 36.81818;
	private static double divisorConCVR = 85.089141;

	// CASE 0
	private static double moveLeft0 = 0.38;
	private static double moveRight0 = 0.38;
	private static double highBound = 60.0;

	// CASE 1
	private static double moveLeft1 = 0.25;
	private static double moveRight1 = 0.225;
	private static double val = 0.0;

	// CASE 2
	private static double highBound2 = 80.0;

	// CASE 4
	private static double highBound3 = 110.0;

	// CASE 6
	private static double moveLeft6 = 0.0;
	private static double moveRight6 = 0.0;
	private static double moveTime = 0.0;

	// CASE VALUES FROM RASPPI
	private static double[] cenX = VisionProvideData.provideArray("CenterX");
	private static double[] ra = VisionProvideData.provideArray("Ratio");
	private static double[] height = VisionProvideData.provideArray("Height");
	private static double avg = VisionProvideData.provideNum("Average");

	public static void moveToCenter()
	{
		switch (state)
		{
			case 0:
				autoForward(moveLeft0, moveRight0, highBound, 1);
				System.out.println("Case 1");
				break;
			case 1:
				autoCal(moveLeft1, moveRight1, 2, 7);
				System.out.println("Case 2");
				break;

			case 2:
				autoForward(moveLeft0, moveRight0, highBound2, 3);
				System.out.println("Case 3");
				break;

			case 3:
				autoCal(moveLeft1, moveRight1, 4, 7);
				System.out.println("Case 4");
				break;

			case 4:
				autoForward(moveLeft0, moveRight0, highBound3, 5);
				System.out.println("Case 5");
				break;

			case 5:
				autoCal(moveLeft1, moveRight1, 6, 7);
				System.out.println("Case 6");
				break;

			case 6:
				autoForwardTimed(moveLeft6, moveRight6, moveTime, 7);
				break;
				
			case 7:
				break;
		}
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
	public static void autoForward(double moveSpeedL, double moveSpeedR, double heightL, int nextState)
	{
		boolean toggle = false;
		
		while (!toggle && Robot.time.get() < 15)
		{
			VisionAutoMovement.moveForward(moveSpeedL, moveSpeedR);
			height = VisionProvideData.provideArray("Height");
			if(height.length == 0)
			{
				continue;
			}
			else if (height.length < 2)
			{
				if (height[0] < 240)
				{
					VisionAutoMovement.moveDirection(left, moveSpeedL, moveSpeedR);
				}
				else
				{
					VisionAutoMovement.moveDirection(right, moveSpeedL - 0.04, moveSpeedR + 0.025);
				}
			}
			else if(height.length > 2)
			{
				continue;
			}
			else
			{
				if (height[0] > heightL)
				{
					System.out.println("Height reached " + height[0]);
					toggle = true;

					VisionAutoMovement.moveForward(0);
				}
			}
		}

		if (toggle)
		{
			VisionCameraStatus.autoModeStatus(1);
			state = nextState;
		}
	}

	public static void autoForwardTimed(double moveSpeedL, double moveSpeedR, double amountTime, int finalState)
	{
		boolean toggle = false;
		time.start();
		
		while (!toggle && Robot.time.get() < 15)
		{
			VisionAutoMovement.moveForward(moveSpeedL, moveSpeedR);
			if (time.get() > amountTime)
			{

				System.out.println("Time reached " + time.get());
				toggle = true;

				VisionAutoMovement.moveForward(0); // stop movement as
													// second parameter is 0
													// speed
			}
		}

		if (toggle)
		{
			time.stop();
			time.reset();
			System.out.println("END");
			state = finalState;
		}
	}

	/**
	 * Auto Calibration with left and right speed Once in the ratio area solved
	 * by ((average - 240) / ratio) / divisor (36.81818)
	 * 
	 * @param moveSpeedL
	 * @param moveSpeedR
	 * @param r2
	 * @param comp2
	 * @param nextState
	 */
	public static void autoCal(double moveSpeedL, double moveSpeedR, int nextState, int breakCode)
	{
		boolean toggle = false;

		while (!toggle && Robot.time.get() < 15)
		{
			cenX = VisionProvideData.provideArray("CenterX");
			ra = VisionProvideData.provideArray("Ratio");
			height = VisionProvideData.provideArray("Height");
			avg = VisionProvideData.provideNum("Average");

			int tmp = 0;

			if (cenX.length > 2)
			{
				continue;
			}
			else if(cenX.length < 2)
			{
				if (height[0] < 240)
				{
					VisionAutoMovement.moveDirection(left, moveSpeedL, moveSpeedR);
				}
				else
				{
					VisionAutoMovement.moveDirection(right, moveSpeedL - 0.04, moveSpeedR + 0.025);
				}
			}
			else
			{
				if (cenX[0] - 240 < cenX[1] - 240)
					tmp = 0;
				else
					tmp = 1;

				val = ((Math.abs(avg - 240) / ra[tmp]) / divisorConCVR);
				//TODO: System.out.println(val);
				if (val > 1.25) // left
				{
					// System.out.println(r2 + comp2 + " LEFT");
					VisionAutoMovement.moveDirection(left, moveSpeedL, moveSpeedR);
				}
				else if (val < 1.0) // right
				{
					// System.out.println(r2 - comp2 + " RIGHT");
					VisionAutoMovement.moveDirection(right, moveSpeedL - 0.05, moveSpeedR + 0.025);
				}
				else
				{
					System.out.println("CENTERED");
					VisionAutoMovement.moveForward(0);
					toggle = true;
				}
			}
		}

		if (toggle)
		{
			state = nextState;
		}
	}
}
