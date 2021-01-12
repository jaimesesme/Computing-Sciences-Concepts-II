package reservation;
import reservation.RentalCar;
import reservation.CarMake;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;
import reservation.RentalCarUtilsImpl;
import reservation.RentalCarUtilsImpl;

public class ReservationUtilsImpl 
{
	
	//receives: inFile, a Scanner instance already open and ready for reading 
	//  tries to read one Reservation derived instance from file, 
	//if successful, creates Reservation-derived instance, populates it, returns it, assumes data in order expected
	//returns null if no data on inFile to read, returns populated Reservation-derived instance otherwise
	public static Reservation readFromScanner(Scanner inFile)
	{
		String reservationType = "";
		String confirmationId = "";
		String startDate = "";
		String endDate = "";
		
		String hotelName = "";
		int numPersons = 0;
		
		String vin = "";
		int year = 0;
		String make = "";
		
		String departCode = "";
		String arrivalCode = "";
		
		if(inFile.hasNext())
			reservationType = inFile.next();
		else
			return null;
		if (inFile.hasNext())
			confirmationId = inFile.next();
		else
			return null;
		if (inFile.hasNext())
			startDate = inFile.next();
		else
			return null;
		if (inFile.hasNext())
			endDate = inFile.nextLine();
		else
			return null;
		GregorianCalendar sDate = utils.MyUtils.stringToDate(startDate);
		GregorianCalendar eDate = utils.MyUtils.stringToDate(endDate);
		if (reservationType.toUpperCase().equals("HOTEL"))
		{
			if(inFile.hasNextInt())
				numPersons = inFile.nextInt();
			else
				return null;
			if (inFile.hasNext())
				hotelName = inFile.nextLine();
			else
				return null;
			HotelReservation hr = new HotelReservation(confirmationId);
			hr.setNumPersons(numPersons);
			hr.setHotelName(hotelName);
			hr.setStartDate(startDate);
			hr.setEndDate(endDate);

			return hr;
			
	
		}
		
		if (reservationType.toUpperCase().equals("CAR"))
		{
			
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
			
			
			CarReservation cr = new CarReservation(confirmationId);
			cr.setCar(car);
			cr.setStartDate(startDate);
			cr.setEndDate(endDate);
			return cr;
		} 
		
		if (reservationType.toUpperCase().equals("FLIGHT"))
		{
			if(inFile.hasNext())
				departCode = inFile.next();
			else
				return null;
			if (inFile.hasNext())
				arrivalCode = inFile.nextLine();
			else
				return null;
			
			FlightReservation fr = new FlightReservation(confirmationId);
			fr.setArrivalCode(arrivalCode);
			fr.setDepartCode(departCode);
			fr.setStartDate(startDate);
			fr.setEndDate(endDate);
			return fr;
		} 
		else
			return null;
			
	}

	//receives: reservation to write, outFile, already open and ready to be written to 
	//writes received reservation instance to file in same format as read in with 
	//including leading HOTEL or CAR or FLIGHT on first line of output
	//returns: nothing
	public static void writeToFile(PrintWriter outFile, Reservation reservation)
	{
		if (reservation instanceof CarReservation)
		{
			CarReservation cr = (CarReservation)reservation;
			outFile.println("CAR " + cr.getConfirmationNumber() + " "+cr.getStartDateAsString()+" "+cr.getEndDateAsString());
			outFile.println(cr.getCar().getVin()+" "+cr.getCar().getYear()+" "+cr.getCar().getMake());
		}
		
		else if (reservation instanceof FlightReservation)
		{
			FlightReservation fr = (FlightReservation)reservation;
			outFile.println("FLIGHT "+fr.getConfirmationNumber() + " "+fr.getStartDateAsString()+" "+fr.getEndDateAsString());
			outFile.println(fr.getArrivalCode()+" "+fr.getDepartCode());
		}
		
		else if (reservation instanceof HotelReservation)
		{
			HotelReservation hr = (HotelReservation)reservation;
			outFile.println("HOTEL "+hr.getConfirmationNumber() + " "+hr.getStartDateAsString()+" "+hr.getEndDateAsString());
			outFile.println(hr.getNumPersons()+" "+hr.getHotelName());
		}
	}
	
	
	

}
