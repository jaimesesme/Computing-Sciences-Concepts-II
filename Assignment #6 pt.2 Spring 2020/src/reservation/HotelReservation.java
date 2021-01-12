package reservation;

public class HotelReservation extends Reservation
{
	public static final String DEFAULT_HOTEL_NAME = "$$$$";
	public static final int DEFAULT_NUM_PERSONS = 1;
	
	private String hotelName;
	private int numPersons;

	
	public HotelReservation (String confirmNumber)
	{
		super(confirmNumber);
		this.hotelName = DEFAULT_HOTEL_NAME;
		this.numPersons = DEFAULT_NUM_PERSONS;
	}
	
	public String toString()
	{
		String retVal = "";
		retVal += "HOTEL: " +super.toString()+"numberOfPersons:"+this.getNumPersons()+" hotelName: "+this.getHotelName();
		return retVal;
	}
	public String getHotelName() 
	{
		return this.hotelName;
	}
	public int getNumPersons()
	{
		return this.numPersons;
	}
	public void setHotelName(String aHotelName) 
	{
		String value = utils.MyUtils.properFormat(aHotelName);
		if (value.contentEquals(""))
			this.hotelName = DEFAULT_HOTEL_NAME;
		else
			this.hotelName = value;
	}
	public void setNumPersons(int aNumPersons)
	{
		if (aNumPersons<1 || aNumPersons>100)
			this.numPersons = DEFAULT_NUM_PERSONS;
		else 
			this.numPersons = aNumPersons;
	}

}
