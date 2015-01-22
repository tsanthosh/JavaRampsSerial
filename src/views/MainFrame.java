package views;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controllers.UserMedsController;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Welcome welcomePanel;
	
	public MainFrame(UserMedsController usermedscont) throws HeadlessException {
		Initialise();
		welcomePanel =  new Welcome(usermedscont);
		this.add(welcomePanel);
	}
	
	private void Initialise(){
		//Initialise Frame
		this.setSize(500, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewUser = new JMenuItem("New User");
		mnFile.add(mntmNewUser);
		
		JMenuItem mntmSelectUser = new JMenuItem("Select User");
		mnFile.add(mntmSelectUser);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEditUser = new JMenuItem("Edit User");
		mnEdit.add(mntmEditUser);
	}
	
}
