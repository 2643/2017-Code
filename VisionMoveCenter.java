package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class VisionMoveCenter
{
	private static int state = RobotMap.state;

	// CASE 0
	private static double moveLeft0 = 0.38;
	private static double moveRight0 = 0.38;
	private static double highBound = 60.0;

	// CASE 1
	private static double moveLeft1 = 0.335;
	private static double moveRight1 = 0.335;
	private static double val = 0.0;

	// CASE 2
	private static double highBound2 = 80.0;

	// CASE 4
	private static double highBound3 = 110.0;

	// CASE 6
	private static double moveLeft6 = 0.45;
	private static double moveRight6 = 0.43;
	private static double moveTime = 0.2;

	private static Timer time = new Timer();

	// CASE VALUES FROM RASPPI
	private static double[] cenX = VisionProvideData.provideArray("CenterX");
	private static double[] ra = VisionProvideData.provideArray("Ratio");
	private static double[] height = VisionProvideData.provideArray("Height");
	private static double avg = VisionProvideData.provideNum("Average");

	public static void resetState()
	{
		state = 0;
	}

	public static void moveToCenter()
	{
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

			case 1:
				state = VisionAutoMovement.autoForward(moveLeft0, moveRight0, highBound, state, 2, 8);
				System.out.println("Case 1");
				break;
			case 2:
				state = VisionAutoMovement.autoCal(moveLeft1, moveRight1, state, 3, 8);
				System.out.println("Case 2");
				break;

			case 3:
				state = VisionAutoMovement.autoForward(moveLeft0, moveRight0, highBound2, state, 4, 8);
				System.out.println("Case 3");
				break;

			case 4:
				state = VisionAutoMovement.autoCal(moveLeft1, moveRight1, state, 5, 8);
				System.out.println("Case 4");
				break;

			case 5:
				state = VisionAutoMovement.autoForward(moveLeft0, moveRight0, highBound3, state, 6, 8);
				System.out.println("Case 5");
				break;

			case 6:
				state = VisionAutoMovement.autoCal(moveLeft1, moveRight1, state, 7, 8);
				System.out.println("Case 6");
				break;

			case 7:
				state = VisionAutoMovement.autoForwardTimed(moveLeft6, moveRight6, moveTime, state, 8);
				System.out.println("Case 7");
				break;

			case 8:
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
				//System.out.println("Case 8");
				break;
		}
	}
}
