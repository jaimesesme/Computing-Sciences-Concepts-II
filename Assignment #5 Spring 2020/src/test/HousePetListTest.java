package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import housepet.HousePet;
import housepet.HousePetUtilsImpl;
import housepet.GenderType;
import housepet.PetType;
import housepetlist.HousePetList;
import housepetlist.HousePetListImpl;
import housepetlist.HousePetListUtilsImpl;

class HousePetListTest {

	@Test

	public void test()
	{  
		String sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Begin Asg5 Testing for : " + sName);
		utils.MyUtils.printTimeStamp("BEGINS");

		testHousePetOnly();
		testListConstructorsAndtoString();
		testListGetters();
		testContainsAndAdd();
		testFindGetRemoveSort();
		testListUtilsMethods();

		System.out.println("End of Asg5 Testing for : " + sName);
		utils.MyUtils.printTimeStamp("ENDS");
	}
	public void testHousePetOnly()
	{
		testAccessors();
		testConstructors();
		testModifiers();
		testEqualsAndHashCode();
		testFileIO();
	}
	public void testEqualsAndHashCode()
	{
		System.out.println("\n-----------------------\nTesting equals() and hashCode() methods  *********");
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet("wilma flintstone", 2010, GenderType.UNKNOWN, PetType.GERBIL);
		HousePet pet2Dup = new HousePet("wilma flintstone", 2010, GenderType.UNKNOWN, PetType.GERBIL);
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet("tweets", 0, GenderType.MALE, PetType.BIRD);
		assertEquals(pet2, pet2Dup);
		assertEquals(pet2.hashCode(), pet2Dup.hashCode());
		assertFalse(pet3.equals(pet2));
		assertFalse(pet2.equals(pet3));
		pet2 = new HousePet();
		assertEquals(pet2, pet1);
		assertEquals(pet2.hashCode(), pet1.hashCode());
		pet2.setPetName("Joey the gerbil");
		pet1.setPetName("Joey the gerbil");
		assertEquals(pet2, pet1);
		assertEquals(pet2.hashCode(), pet1.hashCode());
		pet2.setGenderType(GenderType.FEMALE);
		pet1.setGenderType(GenderType.FEMALE);
		assertEquals(pet2, pet1);
		assertEquals(pet2.hashCode(), pet1.hashCode());
		pet2.setPetType(PetType.BIRD);
		pet1.setPetType(PetType.BIRD);
		assertEquals(pet2, pet1);
		assertEquals(pet2.hashCode(), pet1.hashCode());
		assertFalse(pet1.equals(pet4));

	}
	public  void testFileIO()
	{
		System.out.println("\n-----------------------\nTesting read and write methods for HousePet *********");

		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.MALE, PetType.BIRD);
		Scanner inputFile = null;
		PrintWriter outputFile = null;

		String filename = "housepet8.txt";
		try {
			inputFile = new Scanner(new File(filename));

			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			assertTrue(false);

		}
		int petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		assertEquals(8, petCount);


