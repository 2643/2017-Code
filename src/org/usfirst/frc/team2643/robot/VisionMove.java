package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionMove
{
	private static int stateAuto = RobotMap.state;
	static NetworkTable table = VisionAuto.table;
	private static int center = 225;
	private static int compensation = 10;
	private static int left = 1;
	private static int right = -1;
	private static double highBound = 100.0;// 98.0
	private static boolean finishToggle = false;
	private static double average;
	private static Timer time = new Timer();

	private static Accelerometer accel
	= new BuiltInAccelerometer(Accelerometer.Range.k8G);
	
	//First Case
	private static int moveForwardRightEncoder = 1720; //ENCODER ticks
	private static int moveForwardLeftEncoder = -2080;
	
	private static double moveSpeed0 = 0.65; //<--for case 0
	
	//Second Case
	private static double moveSpeed1 = 0.35; //<--for case 1

	//Third Case
	private static double moveSpeed2L = 0.275;//<--for case 2
	private static double moveSpeed2R = 0.24;//<--for case 2
	
	public static void movePos(int direction)
	{
		/*int center2 = 0;
		if(direction == left)
		{
			center = 289;
			center2 = 303;
		}
		else if(direction == right)
		{
			center = 225;
			center2 = 260;
		}*/
		
		switch (stateAuto)
		{
			/*
			 * MOVE FORWARD to @moveForwardLeftEncoder and @moveForwardRightEncoder
			 */
			case 0: 
				autoForward(moveSpeed0, moveForwardLeftEncoder, moveForwardRightEncoder);
				System.out.println("CASE 0");
				break;
			
			/*
			 * TURN @Direction at speed @moveSpeed1 until it sees 2 objects
			 */
			case 1:
				autoTurnDirection(2, moveSpeed1, moveSpeed1, direction);
				System.out.println("CASE 1");
				break;
			
			/*
			* TURN @Direction at speed @moveSpeed2L and @moveSpeed2R
			*/	
			case 2:
				autoTurnDirection(2, moveSpeed2L, moveSpeed2R, direction);
				System.out.println("CASE 2");
				break;
			
			/*
			 * TODO: CALIBRATION TO CENTER BY USING RATIO of distance between center of gear and camera
			 *  and take ratio of pixels from center of hook to center of the camera
			 */
			case 3:
				System.out.println("CASE 3");
				System.out.println("UHHHHH");
				break;
		}
	}
	
	public static void autoForward(double moveSpeed, int encoderDistanceL, int encoderDistanceR)
	{
		boolean toggle = false;
		while (!toggle)
		{
			VisionAutoMovement.moveForward(moveSpeed);
			System.out.println(accel.getX() + "  " + accel.getY() + "   " + accel.getZ());
			if (RobotMap.leftEncoder.get() < encoderDistanceL || RobotMap.rightEncoder.get() > encoderDistanceR)
			{
				toggle = true;
				VisionAutoMovement.moveForward(0); //stop movement as second parameter is 0 speed	
			}
		}

		if (toggle)
		{
			RobotMap.leftEncoder.reset();
			RobotMap.rightEncoder.reset();
			stateAuto = 1;
		}
	}
	
	public static void autoTurnDirection(int amountOfObjects, double moveSpeedL, double moveSpeedR, int direction) 
	{
		boolean toggle = false;
		while(!toggle)
		{
			VisionAutoMovement.moveDirection(direction, moveSpeedL, moveSpeedR);
			
			if(VisionProvideData.lengthOfArray("Height") >= amountOfObjects)
			{
				toggle = true;
				VisionAutoMovement.moveDirection(direction, 0); //stop movement as second parameter is 0 speed	
			}
		}
		
		if (toggle)
		{
			stateAuto = 1;
		}
	}
}
