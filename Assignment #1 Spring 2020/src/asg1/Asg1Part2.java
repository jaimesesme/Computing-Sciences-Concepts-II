package asg1;

public class Asg1Part2 
{
	public static void main(String[] args) 
	{
		int sum = 0;
		for (int index = 0; index<101; index++)
		{
			sum += index;
		}
		System.out.println("The sum from 1 to 100 is " +sum);
		
		int sum13 = 0;
		for (int index13 = 13; index13 < 2001; index13++)
		{
			if (index13 % 13 == 0)
			{
				sum13 += index13;
			}
		}
		System.out.println("The sum of the numbers from 1 to 2000 that are "
				+ "divisible by 13 is " +sum13);
		int sumSqr = 0;
		for (int sqr = 1; sqr < 51; sqr ++)
		{
			sumSqr += (sqr * sqr);
		}
		System.out.println("the sum of all the squares from 1 to 50 is " + sumSqr);
	}//end of main

}// end of class
