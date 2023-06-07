package com.digipets.main;

import javax.swing.UIManager;

import com.digipets.view.LoginView;

public class Main {
	private static String visual = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
	
	public static void main(String[] args) throws Exception{	
		UIManager.setLookAndFeel(visual);
		new LoginView();
	}
}
