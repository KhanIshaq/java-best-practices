package chapter6;

public enum PayrollDay1 {

	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	private static final int MINS_PER_SHIFT = 8 * 60;
	int pay(int minutesWorked, int payRate) {
		int basePay = minutesWorked * payRate;
		
		int overtimePay;
		switch(this) {
		case SATURDAY:
		case SUNDAY:
			overtimePay = basePay / 2;
		default:
			overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0: (minutesWorked - MINS_PER_SHIFT) * basePay / 2;
		}
		
		 return basePay + overtimePay;
	}
	
}
