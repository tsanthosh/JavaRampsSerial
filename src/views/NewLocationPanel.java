package views;

import java.awt.Panel;

import controllers.UserMedsController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;

public class NewLocationPanel extends Panel {

	private static final long serialVersionUID = -6709827740025104303L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public NewLocationPanel(UserMedsController userMedsCont) {
		this.setSize(500, 500);
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
		
		textField = new JTextField();
		add(textField, "10, 6, left, default");
		textField.setColumns(10);
		
		JLabel lblXaxis = new JLabel("X Axis:");
		add(lblXaxis, "6, 8");
		
		textField_1 = new JTextField();
		add(textField_1, "10, 8, left, default");
		textField_1.setColumns(10);
		
		JLabel lblYAxis = new JLabel("Y Axis:");
		add(lblYAxis, "6, 10");
		
		textField_2 = new JTextField();
		add(textField_2, "10, 10, left, default");
		textField_2.setColumns(10);
		
		JLabel lblZAxis = new JLabel("Z Axis:");
		add(lblZAxis, "6, 12");
		
		textField_3 = new JTextField();
		add(textField_3, "10, 12, left, default");
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		add(btnSave, "6, 16");
		
		JButton btnReset = new JButton("Reset");
		add(btnReset, "10, 16, left, default");
		
	}
}
