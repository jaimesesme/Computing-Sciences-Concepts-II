package reservationlist;

import java.io.PrintWriter;
import java.util.Scanner;
import reservation.Reservation;

public class ReservationListUtilsImpl 
{
	
	
	// receives: inFile, a Scanner already open and ready to read from
	// returns: a reservationList, a list of reservations read from Scanner, returns an empty list if no reservations found.
	// reads from inFile as many reservations as it can, puts each one into reservationList 
	// pre: inFile is open and ready to read from
	// all reservations found on inFile are added to reservationList using add method in ReservationList interface
	// returns: a ReservationList instance, populated with reservations read from received Scanner instance.
	public static ReservationList readFromScanner(Scanner inFile)
	{
		ReservationList reserveList = new ReservationListImpl();
		
		while(inFile.hasNext())
		{
			Reservation reserve = reservation.ReservationUtilsImpl.readFromScanner(inFile);
			if (reserve != null)
				reserveList.add(reserve);
		}
			
		
		return reserveList;
		
	}


	// receives: outFile, an open and ready to write to PrintWriter instance
	//	           reservationList, a list to be written to outFile in data format (so it can be read back in later)
	// writes received reservation list to received outFile in same format as read in with descriptor 
	// on each line describing which type of reservation is on the line
	// pre: outFile is open and ready to print to
	// post: outFile contains entire contents of list written in same format
	//	       as input format
	public static void writeToFile(PrintWriter outFile, ReservationList reservationList)
	{
		for(int i = 0; i<reservationList.getSize();i++)
		{
			Reservation reserve = reservationList.get(i);
			reservation.ReservationUtilsImpl.writeToFile(outFile, reserve);
		}
	}

}
