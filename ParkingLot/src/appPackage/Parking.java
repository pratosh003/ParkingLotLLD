package appPackage;

public interface Parking {
	
	public Ticket park(Vehicle vehicle) throws ParkingFullException;
	public int unPark(Ticket ticket, ParkingStrategy parkingStrategy) throws InvalidVehicleNoException;
}
