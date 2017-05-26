package com.jigglypuff.components.tools;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jigglypuff.globals.StaticObjects;

public class AboutFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutFrame() {
		super("About");
		JPanel panel = new JPanel();
		JLabel text = new JLabel("info123");
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize);
		
		setLocationRelativeTo(null);
		add(panel);
		panel.add(text);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
