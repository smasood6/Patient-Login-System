import java.util.Scanner;
/*
*The patient class that stores all information of a unique patient
*/
public class PatientUser extends User {

	private String favDoctor;
	private NodeBasedList<Appointment> appointments;
	
	
	public PatientUser(String username, String password) {
		super(username, password, "");
		appointments = new NodeBasedList<Appointment>();
		favDoctor = "";
	}
	
	public PatientUser(String username, String password, String name, String doctor) {
		super(username, password, name);
		favDoctor = doctor;
		appointments = new NodeBasedList<Appointment>();
	}
	
	public int numOfAppointments() {
		return appointments.numOfItems();
	}
	
	public String getFavDoctor() {
		return favDoctor;
	}
	public void setFavDoctor(String doctor) {
		favDoctor = doctor;
	}
	
	public void addAppointment(Appointment newApp) {
		appointments.add(newApp);
	}
	
	public String getAppointment(int index) {
		return appointments.get(index).toString();
	}
	
	public String getAppointments() {
		return appointments.toString();
	}
	
	public String toString() {
		return super.toString() + "Favorite Doctor: " + favDoctor;
	}
	
	public boolean equals(Object o1) {
		if(o1 instanceof PatientUser) {
			PatientUser patient = (PatientUser)o1;
		    return patient.getUserName().equals(super.getUserName()) && patient.getPassword().equals(super.getPassword());
		}
	return false;
	}
}
