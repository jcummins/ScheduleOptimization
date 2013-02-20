import java.util.ArrayList;
import java.util.Iterator;

public class Course {
	
	private String ID;
	private String Description;
	private String Instructor;
	private ArrayList<MeetingTime> meetingtimes = new ArrayList<MeetingTime>();
	
	public void addMeeting(int idxStartTime, int idxEndTime) throws Exception {
		try {
			meetingtimes.add(new MeetingTime(idxStartTime,idxEndTime));
		} catch(Exception e) {
			throw e;
		}
	}
	
	public String toString() {
		Schedule schedule = new WeekSchedule();
		String strReturn = "ID: " + this.getID()
				+ "\nDescription: " + this.getDescription()
				+ "\nInstructor: " + this.getInstructor();
		
		for(MeetingTime mt : meetingtimes) {
			Schedule tmpSchedule = new WeekSchedule();
			try {
				strReturn += "\nStart: " + schedule.toTimeString(mt.startTime);
				strReturn += "\nEnd: " + schedule.toTimeString(mt.endTime);
			} catch(Exception e) {
				strReturn += "\nError getting meetinglist.";
			}
		}
		return strReturn;
		
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getInstructor() {
		return Instructor;
	}

	public void setInstructor(String instructor) {
		Instructor = instructor;
	}

	public ArrayList<MeetingTime> getMeetingtimes() {
		return meetingtimes;
	}

	public void setMeetingtimes(ArrayList<MeetingTime> meetingtimes) {
		this.meetingtimes = meetingtimes;
	}
}
