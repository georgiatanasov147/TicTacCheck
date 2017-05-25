package com.jigglypuff.components.tools;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.globals.StaticObjects;

public class MenuFrame extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuFrame(String title) {
		super(title);
		JPanel panel = new JPanel();
		JButton start = new JButton("Start game");
		JButton quit = new JButton("Quit");
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize);
		
		setLocationRelativeTo(null);
		add(panel);
		start.setBounds(225,225,30,10);
//		start.setLocation(new Point(225,225));
		start.addActionListener(new StartAction());
		panel.add(start);
		quit.setBounds(225,240,20,10);
		quit.addActionListener(new QuitAction());
		panel.add(quit);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	class QuitAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	class StartAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			TicTacCheckApplication.mf = new MainFrame("TicTacCheck");
		}
		
	}


}
