package appPackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot implements Parking {
	
	private static ParkingLot parkingLot;
	public List<Slot> twoWheelerSlots;
	public List<Slot> fourWheelerSlots;
	
	private ParkingLot() {
		this.twoWheelerSlots = new ArrayList<>();
		this.fourWheelerSlots = new ArrayList<>();
	}
	
	public static ParkingLot getParkingLot() {
		if(parkingLot == null) {
			parkingLot = new ParkingLot();
		}
		return parkingLot;
	}
	
	public static void clearAll() {
		parkingLot = null;
	}
	
	public boolean initialize(int noOfFourWheelerSlots, int noOfTwoWheelerSlots) {
		for(int i=1;i<=noOfFourWheelerSlots;i++) {
			fourWheelerSlots.add(new Slot(i));
		}
		System.out.println(fourWheelerSlots.size() + " slots created for four-wheelers");
		
		for(int i=1;i<=noOfTwoWheelerSlots;i++) {
			twoWheelerSlots.add(new Slot(i));
		}
		System.out.println(twoWheelerSlots.size() + " slots created for two-wheelers");
		
		return true;
	}
	
	public Ticket park(Vehicle vehicle) throws ParkingFullException{
		Slot nextAvailableSlot;
		if(vehicle.size.equals(VehicleSize.FOURWHEELER)) {
			nextAvailableSlot = getNextAvailableFourWheelerSlot();
		}
		else {
			nextAvailableSlot = getNextAvailableTwoWheelerSlot();
		}
		
		nextAvailableSlot.occupySlot(vehicle);
		Ticket ticket = new Ticket(nextAvailableSlot.number, vehicle.vehicleNo, new Date(), vehicle.size);
		
		return ticket;
	}
	
	public Slot getNextAvailableFourWheelerSlot() throws ParkingFullException{
		for(Slot slot: fourWheelerSlots) {
			if(slot.isEmpty)
				return slot;
		}
		throw new ParkingFullException("Four wheeler parking is full!!!");
	}
	
	public Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException{
		for(Slot slot: twoWheelerSlots) {
			if(slot.isEmpty)
				return slot;
		}
		throw new ParkingFullException("Two wheeler parking is full!!!");
	}
	
	public int unPark(Ticket ticket, ParkingStrategy parkingStrategy) throws InvalidVehicleNoException{
		int costByHours = 0;
		Slot slot = null;
		try {
			if(ticket.vehicleSize.equals(VehicleSize.FOURWHEELER)) {
				slot = getFourWheelerSlotByVehicleNo(ticket.getVehicleNo());
			}
			else {
				slot = getTwoWheelerSlotByVehicleNo(ticket.getVehicleNo());
			}
			
			int hours = getHoursParked(ticket.date, new Date());
			if(hours < 1) hours = 1;
			costByHours = getCost(hours, parkingStrategy);
			System.out.println("Vehicle No: " + ticket.vehicleNo);
			System.out.println("Hours parked: " + hours);
			System.out.println("Total Cost: " + costByHours);
			
			slot.vacateSlot();
		}
		catch(InvalidVehicleNoException invalidVehicleNo) {
			System.out.println(invalidVehicleNo.getMessage());
			throw invalidVehicleNo;
		}
		
		return costByHours;
	}
	
	Slot getFourWheelerSlotByVehicleNo(String no) throws  InvalidVehicleNoException{
		for(Slot slot: fourWheelerSlots) {
			Vehicle v = slot.getParkedVehicle();
			if(v != null && no.equals(v.getVehicleNo()))
				return slot;
		}
		throw new InvalidVehicleNoException("Vehicle with vehicle no.: " + no + " not found!!");
	}
	
	Slot getTwoWheelerSlotByVehicleNo(String no) throws  InvalidVehicleNoException{
		for(Slot slot: twoWheelerSlots) {
			Vehicle v = slot.getParkedVehicle();
			if(v != null && no.equals(v.getVehicleNo()))
				return slot;
		}
		throw new InvalidVehicleNoException("Vehicle with vehicle no.: " + no + " not found!!");
	}
	
	int getHoursParked(Date startDate, Date endDate) {
		long secs = (endDate.getTime() - startDate.getTime()) / 1000;
		int hours = (int)secs / 3600;
		return hours;
	}
	
	int getCost(int hours, ParkingStrategy parkingChargeStrategy) {
		return parkingChargeStrategy.getCharge(hours);
	}


	
}
