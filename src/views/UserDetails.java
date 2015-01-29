package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controllers.UserMedsController;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import models.MedLocation;
import models.Medication;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class UserDetails extends JPanel {

	private static final long serialVersionUID = -2771266074548182417L;
	private JTextField userField;
	private JTextField mediField;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnAddMedication;
	private UserMedsController userMedsCont;

	public UserDetails(UserMedsController usermedscont) {
		
		this.setSize(600,600);
		this.userMedsCont = usermedscont;
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
		
		btnAddMedication = new JButton("Add Medication");
		btnAddMedication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userMedsCont.addUserMeds();
			}
		});
		add(btnAddMedication);
		
		userMedsCont.getUserMedsData();
		TableModel dataModel = new AbstractTableModel() {
			public String[] columnNames = {"Brand Name", "Schedule 1", "Schedule 2", "Schedule 3", "Schedule 4", "Schedule 5", "Location"};
			private static final long serialVersionUID = 5645345126523101651L;
			public int getColumnCount() { return 7; }
			public String getColumnName(int col) { return columnNames[col]; }
			public int getRowCount() { return userMedsCont.getMedScheduleList().size();}
	        public Object getValueAt(int row, int col) { 
	        	Object value = null;
	        	switch (col+1){
	        		case 1:
	        			int medid = userMedsCont.getMedScheduleList().get(row).getMedicationId();
	        			Object brandName = null;
	        			for (Medication med : userMedsCont.getMedicationList()){
	        				if (med.getMedicationId()==medid){
	        					brandName = med.getBrandName();
	        				}
	        			}
	        			value = brandName;
	        			break;
	        		case 2: 
	        			value = userMedsCont.getMedScheduleList().get(row).getSchedule1();
	        			break;
	        		case 3: 
	        			value = userMedsCont.getMedScheduleList().get(row).getSchedule2();
	        			break;
	        		case 4: 
	        			value = userMedsCont.getMedScheduleList().get(row).getSchedule3();
	        			break;
	        		case 5: 
	        			value = userMedsCont.getMedScheduleList().get(row).getSchedule4();
	        			break;
	        		case 6: 
	        			value = userMedsCont.getMedScheduleList().get(row).getSchedule5();
	        			break;
	        		case 7:
	        			int medsid = userMedsCont.getMedScheduleList().get(row).getMedicationId();
	        			Object locationName = null;
	        			int locationId = 0;
	        			for (Medication med : userMedsCont.getMedicationList()){
	        				if (med.getMedicationId()==medsid){
	        					locationId = med.getLocationId();
	        				}
	        			}
	        			for (MedLocation medLoc : userMedsCont.getMedLocationList()){
	        				if (medLoc.getLocationId()==locationId){
	        					locationName = medLoc.getLocationName();
	        				}
	        			}
	        			value = locationName;
	        			break;
	        	}
	        	return value;
	        }
	      };
		table = new JTable(dataModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 500));
		table.setRowSelectionAllowed(false);
		table.setSize(new Dimension(600, 600));
		scrollpane = new JScrollPane(table);
		scrollpane.setSize(new Dimension(600, 600));
		//table.setFillsViewportHeight(true);
		add(scrollpane);
	}

}
