package controllers;

public class Main {
	
	private static UserMedsController usermedscont;
	
	public static void main(String[] args) {
		
		usermedscont = new UserMedsController();
		usermedscont.start();
	
	}

}
