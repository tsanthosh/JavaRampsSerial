package views;

import javax.swing.JPanel;

import controllers.UserMedsController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JSpinner;

import models.MedLocation;

public class AddUserMeds extends JPanel {
	
	private static final long serialVersionUID = 3139186326630080103L;
	private UserMedsController userMedsCont;
	private JTextField tfUserName;
	private JTextField tfBrandName;

	public AddUserMeds(UserMedsController userMedsController){
		this.setSize(500,500);
		this.userMedsCont = userMedsController;
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("85px"),
				ColumnSpec.decode("140px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("166px:grow"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddMedicationsFor = new JLabel("Add Medications For:");
		add(lblAddMedicationsFor, "2, 2, right, center");
		
		tfUserName = new JTextField();
		add(tfUserName, "4, 2, left, top");
		tfUserName.setColumns(20);
		tfUserName.setText(userMedsCont.getUserObj().getFirstName()+" "+userMedsCont.getUserObj().getLastName());
		tfUserName.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Brand Name:");
		add(lblNewLabel, "2, 6, right, default");
		
		tfBrandName = new JTextField();
		add(tfBrandName, "4, 6, left, default");
		tfBrandName.setColumns(20);
		
		JLabel lblLocation = new JLabel("Location:");
		add(lblLocation, "2, 8, right, default");
		
		final JComboBox cbLocationNames = new JComboBox();
		cbLocationNames.setMaximumRowCount(10);
		List<MedLocation> locationObjects = userMedsCont.getLocationObjsData();
		for(int i=0; i<locationObjects.size(); i++){
			cbLocationNames.addItem(locationObjects.get(i).getLocationId().toString()+" "+locationObjects.get(i).getLocationName());
		}
		add(cbLocationNames, "4, 8, left, default");
		
		JLabel lblSchedule = new JLabel("Schedule 1:");
		add(lblSchedule, "2, 10, right, default");
		
		SpinnerDateModel dateModel = new SpinnerDateModel();		
		final JSpinner spSchedule1 = new JSpinner(dateModel);
		add(spSchedule1, "4, 10, left, default");	
		spSchedule1.setEditor(new JSpinner.DateEditor(spSchedule1, "HH:mm"));
		
		JLabel lblNewLabel_1 = new JLabel("Schedule 2:");
		add(lblNewLabel_1, "2, 12, right, default");
		
		SpinnerDateModel dateModel1 = new SpinnerDateModel();
		final JSpinner spSchedule2 = new JSpinner(dateModel1);
		add(spSchedule2, "4, 12, left, default");	
		spSchedule2.setEditor(new JSpinner.DateEditor(spSchedule2, "HH:mm"));
		
		JLabel lblNewLabel_2 = new JLabel("Schedule 3:");
		add(lblNewLabel_2, "2, 14, right, default");
		
		SpinnerDateModel dateModel2 = new SpinnerDateModel();
		final JSpinner spSchedule3 = new JSpinner(dateModel2);
		add(spSchedule3, "4, 14, left, default");	
		spSchedule3.setEditor(new JSpinner.DateEditor(spSchedule3, "HH:mm"));
		
		JLabel lblNewLabel_3 = new JLabel("Schedule 4:");
		add(lblNewLabel_3, "2, 16, right, default");
		
		SpinnerDateModel dateModel3 = new SpinnerDateModel();
		final JSpinner spSchedule4 = new JSpinner(dateModel3);
		add(spSchedule4, "4, 16, left, default");	
		spSchedule4.setEditor(new JSpinner.DateEditor(spSchedule4, "HH:mm"));
		
		JLabel lblNewLabel_4 = new JLabel("Schedule 5:");
		add(lblNewLabel_4, "2, 18, right, default");
		
		SpinnerDateModel dateModel4 = new SpinnerDateModel();
		final JSpinner spSchedule5 = new JSpinner(dateModel4);
		add(spSchedule5, "4, 18, left, default");	
		spSchedule5.setEditor(new JSpinner.DateEditor(spSchedule5, "HH:mm"));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String locationId = cbLocationNames.getSelectedItem().toString().substring(0, cbLocationNames.getSelectedItem().toString().indexOf(" "));
				Time schedule1 = CST(spSchedule1.getValue().toString());
				Time schedule2 = CST(spSchedule2.getValue().toString());
				Time schedule3 = CST(spSchedule3.getValue().toString());
				Time schedule4 = CST(spSchedule4.getValue().toString());
				Time schedule5 = CST(spSchedule5.getValue().toString());
				userMedsCont.addUserMedsData(tfBrandName.getText(), locationId, schedule1, schedule2, schedule3, schedule4, schedule5);
			}
		});
		add(btnSave, "2, 22, right, default");
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfBrandName.setText(null);
			}
		});
		add(btnReset, "4, 22, left, default");
	}
	
	public Time CST(String str){
		//convert string to time
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Time time = null;
		try {
			time = new Time(formatter.parse(str.substring(11, 19)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

}
