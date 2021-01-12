package reservationlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Scanner;

import reservation.Reservation;
import reservation.ReservationUtilsImpl;
import reservationlist.MyNode;

public class ReservationListImpl implements ReservationList
{
	private MyNode <Reservation> first;
	private int count;
	
	
    public ReservationListImpl() 
    {
    	this.first = null;

    	this.count = 0;
    }

    public ReservationListImpl(String fileName) 
    {
    	this.first = null;

    	this.count = 0;
    	
    	Scanner inFile = null;
    	
    	try
    	{

    	    inFile = new Scanner (new  File(fileName) );

    	}

    	catch(FileNotFoundException e)

    	{

	    	System.out.println("Error opening file: " + fileName + " constructing empty list. ");
	    	//return;

    	}
    	
    	while(inFile.hasNext())
    	{
    		Reservation res = reservation.ReservationUtilsImpl.readFromScanner(inFile);
    		if (res != null) 
        	{
        		this.add(res);
        	}
    	}
    	
    
    }
    
    public String toString()
    {
    	String retVal = "";
    	MyNode <Reservation> current = this.first;
    	while(current != null)
    	{
    		retVal+= current.data+"\n";
    		current = current.link;
    	}
    	return retVal;
    }

	//receives: nothing
	// returns: the number reservations in the list
	public int getSize()
	{
		return count;
	}

	// receives: nothing
	// returns:  a String of all reservations that have either start or end date on received date
	//      each reservation is separated by a newline character and specified by descriptor. 
	//      Returns an empty string if no reservations occurred on received date.
	public String getReservationListByDate(GregorianCalendar date)
	{
		String retVal = "";
		MyNode <Reservation> current = this.first;
		
		
		while (current != null)
		{
			if (current.data.getStartDate().equals(date)||current.data.getEndDate().equals(date))
			{
				retVal += current.data+"\n";
			}
			current = current.link;
		}
		return retVal;
	}
	
	// receives: nothing
	// returns: true if the list contains given reservation false if not in list.
	// uses equals method and assumes it is overloaded for Reservation-derived instances
	public boolean contains(Reservation reservation)
	{
		MyNode <Reservation> current = this.first;
		
		while (current != null)
		{
			if (current.data.equals(reservation))
			{
				return true;
			}
			current = current.link;
		}
		return false;
	}

	// receives: reservation to be added to this reservation list instance
	// returns: true if received reservation is added to list if not in list already returns true if added, false if not
	//       assumes equals is overloaded 
	//      list remains sorted by start date at all times (from earliest date to latest date)
	public boolean add(Reservation reservation)
	{
		if(contains(reservation))
			return false;
		else if(this.getSize()>= MAX_SIZE)
			return false;
		MyNode <Reservation> node = new MyNode<Reservation>();
		node.data = reservation;
		node.link = null;
		MyNode <Reservation> previous = null;
		MyNode <Reservation> current = this.first;
		while(current!=null)
		{
			if(current.data.getStartDate().compareTo(reservation.getStartDate())>0)
				break;
			previous=current;
			current=current.link;
		}
		if(previous==null)
		{
			node.link = this.first;
			this.first=node;
		}
		else
		{
			node.link = previous.link;
			previous.link = node;
		}
		this.count ++;
		return true;
	}

	// receives: a position in this list to retrieve a reservation from
	// returns: the reservation in the list at given position.
	//       uses zero-based positions, so 0 is the position of the first reservation in the list
	//       returns null if received position is out of range for this reservation list instance.
	//  Example use:
	//        ReservationList resList = new ReservationListImpl("reservations.txt");
	//        Reservation t1 = resList.get(0);
	//        assertTrue(t1!=null);
	
	
	public Reservation get(int position)
	{
		if (position<0 || position >= this.getSize())
			return null;
		int loc = 0;
		MyNode <Reservation> current = this.first;
		while(loc<position)
		{
			loc++;
			current = current.link;
		}
		return current.data;
		
	}

	// receives: reservation to find in this list instance
	// post: returns the position of received reservation in the list
	//       (uses equals method which is overloaded when matching)
	//       returns -1 if received reservation is not found in current list at any position
	//  Example use:
	//        ReservationList list = new ReservationListImpl("reservation.txt");
	//        HotelReservation hotelRes = new HotelReservation("aabb","3/15/2018", "4/12/2018", "Mariott", 2);
	//		  int position = list.find(hotelRes);
	//	      assertTrue(position != -1);
	public int find(Reservation reservation)
	{
		int retVal = 0; 
		if (!(contains(reservation)))
			return -1;
		MyNode <Reservation> current = this.first;
		while(current!=null)
		{
			
			if (reservation.equals(current.data))
				break;
			retVal++;
			current = current.link;
			
		}
		return retVal;
	
	}

	// receives: reservation to locate in this list
	// returns:  reservation  in list that matches given reservation, removes it from list
	//       list remains sorted by date after removal. (most recent to least recent)
	//  	    if reservation in not in the list, returns null
	public Reservation remove(Reservation reservation)
	{
		if (!(contains(reservation)))
			return null;
		MyNode <Reservation> current = this.first;
		MyNode <Reservation> previous = null;
		
		while(current!=null)
		{
			if (current.data.equals(reservation))
				break;
			previous = current;
			current = current.link;
			
		}
		if (current == null)
			return null;
		if (previous ==null)
			this.first = current.link;
		else
			previous.link = current.link;
		this.count--;
		return current.data;
	}
	// receives: nothing
	// returns: nothing
	//  removes all reservations from this list, so it's size becomes 0.
	public void clear()
	{
		this.count = 0;
		this.first = null;
	}

}
