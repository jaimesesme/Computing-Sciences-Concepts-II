package asg3;

public class House 
{
	public static final String DEFAULT_ADDRESS = "$$$$";
	public static final int DEFAULT_YEARBUILT = 2020;
	public static final int DEFAULT_NUM_BEDROOMS = 1;
	public static final double DEFAULT_NUM_BATHROOMS = 1.0;
	
	
	private String address;
	private int yearBuilt;
	private HouseType houseType;
	private int numBedrooms;
	private double numBathrooms;
	
	
	//default constructor, creates a default House instance
	// receives: nothing
	// task : constructs a this House instance with default values for address and year built
	// sets address of this House instance to DEFAULT_ADDRESS
	// sets year built of this house to DEFAULT_YEARBUILT
	// example use #1: House house1 = new House();
	// example use #2: House yourHouse = new House();
	// example use #3: House funHouse = new House();
	public House()
	{
		this.address = DEFAULT_ADDRESS;
		this.yearBuilt = DEFAULT_YEARBUILT;
		this.houseType = HouseType.PRIVATE;
		this.numBedrooms = DEFAULT_NUM_BEDROOMS;
		this.numBathrooms = DEFAULT_NUM_BATHROOMS;
		
	}
	//second constructor, creates a House instance
	// receives: aAddress, aYearBuilt, aHouseType, aNumBedrooms, aNumBathrooms
	// initializes this house with received values, if invalid, uses defaults
	// with given data, uses default for any value that is invalid
	// example use #1: House house1 = new House("863 North Ridge", 2018, PRIVATE, 12, 2.0);
	// example use #2: House house2 = new House("1423 ELM St. ", 2000,PRIVATE,1, 3.5);
	// example use #3: House house3 = new House("987 West Ave. ", 1950,PRIVATE, 3, 4);
	public House(String aAddress, int aYearBuilt, HouseType aHouseType, int aNumBedrooms, double aNumBathrooms)
	{
		this.setAddress(aAddress);
		this.setYearBuilt(aYearBuilt);
		this.setHouseType(aHouseType);
		this.setNumBedrooms(aNumBedrooms);
		this.setNumBathrooms(aNumBathrooms);
	}

	// receives: aAddress, the value to use to set this instance's address to
	// sets this House's address after proper formatting and checking it is valid
	// if not valid, uses DEFAULT_ADDRESS instead, an empty string is not a valid address, must have at least 2 letters OR digits
	// and cannot be all whitespace, nor empty strings
	// example use #1: house1.setAddress("444 North Elm"); // stores
	// example use #2: someHouse.setAddress("&%^$"); //stores name as DEFAULT_ADDRESS since not 2 letters or digits in string
	// example use #3: funHouse.setAddress("102 great fun avenue"); // stores address as "102 Great Fun Avenue"
	public void setAddress(String aAddress)
	{
		aAddress = utils.MyUtils.properFormat(aAddress);
		
		int count = 0;
		for (int index = 0; index< aAddress.length();index++)
		{	
			char ch = aAddress.charAt(index);
			if (Character.isLetterOrDigit(ch))
			{
				count += 1;
			}
		}
		
		if (count>=2)
		{
			this.address = aAddress;
		}
		else
		{
			this.address = DEFAULT_ADDRESS;
		}

	}

	// sets this house's year built to be received value if
	// in range 1600 thru DEFAULT_YEARBUILT (inclusive)
	// if not in range, uses DEFAULT_YEARBUILT
	// example use #1: year1.setYearBuilt(2019);
	// example use #2: year2.setYearBuilt(2018);
	// example use #3: year3.setYearBuilt(2017);
	public void setYearBuilt (int aYear)
	{
		if (aYear >= 1600 && aYear <= DEFAULT_YEARBUILT )
		{
			
			this.yearBuilt = aYear;
 
		}
		else
		{
			this.yearBuilt = DEFAULT_YEARBUILT;
		}

	}
	
	
	// sets this house's House Type
	// example use #1: house1.setHouseType(rental);
	// example use #2: house2.setHouseType(private);
	// example use #3: house3.setHouseType(vacation);
	public void setHouseType(HouseType aHouseType)
	{
		this.houseType = aHouseType;
	}

	// sets this house's number of bedrooms can be from 0 to 100 bedrooms
	// example use #1: house1.setNumBedroom(2);
	// example use #2: house2.setNumBedroom(4);
	// example use #3: house3.setNumBedroom(90);
	public void setNumBedrooms(int aNumBedrooms)
	{
		if (aNumBedrooms >= 0 && aNumBedrooms<=100)
		{
			this.numBedrooms = aNumBedrooms;
		}
		else 
		{
			this.numBedrooms = DEFAULT_NUM_BEDROOMS;
		}
	}

	// sets this house's number of bathrooms can be from 0.0 to 100.0
	// example use #1: house1.setNumBathrooms(2.0);
	// example use #2: house2.setNumBathrooms(4.3);
	// example use #3: house3.setNumBathrooms(6.5);
	public void setNumBathrooms(double aNumBathrooms)
	{
		if (aNumBathrooms>= 0.0 && aNumBathrooms<=100.0)
		{
			this.numBathrooms = aNumBathrooms;
		}
		else
		{
			this.numBathrooms = DEFAULT_NUM_BATHROOMS;
		}
	}
	// returns the instance of an Address
	// example use #1: String house1 = getAddress();
	// example use #2: String house2 = getAddress();
	// example use #3: String house3 = getAddress();
	
	public String getAddress()
	{
		return this.address;
	}

	// returns the instance of a year
	// example use #1: int year1 = getAddress();
	// example use #2: int year2 = getAddress();
	// example use #3: int year3 = getAddress();
	public int getYearBuilt()
	{
		return this.yearBuilt;
	}
	
	// returns the instance of house type
	// example use #1: HouseType house1 = getHouseType();
	// example use #2: HouseType house2 = getHouseType());
	// example use #3: HouseType house3 = getHouseType());
	public HouseType getHouseType()
	{
		return this.houseType;
	}
	
	// returns the instance of house's number of bedrooms 
	// example use #1: int bedroom1 = getNumBedrooms();
	// example use #2: int bedroom2 = getNumBedrooms();
	// example use #3: int bedroom3 = getNumBedrooms();
	public int getNumBedrooms() 
	{
		return this.numBedrooms;
	}
	
	// returns the instance of house's number of bathrooms  
	// example use #1: double bathroom1 = getNumBathrooms();
	// example use #2: double bathroom2 = getNumBathrooms();
	// example use #3: double bathroom3 = getNumBathrooms();
	public double getNumBathrooms()
	{
		return this.numBathrooms;
	}

	// returns the string "Address: *address Year Built: *year built House Type: *house type Number of Bedrooms: 
	// *num of bedrooms Number of Bathrooms: *num of bathrooms                      
	// returns a nicely formatted String of this House with address and year built
	// all on same line, properly spaced and easy to see no newlines in the string
	// example use #1: String house11 = toString();
	// example use #2: String house12 = toString();
	// example use #3: String house13 = toString();
	
	public String toString()
	{
		String retValue = "";
		retValue += "Address: " + this.getAddress() + " Year Built: " + this.getYearBuilt() + " House Type: "+this.getHouseType()
		+ " Number of Bedrooms: " + this.getNumBedrooms() + " Number of Bathrooms: "+ this.getNumBathrooms();
		return retValue;

	}

}
