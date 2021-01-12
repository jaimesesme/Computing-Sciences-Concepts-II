package housepet;

import housepet.GenderType;
import housepet.PetType;

public class HousePet 
{
	public static final String DEFAULT_NAME = "A$$$$a";
	public static final int MAX_YEAR = 2020;
	public static final int MIN_YEAR = 1900;
	
	private String name; 
	private int year;
	private GenderType gender;
	private PetType type;

	
	// default constructor, creates a default HousePet instance
    // name: DEFAULT_NAME, year born: MAX_YEAR_BORN, gender: GenderType.UNKNOWN, pet type: PetType.UNKNOWN
	public HousePet()
	 {
		 this.name = DEFAULT_NAME;
		 this.year = MAX_YEAR;
		 this.gender = GenderType.UNKNOWN;
		 this.type = PetType.UNKNOWN; 
	 }
	 
	 
	 // creates HousePet instance with given data, if any received data is invalid
     // puts default value into field
     // valid data: MIN_YEAR_BORN <= year born <= MAX_YEAR_BORN
     // pet name:  may not be an empty string nor all whitespace, must have at least 2 letter in it, formatted properly
     // any invalid name received, use  DEFAULT_NAME instead     
	 public HousePet(String aName, int aYear, GenderType aGender, PetType aPetType)
	 {
		 this.setPetName(aName);
		 this.setYearBorn(aYear);
		 this.setGenderType(aGender);
		 this.setPetType(aPetType);	 
	 }
	 
	// returns a nicely formatted String of this HousePet on same line NO NEWLINE
	// NOTE: age of pet MUST be printed, rather than year born (hint: compute age using MAX_YEAR_BORN - age at end of this year)
	 public String toString()
	 {
		 String retVal = "";
		 retVal += "Pet Name: "+this.getPetName();
		 retVal += " Age: "+ (MAX_YEAR-this.getYearBorn());
		 retVal += " Gender: "+(this.getGenderType());
		 retVal += " Pet Type: " +(this.getPetType());
		 return retVal;
	 }
	// returns the name of this HousePet
	 public String getPetName()
	 {
		 return this.name;
	 }
	// returns the year born of this HousePet
	 public int getYearBorn() 
	 {
		 return this.year;
	 }
	 
	// returns the gender  of this HousePet
	 public GenderType getGenderType() 
	 {
		 return this.gender;
	 }
	 
	// returns the pet type  of this HousePet
	 public PetType getPetType()
	 {
		 return this.type;
	 }
	 
	//sets this HousePet's name to aName AFTER calling 
	 public void setPetName(String aName)
	 {
		aName = utils.MyUtils.properFormat(aName);
		int count = 0;
		for (int index = 0; index< aName.length();index++)
		{	
			char ch = aName.charAt(index);
			if (Character.isLetterOrDigit(ch))
			{
				count += 1;
			}
		}
		 

		 if (count < 2)
		 {
			 this.name = DEFAULT_NAME;
		 }
		 else
			 this.name = aName;
			 
	 }
	 
	 public void setYearBorn(int aYearBorn)
	 {
		 if(aYearBorn<=MAX_YEAR && aYearBorn>= MIN_YEAR)
			 this.year = aYearBorn; 
		 else
			 this.year = MAX_YEAR;
	 }
	 
	 //sets this HousePet's gender to given gender
	 public void setGenderType(GenderType aGender)
	 {
		 this.gender = aGender;
	 }
	 
	 // sets this HousePet's pet type to given pet type.
	 public void setPetType(PetType aPetType)   
	 {
		 this.type = aPetType;
	 }
      
	// override of equals for HousePets
	 public boolean equals(Object obj)
	 {
		 HousePet aPet = (HousePet)obj;
		 if (this == obj)
				return true;
		 if (! (obj instanceof HousePet))
			return false;
		 if(!(this.getPetName().equals(aPet.getPetName())))
			return false;
		 if(!(this.getGenderType().equals(aPet.getGenderType())))
			return false;
		 if(!(this.getPetType().equals(aPet.getPetType())))
			return false;
		 if(!(this.getYearBorn()==(aPet.getYearBorn())))
			return false;
		 else
			return true;
	 } 
			
	 
	// override of hashCode for HousePets   		   
	public int hashCode()
	{
		int mult = 31;
		int result = 133;
		result = result * mult + this.getPetName().hashCode();
		result = result * mult + this.getGenderType().hashCode();
		result = result * mult + this.getPetType().hashCode();
		result = result * mult + this.getYearBorn();
		
		// note year is an int already
		return result;		
		}
}
