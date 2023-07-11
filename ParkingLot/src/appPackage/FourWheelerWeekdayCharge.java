package appPackage;

public class FourWheelerWeekdayCharge implements ParkingStrategy {
	@Override
	public int getCharge(int hours) {
		if(hours < 20)
			return 20;
		
		return hours * 20;
	}
}
