package views;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import models.User;
import controllers.UserMedsController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Welcome welcomePanel;
	private NewUser newuserPanel;
	private NewLocationPanel newlocationPanel;
	private UserDetails userDetailsPanel;
	private UserMedsController userMedsCont;
	
	public MainFrame(UserMedsController usermedscont) throws HeadlessException {
		Initialise();
		welcomePanel =  new Welcome();
		this.userMedsCont = usermedscont; 
		getContentPane().add(welcomePanel);
	}
	
	private void Initialise(){
		//Initialise Frame
		this.setSize(600, 600);
		this.setIconImage(null);
		this.setTitle("My Dispenser");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewUser = new JMenuItem("New User");
		mntmNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				newuserPanel = new NewUser(userMedsCont);
				getContentPane().add(newuserPanel);
				validate();
			}
		});
		mnFile.add(mntmNewUser);
		
		JMenuItem mntmSelectUser = new JMenuItem("Select User");
		mntmSelectUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Retrieve user data
				List<User> userObjects = userMedsCont.getUserObjsData();
				//Display JOptionPane
				int i = 0;
				Object[] ArrayOfUsers = new Object[userObjects.size()];
				while (i < userObjects.size()) {
					ArrayOfUsers[i] = userObjects.get(i).getUserId()+" "+userObjects.get(i).getFirstName()+" "+userObjects.get(i).getLastName();
					i++;
				}
				String s = (String)JOptionPane.showInputDialog(null, "Select User:", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, ArrayOfUsers, ArrayOfUsers[0]);
				//Get selected user
				User selectedUser = null;
				Integer selectedUserId = Integer.parseInt((s.substring(0, s.indexOf(" "))));
				for (i=0; i< userObjects.size(); i++){
					if (userObjects.get(i).getUserId() == selectedUserId){
						selectedUser = new User(userObjects.get(i).getUserId(), userObjects.get(i).getFirstName(),userObjects.get(i).getLastName(),userObjects.get(i).getMedicareId(),userObjects.get(i).getDateOfBirth());
					}
				}
				userMedsCont.setUserObj(selectedUser);
				//Display UserDetails Panel
				getContentPane().removeAll();
				userDetailsPanel = new UserDetails(userMedsCont);
				getContentPane().add(userDetailsPanel);
				validate();
			}
		});
		
		JMenuItem mntmEditUser = new JMenuItem("Edit User");
		mnFile.add(mntmEditUser);
		mnFile.add(mntmSelectUser);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNewLocation = new JMenuItem("New Location");
		mntmNewLocation.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				newlocationPanel = new NewLocationPanel(userMedsCont);
				getContentPane().add(newlocationPanel);
				validate();
			}
		});
		mnFile.add(mntmNewLocation);
		
		JMenuItem mntmEditLocation = new JMenuItem("Edit Location");
		mnFile.add(mntmEditLocation);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
	}
	
}
