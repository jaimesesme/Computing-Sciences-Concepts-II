package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import asg3.House;
import asg3.HouseType;
import asg3.HouseUtilsImpl;


public class HouseTest {

	public static void main(String []args)
	{
		String sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Begin Testing of Asg #3 for " + sName + "\n");
		testConstructorsAccessors();
		testModifiers();
		testToString();
		testFileIO();
		System.out.println("\nEnd Testing of Asg #3 for " + sName);

	}

	public static void testFileIO() {
		System.out.println("\n------------------------------------------------------");
		System.out.println("**** Now testing read/write methods ****");
		String fileName="";
		Scanner inFile = null;
		PrintWriter outFile = null;
		fileName= "houseEmpty.txt";
		int count = 0;
		int expCount = 0;
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("\n****Output of reading from: " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		House house = HouseUtilsImpl.readFromScanner(inFile);
		if(house == null && count == 0)
		{
			System.out.println("SUCCESS, should not find any house data in file: " + fileName);
		}
		else
		{
			System.out.println("FAILURE, should not returh a house when trying to read: " + fileName);
		}
		inFile.close();
		fileName = "house1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("\n****Output of reading from: " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		expCount = 1;
		count = 0;
		while(inFile.hasNext())
		{
			house = HouseUtilsImpl.readFromScanner(inFile);
			if(house != null)
			{
				count ++;
				System.out.println(count + ") " +  house);
			}
		}
		if(count == expCount)
		{
			System.out.println("SUCCESS should have read " + count + " houses from file " + fileName);
		}
		else
		{
			System.out.println("FAILURE should have read " + expCount + " houses from file " + fileName);
		}
		inFile.close();
		fileName = "house6.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println(""
					+ "\n****Output of reading from: " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		expCount = 6;
		count = 0;
		while(inFile.hasNext())
		{
			house = HouseUtilsImpl.readFromScanner(inFile);
			if(house != null)
			{

				count ++;
				System.out.println(count + ") " +  house);
			}
		}
		if(count == expCount)
		{
			System.out.println("SUCCESS should have read " + count + " houses from file " + fileName);
		}
		else
		{
			System.out.println("FAILURE should have read " + expCount + " houses from file " + fileName);
		}
		inFile.close();
		fileName = "houseError.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("\n****Output of reading from: " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		expCount = 0;
		count = 0;
		while(inFile.hasNext())
		{
			house = HouseUtilsImpl.readFromScanner(inFile);
			if(house != null)
			{

				count ++;
				System.out.println(count + ") " +  house);
			}

		}
		if(count == expCount)
		{
			System.out.println("SUCCESS should have read " + count + " houses from file " + fileName);
		}
		else
		{
			System.out.println("FAILURE should have read " + expCount + " houses from file " + fileName);
		}
		
		System.out.println("Now Testing writeToFile() for HouseUtilsImpl");
		fileName="house6Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		fileName = "house6.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("\n****Output of reading from: " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		expCount = 0;
		count = 0;
		while(inFile.hasNext())
		{
			house = HouseUtilsImpl.readFromScanner(inFile);
			if(house != null)
			{
				count ++;
				System.out.println( count + ") " +  house);
				HouseUtilsImpl.writeToFile(outFile, house);
			}
		}
		inFile.close();
		outFile.close();
		fileName = "house6Out.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("\n****Output of " + fileName + ":" + " should have 6 houses....");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		expCount = 6;
		count = 0;
		while(inFile.hasNext())
		{
			house = HouseUtilsImpl.readFromScanner(inFile);
			if(house != null)
			{
				count ++;
				System.out.println(count + ") " +  house);
			}
		}
		inFile.close();
		if(count == expCount)
		{
			System.out.println("SUCCESS should have read " + count + " houses from file " + fileName);
		}
		else
		{
			System.out.println("FAILURE should have read " + expCount + " houses from file " + fileName);
		}		
	}

	public static void testModifiers() {
		System.out.println("\n------------------------------------------------------");
		System.out.println("---------- Testing Modifiers ----------------------");
		House house1 = new House();
		String expString = "";
		String retString = "";
		house1.setAddress("   405    maiN strEet NOrth  ");
		expString = "405 Main Street North";
		retString = house1.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house1 ");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house1");
		}
		house1.setAddress(", , :  ");
		expString = House.DEFAULT_ADDRESS;
		retString = house1.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house1 ");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house1");
		}
		house1.setAddress(" ");
		expString = House.DEFAULT_ADDRESS;
		retString = house1.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house1 ");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house1");
		}
		house1.setAddress("");
		expString = House.DEFAULT_ADDRESS;
		retString = house1.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house1 ");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house1");
		}
		house1.setYearBuilt(2019);
		int expYear=2019;
		int retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for house1 ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expYear + " for year built instead got: " + retYear + " for house1");
		}
		house1.setYearBuilt(2021);
		expYear=House.DEFAULT_YEARBUILT;
		retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for house1 ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expYear + " for year built instead got: " + retYear + " for house1");
		}
		house1.setYearBuilt(1600);
		expYear=1600;
		retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for house1 ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expYear + " for year built instead got: " + retYear + " for house1");
		}
		house1.setYearBuilt(1599);
		expYear=House.DEFAULT_YEARBUILT;
		retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for house1 ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expYear + " for year built instead got: " + retYear + " for house1");
		}
		house1.setYearBuilt(2050);
		expYear=House.DEFAULT_YEARBUILT;
		retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for house1 ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expYear + " for year built instead got: " + retYear + " for house1");
		}
		house1.setYearBuilt(-888);
		expYear=House.DEFAULT_YEARBUILT;
		retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for house1 ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expYear + " for year built instead got: " + retYear + " for house1");
		}
		System.out.println("\nNow Testing setHouseType()");
		HouseType expType = HouseType.PRIVATE;
		HouseType retType = HouseType.PRIVATE;
		retType = house1.getHouseType();
		if(retType.equals(expType))
		{
			System.out.println("SUCCESS expected " + expType + " for house1's house type ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expType + " for house1's type instead got: " + retType + " for house1");
		}
		house1.setHouseType(HouseType.RENTAL);
		expType = HouseType.RENTAL;
		retType = house1.getHouseType();
		if(retType.equals(expType))
		{
			System.out.println("SUCCESS expected " + expType + " for house1's house type ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expType + " for house1's type instead got: " + retType + " for house1");
		}
		house1.setHouseType(HouseType.VACATION);
		expType = HouseType.VACATION;
		retType = house1.getHouseType();
		if(retType.equals(expType))
		{
			System.out.println("SUCCESS expected " + expType + " for house1's house type ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expType + " for house1's type instead got: " + retType + " for house1");
		}
		System.out.println("\nNow Testing setNumBedrooms");
		int expNum = 0;
		int retNum = 0;
		expNum = 1;
		retNum = house1.getNumBedrooms();
		if(retNum == expNum)
		{
			System.out.println("SUCCESS expected " + expNum + " for house1's number of bedrooms ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expNum + " for house1's number of bedrooms instead got: " + retNum + " for house1");
		}
		house1.setNumBedrooms(-1);
		expNum = 1;
		retNum = house1.getNumBedrooms();
		if(retNum == expNum)
		{
			System.out.println("SUCCESS expected " + expNum + " for house1's number of bedrooms ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expNum + " for house1's number of bedrooms instead got: " + retNum + " for house1");
		}
		house1.setNumBedrooms(100);
		expNum = 100;
		retNum = house1.getNumBedrooms();
		if(retNum == expNum)
		{
			System.out.println("SUCCESS expected " + expNum + " for house1's number of bedrooms ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expNum + " for house1's number of bedrooms instead got: " + retNum + " for house1");
		}
		house1.setNumBedrooms(101);
		expNum = 1;
		retNum = house1.getNumBedrooms();
		if(retNum == expNum)
		{
			System.out.println("SUCCESS expected " + expNum + " for house1's number of bedrooms ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expNum + " for house1's number of bedrooms instead got: " + retNum + " for house1");
		}
		house1.setNumBedrooms(5);
		expNum = 5;
		retNum = house1.getNumBedrooms();
		if(retNum == expNum)
		{
			System.out.println("SUCCESS expected " + expNum + " for house1's number of bedrooms ");
		}
		else 
		{
			System.out.println("FAILURE expected " + expNum + " for house1's number of bedrooms instead got: " + retNum + " for house1");
		}
		house1.setNumBathrooms(100.0);
		double expVal = 100.0;
		double retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}
		house1.setNumBathrooms(0.0);
		expVal = 0.0;
		retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}

		house1.setNumBathrooms(-10.0);
		expVal = 1.0;
		retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}
		house1.setNumBathrooms(1.0);
		expVal = 1.0;
		retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}
		house1.setNumBathrooms(3.5);
		expVal = 3.5;
		retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}
		house1.setNumBathrooms(100.1);
		expVal = 1.0;
		retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}
		house1.setNumBathrooms(0.5);
		expVal = 0.5;
		retVal = house1.getNumBathrooms();
		if(retVal > expVal || retVal < expVal)
		{
			System.out.println("FAILURE expected " + expVal + " for house1's number of bathrooms instead got " +
					retVal + " bathrooms");
		}
		else 
		{
			System.out.println("SUCCESS expected " + expVal + " for house1's number of bathrooms as expected");
		}
	}



	public static void testConstructorsAccessors()
	{
		House house1 = new House();
		House house2 = new House("1403   West AVE.  ", 2018, HouseType.RENTAL, 3, 2.0);
		House house3 = new House("    ", 1500, HouseType.VACATION, -1, 100.1);
		House house4 = new House("  ,  ,  ,; .", 2050, HouseType.RENTAL, 101, -1.0);
		House house5 = new House("  ,? -- ", 1600, HouseType.VACATION, 99, 99.0);
		System.out.println("\n------------------------------------------------------");
		System.out.println("*********Now testing constructors and accessors for House instances");
		String expString = "";
		String retString = "";
		expString = House.DEFAULT_ADDRESS;
		retString = house1.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house1");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house1");
		}
		expString = House.DEFAULT_ADDRESS;
		retString = house4.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house4");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house4");
		}
		expString = "1403 West Ave.";
		retString = house2.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString + " for house2");
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString + " for house2");
		}
		expString = House.DEFAULT_ADDRESS;
		retString = house3.getAddress();
		if(retString.equals(expString))
		{
			System.out.println("SUCCESS expected " + expString);
		}
		else
		{
			System.out.println("FAILURE expected " + expString + " instead got: " + retString);
		} 
		int expYear = 0;
		int retYear =  0;
		expYear = House.DEFAULT_YEARBUILT;
		retYear = house1.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear = House.DEFAULT_YEARBUILT;
		retYear = house3.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear = 2018;
		retYear = house2.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear = House.DEFAULT_YEARBUILT;
		retYear = house4.getYearBuilt();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear);
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		double expBaths = 0.0;
		double retBaths = 0.0;
		expBaths = 1.0;
		retBaths = house1.getNumBathrooms();
		if(retBaths < expBaths || retBaths > expBaths)
		{
			System.out.println("FAILURE expected " + expBaths + " bathrooms for house1 instead got: " + retBaths);
		}
		else 
		{
			System.out.println("SUCCESS expected " + expBaths + " bathrooms for house1");
		}
		expBaths = 2.0;
		retBaths = house2.getNumBathrooms();
		if(retBaths < expBaths || retBaths > expBaths)
		{
			System.out.println("FAILURE expected " + expBaths + " bathrooms for house2 instead got: " + retBaths);
		}
		else 
		{
			System.out.println("SUCCESS expected " + expBaths + " bathrooms for house2");
		}
		expBaths = 1.0;
		retBaths = house3.getNumBathrooms();
		if(retBaths < expBaths || retBaths > expBaths)
		{
			System.out.println("FAILURE expected " + expBaths + " bathrooms for house3 instead got: " + retBaths);
		}
		else 
		{
			System.out.println("SUCCESS expected " + expBaths + " bathrooms for house3");
		}
		expBaths = 1.0;
		retBaths = house4.getNumBathrooms();
		if(retBaths < expBaths || retBaths > expBaths)
		{
			System.out.println("FAILURE expected " + expBaths + " bathrooms for house4 instead got: " + retBaths);
		}
		else 
		{
			System.out.println("SUCCESS expected " + expBaths + " bathrooms for house4");
		}
		expBaths = 99.0;
		retBaths = house5.getNumBathrooms();
		if(retBaths < expBaths || retBaths > expBaths)
		{
			System.out.println("FAILURE expected " + expBaths + " bathrooms for house5 instead got: " + retBaths);
		}
		else 
		{
			System.out.println("SUCCESS expected " + expBaths + " bathrooms for house5");
		}
		int expBeds = 0;
		int retBeds = 0;
		expBeds = 1;
		retBeds = house1.getNumBedrooms();
		if(retBeds == expBeds)
		{
			System.out.println("SUCCESS expected " + expBeds + " bedrooms for house1");
		}
		else
		{
			System.out.println("FAILURE expected " + expBeds + " bedrooms for house1 instead got: " + retBeds);
		}
		expBeds = 3;
		retBeds = house2.getNumBedrooms();
		if(retBeds == expBeds)
		{
			System.out.println("SUCCESS expected " + expBeds + " bedrooms for house2");
		}
		else
		{
			System.out.println("FAILURE expected " + expBeds + " bedrooms for house2 instead got: " + retBeds);
		}
		expBeds = 1;
		retBeds = house3.getNumBedrooms();
		if(retBeds == expBeds)
		{
			System.out.println("SUCCESS expected " + expBeds + " bedrooms for house3");
		}
		else
		{
			System.out.println("FAILURE expected " + expBeds + " bedrooms for house3 instead got: " + retBeds);
		}
		expBeds = 1;
		retBeds = house4.getNumBedrooms();
		if(retBeds == expBeds)
		{
			System.out.println("SUCCESS expected " + expBeds + " bedrooms for house4");
		}
		else
		{
			System.out.println("FAILURE expected " + expBeds + " bedrooms for house4 instead got: " + retBeds);
		}
		expBeds = 99;
		retBeds = house5.getNumBedrooms();
		if(retBeds == expBeds)
		{
			System.out.println("SUCCESS expected " + expBeds + " bedrooms for house5");
		}
		else
		{
			System.out.println("FAILURE expected " + expBeds + " bedrooms for house5 instead got: " + retBeds);
		}
		HouseType expType = HouseType.PRIVATE;
		HouseType retType = HouseType.PRIVATE;
		expType = HouseType.PRIVATE;
		retType = house1.getHouseType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType + " for house1");
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " for house1 instead got: " + retType);
		}
		expType = HouseType.RENTAL;
		retType = house2.getHouseType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType + " for house2");
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " for house2 instead got: " + retType);
		}	
		expType = HouseType.VACATION;
		retType = house3.getHouseType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType + " for house3");
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " for house3 instead got: " + retType);
		}
		expType = HouseType.RENTAL;
		retType = house4.getHouseType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType + " for house4");
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " for house4 instead got: " + retType);
		}
		expType = HouseType.VACATION;
		retType = house5.getHouseType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType + " for house5");
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " for house5 instead got: " + retType);
		}
	}
	public static void testToString()
	{
		System.out.println("\n------------------------------------------------------");
		System.out.println("*********Now testing toString() for House instances**********");
		House house1 = new House();
		String s1 = house1.toString();
		if(s1.contains(House.DEFAULT_ADDRESS) && s1.contains(House.DEFAULT_YEARBUILT+""))
		{
			System.out.println("SUCCESS expected " + s1 + " for house1 to have year and address defaults ");
		}
		else
		{
			System.out.println("FAILURE expected to have 2020 and $$$$ instead got: " + s1 + " for house1 toString()");
		}
		int numLines = utils.MyUtils.numberLines(s1);
		int expLines = 0;
		if(numLines == 0)
		{
			System.out.println("SUCCESS expected " + s1 + " for house1 to have " + numLines + " newlines");
		}
		else
		{
			System.out.println("FAILURE expected " + s1 + " for house1 to have " + expLines + " newlines\"");
		}
		String addr = "4401 SOUTH CONGRESS Ave.";
		String expString = "4401 South Congress Ave.";
		house1.setAddress("4401 SOUTH CONGRESS Ave.");
		s1 = house1.toString();
		if(s1.contains(expString) && s1.contains(House.DEFAULT_YEARBUILT+""))
		{
			System.out.println("SUCCESS expected " + s1 + " for house1 to have address: " + addr );
		}
		else
		{
			System.out.println("FAILURE expected to have 2020 and " + addr + " instead got: " + s1 + " for house1 toString()");
		}
		addr = ";,,;;.";
		expString = House.DEFAULT_ADDRESS;
		house1.setAddress(addr);
		s1 = house1.toString();
		if(s1.contains(expString) && s1.contains(House.DEFAULT_YEARBUILT+""))
		{
			System.out.println("SUCCESS expected " + s1 + " for house1 to address: " + addr );
		}
		else
		{
			System.out.println("FAILURE expected to have 2020 and " + addr + " instead got: " + s1 + " for house1 toString()");
		}
		addr = "403 Main St.";
		expString = "403 Main St.";
		house1.setAddress(addr);
		s1 = house1.toString();
		if(s1.contains(expString) && s1.contains(House.DEFAULT_YEARBUILT+""))
		{
			System.out.println("SUCCESS expected " + s1 + " for house1 to have address: " + addr );
		}
		else
		{
			System.out.println("FAILURE expected to have 2020 and " + addr + " instead got: " + s1 + " for house1 toString()");
		}
		int year = 2025;
		int expYear = House.DEFAULT_YEARBUILT;
		house1.setYearBuilt(year);
		s1 = house1.toString();
		if(s1.contains(expYear+"") )
		{
			System.out.println("SUCCESS expected for house1 to have year: " + expYear + " toString() returned: " + s1);
		}
		else
		{
			System.out.println("FAILURE expected toString() to have year:" + expYear + " instead got: " + s1 + " for house1 toString()");
		}
		year = 2000;
		expYear = 2000;
		house1.setYearBuilt(year);
		s1 = house1.toString();
		if(s1.contains(expYear+"") )
		{
			System.out.println("SUCCESS expected for house1 to have year: " + expYear + " toString() returned: " + s1);
		}
		else
		{
			System.out.println("FAILURE expected toString() to have year:" + expYear + " instead got: " + s1 + " for house1 toString()");
		}
		year = 1708;
		expYear = 1708;
		house1.setYearBuilt(year);
		s1 = house1.toString();
		if(s1.contains(expYear+"") )
		{
			System.out.println("SUCCESS expected for house1 to have year: " + expYear + " toString() returned: " + s1);
		}
		else
		{
			System.out.println("FAILURE expected toString() to have year:" + expYear + " instead got: " + s1 + " for house1 toString()");
		}
	}
}

