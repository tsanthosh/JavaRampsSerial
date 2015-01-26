package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controllers.UserMedsController;

import javax.swing.JTable;
import javax.swing.JButton;

public class UserDetails extends JPanel {

	private static final long serialVersionUID = -2771266074548182417L;
	private JTextField userField;
	private JTextField mediField;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnAddMedication;

	public UserDetails(UserMedsController usermedscont) {
		
		this.setSize(500,500);
		
		JLabel lblNewLabel = new JLabel("User:");
		add(lblNewLabel);
		
		userField = new JTextField();
		userField.setText(usermedscont.getUserObj().getFirstName()+" "+usermedscont.getUserObj().getLastName());
		userField.setEditable(false);
		add(userField);
		userField.setColumns(15);
		
		JLabel lblMedicareId = new JLabel("Medicare Id:");
		add(lblMedicareId);
		
		mediField = new JTextField();
		mediField.setText(usermedscont.getUserObj().getMedicareId());
		mediField.setEditable(false); 
		add(mediField);
		mediField.setColumns(10);
		
		table = new JTable();
		scrollpane = new JScrollPane(table);
		//table.setFillsViewportHeight(true);
		add(scrollpane);
		
		btnAddMedication = new JButton("Add Medication");
		add(btnAddMedication);
		
		
	}

}
