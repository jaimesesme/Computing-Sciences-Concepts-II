package housepetlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import housepet.GenderType;
import housepet.HousePet;
import housepet.HousePetUtilsImpl;
import housepet.PetType;

public class HousePetListImpl implements HousePetList
{

	private HousePet [] myPets;
	private int numPets; 
	
	public HousePetListImpl()
	{
		this.myPets = new HousePet [MAX_SIZE];
		this.numPets = 0;
	}
	
	public HousePetListImpl(String fileName)
	{
		this.myPets = new HousePet [MAX_SIZE];
		this.numPets = 0;
		Scanner inFile = null;
		try
		{
			inFile = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error finding file");
		}

		while(inFile.hasNext())
		{
			HousePet pet = HousePetUtilsImpl.readFromScanner(inFile);
			if(pet!=null)
			{
				this.add(pet);
			}
		}
		inFile.close();
		
		// create a scanner with given file name 
		// scanner inFile = null;
		// try
		// {
		//   inFile = new Scanner(new File(filename));
		// catch (FileNotFoundException e)
		// { SOP: can't find file.
		// return;}
		// while (inFile.hasNext())
		// {  HousePet pet = HousePetUtilsImpl.readFromScanner(inFile);
		//    if(pet!=null)
		//    { this.add(pet);}
		// }
		// inFile.close();
		
		
	}
	
	public String toString()
	{
		String retVal ="";
		for (int index= 0; index<numPets; index++)
		{
			retVal+=myPets[index]+"\n";
		}
		return retVal;
	}
	
	// receives: nothing
	// returns: number of HousePets currently in the list
	// Example use
	// HousePetList list = new HousePetListImpl();  // create empty list of HousePet instances
	// assertTrue(list.getSize() == 0);   // size should be 0
	// boolean result = list.add(new HousePet("Tweety Bird", 2012, GenderType.MALE, PetType.BIRD));
    // assertTrue(list.getSize() == 1a);
	public int getSize()
	{
		return numPets;
	}
	
	// receives: a HousePet instance that is NOT null
	// returns:  true if received housepet matches any housepet in this list,
    //          assumes equals is overloaded in HousePet class
	//          returns false if received housepet is not currently in this list
	public boolean contains(HousePet housepet)
	{
		boolean retVal = false;
		for (int index= 0; index<numPets; index++)
		{
			if (housepet.equals(myPets[index]))
			{
				retVal= true;
				break;
			}
		}
		return retVal;
	}
	
	
	// receives: a HousePet instance that is NOT null
	// task:   housepet is added to this list if not already contained in this list
	//         (house pets must be unique so no two matching pets should be in the list)
	// returns:true if housepet was added, false if no room in the list or duplicate
	//         housepet is found in the list
	//         a housepet is a duplicate if it is equal to any other housepet instance
    // precondition: HousePet overrrides equals methed
	// Example use:
	//        HousePetList list = new HousePetListImpl();
	//        boolean result = list.add(new HousePet("Sporty Sport", 2014, GenderType.MALE, PetType.GERBIL));
	//        assertTrue(result == true);
	public boolean add(HousePet housepet)
	{
		boolean retVal = false;
		if (numPets<15 && !(contains(housepet)))
		{
			myPets[numPets] = housepet;
			numPets = numPets +1;
			retVal = true;
		}
		return retVal;
	}
	
	// receives: a positon (int) in this house pet list
	// returns: the housepet in the list at given position.
	//       uses zero-based positions, so 0 is the position of the first house pet in the list
	//       returns null if received position is out of range (0 to less than size of list.)
	//  Example use:
	//        HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("SillyCat", 2010, GenderType.FEMALE, PetType.CAT));
	//        boolean result = list.add(pet2);
	// 		  HousePet pet1 = list.get(0);
	//        assertTrue(pet1.equals(pet2));
	public HousePet get(int position)
	{
		if (position>= 0 && position <=15)
		{
			return myPets[position];
		}
		else
			return null;
	}
	
