package controllers;

import views.MainFrame;

public class Main {
	
	private static UserMedsController usermedscont;
	private static MainFrame mainframe;
	
	public static void main(String[] args) {
		
		usermedscont = new UserMedsController();
		mainframe = new MainFrame(usermedscont);
		mainframe.setVisible(true);		
		
	}

}
