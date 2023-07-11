package appPackage;

public class TwoWheelerWeekdayCharge implements ParkingStrategy {
	@Override
	public int getCharge(int hours) {
		if(hours < 1)
			return 10;
		
		return hours * 10;
	}
}

