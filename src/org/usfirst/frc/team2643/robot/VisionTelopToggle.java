package org.usfirst.frc.team2643.robot;

public class VisionTelopToggle
{
	private static boolean cameraToggle = true;
	private static boolean streamToggle = true;
	
	public static void toggle()
	{
		if (RobotMap.driveStick.getRawButton(RobotMap.VISION_AUTO_ASSIST))
		{
			while(RobotMap.driveStick.getRawButton(RobotMap.VISION_AUTO_ASSIST))
			{
				if(cameraToggle)
				{
					VisionCameraStatus.cameraStatus(1);
					cameraToggle = false;
					try
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				VisionAuto.startVision();
			}
		}
		else if(RobotMap.driveStick.getRawButton(RobotMap.VISION_STREAMER))
		{
			//starts stream
			if(streamToggle)
			{
				VisionCameraStatus.cameraStatus(0);
				streamToggle = false;
			}	
		}
		else
		{
			streamToggle = true;
			cameraToggle = true;
		}
	}
}
