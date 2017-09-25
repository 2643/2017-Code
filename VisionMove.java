package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionMove
{
	private static int state;
	static NetworkTable table = VisionAuto.table;
	private static int left = 1;
	private static int right = -1;
	private static boolean finishToggle = false;
	private static double average;
	private static Timer time = new Timer();

	// First Case
	private static int moveForwardRightEncoder = 2225; // ENCODER ticks
	private static int moveForwardLeftEncoder = -2225;

	private static double moveSpeed0 = 0.75; // <--for case 0

	// Second Case
	private static double moveSpeed1 = 0.325; // <--for case 1

	// Third Case
	private static double moveSpeed2L = 0.35;// <--for case 2
	private static double moveSpeed2R = 0.35;// <--for case 2

	// Forth Case
	private static double moveLeft1 = 0.365;
	private static double moveRight1 = 0.355;

	// Fifth Case
	private static double moveLeft0 = 0.465;
	private static double moveRight0 = 0.455;

	// CASE 2
	private static double highBound = 90.0;

	// CASE 4
	private static double highBound2 = 135.0;

	// CASE 6
	private static double moveLeft6 = 0.55;
	private static double moveRight6 = 0.54;
	private static double moveTime = 0.65;

	public static void resetState()
	{
		state = 0;
	}

	public static void movePos(int direction)
	{
		//System.out.print("Direction: " + direction + "	" + state);
		switch (state)
		{
			case 0:
				time.start();
				while (time.get() < 1.0)
				{
					RobotMap.climbMotor.set(0.3);
				}
				RobotMap.climbMotor.set(0);
				time.stop();
				time.reset();
				state = 1;
				VisionCameraStatus.takePhoto(1);
				System.out.println("Case 0");
				break;

			/*
			 * MOVE FORWARD to @moveForwardLeftEncoder
			 * and @moveForwardRightEncoder
			 */
			case 1:
				System.out.println("MOVED TO CASE 1");
				state = VisionAutoMovement.autoForward(moveSpeed0, moveForwardLeftEncoder, moveForwardRightEncoder,
						state, 2);
				System.out.println("Case 1 completed");
				break;

			/*
			 * TURN @Direction at speed @moveSpeed1 until it sees 2 objects
			 */
			case 2:
				state = VisionAutoMovement.autoTurnDirection(1, moveSpeed1, moveSpeed1, direction, state, 3, 10);
				System.out.println("Case 2");
				break;

			/*
			 * TURN @Direction at speed @moveSpeed2L and @moveSpeed2R
			 */
			case 3:
				state = VisionAutoMovement.autoTurnDirection(2, moveSpeed2L, moveSpeed2R, direction, state, 4, 10);
				System.out.println("Case 3");
				break;

			case 4:
				state = VisionAutoMovement.autoCal(moveLeft1, moveRight1, state, 5, 10);
				System.out.println("Case 4" + "	" + state);
				break;

			case 5:
				state = VisionAutoMovement.autoForward(moveLeft0, moveRight0, highBound, state, 6, 10);
				System.out.println("Case 5");
				break;

			case 6:
				state = VisionAutoMovement.autoCal(moveLeft1, moveRight1, state, 7, 10);
				System.out.println("Case 6");
				break;

			case 7:
				state = VisionAutoMovement.autoForward(moveLeft0, moveRight0, highBound2, state, 8, 10);
				System.out.println("Case 7");
				break;

			case 8:
				state = VisionAutoMovement.autoCal(moveLeft1, moveRight1, state, 9, 10);
				System.out.println("Case 8");
				break;

			case 9:
				state = VisionAutoMovement.autoForwardTimed(moveLeft6, moveRight6, moveTime, state, 10);
				System.out.println("Case 9");
				break;

			case 10:
				if (RobotMap.gearBottomLimit.get() == true)// if it is not
															// hitting the limit
				{
					RobotMap.gearMotor.set(-0.4);
				}
				else // if it is hitting the limit
				{
					// at -0.25 when at hover position, the plate ends up
					// bending, but we are leaving it alone
					RobotMap.gearMotor.set(-0.25);
				}
				//System.out.print("Case 10");
				break;
		}
	}
}
