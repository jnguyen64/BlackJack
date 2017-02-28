/*
 * FindTheSums.java
 * Author: Jonathan Nguyen
 * Submission Date: December 3, 2015
 *
 * Purpose: This program uses a 2D array and tries to find a user-inputted
 * sum horizontally and vertically.
 * It only shows the numbers that fit that sum.
 * 
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on a programming project created by the Department of
 * Computer Science at the University of Georgia. Any publishing
 * of source code for this project is strictly prohibited without
 * written consent from the Department of Computer Science.
 */
public class FindTheSums
{

	public static String arrayToString(int[][] a)
	{
		String arrayString = "";
		for (int x = 0; x<a.length; x++)
		{
			for (int y = 0; y<a[0].length; y++)
			{
				if(y != (a[0].length -1))
				{
					arrayString= arrayString + a[x][y] + " ";
				}
				if(y == (a[0].length -1))
				{
					arrayString = arrayString + a[x][y];
				}
			}
			if(x != (a.length - 1))
			{
				arrayString = arrayString + "\n";
			}
		}
		return arrayString;
	}

	public static int[][] horizontalSums(int[][] a, int sumToFind)
	{
		int[][] b = new int[a.length][a[0].length];

		int totalSum = 0;
		for(int x = 0; x < a.length; x++)
		{
			for(int y = 0; y < a[x].length; y++)
			{
				totalSum = 0;
				for(int colCheck = y; colCheck < a[x].length; colCheck++)
				{
					totalSum = totalSum + a[x][colCheck];
					if(totalSum == sumToFind)
					{
						for(int colSwap = colCheck; colSwap >= y; colSwap--)
						{
							b[x][colSwap] = a[x][colSwap];
						}
						break;
					}
				}
			}
		}
		return b;
	}

	public static int[][] verticalSums(int[][] a, int sumToFind){
		int totalSum = 0;
		int[][] b = new int[a.length][a[0].length];
		for(int y = 0; y < a[0].length; y++)
		{
			for(int x = 0; x < a.length; x++)
			{
				totalSum = 0;
				for(int rowCheck = x; rowCheck < a.length; rowCheck++)
				{
					totalSum = totalSum + a[rowCheck][y];
					if(totalSum == sumToFind){
						for(int rowSwap = rowCheck; rowSwap >= x; rowSwap--)
						{
							b[rowSwap][y] = a[rowSwap][y];
						}
						break;
					}
				}
			}
		}
		return b;
	}
}
