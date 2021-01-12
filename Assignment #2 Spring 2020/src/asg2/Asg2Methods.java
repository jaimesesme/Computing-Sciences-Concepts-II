package asg2;

import java.util.Scanner;

public class Asg2Methods 
{
	public static double computeDiscountRate(char discountCode)
	{
		if (discountCode == 'K' || discountCode == 'k')
		{
			return 0.10;
		}
		else if(discountCode == 'G' || discountCode == 'g')
		{
			return 0.25;
		}
		else if(discountCode == 'Z' || discountCode == 'z')
		{
			return 0.40;
		}
		else
		{
			return 0.0;
		}
	} // end of computeDiscountRate
	
	public static String sillyString(String word)
	{
		String returnValue = "";
		for (int index = 0; index < word.length(); index++)
		{
			char ch = word.charAt(index);
			if (ch == 's' || ch == 'S')
			{
				ch = '$';
			}
			else if (ch == 'o' || ch == 'O')
			{
				ch = '@';
			}
			else if (Character.isUpperCase(ch))
			{
				ch = Character.toLowerCase(ch);
			}
			returnValue += ch;
		}
		return returnValue;
	} // end of sillyString
	
	public static boolean isValid(String aString)
	{
		if (aString == "")
		{
			return false;
		}
		else
		{
			for (int index = 0; index < aString.length(); index++)
			{
				
				char ch = aString.charAt(index);
				if (Character.isLetterOrDigit(ch))
				{
					continue;
				}
	
				else 
				{
					return false;
				}
			}
		}
		return true;
		
		
	} // end of isValid
	public static double computeDiscountRate(char discountCode)
	{
		if (discountCode == 'K' || discountCode == 'k')
		{
			return 0.10;
		}
		else if(discountCode == 'G' || discountCode == 'g')
		{
			return 0.25;
		}
		else if(discountCode == 'Z' || discountCode == 'z')
		{
			return 0.40;
		}
		else
		{
			return 0.0;
		}
	} // end of computeDiscountRate
	
	public static String sillyString(String word)
	{
		String returnValue = "";
		for (int index = 0; index < word.length(); index++)
		{
			char ch = word.charAt(index);
			if (ch == 's' || ch == 'S')
			{
				ch = '$';
			}
			else if (ch == 'o' || ch == 'O')
			{
				ch = '@';
			}
			else if (Character.isUpperCase(ch))
			{
				ch = Character.toLowerCase(ch);
			}
			returnValue += ch;
		}
		return returnValue;
	} // end of sillyString
	
	public static boolean isValid(String aString)
	{
		if (aString == "")
		{
			return false;
		}
		else
		{
			for (int index = 0; index < aString.length(); index++)
			{
				
				char ch = aString.charAt(index);
				if (Character.isLetterOrDigit(ch))
				{
					continue;
				}
	
				else 
				{
					return false;
				}
			}
		}
		return true;
		
		
	} // end of isValid
	public static String removeSpaces(String word)
	{
		String retValue = "";
		for (int index = 0; index < word.length(); index++)
		{
			char ch = word.charAt(index);
			if (Character.isWhitespace(ch))
			{
				continue;
			}
			else
			{
				retValue += ch;
			}
			
			
		}
		return retValue;
	} // end of removeSpaces
	
	public static double toCelsius(double temperature)
	{
		double far = (temperature-32.0)*5/9;
		return far;
		
	} // end of toCelsius
	
	public static char getLetterGrade(double gradeAvg)
	{
		if (gradeAvg < 0.0 || gradeAvg >= 105.0)
		{
			return 'X';
		}
		else if (gradeAvg >= 90.0)
		{
			return 'A';
		}
		else if (gradeAvg >= 80.0)
		{
			return 'B';
		}
		else if (gradeAvg >= 70.0)
		{
			return 'C';
		}
		else if (gradeAvg >= 60.0)
		{
			return 'D';
		}
		else //if (gradeAvg < 60.0)
		{
			return 'F';
		}
	} // end of getLetterGrade
	
	public static String getFirstLast(String aString)
	{ 
		String newString = removeSpaces(aString);
		int length = newString.length();
		
		if (length == 1|| length == 0)
		{
			return newString;
		}
		//StringBuilder retValue = new StringBuilder();
		else
		{
		String retValue = new StringBuilder().append(newString.charAt(0)).append(newString.charAt(length-1)).toString();
		//String retValue = newString.charAt(0) + newString.charAt(length-1);
		return retValue;
		}
	} // end of getFirstLast
	
	public static String doubleChars(String str)
	{
		String retValue = "";
		for (int index = 0; index < str.length(); index++)
		{
			char ch = str.charAt(index);
				retValue += new StringBuilder().append(ch).append(ch).toString();
		}
		return retValue;
	} // end of doubleChars
	
	public static String mixIt(String str1, String str2)
	{
		String retValue = "";
		String newString = str1+str2;
		// if statement for shorter
		if (str1.length()<str2.length())
		{
			for (int index = 0; index < str1.length(); index++)
			{
				char ch1 = str1.charAt(index);
				char ch2 = str2.charAt(index);
				retValue += new StringBuilder().append(ch1).append(ch2).toString();
			}
			retValue += new StringBuilder().append(str2.substring(str1.length(), str2.length())).toString();
		
			
		}
		else //str2
		{
			for (int index2 = 0; index2 < str2.length(); index2++)
			{
				char ch1 = str1.charAt(index2);
				char ch2 = str2.charAt(index2);
				retValue +=  new StringBuilder().append(ch1).append(ch2).toString();
			}
			retValue += new StringBuilder().append(str1.substring(str2.length(), str1.length())).toString();
		}
		
		return retValue;
	} // end of mixIt
	public static int computeTicketCode(int speed, boolean isSchoolZone)
	{
		int code = 00;
		if (!isSchoolZone)
		{
			if (speed > 0 && speed < 31)
			{
				code = 0;
			}
			else if (speed > 30 && speed < 60)
			{
				code = 1;
			}
			else if (speed > 59 && speed < 76)
			{
				code = 2;
			}
			else if (speed > 75) 
			{
				code = 3;
			}
		}
		else if (isSchoolZone)
		{
			if (speed > 0 && speed < 21)
			{
				code = 0;
			}
			else if (speed > 20 && speed < 51)
			{
				code = 1;
			}
			else if (speed > 50 && speed < 61)
			{
				code = 2;
			}
			else if (speed > 60) 
			{
				code = 3;
			}
		}
		return code;
	}// end of computeTicketCode
	
	
	
	
	
	
} // end of class