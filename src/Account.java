/*
*The basic overhead class for all patients to create/view appointments based on each unique patient
*/
public class Account{

	private PatientUser user;
	
	public Account(PatientUser user) {
		this.user = user;
	}
	
	public String accountSummary() {
		return user.toString();
	}
	
	
	public void createAppointment(String doctor, String date, String time) {
		Appointment app = new Appointment(doctor, date, time);
		user.addAppointment(app);
		
	}
	public String viewAppointment(int index) {
		return user.getAppointment(index);
	}
	
	public int numOfAppointments() {
		return user.numOfAppointments();
	}
	public String viewAppointments() {
		return user.getAppointments();
	}

	
}
