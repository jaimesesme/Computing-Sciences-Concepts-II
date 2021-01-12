package housepet;

import java.io.PrintWriter;
import java.util.Scanner;

public class HousePetUtilsImpl 

{
	
	 //receives: inFile - precondition:  inFile is open and ready to read data from
	 //     file format: pet name {newline} year born {space} gender {space} pet type {newline}
	 //returns:  a single populated HousePet instance with data from inFile if all data is there, 
	 //      returns null if no data found (end of input) for a house pet or if 
	 //      any mismatch of data or missing expected data occurs
	public static HousePet readFromScanner(Scanner inFile)
	{
		String name = "";
		int year = 0;
		String gender = "";
		String type ="";
		
		if(inFile.hasNext())
			name = inFile.nextLine();
		else
			return null;
		if (inFile.hasNextInt())
			year = inFile.nextInt();
		else
			return null;
		if (inFile.hasNext())
			gender = inFile.next().trim().toUpperCase();
		else
			return null;
		if (inFile.hasNextLine())
			type = inFile.nextLine().trim().toUpperCase();
		else
			return null;
		
		GenderType agender = GenderType.UNKNOWN;
		try
		{
			agender = GenderType.valueOf(gender); 
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error reading carmake");
			return null;
		}
		
		PetType atype = PetType.UNKNOWN;
		try
		{
			atype = PetType.valueOf(type);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error reading carmake");
			return null;
		}
		HousePet pet = new HousePet(name, year, agender, atype);
		return pet;
		
	}
	  
	 //receives: outFile - precondition : outFile is open and ready to receive output
	 // returns: nothing
	// task : received housePet is written to outFile in program readable format (so that it could be read back in later)
//	      writes pet name on first output line, year, gender, and pet type on 2nd line.
	public static void writeToFile(PrintWriter out, HousePet housePet)
	{
		out.println(housePet.getPetName());
		out.println(housePet.getYearBorn()+" "+housePet.getGenderType()+" "+ housePet.getPetType()+"\n");
		
	}
	

}
