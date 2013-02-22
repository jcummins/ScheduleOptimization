
public class MeetingTime {
	public int startTime;
	public int endTime;
	
	public MeetingTime(int startTime, int endTime) throws Exception {
		if(startTime>endTime) {
			throw new Exception("End time cannot be before start time");
		}
		else {
			this.startTime=startTime;
			this.endTime=endTime;
		}
	}
}
