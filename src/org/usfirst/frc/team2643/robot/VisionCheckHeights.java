package org.usfirst.frc.team2643.robot;

public class VisionCheckHeights
{

	static double[] height = VisionAuto.table.getNumberArray("Height", new double[0]);
	static double[] temp = new double[2];
	private static int moveLeft = 1;
	private static int moveRight = -1;
	private static int heightBounds = 35;
	private static int newHB = 85;

	public static void checkHeight(String name)
	{
		System.out.println(height.length);
		
		if(height[0] > heightBounds || height[1] > heightBounds)
		{
			System.out.println("Calculating");
			VisionAutoMovement.trackingRetro(VisionAuto.table.getNumberArray("CenterX", new double[0]), 10, true);
			heightBounds = newHB;
		}	
		else
		{
			VisionAutoMovement.moveForward(0.57, 0.52);
		}
	}
	
	public static int lengthOfArray(String name)
	{
		return VisionAuto.table.getNumberArray(name, new double[0]).length;
	}
	
	public static double[] provideArray(String name)
	{
		return VisionAuto.table.getNumberArray(name, new double[0]);
	}

	private static boolean moveToSide()
	{
		double[] tmpArr = VisionAuto.table.getNumberArray("CenterX", new double[0]);
		if(tmpArr[0] > 320)
			return true;
		return false;
	}
	
	private static int[] narrowHeight()
	{
		int[] values = new int[2];
		int temp = largestValue(height);
		int temp2 = secondLargestValue(height, temp);
		values[0] = temp;
		values[1] = temp2;
		return values;
	}

	private static int largestValue(double[] table)
	{
		int largestVal = 0;

		for (int x = 0; x < table.length; x++)
		{
			if (table[largestVal] < table[x])
				largestVal = x;
		}
		return largestVal;
	}

	private static int secondLargestValue(double[] table, double largestVal)
	{
		int secondLargestVal = 0;

		for (int x = 0; x < table.length; x++)
		{
			if ((table[secondLargestVal] < table[x] && table[x] != largestVal))
			{
				secondLargestVal = x;
			}
		}
		return secondLargestVal;
	}
}
