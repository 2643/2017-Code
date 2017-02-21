package org.usfirst.frc.team2643.robot;

public class VisionCameraStatus
{	
	public static void cameraStatus(int call)
	{
		VisionAuto.table.putNumber("Camera Call", call);
	}
	
	public static void autoModeStatus(int call)
	{
		VisionAuto.table.putNumber("Auto Mode", call);
	}
}
