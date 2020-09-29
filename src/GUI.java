import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*
*Provides the Graphical interface for where the main program will be run
*performs all event-driven programming based on user-input
*/
public class GUI extends JFrame {

	private JButton createAcc;
	private JButton currentUser;
	private JButton exit;
	private JButton enter;
	private JButton login;
	private JButton createApp;
	private JButton viewApp;
	private JButton logout;
	private JButton submit;
	private NodeBasedList<PatientUser> users = new NodeBasedList<PatientUser>();
	private JFrame page;
	private JFrame accountPage;
	private JPasswordField password;
	private JTextField username;
	private JTextField doctor;
	private JTextField date;
	private JTextField time;
	private Account currentAccount;
	/*
	*Creates the basic front page of the login system
	*/
	public GUI() { 
		super("Account Page");	
		setLayout(new FlowLayout());
		createAcc = new JButton("Create an account");
		currentUser = new JButton("Returning User");
		exit = new JButton("Exit");
		enter = new JButton("Enter");
		login = new JButton("Login");
		password = null;
		username = null;
		doctor = null;
		date = null;
		time = null;
		createApp = new JButton("Create Appointment");
		viewApp = new JButton("View Appointments");
		logout = new JButton("Log Out");
		submit = new JButton("Submit");
		add(createAcc);
		add(currentUser);
		add(exit);
		TheHandler handler = new TheHandler();
		createAcc.addActionListener(handler);
		login.addActionListener(handler);
		exit.addActionListener(handler);
		enter.addActionListener(handler);
		currentUser.addActionListener(handler);
		createApp.addActionListener(handler);
		viewApp.addActionListener(handler);
		logout.addActionListener(handler);
		submit.addActionListener(handler);
		}
	
		public  void setUpJFrame(int x, int y) {
			accountPage = new JFrame();
			accountPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			accountPage.setLayout(new FlowLayout());
			accountPage.setSize(x,y);
			accountPage.setVisible(true);
		}
	/*
	*Sub-class that performs any given action such as button pressing and opening of new windows based on user input
	*/
	private class TheHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == exit) {
				dispose();
				System.exit(0);
			}
			if(event.getSource() == createAcc) {
				setUpJFrame(250, 150);
				accountPage.add(new JLabel("New Username:"));
				username = new JTextField(10);
				accountPage.add(username);
				accountPage.add(new JLabel("New Password:"));
				password = new JPasswordField(10);
				accountPage.add(password);
				accountPage.add(enter);
				accountPage.setVisible(true);
			}
			if(event.getSource() == enter) {
				PatientUser newUser = new PatientUser(username.getText(), String.valueOf(password.getPassword()));
				if(users.find(newUser)) {
					JOptionPane.showMessageDialog(null, "There's an account already in place for this combination of username and password");
				}
				else {
				users.add(newUser);
				accountPage.dispose();
				JOptionPane.showMessageDialog(null, "Your account was created successfully!");
				}
			}
			if(event.getSource() == currentUser) {
				setUpJFrame(250, 150);
				accountPage.add(new JLabel("Username:"));
				username = new JTextField(10);
				accountPage.add(username);
				accountPage.add(new JLabel("Password:"));
				password = new JPasswordField(10);
				accountPage.add(password);
				accountPage.add(login);
				accountPage.setVisible(true);
			}
			if(event.getSource() == login) {
				PatientUser currentUser = new PatientUser(username.getText(), String.valueOf(password.getPassword()));
				if(users.find(currentUser)) {
					currentUser = (PatientUser)users.locate(currentUser).getData();
					currentAccount = new Account(currentUser);
					JOptionPane.showMessageDialog(null, "successfully login!");
					page = new JFrame();
					page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					page.setLayout(new FlowLayout());
					page.setSize(250, 150);
					page.add(createApp);
					page.add(viewApp);
					page.add(logout);
					page.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Login failed, try again.");
				}
			}
			if(event.getSource() == logout) {
				page.dispose();
			}
			if(event.getSource() == createApp) {
				setUpJFrame(150, 250);
				JLabel doctorLabel = new JLabel("Doctor Name:");
				JLabel dateLabel = new JLabel("Date:");
				JLabel timeLabel = new JLabel("Time:");
				doctor = new JTextField(10);
				date = new JTextField(10);
				time = new JTextField("e.g. 10:30 AM", 10);
				accountPage.add(doctorLabel);
				accountPage.add(doctor);
				accountPage.add(dateLabel);
				accountPage.add(date);
				accountPage.add(timeLabel);
				accountPage.add(time);
				accountPage.add(submit);
				accountPage.setVisible(true);
			}
			if(event.getSource() == submit) {
				currentAccount.createAppointment(doctor.getText(), date.getText(), time.getText());
				accountPage.dispose();
				JOptionPane.showMessageDialog(null, "Appointment submitted");
				accountPage = page;
			}
			if(event.getSource() == viewApp) {
				accountPage = new JFrame();
				accountPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				accountPage.setLayout(new FlowLayout());
				accountPage.setSize(450, 450);
				for(int i = 0; i<currentAccount.numOfAppointments();i++) {
					JLabel app = new JLabel(currentAccount.viewAppointment(i));
					accountPage.add(app);
				}
				accountPage.setVisible(true);
			}
		}
	}
}
		
