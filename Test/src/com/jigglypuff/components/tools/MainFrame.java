package com.jigglypuff.components.tools;


import javax.swing.JFrame;

import com.jigglypuff.globals.StaticObjects;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private MouseController m;
	
	
	public MainFrame(String title) {
		super(title);
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		m = new MouseController();
		addMouseMotionListener(m);
		addMouseListener(m);
		add(StaticObjects.panel);
		pack();
		setVisible(true);
	}
	

}
