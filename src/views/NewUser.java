package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import controllers.UserMedsController;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import models.User;

import java.util.Date;

public class NewUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfMedicareId;
	private JDatePickerImpl dpDateOfBirth; 
	private JButton btnSave;
	private JButton btnReset;
	private User userObj;
	private UserMedsController usermedscont;
	
	public NewUser(UserMedsController usermedscont) {
		Initialise();
		this.usermedscont = usermedscont;
	}
	
	public void Initialise(){
		this.setSize(500,500);
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
		
		JLabel lblFirstName = new JLabel("First Name:");
		add(lblFirstName, "6, 6");
		
		tfFirstName = new JTextField();
		add(tfFirstName, "10, 6, left, default");
		tfFirstName.setColumns(20);
		
		JLabel lblLastName = new JLabel("Last Name:");
		add(lblLastName, "6, 8");
		
		tfLastName = new JTextField();
		add(tfLastName, "10, 8, left, default");
		tfLastName.setColumns(20);
		
		JLabel lblMedicareId = new JLabel("Medicare Id:");
		add(lblMedicareId, "6, 10");
		
		tfMedicareId = new JTextField();
		add(tfMedicareId, "10, 10, left, default");
		tfMedicareId.setColumns(20);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		add(lblDateOfBirth, "6, 12");
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(2015,  01, 01);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		dpDateOfBirth = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.add(dpDateOfBirth, "10, 12, left, default");
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userObj = new User(null, tfFirstName.getText(), tfLastName.getText(), tfMedicareId.getText(), (Date)dpDateOfBirth.getModel().getValue());
				usermedscont.setUserObjData(userObj);
			}
		});
		add(btnSave, "6, 16");
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfFirstName.setText(null);
				tfLastName.setText(null);
				tfMedicareId.setText(null);
			}
		});
		add(btnReset, "10, 16, left, default");		
	}
	
	public class DateLabelFormatter extends AbstractFormatter {

		private static final long serialVersionUID = 1L;
		private String datePattern = "dd-MM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }
	}
}