		System.out.println("********Now Testing writeToFile...");
		filename = "housepetEmpty.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
			assertTrue(outputFile != null);
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			assertTrue(false);
			System.exit(0);	
		}
		outputFile.close();
		try {
			inputFile = new Scanner(new File(filename));
			assertTrue(inputFile != null);
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			assertTrue(false);//kill
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
			{
				petCount ++;
			}
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		assertEquals(0, petCount);	// now write 1 pet to file

		filename = "housepetError.txt";
		try {
			inputFile = new Scanner(new File(filename));
			assertTrue(inputFile != null);
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			assertTrue(false);//kill
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
			{
				petCount ++;
				System.out.println("Just read: " + pet1);
			}

		}
		inputFile.close();
		assertEquals(0, petCount);	// now write 1 pet to file
		filename = "housepet1.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));

		}catch (IOException e) {

			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			assertTrue(false);
		}
		pet1 = new HousePet("fred flintSTONe ", 2015, GenderType.MALE, PetType.POTBELLY_PIG);
		HousePetUtilsImpl.writeToFile(outputFile, pet1);
		outputFile.close();
		try {
			inputFile = new Scanner(new File(filename));

			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			assertTrue(false);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
			{
				petCount ++;
				System.out.println("Just read: " + pet1);
			}

		}
		inputFile.close();
		assertEquals(1, petCount);
		// now write 4 pets to file
		filename = "housepetFourWrite.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
		}catch (IOException e) {
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			assertTrue(false);
		}
		System.out.println("Now writing 4 pets: \n" + 
				pet1 + "\n" +
				pet2 + "\n" +
				pet3 + "\n" +
				pet4 );

		HousePetUtilsImpl.writeToFile(outputFile, pet1);
		HousePetUtilsImpl.writeToFile(outputFile, pet2);
		HousePetUtilsImpl.writeToFile(outputFile, pet3);
		HousePetUtilsImpl.writeToFile(outputFile, pet4);
		outputFile.close();

		filename = "housepetFourWrite.txt";
		try {
			inputFile = new Scanner(new File(filename));
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			assertTrue(false);  // kill
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
			{	
				petCount ++;
				System.out.println("Just read: " + pet1);
			}
		}
		inputFile.close();
		int expCount = 4;
		assertEquals(expCount, petCount);
		try {
			inputFile = new Scanner(new File(filename));		
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			assertTrue(false);  //kill
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
			{
				petCount ++;
				System.out.println("Just read: " + pet1);
			}

		}
		assertEquals(4, petCount);
		inputFile.close();
		String expString = HousePet.DEFAULT_NAME;
		String retString = pet1.getPetName();
		assertEquals(expString, retString);

		expString = "0";
		retString = pet1.toString();
		assertTrue(retString.contains(expString));

		expString = "BIRD";

		retString = pet1.getPetType().toString();
		assertTrue(retString.equals(expString));
		expString = "MALE";
		retString = pet1.getGenderType().toString();
		assertTrue(retString.equals(expString));

	}
	public static void testAccessors()
	{
		System.out.println("\n*********************Now testing getters for HousePets");
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.MALE, PetType.BIRD);

		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		GenderType expGender=GenderType.MALE;
		GenderType retGender=pet4.getGenderType();
		assertEquals(expGender, retGender);

		expGender=GenderType.UNKNOWN;
		retGender=pet1.getGenderType();
		assertEquals(expGender, retGender);
		expGender=GenderType.UNKNOWN;
		retGender=pet2.getGenderType();
		assertEquals(expGender, retGender);

		pet1.setGenderType(GenderType.MALE);
		expGender=GenderType.MALE;
		retGender=pet1.getGenderType();
		assertEquals(expGender, retGender);

		pet2.setGenderType(GenderType.FEMALE);
		expGender=GenderType.FEMALE;
		retGender=pet2.getGenderType();
		assertEquals(expGender, retGender);

	}
	public static void testConstructors()
	{
		System.out.println("\n*********Now testing constructors for HousePet instances");
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.UNKNOWN, PetType.UNKNOWN);

		String expName = HousePet.DEFAULT_NAME;
		String retName = pet1.getPetName();
		assertEquals(expName, retName);

		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		expName = "Shirley Ann Marie";
		retName = pet3.getPetName();
		assertEquals(expName, retName);
		expName = HousePet.DEFAULT_NAME;
		retName = pet4.getPetName();
		assertEquals(expName, retName);
		int expYear = HousePet.MAX_YEAR;
		int retYear = pet1.getYearBorn();
		assertEquals(expYear, retYear);
		expYear = HousePet.MAX_YEAR;
		retYear = pet2.getYearBorn();
		assertEquals(expYear, retYear);

		expYear = 2011;
		retYear = pet3.getYearBorn();
		assertEquals(expYear, retYear);
		expYear = HousePet.MAX_YEAR;
		retYear = pet4.getYearBorn();
		assertEquals(expYear, retYear);
	}
	public static void testModifiers()
	{
		System.out.println("\n*********************Now testing modifiers for HousePets");
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.MALE, PetType.BIRD);;

		System.out.println("\n*********************Now testing setter/getter for petName");
		pet1.setPetName(" QUeEn   AnnE  MARGARET ");
		String expName = "Queen Anne Margaret";
		String retName = pet1.getPetName();
		assertEquals(expName, retName);
		pet2.setPetName(" \n");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		pet2.setPetName("\t/@$%^&*()");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		pet2.setPetName("\nA");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		pet2.setPetName("$%^&*KK"); // should work, has 2 letters.
		expName = "$%^&*kk";
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		pet2.setPetName("$   ABB"); // should work, has 2 letters.
		expName = "$ Abb";
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		pet2.setPetName("$%^&* ");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		assertEquals(expName, retName);
		pet4.setPetName("  KinG   GEORgE  ");
		expName = "King George";
		retName = pet4.getPetName();
		assertEquals(expName, retName);

		expName = "Shirley Ann Marie";
		retName = pet3.getPetName();
		assertEquals(expName, retName);
		System.out.println("Now testing setter/getter for yearBorn");
		int myYear = 0;
		pet1.setYearBorn(myYear);
		int expYear = HousePet.MAX_YEAR;
		int retYear = pet2.getYearBorn();
		assertEquals(expYear, retYear);
		myYear = 1899;
		pet1.setYearBorn(myYear);
		expYear = HousePet.MAX_YEAR;
		retYear = pet1.getYearBorn();
		assertEquals(expYear, retYear);
		myYear = HousePet.MIN_YEAR;
		pet1.setYearBorn(myYear);
		expYear = myYear;
		retYear = pet1.getYearBorn();
		assertEquals(expYear, retYear);
		myYear = 2021;
		pet1.setYearBorn(myYear);
		expYear = HousePet.MAX_YEAR;
		retYear = pet1.getYearBorn();
		assertEquals(expYear, retYear);
		myYear = 2020;
		pet1.setYearBorn(myYear);
		expYear = HousePet.MAX_YEAR;
		retYear = pet1.getYearBorn();
		assertEquals(expYear, retYear);
		myYear = 2008;
		pet1.setYearBorn(myYear);
		expYear = myYear;
		retYear = pet1.getYearBorn();
		String expValue = (HousePet.MAX_YEAR - myYear) + "";
		assertTrue(pet1.toString().contains(expValue));
		assertEquals(expYear, retYear);


		System.out.println("\n********* Now testing toString() on all 4 pets, each output line should be " +
				"\n*********   neat and easy to read with proper spacing.");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		String expStr = "12";
		String retStr = pet1.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "Queen Anne Margaret";
		retStr = pet1.toString();
		assertTrue(retStr.contains(expStr));

		expStr = "9";
		retStr = pet3.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "King George";
		retStr = pet4.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "0";
		retStr = pet4.toString();
		assertTrue(retStr.contains(expStr));
		System.out.println("********Now testing set/get for gender ");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		GenderType expGender=GenderType.MALE;
		GenderType retGender=pet4.getGenderType();
		assertEquals(expGender, retGender);
		expGender=GenderType.UNKNOWN;
		retGender=pet1.getGenderType();
		assertEquals(expGender, retGender);
		expGender=GenderType.UNKNOWN;
		retGender=pet2.getGenderType();
		assertEquals(expGender, retGender);
		pet1.setGenderType(GenderType.MALE);
		expGender=GenderType.MALE;
		retGender=pet1.getGenderType();
		assertEquals(expGender, retGender);
		pet2.setGenderType(GenderType.FEMALE);
		expGender=GenderType.FEMALE;
		retGender=pet2.getGenderType();
		assertEquals(expGender, retGender);
		System.out.println("********Now testing set/get for pet type ");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);
		PetType expType=PetType.UNKNOWN;
		PetType retType = pet1.getPetType();
		assertEquals(expType,retType);
		expType=PetType.CAT;
		retType = pet3.getPetType();
		assertEquals(expType,retType);
		expType=PetType.BIRD;
		retType = pet4.getPetType();
		assertEquals(expType,retType);
		pet1.setPetType(PetType.DOG);
		expType=PetType.DOG;
		retType = pet1.getPetType();
		assertEquals(expType,retType);

		pet2.setPetType(PetType.GERBIL);
		expType=PetType.GERBIL;
		retType = pet2.getPetType();
		assertEquals(expType,retType);
		System.out.println("********* Now testing toString() on all 4 pets, each output line should be " +
				"\n*********   neat and easy to read with proper spacing.");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		expStr = "12"; // note should have age as 11 in toString
		retStr = pet1.toString();
		assertTrue(retStr.contains(expStr));

		expStr = "MALE"; // note should have gender in toString
		retStr = pet1.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "DOG"; // note should have petType in toString
		retStr = pet1.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "Queen Anne Margaret";
		retStr = pet1.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "9";
		retStr = pet3.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "FEMALE"; // note should have gender in toString
		retStr = pet3.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "CAT"; // note should have petType in toString
		retStr = pet3.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "BIRD"; // note should have petType in toString
		retStr = pet4.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "King George";
		retStr = pet4.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "0";
		retStr = pet4.toString();
		assertTrue(retStr.contains(expStr));
		expStr = HousePet.DEFAULT_NAME; // note should have default name in toString
		retStr = pet2.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "GERBIL";
		retStr = pet2.toString();
		assertTrue(retStr.contains(expStr));
		expStr = "FEMALE";
		retStr = pet2.toString();
		assertTrue(retStr.contains(expStr));

		System.out.println("********Now testing that toString() produces no new line chars in returned String for HousePet");
		int expLines=0;
		int retLines = utils.MyUtils.numberLines(pet1.toString());
		assertEquals(expLines, retLines);
		expLines=0;
		retLines = utils.MyUtils.numberLines(pet2.toString());
		assertEquals(expLines, retLines);
		expLines=0;
		retLines = utils.MyUtils.numberLines(pet3.toString());
		assertEquals(expLines, retLines);
		expLines=0;
		retLines = utils.MyUtils.numberLines(pet4.toString());
		assertEquals(expLines, retLines);
	}

	public void testListConstructorsAndtoString() {
		System.out.println("\n***** testing constructors and toString() *****");
		HousePetList list1 = new HousePetListImpl();
		HousePetList list2 = new HousePetListImpl("housepet1.txt");
		HousePetList list3 = new HousePetListImpl("housepet8.txt");
		HousePetList list4 = new HousePetListImpl("housepetExtra.txt");


		int expSize=0;
		int retSize=0;
		System.out.println("**** Testing getSize() **** ");
		retSize = list1.getSize();
		expSize=0;
		assertEquals(retSize, expSize);
		retSize = list2.getSize();
		expSize=1;
		assertEquals(expSize, retSize);
		retSize = list3.getSize();
		expSize=8;
		assertEquals(expSize, retSize);
		retSize = list4.getSize();
		expSize=HousePetList.MAX_SIZE;
		assertEquals(expSize, retSize);

		String retString="";

		System.out.println("****Testing toString()****");
		System.out.println("Here is list1:  should be empty\n" + list1);
		expSize=0;
		retString = list1.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);
		System.out.println("Here is list2:  should have 1 pet \n" + list2);
		expSize=1;
		retString = list2.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);
		System.out.println("Here is list3:  should have 8 pets \n" + list3);
		expSize=8;
		retString = list3.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);
		System.out.println("Here is list4:  should have 15 (MAX_SIZE) petss \n" + list4);
		expSize=15;
		retString = list4.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);

		System.out.println("**** End of testConstructorsAndtoString()****");
	}
	public void testListGetters()
	{
		System.out.println("\n***** testing HousePetList getters() *****");

		HousePetList list1 = new HousePetListImpl();
		HousePetList list2 = new HousePetListImpl("housepet1.txt");
		HousePetList list3 = new HousePetListImpl("housepet8.txt");
		HousePetList list4 = new HousePetListImpl("housepetExtra.txt");
		PetType actualPetType = PetType.DOG;


		HousePet b5 = new HousePet();
		b5.setPetName("Joey the Gambler");

		String retString = "";
		String expString = "";
		String actString = "";
		System.out.println ("list1: \n" + list1 + "\n" + "list2: \n" + list2);
		System.out.println("****Testing getHousePetsMatchingGender() ****");
		expString = list1.getHousePetsMatchingGender(GenderType.MALE);
		assertEquals(0, utils.MyUtils.numberLines(expString), "list1 should be an empty list:" + expString);
		expString = list2.getHousePetsMatchingGender(GenderType.FEMALE);
		assertEquals(0, utils.MyUtils.numberLines(expString), "list1 should have 1 pet (FEMALE) \n" + expString);
		expString = list2.getHousePetsMatchingGender(GenderType.MALE);
		assertEquals(1, utils.MyUtils.numberLines(expString), "list1 should have 1 pet (FEMALE) \n" + expString);

		expString = list3.getHousePetsMatchingGender(GenderType.MALE);
		System.out.println("Here are the pets matching MALE \n" + expString);
		assertEquals(5, utils.MyUtils.numberLines(expString));
		expString = list4.getHousePetsMatchingGender(GenderType.FEMALE);
		System.out.println("Here are the pets matching FEMALE \n" + expString);
		assertEquals(6, utils.MyUtils.numberLines(expString));
		expString = list4.getHousePetsMatchingGender(GenderType.UNKNOWN);
		System.out.println("Here are the pets matching UNKNOWN \n" + expString);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		retString = list1.getHousePetsMatchingPetType(PetType.DOG);
		assertEquals(0, utils.MyUtils.numberLines(retString));
		System.out.println("Here are the pets matching DOG \n" + retString);
		retString = list2.getHousePetsMatchingPetType(PetType.CAT);
		assertEquals(0, utils.MyUtils.numberLines(retString));
		System.out.println("Here are the pets matching CAT \n" + retString);
		retString = list3.getHousePetsMatchingPetType(PetType.CAT);
		assertEquals(1, utils.MyUtils.numberLines(retString));
		System.out.println("Here are the pets matching CAT \n" + retString);
		retString = list4.getHousePetsMatchingPetType(PetType.BIRD);
		assertEquals(4, utils.MyUtils.numberLines(retString));
		System.out.println("Here are the pets matching BIRD \n" + retString);


		System.out.println("****Testing getPetsWithMatchingName() ****");
		actString = "sport";
		expString = list1.getHousePetsMatchingName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		actString = "MISS WonDERFul";
		expString = list2.getHousePetsMatchingName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		System.out.println ("Matching name: " + actString + "\n" + expString);
		actString = "Fred flintsTone";
		System.out.println ("Matching name: " + actString + "\n" + expString);
		expString = list2.getHousePetsMatchingName(actString);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		System.out.println ("Matching name: " + actString + "\n" + expString);
		actString = "sweety tWEETy  ";
		expString = list3.getHousePetsMatchingName(actString);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		System.out.println ("Matching name: " + actString + "\n" + expString);
		actString = "FRED   FlintSTOne  ";
		expString = list3.getHousePetsMatchingName(actString);
		assertEquals(2, utils.MyUtils.numberLines(expString));
		System.out.println ("Matching name: " + actString + "\n" + expString);
		actString = "king of queens ";
		expString = list4.getHousePetsMatchingName(actString);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		System.out.println ("Matching name: " + actString + "\n" + expString);
		actString = "queen OF kINGS  ";
		expString = list4.getHousePetsMatchingName(actString);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		System.out.println ("Matching name: " + actString + "\n" + expString);

	}

	public void testContainsAndAdd()
	{
		System.out.println("\n***** testing contains() and add() *****");
		HousePetList list1 = new HousePetListImpl();
		HousePetList list2 = new HousePetListImpl("housepet1.txt");
		HousePetList list3 = new HousePetListImpl("housepet8.txt");
		HousePetList list4 = new HousePetListImpl("housepetExtra.txt");

		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet("fred flintstone", 2010, GenderType.MALE, PetType.GERBIL);
		HousePet pet3 = new HousePet("Ronda rio", 2012, GenderType.FEMALE, PetType.POTBELLY_PIG);
		HousePet pet4 = new HousePet("grey man bleu", 2000, GenderType.MALE, PetType.DOG);
		HousePet pet5 = new HousePet("wilma   flintstone", 2016, GenderType.FEMALE, PetType.CAT);

		assertEquals(0, list1.getSize());
		assertFalse(list1.contains(pet1));
		assertFalse(list1.contains(pet2));
		assertFalse(list1.contains(pet3));
		assertTrue(list1.add(pet2));
		assertTrue(list1.contains(pet2));
		assertFalse(list1.add(pet2));
		assertEquals(1, list1.getSize());
		assertTrue(list1.add(pet3));
		assertEquals(2, list1.getSize());
		assertTrue(list1.contains(pet3));
		assertFalse(list1.contains(pet4));
		assertFalse(list1.add(pet3));
		assertFalse(list1.add(pet2));
		assertTrue(list1.add(pet4));
		assertTrue(list1.contains(pet4));
		assertFalse(list1.add(pet4));
		assertTrue(list1.add(pet5));
		assertEquals(4,list1.getSize());
		assertFalse(list4.add(pet1));
		assertTrue(list3.add(pet2));
		assertTrue(list3.contains(pet2));
		assertFalse(list3.add(pet2));
		assertEquals(9, list3.getSize());


		System.out.println("Size: " + list1.getSize() + " expected(4)  list1: \n" + list1);
		System.out.println("Size: " + list2.getSize() + " expected(1) list2: \n" + list2);
		System.out.println("Size: " + list3.getSize() + " expected(9) list3: \n" + list3);
		System.out.println("Size: " + list4.getSize() + " expected(15) list4: \n" + list4);
		System.out.println("\n***** testing add() and contains() completed *****");	
	}	
	public void testFindGetRemoveSort()
	{

		System.out.println("\n***** testing find() get() and remove() and sort() and clear() *****");
		HousePetList list1 = new HousePetListImpl();
		HousePetList list2 = new HousePetListImpl("housepet1.txt");
		HousePetList list3 = new HousePetListImpl("housepet8.txt");
		HousePetList list4 = new HousePetListImpl("housepetExtra.txt");

		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet("fred flintstone", 2010, GenderType.MALE, PetType.GERBIL);
		HousePet pet3 = new HousePet("Ronda rio", 2012, GenderType.FEMALE, PetType.POTBELLY_PIG);
		HousePet pet4 = new HousePet("grey man bleu", 2000, GenderType.MALE, PetType.DOG);
		HousePet pet5 = new HousePet("wilma   flintstone", 2016, GenderType.FEMALE, PetType.CAT);
		HousePet pet6 = new HousePet("betty rubble", 2016, GenderType.FEMALE, PetType.CAT);

		list1.sortByAge();
		list1.sortByName();
		assertEquals(0, list1.getSize());
		assertEquals(-1, list1.find(pet2));
		assertEquals(-1, list2.find(pet2));
		assertEquals(-1, list3.find(pet2));
		assertEquals(-1, list4.find(pet2));
		assertTrue(list1.add(pet2));
		assertEquals(0, list1.find(pet2));
		HousePet pet = list1.get(0);
		assertEquals(pet2, pet);



		assertFalse(list1.contains(pet3));
		assertTrue(list1.contains(pet2));
		assertFalse(list1.add(pet2));
		assertEquals(1, list1.getSize());
		assertEquals(0, list1.find(pet2));
		HousePet aPet = list1.get(0);
		assertEquals(pet2, aPet);
		assertTrue(list1.add(pet3));
		assertEquals(2, list1.getSize());
		assertTrue(list1.contains(pet3));
		assertFalse(list1.contains(pet4));
		assertFalse(list1.add(pet3));
		assertFalse(list1.add(pet2));
		assertTrue(list1.add(pet4));
		assertTrue(list1.contains(pet4));
		assertFalse(list1.add(pet4));
		assertTrue(list1.add(pet5));
		list1.sortByAge();

		System.out.println("Here is list1 sorted by age: \n" + list1);
		assertEquals(0,list1.find(pet4));
		assertEquals(1,list1.find(pet2));
		assertEquals(2,list1.find(pet3));
		assertEquals(-1,list1.find(pet6));
		assertEquals(3,list1.find(pet5));

		assertEquals(pet4, list1.get(0));
		System.out.println("** found pet4 at index  " + list1.find(pet4) + ": " + list1.get(0));
		System.out.println("** found pet2 at index  " + list1.find(pet2) + ": " + list1.get(1));
		System.out.println("** found pet3 at index  " + list1.find(pet3) + ": " + list1.get(2));
		System.out.println("** found pet4 at index  " + list1.find(pet5) + ": " + list1.get(3));
		assertEquals(pet5, list1.get(3));

		assertEquals(4,list1.getSize());
		assertFalse(list4.add(pet1));
		assertTrue(list3.add(pet2));
		assertTrue(list3.contains(pet2));
		assertFalse(list3.add(pet2));
		assertEquals(9, list3.getSize());

		list4.sortByAge();
		for(int i=0; i< list4.getSize()-1; i++)
		{
			assertTrue(list4.get(i).getYearBorn() <= list4.get(i+1).getYearBorn());
		}
		System.out.println("List of 15 sorted by pet age: \n" + list4);
		list4.sortByName();
		for(int i=0; i< list4.getSize()-1; i++)
		{
			assertTrue(list4.get(i).getPetName().compareTo(list4.get(i+1).getPetName()) <= 0);
		}
		System.out.println("List of 15 sorted by pet name: \n" + list4);

		aPet = list1.remove(pet4);
		assertEquals(aPet, pet4);
		aPet = list1.remove(pet5);
		assertEquals(aPet, pet5);
		aPet = list1.remove(pet5);
		assertEquals(null, aPet);
		aPet = list1.remove(pet2);
		assertEquals(aPet, pet2);
		aPet = list1.remove(pet2);
		assertEquals(null, aPet);
		aPet = list1.remove(pet4);
		assertEquals(null, aPet);
		aPet = list1.remove(pet2);
		assertEquals(null, aPet);

		list1 = new HousePetListImpl("housepet8.txt");
		assertEquals(8,list1.getSize());
		list1.clear();
		assertEquals(0,list1.getSize());
		list1.add(pet2);
		list1.add(pet3);
		assertEquals(2, list1.getSize());
		list1.clear();
		assertEquals(0, list1.getSize());






	}
	public void testListUtilsMethods()
	{
		HousePetList list1 = null;

		System.out.println("\n------------------------------------------------------");
		System.out.println("\n**** Now testing HousePetListUtilsImpl methods ****");
		String fileName="";
		Scanner inFile = null;
		PrintWriter outFile = null;
		fileName= "HousePetEmpty.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		int size1 = list1.getSize();
		assertEquals(size1, 0);
		inFile.close();
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "housepet1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		size1 = list1.getSize();
		assertEquals(size1, 1);
		fileName="HousePet1out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		HousePetListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);

		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened file: " + fileName + " for reading...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		int size2=list1.getSize();
		assertEquals(1, size2);

		System.out.println("Contents of previously written file: " + fileName + "\n" + list1);
		System.out.println("**** Now testing several pets on a file - read and write ****");
		fileName= "housepet8.txt";
		list1 = null;
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened for reading: " + fileName );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		inFile.close();
		size1=list1.getSize();
		System.out.println("Output from reading filename: " + fileName + "\n" + list1);
		assertEquals(8, list1.getSize());
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "housepet8Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		HousePetListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		list1 = null;
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened file: " + fileName + " for reading...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 == 8);	
		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
		fileName= "housepetExtra.txt";
		list1 = null;
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened for reading: " + fileName );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		inFile.close();
		size1=list1.getSize();
		assertTrue(size1==HousePetList.MAX_SIZE);
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "HousePetExtraOut.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		HousePetListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		String expString = "";
		String actString = list1.toString();
		assertEquals(actString, expString);
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened file: " + fileName + " for reading...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		list1 = HousePetListUtilsImpl.readFromScanner(inFile);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 == HousePetList.MAX_SIZE);
		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
		System.out.println("**** End of testUtilsMethods() **** \n");

	}

}
