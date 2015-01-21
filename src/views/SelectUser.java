package views;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class SelectUser extends JFrame {

	public SelectUser() throws HeadlessException {
		
		
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, BorderLayout.CENTER);
		
	}
	
}
