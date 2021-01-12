package reservation;

public class FlightReservation extends Reservation
{

	public static final String DEFAULT_CODE = "AUS";
	
	private String arrivalCode;
	private String departCode;
	
	public FlightReservation(String confirmNumber)
	{
		super(confirmNumber);
		this.arrivalCode = DEFAULT_CODE;
		this.departCode = DEFAULT_CODE;
	}
	
	public String toString()
	{
		String retVal = "";
		retVal+= "FLIGHT: "+super.toString()+this.getArrivalCode()+this.getDepartCode();
		return retVal;
	}
	public String getArrivalCode()
	{
		return this.arrivalCode;
	}
	
	public String getDepartCode()
	{
		return this.departCode;
	}
	
	public void setArrivalCode(String aCode) 
	{
		aCode = utils.MyUtils.properFormat(aCode);
		aCode = aCode.toUpperCase();
		if (!(aCode.length()==3))
			this.arrivalCode = DEFAULT_CODE;
		else
			this.arrivalCode = aCode;
	}
	public void setDepartCode(String aCode)//uses default code if invalid code received for either setter)
	{
		aCode = utils.MyUtils.properFormat(aCode);
		aCode = aCode.toUpperCase();
		if (!(aCode.length()==3))
			this.departCode = DEFAULT_CODE;
		else
			this.departCode = aCode;
	}
}
