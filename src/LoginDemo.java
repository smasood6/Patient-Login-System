import java.util.Scanner;

import javax.swing.JFrame;
/*
*Main program that runs the GUI class
*/
public class LoginDemo {
	public static void main(String[] args) {
		GUI go = new GUI();
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setSize(300, 150);
		go.setVisible(true);
	}

}
