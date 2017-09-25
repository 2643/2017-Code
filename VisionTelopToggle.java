package org.usfirst.frc.team2643.robot;

public class VisionTelopToggle
{
	private static boolean cameraToggle = true;
	private static boolean streamToggle = true;

	private static int moveLeft = 1;
	private static int moveRight = -1;

	private static boolean toggle = false;
	private static double tmp;
	private static double average;

	private static int center = 400;

	public static void toggle()
	{
		if (RobotMap.driveStick.getRawButton(RobotMap.VISION_AUTO_ASSIST))
		{
			average = VisionAuto.table.getNumber("Average", tmp);

			if (cameraToggle)
			{
				VisionCameraStatus.cameraStatus(1);
				cameraToggle = false;
				try
				{
					Thread.sleep(2000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			if (average < center + 20 && average > center - 20)
			{
				System.out.println("centered");
			}
			else if (average > center + 20)
			{
				VisionAutoMovement.moveDirection(moveLeft, 0.275, 0.285);
				System.out.println("MOVING LEFT*");
			}
			else if (average < center - 20)
			{
				VisionAutoMovement.moveDirection(moveRight, 0.3, 0.32);
				//System.out.println("MOVING RIGHT*");
			}
		}
		else if (RobotMap.driveStick.getRawButton(RobotMap.VISION_STREAMER))
		{
			// starts stream
			if (streamToggle)
			{
				VisionCameraStatus.cameraStatus(0);
				streamToggle = false;
				cameraToggle = true;
			}
		}
		else if (RobotMap.driveStick.getRawButton(5))
		{
			VisionCameraStatus.cameraStatus(1);
			cameraToggle = false;
		}
		else
		{
			streamToggle = true;
			cameraToggle = true;
			toggle = false;
		}
	}
}
