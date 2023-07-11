package appPackage;

public class FourWheelerWeekendCharge implements ParkingStrategy {
	@Override
	public int getCharge(int hours) {
		if(hours < 1)
			return 30;
		
		return hours * 30;
	}
}
