package myarrays;

public class ArrayExamples 
{
	// finds and returns largest value in the array list.	  
    // precondition: numElementsInArray >=0  and list.length >= 0
    // if NumElements is 0, returns 0 as largest value.
	// receives: list - an array of ints, numElementsInArray - current number of elements stored in list
	// Example call #1:   int theMax = ArrayExamples.findMax(someArrayOfInts, size);
	// Example call #2:   int biggest  = ArrayExamples.findMax(myList, 10);
	// Example call #3:   int aMax = ArrayExamples.findMax(yourList, 25);
   public static int findMax(int [] list, int numElementsInArray)
   {
	   int largestNumber = 0;
	   for (int index=0; index<numElementsInArray; index++)
	   {
		   if (list[index]>largestNumber)
		   {
			   largestNumber =list[index];
		   }
	   } 
		   
	   return largestNumber;
	   
   }
  
   // finds and returns the smallest value in the array list.
   // precondition: numElementsInArray >= 0  and list.length >= 0
   //  if numElements is 0, returns 0 as the smallest value.
   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
   // Example call #1: int theMax = ArrayExamples.findMin(someArrayOfInts, size);
   // Example call #2: int theMax = ArrayExamples.findMin(myList, 10);
   // Example call #3: int theMax = ArrayExamples.findMin(yourList, 25);
   public static int findMin(int [] list, int numElementsInArray)
   {
	   int smallestNumber = 0;
	   if (numElementsInArray>0)
	   {
		   smallestNumber =list[0];
		   for (int index=1; index<numElementsInArray; index++)
		   {
			   if (smallestNumber>list[index])
			   {
				   smallestNumber = list[index];
			   }
		   }
	   }
	   return smallestNumber;
   }
  
   // computes and returns average of all values in array list
   // computes the average as a double
   // precondition:  numElementsInArray >=0  and list.length >=0
   // returns 0 if numElements is 0.
   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
   // Example call #1: computeAverage( list1, 3);
   // Example call #2: computeAverage( list2, 4);
   // Example call #3: computeAverage( list3, 5);   
   public static double computeAverage(int [] list, int numElementsInArray)
   {
	   double average = 0.0;
	   if (numElementsInArray > 0 && list.length >0)
	   {
		   for (int index=0; index<numElementsInArray; index++)
		   {
			   average+= list[index];
		   }
		   average = average/numElementsInArray;
		   return average;
	   }
	   else
		   return 0;
   }
   
   //reverses the array elements, so first element becomes last, last becomes first etc.
   //  the array has numElementsInArray values stored in it currently
   // precondition:  numElementsInArray >=0  and list.length >= 0 and numElementsInArray <= list.length 
   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
   // so if list1 has 3 values in it:  4, 15, 34, 200    list1 becomes 200, 34, 15, 4 after it is reversed
   // Example call #1: reverseArray(list1, num1);
   // Example call #2: reverseArray(list2, num2);
   // Example call #3: reverseArray(list3, num3); 
   public static void reverseArray(int [] list, int numElementsInArray)
   {
	   int [] tempArray = new int[numElementsInArray];
	   if (numElementsInArray>0 && list.length>0)
	   {
		   int index2 = 0;
		   for (int index=numElementsInArray-1; index>=0; index--)
		   {
			   tempArray[index2]=list[index];
			   index2+=1;
		   }
		   for(int index=0; index<numElementsInArray; index++)
		   {
			   list[index]=tempArray[index];
		   }
	   }
   } 
   // counts the number of times the received String, valueToMatch, 
   // appears in the String array list, ignores case.
   // returns that count.  Matches case INSENSITIVE
   // receives: list - an array of Strings to examine, int numElementsInArray, and the String, valueToMatch
   // Example call #1: int matches = countMatches(list1, num1, string1);
   // Example call #2: int matches1 = countMatches(list2, num2, string2);
   // Example call #3: int matches2 = countMatches(list3, num3, string3);
   
   public static int countMatches(String [] list, int numElementsInArray, String valueToMatch)
   {
	   int retVal=0;
	   for (int index=0; index<numElementsInArray; index++)
	   {
		   if (list[index].toLowerCase().contentEquals(valueToMatch.toLowerCase()))
		   {
			   retVal+=1;   
		   }
	   }
	   return retVal;
   }
   
   // populates received integer array with all zero values
   // precondition: 
   // receives: array of integers that will have all locations set to zero
   // Example call #1: resetArray(list1); 
   // Example call #2: resetArray(list2); 
   // Example call #3: resetArray(list3); 
   public static void resetArray(int [] list)
   {
	   for (int index=0; index<list.length; index++)
	   {
		   list[index]=0;
	   }
   }
  

  
   // populates received integer array with count of each letter of alphabet in received String (case-insensitive)
   // size of int array is 26 exactly and is zeroed out.
   // receives: String to count letters in, and an array of integers of size 26, ASSUMES that the array 
   // has all elements set to zero prior to this method being used
   //  Example :  given "cats and dogs"  as the String, list[0] = 2, list[1] = 0, list[2] = 1, list[3]=2 etc.
   //             each array location corresponds to a letter of the alphabet, 'a' is location 0, 'b' is location 1 etc.
   // Example call #1: countLetters(string1, list1);
   // Example call #2: countLetters(string2, list2);
   // Example call #3: countLetters(string3, list3);  
   public static void countLetters(String aString, int [] list)
   {
	   String tempString = aString.toLowerCase();
	   for (int index=0; index< tempString.length(); index++)
	   {
		   char ch = tempString.charAt(index);
		   int loc = (int) ch;
		   loc = loc-97;
		   if (loc >= 0 && loc <= 25)
		   {
			   list[index]+=1;
		   }
	   }
	  
   }
   