	// receives: a HousePet instance (not null)
	// returns:  the position of received housepet in the list (0 based positioning)
	//       (uses overloaded equals when matching)
	//       returns -1 if received housepet is not found in current list at any position
	//        HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Biggy Big", 2010, GenderType.MALE, PetType.POTBELLY_PIG));
	//        boolean result = list.add(pet2);
	//		  int position = list2.find(pet2);
	//	      assertTrue(position == 0);
	public int find(HousePet housepet)
	{
		int retVal = 0; 
		if (contains(housepet))
		{
			for (int index= 0; index< numPets; index++)
			{
				if (myPets[index].equals(housepet))
				{
					retVal = index;
				}
			}
		}
		else
			retVal = -1;
		return retVal;
	}
	
	// receives: a PetType value
	// returns: a String containing a list (1 house pet per line) of house pets
	//        that have the received PetType value.
	//        returns an EMPTY String if NO house pets have the received PetType value
	// Example use:
	//	      HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Paul the Parrot", 2004, GenderType.MALE, PetType.BIRD);
	//        boolean result = list.add(pet2);
	//        assertTrue(result == true);
	// 		  String list1 = list.getHousePetsMatchingPetType(PetType.DOG);
	//        assertTrue(list1.equals(""));
    //        list1 = list.getHousePetsMatchingPetType(PetType.BIRD);
    //        assertEquals(1, utils.MyUtils.countNewLines(list1));
	public String getHousePetsMatchingPetType(PetType matchingType)
	{
		String retVal = "";
		for (int index= 0; index< numPets; index++)
		{
			if (myPets[index].getPetType().equals(matchingType))
			{
				retVal+= myPets[index] +"\n";
			}
		}
		return retVal;
	}
	
	
	// receives: a GenderType value
	// returns: a String containing a list (1 house pet per line) of house pets
	//       that are of the received account type.
	//    Example use:
	//        HousePetList list = new HousePetListImpl();
	//        HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Paul the Parrot", 2004, GenderType.MALE, PetType.BIRD);
	//        boolean result = list.add(pet2);
	//        assertTrue(result == true);
	// 		String list1 = list.getHousePetsMatchingGender(GenderType.UNKNOWN);
	//        assertTrue(list1.equals(""));
    //        list1 = list.getHousePetsMatchingGender(GenderType.MALE);
    //        assertEquals(1, utils.MyUtils.numberLines(list1));
	public String getHousePetsMatchingGender(GenderType aGender)
	{
		String retVal = "";
		for (int index= 0; index< numPets; index++)
		{
			if (myPets[index].getGenderType().equals(aGender))
			{
				retVal+= myPets[index] +"\n";
			}
		}
		return retVal;
	}
	

	
	
	// receives: a last name (String)
	// returns: a String containing a list (1 house pet per line) of house pets
	//      with name matching  received (case in-sensitive) String
	//      if no matches exist, returns empty string
        //  Example use:
	//	HousePetList list = new HousePetListImpl();
	//        HousePet pet2 = new HousePet("Paul the Parrot", 2004, GenderType.MALE, PetType.BIRD);
	//        boolean result = list.add(pet2);
	//        assertTrue(result == true);
	// 		String list1 = list.getHousePetsMatchingName("PAUL the PARROT");
        //        assertEquals(1, utils.MyUtils.numberLines(list1));
	public String getHousePetsMatchingName(String aName)
	{
		aName = utils.MyUtils.properFormat(aName);
		String retVal = "";
		for (int index= 0; index< numPets; index++)
		{
			if (myPets[index].getPetName().equals(aName))
			{
				retVal+= myPets[index] +"\n";
			}
		}
		return retVal;
	}
	

	
	// receives: nothing
	// returns: nothing
    // task: this HousePetList is sorted by pet name from lowest alphabetically to highest
	// Example use (give 2 more):
	//	    HousePetList list = new HousePetListImpl();
	//      HousePet pet1 = new HousePet("Paul the Parrot", 2004, GenderType.MALE, PetType.BIRD);
    //      boolean result = list.add(pet1);
	//      assertTrue(result == true);
    //      HousePet pet2 = new HousePet("Crazy cat",2012, GenderType.FEMALE, PetType.CAT);
    //      HousePet pet3 = new HousePet("prince", 2018, GenderType.MALE, PetType.DOG);
	//      boolean result = list.add(pet2);
	//      assertTrue(result == true);
	// 	    list.sortByName();
	//      System.out.println("here is the sorted list:\n" + list);  // should be in appropriate order smallest name  to largest
	// should output:
    //      Crazy Cat 7 years FEMALE CAT
    //      Paul The Parrot 15 years MALE BIRD
    //      Prince 1 years MALE DOG
    public void sortByName()
    {
    	String alphabet = "abcdefghijklmnopqrstuvwxyz";
    	
    	for (int index=0; index<numPets; index++)
    	{
    		int k = index;
    		while (k>0)
    		{
    			if (myPets[k].getPetName().toLowerCase().compareTo(myPets[k-1].getPetName().toLowerCase())<0)
        		{
        			HousePet temp =  myPets[k];
        			
        			myPets[k]= myPets[k-1];
        			myPets[k-1] = temp;
        			k--;
        		}
    			else
    			{
    				k=0;
    			}
    		}
    	}
    }
	
	
	
