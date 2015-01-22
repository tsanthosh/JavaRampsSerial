package views;

import java.awt.HeadlessException;

import javax.swing.JPanel;

import controllers.UserMedsController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Welcome extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public Welcome(UserMedsController usermedscont) throws HeadlessException{
		Initialise();
	}
	
	private void Initialise(){
		this.setSize(500, 500);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWelcome);
	}

}
