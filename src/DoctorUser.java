import java.util.Scanner;
public class DoctorUser extends User {
	
	private int doctorId;
	public static NodeBasedList<DoctorUser> doctorList;
	
	public DoctorUser(int id) {
		super();
		doctorId = id;
	}
	
	public void createAccount() {
		super.createAccount();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter in a Doctor ID");
		doctorId = keyboard.nextInt();
	}
	
	public String toString() {
		return super.toString() + "\n" + "Doctor ID: " + doctorId;
	}

}
