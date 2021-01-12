package reservation;
import reservation.RentalCar;

public class CarReservation extends Reservation
{

	private RentalCar car; 
	
	public CarReservation(String confirmNumber)
	{
		super(confirmNumber);
		this.car = new RentalCar();
		
	}
	
	public String toString()
	{
		String retVal = "";
		retVal += "CAR: "+super.toString()+"Car: "+this.getCar();
		return retVal;
	}
	
	public RentalCar getCar()
	{
		return this.car;
	}
	
	public void setCar(RentalCar aCar)
	{
		this.car = aCar;
	}
	
}
