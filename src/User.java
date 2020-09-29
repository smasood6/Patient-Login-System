import java.util.Scanner;
/*
*Parent class of both PatientUser and DoctorUser; provides basic information that is needed in both sub-classes
*/
public class User {
private String userName;
private String password; 
private String name;

public User() {
	userName = "";
	password = "";
	name = "";
}

public User(String userName, String password, String name) {
	this.userName = userName;
	this.password = password;
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public void createAccount() {
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter in a valid username");
	setUserName(keyboard.nextLine());
	System.out.println("Please enter in a valid password");
	setPassword(keyboard.nextLine());
	System.out.println("Please enter in your full name");
	setName(keyboard.nextLine());
}

public String toString() {
	return "Name: " + name + "\n" + "UserName: " + userName + "\n" + "Password: " + password;
}
}
