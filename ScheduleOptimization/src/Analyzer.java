import java.util.Arrays;

public class Analyzer {

	public Scheduler scheduler;
	private int[] totalFrequencies;
	private int[] dayFrequencies;
	private int[] hourFrequencies;
	private int intTotalMinutes;
	private int intTotalMeetings;
	private int intTotalMeetingsWithMinutes;
	private int intTotalCourses;
	private int intTotalCoursesWithMeetings;
	
	public Analyzer(Scheduler scheduler) {
		this.scheduler=scheduler;
		Update();
	}
	
	public void Update() {
		this.totalFrequencies = this.GenerateTotalFrequencies();
		this.dayFrequencies = this.GenerateDayFrequencies();
		this.hourFrequencies = this.GenerateHourFrequencies();
	}
	
	public int[] GenerateHourFrequencies() {
		int divisor = 168;
		int[] results = new int[divisor];
		Arrays.fill(results,0);
		int start=0;
		int end = (scheduler.schedule.endTime+1)/divisor;
		for(int j=0;j<=divisor-1;j++) {
			for(int i=start;i<=end-1;i++)
			{
				
				results[j]+=totalFrequencies[i];
			}
			start=end;
			end=end+((scheduler.schedule.endTime+1)/divisor);
		}
		return results;
	}
	
	public int[] GenerateDayFrequencies() {
		int divisor = 7;
		int[] results = new int[divisor];
		Arrays.fill(results,0);
		int start=0;
		int end = (scheduler.schedule.endTime+1)/divisor;
		
		for(int j=0;j<=divisor-1;j++) {

			for(int i=start;i<=end-1;i++)
			{
				results[j]+=totalFrequencies[i];
			}
			start=end;
			end=end+((scheduler.schedule.endTime+1)/divisor);
		}
		return results;
	}
	
	public int[] GenerateTotalFrequencies() {
		int[] results = new int[scheduler.schedule.endTime];
		this.intTotalMinutes = 0;
		this.intTotalMeetings = 0;
		this.intTotalMeetingsWithMinutes = 0;
		this.intTotalCourses = 0;
		this.intTotalCoursesWithMeetings = 0;
		Arrays.fill(results,0);
		
		for(Course c : scheduler.Courses) {
			for(MeetingTime m : c.getMeetingtimes()) {
				for(int i=m.startTime;i<=m.endTime;i++) {
					this.intTotalMinutes++;
					results[i]++;
				}
				if(m.endTime>m.startTime) {
					this.intTotalMeetingsWithMinutes++;
				}
				this.intTotalMeetings++;
			}
			if(c.getMeetingtimes().size()>0) {
				this.intTotalCoursesWithMeetings++;
			}
			this.intTotalCourses++;
		}
		return results;
	}
	
	public int[] getTotalFrequencies() {
		return this.totalFrequencies;
	}
	
	public int[] getDayFrequencies() {
		return this.dayFrequencies;
	}
	
	public int[] getHourFrequencies() {
		return this.hourFrequencies;
	}
	public int getTotalMinutes() {
		return this.intTotalMinutes;
	}
}
