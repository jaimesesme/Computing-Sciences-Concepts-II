package test;

import java.util.Scanner;

import asg2.Asg2Methods;
// test for Assignment #2
public class Asg2Test {
	public static void main(String[] args) 
	{
		String yourName = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name: ");
		yourName = in.nextLine();
		System.out.println("Testing for " + yourName);
		testComputeDiscountRate();
		testSillyString();
		testIsValid();
		testRemoveSpaces();
		testGetFirstLast();
		testToCelsius();
		testGetLetterGrade();
		testMixIt();
		testDoubleChars();
		testComputeTicketCode();
		System.out.println("\nEnd of Testing for " + yourName);
	}
	public static void testDoubleChars()
	{

			String s1 = "Hi";
			
			String result = Asg2Methods.doubleChars(s1);
			String correct = "HHii";
			if(result.equals(correct))
			{
				System.out.println("SUCCESS doubleChars returns " + result);

			}
			else
			{
				System.out.println ("FAILURE doubleChars returns " + result+ " expected " + correct);
			}
			s1 = "CS is a great major";
			 result = Asg2Methods.doubleChars(s1);
			correct = "CCSS  iiss  aa  ggrreeaatt  mmaajjoorr";
			if(result.equals(correct))
			{
				System.out.println("SUCCESS doubleChars returns " + result);

			}
			else
			{
				System.out.println ("FAILURE doubleChars returns " + result+ " expected " + correct);
			}
			s1 = "";
			 result = Asg2Methods.doubleChars(s1);
			correct = "";
			if(result.equals(correct))
			{
				System.out.println("SUCCESS doubleChars returns " + result);

			}
			else
			{
				System.out.println ("FAILURE doubleChars returns " + result+ " expected " + correct);
			}
			s1 = "GoGoHilltoppers!!!!";
			 result = Asg2Methods.doubleChars(s1);
			correct = "GGooGGooHHiillllttooppppeerrss!!!!!!!!";
			if(result.equals(correct))
			{
				System.out.println("SUCCESS doubleChars returns " + result);

			}
			else
			{
				System.out.println ("FAILURE doubleChars returns " + result+ " expected " + correct);
			}
		
	}
	
	public static void testMixIt()
	{
		String s1 = "Hi";
		String s2 = "There";
		String result = Asg2Methods.mixIt(s1, s2);
		String correct = "HTihere";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns " + result+ " expected " + correct);
		}
			