   // returns a String in described format of current letters in array
   // receives the int array of letter counts
   // Example: Assume: letterCount[1] = 4, letterCount[5] = 2,letterCount[6] = 3, with 0's all other locations returns: "[bbbbffggg]"
   // Example call #1: String string1 = getLetters(list1);
   // Example call #2: String string2 = getLetters(list2);
   // Example call #3: String string3 = getLetters(list3);

   public static String getLetters(int [] letterCount)  
   {
	   String string = "";
	   String alphabet = "abcdefghijklmnopqrstuvwxyz";
	   for (int index=0; index< letterCount.length; index++)
	   {
		   char ch = alphabet.charAt(index);
		   int i = letterCount[index];
		   for (int index2 = 0; index2< i; index2++)
		   {
			  string+=ch; 
		   }
		   
	   }
	   String retVal="["+ string +"]";
	   return retVal;  
   }
 

   // Gets value in a "letterCount" array in which each index corresponds to a letter of the alphabet, case-insensitive
   //  so the letterCount array has 26 indexes, 0 to 25.
   // receives: letterCount array and specific letter 
   // returns: count of corresponding letter
   // if invalid (non-letter) character received, returns 0.
   // Example call #1: int number1= getCount(list1, ch1);
   // Example call #2: int number2= getCount(list2, ch2);
   // Example call #3: int number3= getCount(list3, ch3); 
   public static int getCount(int []countArray, char ch)
   {
	   int retValue=0;
	   for (int index=0; index< countArray.length; index++)
	   {
		   if (countArray[index]==ch)
			   retValue+=1;
	   }
	   return retValue;
   }

  
   // Adds contents of 2 int arrays received, returns an array with sum of each corresponding row.
   // receives: 2 integer arrays of same length which is >=0
   // returns an integer array with the sum of both array values per row.
   // precondition: both arrays are same length, if not returns an array of length 0
   // note:  here is how to create an int [] array of length 0:
   //          int [] retValue = new int [0];
   // Example call #1: int [] array1 = getArraySum(array10, array11);
   // Example call #2: int [] array2 = getArraySum(array11, array12);
   // Example call #3: int [] array3 = getArraySum(array13, array14);
   public static int [] getArraySum(int [] array1, int []array2)
   {
	   int length = array1.length;
	   int [] retArray = new int[length];
	   for (int index = 0; index< array1.length; index++)
	   {
		   retArray[index]= array1[index]+array2[index];
	   }
	   return retArray;
   }

   // receives: an array of String values
   // returns: an array of String values with exact same values as in received array
   //          
   // example:  String [] myNames  = { "Joe", "Joey","JOEY", "JOE", "Maria", "MARIA"};
   // returned array contents: { "Joe", "Joey","JOEY", "JOE", "Maria", "MARIA"};
   // Example call:   String [] result = copyStringArray(myNames);
   // Example call #1: String [] array1 = copyStringArray(list1);
   // Example call #2: String [] array2 = copyStringArray(list2);
   // Example call #3: String [] array3 = copyStringArray(list3);
    public static String [] copyStringArray(String [] array)
    {
    	if (array.length>0)
    	{
    		String [] temp = new String[array.length];
        	
        	for (int index=0; index< array.length; index++)
        	{
        		temp[index]=array[index];
        	}
        	return temp;
    	}
    	return array;
    	
    }
    
    
    // receives: an array of ints and number of elements in array
 	// returns: the sum of all of the values in the received array of ints.
 	// task: sums up the values in the array
 	// 1. int sum1 = getSum(array1, number1);
 	// 2. int sum2 = getSum(array2, number2);
 	// 3. int sum3 = getSum(array3, number3);
    public static int getSum(int [] array, int numElementsInArray)
	{
		int sum =0;
		for (int index=0; index< numElementsInArray; index++)
		{
			sum += array[index];
		}
		return sum;
	}
   
    // receives: an array of ints and number of elements in the array
	// task: prints each int in the array to the screen, 1 int per line 
	// 1. printArray( array1, number1);
	// 2. printArray( array2, number2);
	// 3. printArray( array3, number3);
	public static void printArray(int [] array, int numElementsInArray)
	{
		for (int index=0; index < numElementsInArray; index++)
		{
			System.out.println("["+index+"]: "+array[index]);
		}
	}

}
