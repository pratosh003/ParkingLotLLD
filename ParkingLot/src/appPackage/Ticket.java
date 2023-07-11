package appPackage;

import java.util.Date;

public class Ticket {
	int slotNumber;
	String vehicleNo;
	Date date;
	VehicleSize vehicleSize;
	
	public Ticket(int slotNumber, String vehicleNo, Date date, VehicleSize vehicleSize) {
		this.slotNumber = slotNumber;
		this.vehicleNo = vehicleNo;
		this.date = date;
		this.vehicleSize = vehicleSize;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	public void setVehicleSize(VehicleSize vehicleSize) {
		this.vehicleSize = vehicleSize;
	}

	@Override
	public String toString() {
		return "Ticket [slotNumber=" + slotNumber + ", vehicleNo=" + vehicleNo + ", date=" + date + ", vehicleSize="
				+ vehicleSize + "]";
	}
	
	
}
