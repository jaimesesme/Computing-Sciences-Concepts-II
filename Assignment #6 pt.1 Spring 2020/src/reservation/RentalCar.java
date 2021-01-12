package reservation;

import reservation.CarMake;

public class RentalCar 
{
	public static final String DEFAULT_VIN = "0000";
	public static final int MAX_YEAR = 2020;
	public static final int MIN_YEAR = 2015;

	private String vin;
	private int year;
	private CarMake carmake;
	
	public RentalCar()
	{
		this.vin = DEFAULT_VIN;
		this.year = MAX_YEAR;
		this.carmake = CarMake.TOYOTA;
	}
	
	// second constructor, creates a RentalCar instance
	// receives: aVin, aYear, aMake
	// initializes this RentalCar with received values, if invalid, uses defaults
	// with given data, uses default for any value that is invalid
	// example use #1: RentalCar car1 = new RentalCar("er09", 2018);
	// example use #2: RentalCar car2 = new RentalCar("er08", 2019);
	// example use #3: RentalCar car3 = new RentalCar("er07", 2020);
	public RentalCar(String aVin, int aYear, CarMake aMake)
	{
		this.setVin(aVin);
		this.setYear(aYear);
		this.setMake(aMake);
	}
	
	// returns a nicely formatted String of this car with vin, year, and type
	// all on same line, properly spaced and easy to see no newlines in the string
	// example use #1: String car11 = toString();
	// example use #2: String car12 = toString();
	// example use #3: String car13 = toString();
	public String toString()
	{
		String retVal = "";
		retVal += "Year: " + this.getYear();
		retVal += " VIN: " + this.getVin();
		retVal += " Make: " + this.getMake();
		return retVal;
	}
	/////////
	public void setMake(CarMake acarmake)
	{
		this.carmake = acarmake;
	}
	// sets this rental car's VIN 
	// (with only 4 characters) (only letter and characters) 
	// if not in range, uses DEFAULT_VIN
	// example use #1: vin1.setVin("er20");
	// example use #2: vin2.setVin("er21");
	// example use #3: vin3.setVin("er22");
	public void setVin( String aVin)
	{
		boolean valid = true;
		for (int index = 0; index< aVin.length();index++)
		{	
			char ch = aVin.charAt(index);
			if (Character.isLetterOrDigit(ch))
			{
				valid = true;
			}
			else 
			{
				valid = false;
				break;
			}
		}
		
		if(aVin.length()== 4 && valid == true)
		{

			this.vin = aVin.toUpperCase();
		}
		else 
		{
			this.vin = DEFAULT_VIN;
		}
	}
	
	// sets this rental car's year 
	// in range 2015 thru 2020 (inclusive)
	// if not in range, uses MAX_YEAR
	// example use #1: year1.setYear(2019);
	// example use #2: year2.setYear(2018);
	// example use #3: year3.setYear(2017);
	public void setYear(int aYear)
	{
		if (aYear>= 2015 && aYear<= 2020)
		{
			this.year = aYear;
		}
		else
		{
			this.year = MAX_YEAR; 
		}
	}
	
	// returns the instance of the Year
	// example use #1: int vin1 = getVin();
	// example use #2: int vin2 = getVin();
	// example use #3: int vin3 = getVin();
	public String getVin()
	{
		return this.vin;
	}
	// returns the instance of the Year
	// example use #1: int year1 = getYear();
	// example use #2: int year2 = getYear();
	// example use #3: int year3 = getYear();
	public int getYear()
	{
		return this.year;
	}
	// returns the instance of the type of Car
	// example use #1: CarMake car1 = getMake();
	// example use #2: CarMake car2 = getMake();
	// example use #3: CarMake car3 = getMake();
	public CarMake getMake()
	{
		return this.carmake;
	}
	
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (! (obj instanceof RentalCar))
		{
			return false;
		}
		if(!(this.getVin().equals(((RentalCar) obj).getVin())))
		{
			return false;
		}
		if(!(this.getYear()==((RentalCar) obj).getYear()))
		{
			return false;
		}
		if(!(this.getMake().equals(((RentalCar) obj).getMake())))
		{
			return false;
		}
		return true;
	}
	
	public int hashCode()
	{
		int mult = 31;
		int result = 133;
		result = result * mult + this.getVin().hashCode();
		result = result * mult + this.getYear();
		result = result * mult + this.getMake().hashCode(); 
		return result;		
	}
	
}
