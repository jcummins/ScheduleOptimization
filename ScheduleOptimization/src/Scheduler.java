import java.util.*;

public class Scheduler {
	
	public ArrayList<Course> Courses = new ArrayList<Course>();
	public Schedule schedule = new WeekSchedule();
	public Scheduler() {
		
		try {
			
			System.out.println(Integer.toString(schedule.toDayOfWeek(60)));
			System.out.println(Integer.toString(schedule.toHours(60)));
			System.out.println(Integer.toString(schedule.toMinutes(60)));
			System.out.println(Integer.toString(schedule.toDayOfWeek(1439)));
			System.out.println(Integer.toString(schedule.toHours(1439)));
			System.out.println(Integer.toString(schedule.toMinutes(1439)));
			System.out.println(Integer.toString(schedule.toDayOfWeek(1440)));
			System.out.println(Integer.toString(schedule.toHours(1440)));
			System.out.println(Integer.toString(schedule.toMinutes(1440)));
			
			Course math131 = new Course();
			math131.setDescription("This is a basic math course.");
			math131.setID("Math131");
			math131.setInstructor("Jim Cummins");
			math131.addMeeting(0, 29);
			math131.addMeeting(1440,1469);
			math131.addMeeting(10050, 10079);
			Courses.add(math131);
			
			Course math141 = new Course();
			math141.setDescription("This is a basic math course.");
			math141.setID("Math141");
			math141.setInstructor("Jim Cummins");
			math141.addMeeting(50, 90);
			math141.addMeeting(1440,1469);
			math141.addMeeting(10050, 10079);
			Courses.add(math141);
			System.out.println(math141);
			
			System.out.println(schedule.toIndex(1, 0, 0));
			System.out.println(schedule.toIndex(6, 23, 59));
			System.out.println(schedule.toIndex(6, 23, 59));
			System.out.println(schedule.toIndex("Sunday:23:59"));
			System.out.println(schedule.toIndex("Saturday:23:59"));
			System.out.println(Integer.toString(schedule.toHours(math131.getMeetingtimes().get(0).endTime)));
			
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	
	
}
