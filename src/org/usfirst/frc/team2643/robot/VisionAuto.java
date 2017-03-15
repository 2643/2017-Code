package org.usfirst.frc.team2643.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionAuto
{	
	static NetworkTable table = NetworkTable.getTable("Vision");
	
	public static void startVision()
	{
		//VisionProvideData.checkHeight("CenterX");
	}
	
	public static void positionForAuto(String pos)
	{
		//System.out.println(pos);
		if (pos.equals("c"))
		{
			VisionMoveCenter.moveToCenter();
		}
		else if (pos.equals("l"))
		{
			VisionMove.movePos(1);
		}
		else if (pos.equals("r"))
		{
			VisionMove.movePos(-1);
		}
	}
}
