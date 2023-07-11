package appPackage;

public class Main {
	public static void main(String[] args) throws ParkingFullException, InvalidVehicleNoException {
		ParkingLot parkingLot = ParkingLot.getParkingLot();
		parkingLot.initialize(10, 10);
		Vehicle vehicle= new Vehicle("KA22", VehicleSize.TWOWHEELER);
		Ticket ticket = parkingLot.park(vehicle);
		System.out.println(ticket);
		
		int cost = parkingLot.unPark(ticket, new FourWheelerWeekdayCharge());
		System.out.println(cost);
	}
}
