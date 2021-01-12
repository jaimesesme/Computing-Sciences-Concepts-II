package asg1;

import java.util.Scanner;

public class Asg1Part1 
{
	public static void main(String[] args) 
	{
		int age = 0;
		double gpa = 0;
		String homeTown = "";
		String upperTown = "";
		int intlen = 0;
		
		Scanner in = new Scanner(System.in);
		
		// AGE
		System.out.println("Enter your age: ");
		age = in.nextInt(); in.nextLine();
		
		if (age < 18)
		{
			System.out.println("You are not eligible to vote.");
		}
		else
		{
			System.out.println("You are eligible to vote!");
		}
		
		if (age < 35)
		{
			System.out.println("You are not eligible to be President of the United States.");
		}
		else
		{
			System.out.println("You are eligible to be President of the United States!");
		}
		
		if (age < 65)
		{
			System.out.println("You are not eligible to receive Medicaid benifits.");
		}
		else
		{
			System.out.println("You are  eligible to receive Medicaid benifits!");
		}
		
		if (age > 15 && age < 26)
		{
			System.out.println("You will have to pay extra for car insurance.");
		}
		else
		{
			System.out.println("You will not have to pay extra for car insurance.");
		}
		// Are they paying extra for car insurance? (between the ages of 16 and 25 inclusive).
		
		//GPA
		System.out.println("Enter your gpa: ");
		gpa = in.nextDouble(); in.nextLine();

		if (gpa < 0.0 || gpa > 4.0)
		{
			System.out.println("Error: you have inputed a number less than 0.0 or greater than 4.0");
		}
		else
		{
			if (gpa > 3.24)
			{
				System.out.println("You are eligible for the Dean's List");
			}
			else if (gpa < 2.0)
			{
				System.out.println("You are in a probationary status because of your " +gpa+ 
						" gpa which is lower than 2.0");
			}
			else if (gpa >2.4)
			{
				System.out.println("You have a satisfactory gpa!");
			}
		}
		
		//HOMETOWN
		System.out.println("Enter your home town: ");
		homeTown = in.nextLine();
		
		System.out.println("Welcome! It is awesome to have someone from " +homeTown+".");
		upperTown = homeTown.toUpperCase();
		System.out.println(upperTown);
		
		int letter = 0;
		int counter = 0;
		for (letter = 0; letter < homeTown.length(); letter++)
		{
			if (homeTown.charAt(letter) == ' ')
				{
				counter ++;
				}
		}
		System.out.println("Your home town has "+(letter-counter)+ " words");
		
	} // end of main

} // end of class
