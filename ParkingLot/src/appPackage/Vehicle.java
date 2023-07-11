package appPackage;

public class Vehicle {
	String vehicleNo;
	VehicleSize size;
	
	public Vehicle(String id, VehicleSize size) {
		this.size = size;
		this.vehicleNo = id;
	}
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public VehicleSize getSize() {
		return size;
	}
	public void setSize(VehicleSize size) {
		this.size = size;
	}
	
	
}