  	// receives: nothing
	// returns: nothing
    // task:   this HousePetList is sorted by age of pet, from HIGHEST to LOWEST
	// Example use (give 2 more):
	//	    HousePetList list = new HousePetListImpl();
	//      HousePet pet1 = new HousePet("Paul the Parrot", 2004, GenderType.MALE, PetType.BIRD);
    //      boolean result = list.add(pet1);
	//      assertTrue(result == true);
    //      HousePet pet2 = new HousePet("Crazy cat",2012, GenderType.FEMALE, PetType.CAT);
    //      HousePet pet3 = new HousePet("prince", 2018, GenderType.MALE, PetType.DOG);
	//      boolean result = list.add(pet2);
	//      assertTrue(result == true);
	// 	    list.sortByName();
	//      System.out.println("here is the sorted list:\n" + list);  // should be in appropriate order smallest name  to largest
	// should output:
    //         Prince 1 years MALE DOG
    //         Crazy Cat 7 years FEMALE CAT
    //         Paul The Parrot 15 years MALE BIRD
    public void sortByAge()
    {
    	for (int index = 0; index<numPets; index++)
		{
  
    		int k = index;
    		while (k>0)
    		{
    			if (myPets[k].getYearBorn()<myPets[k-1].getYearBorn())
        		{
        			HousePet temp =  myPets[k];
        			
        			myPets[k]= myPets[k-1];
        			myPets[k-1] = temp;
        			k--;
        		}
    			else
    			{
    				k=0;
    			}
    		}
    		
		}
    	
    }
    
	// receives: a HousePet instance, not null
  	// returns:   a HousePet instance  in this list that is found that MATCHES the
	//       received housepet (assume equals is overloaded for HousePet)
	//       the HousePet instance in the list that matched received housepet is removed
	//       from this list AND RETURNED.
	//       If no HousePet instance is found that matches received housepet
	//       then null is RETURNED
    // Example use:
    //      HousePetList list = new HousePetListImpl();
    //      HousePet pet2 = new HousePet("Paul the Parrot", 2004, GenderType..MALE, PetType.BIRD);

    //      HousePet pet3 = new HousePet("Silly Bird", 2017, GenderType.FEMALE, PetType.BIRD);
	//      boolean result = list.add(pet3);
	//      assertTrue(result == true);
    //      boolean result = list.add(pet2);
    //      assertTrue(result == true);
    //      assertTrue(list.getSize() ==2);
    //      HousePet remPet = list.remove(pet2);
    //      assertTrue(remPet.equals(pet2));
    //      assertTrue(list.getSize() == 1);
    // Example use #2:
    //      remPet = list.remove(pet2)
    //      assertEquals(null, remPet);
    public HousePet remove(HousePet housepet)
    {
    	if (contains(housepet)) 
    	{
    		int index = find(housepet);
    		HousePet retVal =  myPets[index];
    		myPets[index]= myPets[numPets-1];
    		numPets=numPets-1;
    		return retVal;
    	}
    	else
    		return null;
    }
    
    
    // receives: nothing
    // returns: nothing
    // task:  this HousePetList instance is made to be empty
    //        clear out all house pets from this instance
    public void clear()
    {
    	int number = numPets;
    	for (int index= 0; index<number; index++)
		{
    		remove(myPets[index]);
		}
    }
	
	
}
