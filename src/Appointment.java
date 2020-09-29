
public class Appointment {

	private String doctor;
	private String date;
	private String time;
	
	public Appointment() {
		doctor = "";
		date = "";
		time = "";
	}
	
	public Appointment(String name, String date, String time) {
		doctor = name;
		this.date = date;
		this.time = time;
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public String toString() {
		return "Doctor: " + doctor + "  " + "Date: " + date + "  " + "Time: " + time + "  ";
	}
}
