package asg1;

import java.util.Scanner;

public class Asg1Part3 
{
	public static boolean  isOdd (int number)
	{
		boolean result = true;
		if ((number % 2) != 1)
		{
			result = false;
		}
		return result;
	}// end of boolean
	
	public static String getCategory(double aValue)
	{
		if (aValue > 100.0)
		{
			return "Over";
		}
		else if ( aValue <= 100.0 && aValue >= 25.0)
		{
			return "Average";
		}
		else if (aValue < 25.0)
		{
			return "Below";
		}
		return null;
		
	}// end of String
	
	
	public static void main(String[] args) 
	{ 

		boolean answer = true;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = in.nextInt(); in.nextLine();
		answer = isOdd(number);
		if (answer == true)
		{
			System.out.println(number+" ODD");
		}					
		else
		{
			System.out.println(number +" EVEN");
		}
		
		String answer2 = "";
		System.out.println("Enter a number with a decimal: ");
		double number2 = in.nextDouble(); in.nextLine();
		answer2 = getCategory(number2);
		System.out.println(answer2);
	}//end of main	
	
	

}// end of class
