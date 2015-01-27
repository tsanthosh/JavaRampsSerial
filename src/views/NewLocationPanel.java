package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.UserMedsController;
import models.MedLocation;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;

public class NewLocationPanel extends JPanel {

	private static final long serialVersionUID = -6709827740025104303L;
	private JTextField tfLocationName;
	private JTextField tfXAxis;
	private JTextField tfYAxis;
	private JTextField tfZAxis;
	private UserMedsController usermedscont;
	
	public NewLocationPanel(UserMedsController userMedsCont) {
		this.setSize(500, 500);
		this.usermedscont = userMedsCont;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
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
		
		JLabel lblLocationName = new JLabel("Location Name:");
		add(lblLocationName, "6, 6");
		
		tfLocationName = new JTextField();
		add(tfLocationName, "10, 6, left, default");
		tfLocationName.setColumns(10);
		
		JLabel lblXaxis = new JLabel("X Axis:");
		add(lblXaxis, "6, 8");
		
		tfXAxis = new JTextField();
		add(tfXAxis, "10, 8, left, default");
		tfXAxis.setColumns(10);
		
		JLabel lblYAxis = new JLabel("Y Axis:");
		add(lblYAxis, "6, 10");
		
		tfYAxis = new JTextField();
		add(tfYAxis, "10, 10, left, default");
		tfYAxis.setColumns(10);
		
		JLabel lblZAxis = new JLabel("Z Axis:");
		add(lblZAxis, "6, 12");
		
		tfZAxis = new JTextField();
		add(tfZAxis, "10, 12, left, default");
		tfZAxis.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		add(btnSave, "6, 16");
		btnSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MedLocation locationobj =  new MedLocation(null, tfLocationName.getText(), Float.parseFloat(tfXAxis.getText()), Float.parseFloat(tfYAxis.getText()), Float.parseFloat(tfZAxis.getText()));
				usermedscont.setLocationData(locationobj);
			}
		});
		
		JButton btnReset = new JButton("Reset");
		add(btnReset, "10, 16, left, default");
		btnReset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfLocationName.setText(null);
				tfXAxis.setText(null);
				tfYAxis.setText(null);
				tfZAxis.setText(null);
			}
		});
		
	}
}
