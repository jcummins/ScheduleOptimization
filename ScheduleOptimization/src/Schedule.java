import java.util.HashMap;
import java.util.Map;


public abstract class Schedule {
	
	public int startTime;
	public int endTime;
	public Map<String, String> dayToDayIndex;
	public Map<String, String> dayIndexToDay;

	public abstract int toDayOfWeek(int idxTime) throws Exception;
	public abstract int toHours(int idxTime) throws Exception;
	public abstract int toMinutes(int idxTime) throws Exception;
	public abstract int toIndex(String strTime) throws Exception;
	public abstract int toIndex(int day, int hours, int minutes) throws Exception;
	public abstract String toTimeString(int idxTime) throws Exception;
}
