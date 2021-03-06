package views;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controllers.SerialPortController;
import controllers.UserMedsController;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import models.MedLocation;
import models.Medication;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextArea;

public class UserDetails extends JPanel {

	private static final long serialVersionUID = -2771266074548182417L;
	private JTextField userField;
	private JTextField mediField;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnAddMedication;
	private UserMedsController userMedsCont;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private SerialPortController serialPortCont;

	public UserDetails(UserMedsController usermedscont) {
		
		this.setSize(700,500);
		this.userMedsCont = usermedscont;
		//serialPortCont = new SerialPortController(this);
		
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
			public String[] columnNames = {"Brand Name", "Schedule 1", "Schedule 2", "Schedule 3", "Schedule 4", "Schedule 5", "Location", "Dispense"};
			private static final long serialVersionUID = 5645345126523101651L;
			public int getColumnCount() { return 8; }
			public String getColumnName(int col) { return columnNames[col]; }
			public boolean isCellEditable(int row, int col){ return true; }
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
	        		case 8:
	        			int medsid1 = userMedsCont.getMedScheduleList().get(row).getMedicationId();
	        			Object locationName1 = null;
	        			int locationId1 = 0;
	        			for (Medication med : userMedsCont.getMedicationList()){
	        				if (med.getMedicationId()==medsid1){
	        					locationId1 = med.getLocationId();
	        				}
	        			}
	        			for (MedLocation medLoc : userMedsCont.getMedLocationList()){
	        				if (medLoc.getLocationId()==locationId1){
	        					locationName1 = medLoc.getLocationName();
	        				}
	        			}
	        			value = locationName1;
	        			break;
	        	}
	        	return value;
	        }
	      };
		table = new JTable(dataModel);
		table.getColumn("Brand Name").setMinWidth(150);
		table.getColumn("Dispense").setCellRenderer(new ButtonRenderer());
	    table.getColumn("Dispense").setCellEditor(new ButtonEditor(new JCheckBox(), this));
		table.setPreferredScrollableViewportSize(new Dimension(650, 300));
		scrollpane = new JScrollPane(table);
		add(scrollpane);
		
		scrollPane = new JScrollPane();
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setRows(5);
		textArea.setColumns(70);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void settxtReceive(String inputLine) {
        textArea.append(inputLine+"\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	public void sendText(String text) {
		JOptionPane.showMessageDialog(this,text );
	}
}

class ButtonRenderer extends JButton implements TableCellRenderer {

	private static final long serialVersionUID = -1075291424898382706L;

	public ButtonRenderer() {
	    setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(UIManager.getColor("Button.background"));
	    }
	    setText((value == null) ? "" : value.toString());
	    return this;
	}
}

class ButtonEditor extends DefaultCellEditor {

	private static final long serialVersionUID = -757315571902140913L;
	protected JButton button;
	private String label;
	private boolean isPushed;
	
	public ButtonEditor(JCheckBox checkBox, final UserDetails userDetails) {
	    super(checkBox);
	    button = new JButton();
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  userDetails.getTextArea().append("Dispensing..."+"/n");
	    	  userDetails.sendText(button.getText());
	    	  fireEditingStopped();
	      }
	    });
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
	      boolean isSelected, int row, int column) {
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else {
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }
	    label = (value == null) ? "" : value.toString();
	    button.setText(label);
	    isPushed = true;
	    return button;
	}

	public Object getCellEditorValue() {
	    if (isPushed) {
	      JOptionPane.showMessageDialog(button, label + ": Ouch!");
	    }
	    isPushed = false;
	    return new String(label);
	}

	public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
	    super.fireEditingStopped();
	}
}