		s1 = "Silly";
		s2 = "me";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "Smielly";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns "  + result+ " expected " + correct);
		}
		s1 = "";
		s2 = "me";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "me";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns " + result + " expected " + correct);
		}
		s1 = "you";
		s2 = "";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "you";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns "  + result+ " expected " + correct);
		}
		s1 = "";
		s2 = "";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns " + result + " expected " + correct);
		}
		s1 = "crazy";
		s2 = "stuff";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "csrtauzfyf";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns " + " expected " + correct);
		}
		s1 = "All about";
		s2 = "computer science";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "Aclolm paubtoeurt science";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns " + result + " expected " + correct);
		}
		s1 = "We all love software design";
		s2 = "computer science";
		result = Asg2Methods.mixIt(s1,  s2);
		correct = "Wceo maplult elro vsec iseonfcteware design";
		if(result.equals(correct))
		{
			System.out.println("SUCCESS mixIt returns " + result);

		}
		else
		{
			System.out.println ("FAILURE mixIt returns " + result + " expected " + correct);
		}
	}
	//receives: nothing
	// returns: nothing
	// tests for computeDiscountRate() method
	public static void testComputeDiscountRate()
	{
		System.out.println("*****Now testing computeDiscountRate method*****");
		char code = 'K';
		double retPrice = 0.00;
		double expPrice = 0.10;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'k';

		expPrice = 0.10;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'G';

		expPrice = 0.25;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'g';

		expPrice = 0.25;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'G';
		expPrice = 0.25;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);

		code = 'z';

		expPrice = 0.40;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'Z';

		expPrice = 0.40;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = ';';

		expPrice = 0.0;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'B';

		expPrice = 0.00;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = '$';

		expPrice = 0.00;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
	}
	//receives: nothing
	// returns: nothing
	// tests for sillyString() method
	public static void testSillyString()
	{
		System.out.println("***** Now testing sillyString() method*****");
		String orgString ="";
		String retString ="";
		String expString="";
		orgString ="zoo Loos";
		expString = "z@@ l@@$";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="Lots of Vowels here haaaaaaaaa";
		expString = "l@t$ @f v@wel$ here haaaaaaaaa";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "PTs SJK ROT ";
		expString = "pt$ $jk r@t ";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "";
		expString = "";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " (empty string) received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " (empty string) WRONGLY received " + retString);
		orgString = ";**&&%$#@ ";
		expString = ";**&&%$#@ ";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "Oh WOW silly String";
		expString = "@h w@w $illy $tring";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
	}

	//receives: nothing
	// returns: nothing
	// tests for isValid() method
	public static void testIsValid()
	{
		System.out.println("*****Now testing isValid()*****");	
		String string = "";
		boolean expBool = false;
		boolean retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "thisIsAValid233String999";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "12345678900";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "ABCDEaabb FGHIJ22K33 ddLMNOPQRSTUVWXYZ";
		expBool = false;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string="";
		expBool = false;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		
	}
	//receives: nothing
	// returns: nothing
	// tests for removeSpaces() method
	public static void testRemoveSpaces()
	{

		System.out.println("*****Now testing removeSpaces()*****");
		String orgString ="   Lots of Vowels here haaaaaaaaa    ";
		String expString = "LotsofVowelsherehaaaaaaaaa";
		String retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="     ";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" ";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="\t\t  \t\n\n\n  \n\n\n";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="test  \t\n\n\ntest  \n\n\n";
		expString = "testtest";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="test3";
		expString = "test3";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="   \n\n\ntest4";
		expString = "test4";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="Test2\t  \t\n\n\n  \n\n\n";
		expString = "Test2";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
	}
	//receives: nothing
	// returns: nothing
	// tests for getFirstLast() method
	public static void testGetFirstLast()
	{
		System.out.println("*****Now testing getFirstLast()*****");
		String orgString ="Lots of Vowels here haaaaaaaaa";
		String expString = "La";
		String retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" St. Edward's University";
		expString = "Sy";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="aba ";
		expString = "aa";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="ab";
		expString = "ab";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" K ";
		expString = "K";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="";
		expString = "";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="1aaKaa1";
		expString = "11";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="   1  Kaa1  ";
		expString = "11";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="        a    ";
		expString = "a";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="      ";
		expString = "";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
	}
	//receives: nothing
	// returns: nothing
	// tests for toCelsius() method
	public static void testToCelsius()
	{
		System.out.println("*****Now testing toCelsius()*****");
		double expDouble=0.0;
		double retDouble = 0.0;
		double orgDouble = 0.0; 
		orgDouble = 212.0;
		expDouble = 100.0;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		double diff = 0.0;
		double allowableDiff = 0.0001;  // if we are within 1/10000 we'll accept...
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);

		orgDouble = 32.0;
		expDouble = 0.0;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		orgDouble = 100.0;
		expDouble = 37.77777777777778;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		orgDouble = -100.0;
		expDouble = -73.33333333333334;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
	}
	//receives: nothing
	// returns: nothing
	// tests for getLetterGrade() method
	public static void testGetLetterGrade()
	{
		System.out.println("****Now testing getLetterGrade()****");
		char expChar = 'A';
		char retChar='A';
		double orgDouble=89.9999;
		expChar = 'B';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=104.0;
		expChar = 'A';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=105.01;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=111.9999;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=-100.0;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=79.9999;
		expChar = 'C';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=80.0;
		expChar = 'B';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=59.9999;
		expChar = 'F';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=69.9999;
		expChar = 'D';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=77.7777;
		expChar = 'C';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=99.9999;
		expChar = 'A';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
	}
	public static void testComputeTicketCode()
	{
		int result = 0;
		int speed = 0;
		int correct = 0;
	    boolean isZone = true;
		speed = 30;
		isZone = false;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 0;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 59;
		isZone = false;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 1;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 75;
		isZone = false;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 2;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		
		speed = 76;
		isZone = false;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 3;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 31;
		isZone = false;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 1;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 20;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 0;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 30;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 1;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 50;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 1;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 60;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 2;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 61;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 3;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 75;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 3;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		speed = 10;
		isZone = true;
		result = Asg2Methods.computeTicketCode(speed, isZone);
		correct = 0;
		if(result == correct)
			System.out.println("SUCCESS  expected: " + result + " for speed " + speed + " school zone: " + isZone);
		else
			System.out.println("FAILURE returned: " + result + " expected " + 
		                                correct + " for speed " + speed + " school zone: " + isZone);
		
	}
}
