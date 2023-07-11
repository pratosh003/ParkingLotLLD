package appPackage;

public class TwoWheelerWeekendCharge implements ParkingStrategy {
	@Override
	public int getCharge(int hours) {
		if(hours < 1)
			return 20;
		
		return hours * 20;
	}
}

