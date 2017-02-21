package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionAuto
{	
	static NetworkTable table = NetworkTable.getTable("Vision");
	
	public static void startVision()
	{
		VisionCheckHeights.checkHeight("CenterX");
	}
	
	public static void positionForAuto(String pos)
	{
		if (pos.equals("center"))
		{
			VisionMoveCenter.moveToCenter();
		}
		else if (pos.equals("left"))
		{
			VisionMove.movePos(1);
		}
		else if (pos.equals("right"))
		{
			VisionMove.movePos(-1);
		}
	}
}
