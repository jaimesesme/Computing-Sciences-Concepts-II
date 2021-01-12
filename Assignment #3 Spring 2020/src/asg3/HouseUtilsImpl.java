package asg3;


import java.util.Scanner;
import asg3.HouseType;
import asg3.House;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


public class HouseUtilsImpl 
{
	public static House readFromScanner(Scanner inFile)
	{
		String address = "";
		int yearBuilt = 0;
		String houseType = "";
		int numBedrooms = 0;
		double numBathrooms = 0.0;
		
		
		if (inFile.hasNext())
		{
			address = inFile.nextLine();
		}
		else
		{
			return null;
		}
		if(inFile.hasNextInt())
		{
			yearBuilt = inFile.nextInt();inFile.nextLine();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			houseType = inFile.nextLine().trim().toUpperCase();
		}
		else
		{
			return null;
		}
		if(inFile.hasNextInt())
		{
			numBedrooms = inFile.nextInt();
		}
		else
		{
			return null;
		}
		if(inFile.hasNextDouble())
		{
			numBathrooms = inFile.nextDouble();inFile.nextLine();
		}
		else
		{
			return null;
		}
		
		HouseType aHouseType = HouseType.PRIVATE;
		try
		{
			aHouseType = HouseType.valueOf(houseType);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error reading carmake");
			return null;
		}
		
		House house1 = new House(address,yearBuilt,aHouseType,numBedrooms, numBathrooms);
		return house1;
		
		
		
		
		
		
	}

	// public class HouseUtilsImpl
	// receives: inFile - precondition:  inFile is open and ready to read data from
	// file format: address {newline} year built {newline} type of house {newline} number of bedrooms {space} number of bathrooms {newline}
	// returns:  a single populated House instance with data from inFile if all data is there, 
	// returns null if no data found (end of input) for a house  or if 
	// any mismatch of data or missing expected data occurs
	  
	  
	 //receives: outFile - precondition : outFile is open and ready to receive output
	 // returns: nothing
	 // task : received house is written to outFile in program readable format (so that it could be read back in later)
	  public static void writeToFile(PrintWriter out, House house)
	  {
		  out.println(house.getAddress());
		  out.println(house.getYearBuilt());
		  out.println(house.getHouseType());
		  out.println(house.getNumBedrooms()+" "+house.getNumBathrooms());
		  
	  }
	  
	  
 
	  
	  
	  
	  
	  

}
