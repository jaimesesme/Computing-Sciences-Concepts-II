package reservation;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class RentalCarUtilsImpl 
{
	//receives: inFile, an ALREADY set up Scanner, ready to be read from
	// precondition: inFile is connected to a Scanner and is not null
	//returns: a populated RentalCar instance with values of 1 single car
	// read from the inFile. If values are not there to read, returns null.
	public static RentalCar readFromScanner(Scanner inFile)
	{
		String vin = "";
		int year = 0;
		String make = "";
		
		if (inFile.hasNext())
		{
			vin = inFile.next();
		}
		else
		{
			return null;
		}
		if(inFile.hasNextInt())
		{
			year = inFile.nextInt();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			make = inFile.nextLine().trim().toUpperCase();
		}
		else
		{
			return null;
		}
		
		CarMake aCarMake = CarMake.TOYOTA;
		try
		{
			aCarMake = CarMake.valueOf(make);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error reading carmake");
			return null;
		}
		
		//CarMake aCarMake = CarMake.valueOf(make);
		RentalCar car = new RentalCar(vin,year,aCarMake);
		return car;

		
	}

	//receives: outFile an ALREADY set up PrintWriter, ready to be written to
	// car: a RentalCar instance to write out to outFile
	// precondition: outFile is connected to a PrintWriter and is not null
	// car is not null
	//returns: nothing, prints to the file in same format as input (carVin {space} carYear {space} carMake {end of line}
	public static void writeToFile(PrintWriter outFile, RentalCar car)
	{
		outFile.println(car.getVin()+" "+car.getYear()+" "+car.getMake());
	
	}

}
