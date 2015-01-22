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

public class NewUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JDatePickerImpl datePicker;
	private JButton btnSave;
	private JButton btnReset;

	public NewUser(UserMedsController usermedscont) {
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
		
		textField = new JTextField();
		add(textField, "10, 6, left, default");
		textField.setColumns(20);
		
		JLabel lblLastName = new JLabel("Last Name:");
		add(lblLastName, "6, 8");
		
		textField_1 = new JTextField();
		add(textField_1, "10, 8, left, default");
		textField_1.setColumns(20);
		
		JLabel lblMedicareId = new JLabel("Medicare Id:");
		add(lblMedicareId, "6, 10");
		
		textField_2 = new JTextField();
		add(textField_2, "10, 10, left, default");
		textField_2.setColumns(20);
		
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
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.add(datePicker, "10, 12, left, default");
		
		btnSave = new JButton("Save");
		add(btnSave, "6, 16");
		
		btnReset = new JButton("Reset");
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
