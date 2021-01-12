package housepetlist;
import java.io.PrintWriter;
import java.util.Scanner;

import housepet.HousePet;
import housepet.HousePetUtilsImpl;


public class HousePetListUtilsImpl 
{
	// receives: inFile, a Scanner instance that is open and ready to read data from
    // returns:  a HousePetList instance that is populated with house pets from received Scanner
    //
    // task:  constructs a HousePetList instance and populates it with any house pets found on scanner (adds tolist as it reads accounts)
	//   invalid data on scanner stops reading
	//   stops reading when end of input or when aList reaches MAX_SIZE
	//   or when attempting to read an account and bad data is found
	// Example use: Scanner infile = new Scanner(new File("test.txt"));
	//              HousePetList myList = HousePetListUtilsImpl.readFromScanner(infile);
	//              HousePetList anotherList = HousePetListUtilsImpl.readFromScanner(scanner);
	public static HousePetList readFromScanner(Scanner scanner)
	{
		HousePetList petList = new HousePetListImpl();
		while (scanner.hasNext())
		{
			HousePet pet = HousePetUtilsImpl.readFromScanner(scanner);
			if(pet != null)
			{
				petList.add(pet);
			}	
		}
		return petList;
	}
	
	//receives: out, a PrintWriter that is open and ready to write to,
	//         petList, a HousePetList instance to write out to the given PrintWriter
	//returns: nothing
	// task:  prints to the received print writer, out,  contains current contents of petList in program readable format
	public static void writeToFile(PrintWriter out, HousePetList aList)
	{
		for (int index =0; index < aList.getSize() ; index++)
		{
			HousePetUtilsImpl.writeToFile(out, aList.get(index));
		}
		
	}
}
