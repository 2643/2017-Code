package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.Timer;

public class VisionMoveCenter
{
	private static double[] centerX;
	private static double average;
	private static int center = 350;
	private static int compensation = 10;
	private static int left = 1;
	private static int right = -1;
	private static double highBound = 40.0;
	private static Timer time = new Timer();
	private static int state = RobotMap.state;
	private static boolean moveToggle = false;
	
	public static void moveToCenter()
	{
		switch (state)
		{
			case 0:
				double[] height = VisionCheckHeights.provideArray("Height");
				boolean toggle0 = false;
				System.out.println("CASE 0 - Center Code");
				while (!toggle0)
				{
					if(moveToggle)
					{
						highBound = 90;
						center = 316;
					}
					
					if (height == null || height.length == 0)
					{
						toggle0 = true;
					}
					else
					{
						if (height[0] > highBound)
						{
							System.out.println("Height reached heights are: " + height[0] + "    " + height[1]);
							toggle0 = true;
							break;
						}
						else
						{
							VisionAutoMovement.moveForward(0.285, 0.265);
							height = VisionCheckHeights.provideArray("Height");
						}
					}
				}

				if (toggle0)
				{
					VisionAutoMovement.moveForward(0);

					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();

					state = 1;
					System.out.println("CASE 1");
				}
				break;

			case 1:
				boolean toggle1 = false;
				centerX = VisionAuto.table.getNumberArray("CenterX", new double[0]);
				average = ((centerX[0] + centerX[1]) / 2.0);

				System.out.println(average);
				while (!toggle1)
				{
					if ((average < center + compensation && average > center - compensation) || centerX.length < 2)
					{
						System.out.println("TOGGLE OFF");
						VisionAutoMovement.moveDirection(1, 0);
						toggle1 = true;
						break;
					}
					else if (average > center + compensation)
					{
						average = ((centerX[0] + centerX[1]) / 2.0);
						centerX = VisionAuto.table.getNumberArray("CenterX", new double[0]);
						VisionAutoMovement.moveDirection(left, 0.237, 0.24);// changeable
					}
					else if (average < center - compensation)
					{
						average = ((centerX[0] + centerX[1]) / 2.0);
						centerX = VisionAuto.table.getNumberArray("CenterX", new double[0]);
						VisionAutoMovement.moveDirection(right, 0.26, 0.245);// changeable
					}
					else
					{
						VisionAutoMovement.moveDirection(1, 0);
						break;
					}
				}

				if (toggle1)
				{
					if(moveToggle)
					{
						state = 2;

						RobotMap.leftEncoder.reset();
						RobotMap.rightEncoder.reset();

						time.start();
					
						System.out.println("CASE 2");
					}
					else
					{
						moveToggle = true;
						state = 0;
					}
				}
				break;
				
			case 2:
				boolean toggle2 = false;

				while (RobotMap.leftEncoder.get() > -1400 || RobotMap.rightEncoder.get() < 1380 || time.get() > 5.0)
				{
					VisionAutoMovement.moveForward(0.265, 0.245);

					if (RobotMap.leftEncoder.get() < -1400 || RobotMap.rightEncoder.get() > 1380 || time.get() > 5.0)
					{
						VisionAutoMovement.moveDirection(1, 0);
						toggle2 = true;
						break;
					}
				}

				if (toggle2)
				{
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();
					time.stop();
					time.reset();

					System.out.println("CASE 3");
					state = 3;
				}
				break;
				
			case 3:
				boolean toggle5 = false;
				while(time.get() < 1.5 || !RobotMap.gearBottomLimit.get())
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
					state = 4;
					System.out.println("CASE 4");
				}
				break;
				
			case 4:
				boolean toggle4 = false;
				while (RobotMap.leftEncoder.get() < 100 || RobotMap.rightEncoder.get() < -80)
				{
					VisionAutoMovement.moveForward(-0.25, -0.25);

					if (RobotMap.leftEncoder.get() > 100 || RobotMap.rightEncoder.get() < -80)
					{
						toggle4 = true;
					}
				}

				if (toggle4)
				{
					RobotMap.leftEncoder.reset();
					RobotMap.rightEncoder.reset();

					VisionAutoMovement.moveDirection(1, 0);
				}
				break;
		}
	}
}
