package appPackage;

public class Slot {
	Integer number;
	boolean isEmpty;
	Vehicle parkedVehicle;
	
	public Slot(int no) {
		this.number = no;
		this.isEmpty = true;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Vehicle getParkedVehicle() {
		return parkedVehicle;
	}

	public void setParkedVehicle(Vehicle parkedVehicle) {
		this.parkedVehicle = parkedVehicle;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	public void occupySlot(Vehicle vehicle) {
		parkedVehicle = vehicle;
		isEmpty = false;
	}
	
	public void vacateSlot() {
		parkedVehicle = null;
		isEmpty = true;
	}
}
