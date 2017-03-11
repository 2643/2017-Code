package org.usfirst.frc.team2643.robot;

public class VisionProvideData
{
	public static int lengthOfArray(String name)
	{
		return VisionAuto.table.getNumberArray(name, new double[0]).length;
	}

	public static double[] provideArray(String name)
	{
		return VisionAuto.table.getNumberArray(name, new double[0]);
	}

	public static double provideNum(String name)
	{
		double temp = 0.0;
		return VisionAuto.table.getNumber(name, temp);
	}
	
	/*
	private static boolean moveToSide()
	{
		double[] tmpArr = VisionAuto.table.getNumberArray("CenterX", new double[0]);
		if (tmpArr[0] > 320)
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
	*/
}
