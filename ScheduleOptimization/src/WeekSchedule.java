import java.util.HashMap;
import java.util.Map;


public class WeekSchedule extends Schedule {

	public Map<String, String> dayToDayIndex = new HashMap<String, String>();
	public Map<String, String> dayIndexToDay = new HashMap<String, String>();
	
	public WeekSchedule() {
		super();
		this.startTime=0;
		this.endTime=10080;
		
		dayToDayIndex.put("Sunday", "0");
		dayToDayIndex.put("Monday", "1");
		dayToDayIndex.put("Tuesday","2");
		dayToDayIndex.put("Wednesday","3");
		dayToDayIndex.put("Thursday","4");
		dayToDayIndex.put("Friday","5");
		dayToDayIndex.put("Saturday","6");
		
		dayIndexToDay.put("0","Sunday");
		dayIndexToDay.put("1","Monday");
		dayIndexToDay.put("2","Tuesday");
		dayIndexToDay.put("3","Wednesday");
		dayIndexToDay.put("4","Thursday");
		dayIndexToDay.put("5","Friday");
		dayIndexToDay.put("6","Saturday");
	}
	
	@Override
	public int toDayOfWeek(int idxTime) throws Exception {
		if((idxTime >= 0) && (idxTime <= 1439)) {
			return 0; // Sunday
		} else if((1439 < idxTime) && (idxTime <= 2879) ) {
			return 1;
		} else if((2879 < idxTime) && (idxTime <= 4319) ) {
			return 2;
		} else if((4319 < idxTime) && (idxTime <= 5759) ) {
			return 3;
		} else if((5759 < idxTime) && (idxTime <= 7199) ) {
			return 4;
		} else if((7199 < idxTime) && (idxTime <= 8639) ) {
			return 5;
		} else if((8639 < idxTime) && (idxTime <= 10079) ) {
			return 6;
		} else {
			throw new Exception("Index out of bounds");
		}
	}

	@Override
	public int toHours(int idxTime) throws Exception {
		if((idxTime >= 0) && (idxTime <= 10079)) {
			int hours = (idxTime-(toDayOfWeek(idxTime)*1440))/60;
				return hours;
		} else {
			throw new Exception("Index out of bounds");
		}
	}

	@Override
	public int toMinutes(int idxTime) throws Exception {
		int minutes = (idxTime-(toDayOfWeek(idxTime)*1440)-(toHours(idxTime)*60));
		if((idxTime >= 0) && (idxTime <= 10079)) {
			return minutes;
		} else {
			throw new Exception("Index out of bounds");
		}
		
	}

	@Override
	public int toIndex(String strTime) throws Exception { // Monday:13:45
		try {
			String[] parts = strTime.split(":");
			parts[0] = dayToDayIndex.get(parts[0]);
			
			return toIndex(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
			
		} catch(Exception e) { 
			throw e;
		}
	}

	@Override
	public int toIndex(int day, int hours, int minutes) throws Exception {
		return 1440*day+60*hours+minutes;
	}

	@Override
	public String toTimeString(int idxTime) throws Exception {	
		return dayIndexToDay.get(Integer.toString(toDayOfWeek(idxTime)))+":"+toHours(idxTime)+":"+toMinutes(idxTime);
	}
	
	
}
