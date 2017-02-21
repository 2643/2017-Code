package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;
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

	private static double[] centerX;
	// TODO: add in Encoder check

	public static void movePos(int direction)
	{
		int center2 = 0;
		if(direction == left)
		{
			center = 289;
			center2 = 303;
		}
		else if(direction == right)
		{
			center = 225;
			center2 = 265;
		}
		
		switch (stateAuto)
		{
			case 0:
				boolean toggle = false;
				System.out.println("CASE 0 - Left or Right");
				while (RobotMap.leftEncoder.get() > -1680 || RobotMap.rightEncoder.get() < 1320)
				{
					System.out.println(RobotMap.leftEncoder.get() + "   " + RobotMap.rightEncoder.get());
					String val = RobotMap.arduino.readString();
					if (RobotMap.gyroToggle)
					{
						RobotMap.tmp = 0;
						RobotMap.x = 0;
						RobotMap.gyroToggle = false;
					}

					GyroMaster.gyroMaster(val, 0.65);
					if (RobotMap.leftEncoder.get() < -1680 || RobotMap.rightEncoder.get() > 1320)
					{
						toggle = true;
						VisionAutoMovement.moveDirection(1, 0);
					}
					
				}

				if (toggle)
				{
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();
					stateAuto = 1;
				}
				break;

			case 1:
				RobotMap.gyroToggle = true;
				boolean toggle1 = false;

				int heightL = VisionCheckHeights.lengthOfArray("Height");
				int centerXL = VisionCheckHeights.lengthOfArray("CenterX");

				System.out.println("CASE 1");
				while (heightL < 2)
				{
					VisionAutoMovement.moveDirection(direction, 0.25, 0.23);
					heightL = VisionCheckHeights.lengthOfArray("Height");
					centerXL = VisionCheckHeights.lengthOfArray("CenterX");

					if (heightL >= 2 || centerXL >= 2)
					{
						toggle1 = true;
						break;
					}
				}

				if (toggle1)
				{
					try
					{
						Thread.sleep(400);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("CASE 2");
					VisionAutoMovement.moveDirection(direction, 0);
					stateAuto = 2;

				}
				break;

			case 2:
				boolean toggle2 = false;
				centerX = VisionAuto.table.getNumberArray("CenterX", new double[0]);
				average = ((centerX[0] + centerX[1]) / 2.0);

				while (!toggle2)
				{
					//System.out.println(average);
					if (finishToggle)
					{
						center = center2;
					}
					
					if ((average < center + compensation && average > center - compensation) || centerX.length < 2)
					{
						System.out.println("TOGGLE OFF");
						VisionAutoMovement.moveDirection(direction, 0);
						toggle2 = true;
						break;
					}
					else if (average > center + compensation) //move left
					{
						average = ((centerX[0] + centerX[1]) / 2.0);
						centerX = VisionAuto.table.getNumberArray("CenterX", new double[0]);
						VisionAutoMovement.moveDirection(left, 0.247, 0.25);// changeable
					}
					else if (average < center - compensation) //move right
					{
						average = ((centerX[0] + centerX[1]) / 2.0);
						centerX = VisionAuto.table.getNumberArray("CenterX", new double[0]);
						VisionAutoMovement.moveDirection(right, 0.27, 0.265);// changeable
					}
					else
					{
						VisionAutoMovement.moveDirection(direction, 0);
						break;
					}
				}

				if (toggle2)
				{
					System.out.println(finishToggle);
					if (!finishToggle)
					{
						stateAuto = 3;
						System.out.println("CASE 3");
					}
					else
					{
						stateAuto = 4;

						RobotMap.leftEncoder.reset();
						RobotMap.rightEncoder.reset();

						System.out.println("CASE 4");
					}
					break;
				}

				break;

			case 3:
				double[] height = VisionCheckHeights.provideArray("Height");
				boolean toggle3 = false;

				while (!toggle3)
				{
					if (height == null || height.length == 0)
					{
						toggle3 = true;
					}
					else
					{
						if (height[0] > highBound)
						{
							System.out.println("Height reached heights are: " + height[0] + "    " + height[1]);
							toggle3 = true;
							break;
						}
						else
						{
							VisionAutoMovement.moveForward(0.275, 0.255);
							height = VisionCheckHeights.provideArray("Height");
						}
					}
				}

				if (toggle3)
				{
					VisionAutoMovement.moveForward(0);
					finishToggle = true;
					toggle1 = false;

					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();

					stateAuto = 2;

					System.out.println("CASE 2");
					System.out.println("MOVED THE CERTAIN DISTANCE!");
				}
				break;

			case 4:
				boolean toggle4 = false;
				
				while (RobotMap.leftEncoder.get() > -900 || RobotMap.rightEncoder.get() < 880 || time.get() < 1.0)
				{
					// System.out.println(RobotMap.lEncoder.get() + " " +
					// RobotMap.rEncoder.get());
					//System.out.println(time.get());
					VisionAutoMovement.moveForward(0.265, 0.245);

					if (RobotMap.leftEncoder.get() < -900 || RobotMap.rightEncoder.get() > 880 || time.get() > 1.0)
					{
						VisionAutoMovement.moveDirection(1, 0);
						toggle4 = true;
						break;
					}
				}

				if (toggle4)
				{
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();
					System.out.println("CASE 5");
					stateAuto = 5;
					
					time.stop();
					time.reset();
					time.start();
				}
				break;
				
			case 5:
				boolean toggle5 = false;
				while(time.get() < 1.5)
				{
					//System.out.println("Drop Loop");
					RobotMap.gearMotor.set(-0.4);
					if(RobotMap.gearBottomLimit.get() || time.get() > 1.5)
					{
						time.stop();
						time.reset();
						toggle5 = true;
					}
				}
				
				if(toggle5)
				{
					RobotMap.gearMotor.set(-0.25);
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();
					stateAuto = 6;
					System.out.println("CASE 6");
				}
				break;
				
			case 6:
				boolean toggle6 = false;
				while (RobotMap.leftEncoder.get() < 100 || RobotMap.rightEncoder.get() > -80)
				{
					VisionAutoMovement.moveForward(-0.25, -0.25);

					if (RobotMap.leftEncoder.get() > 100 || RobotMap.rightEncoder.get() < -80)
					{
						toggle6 = true;
					}
				}

				if (toggle6)
				{
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();
					
					RobotMap.gearMotor.set(0);
					
					VisionAutoMovement.moveDirection(1, 0);
				}
				break;
		}
	}
}
