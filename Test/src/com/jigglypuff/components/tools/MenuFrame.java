package com.jigglypuff.components.tools;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
		JButton start = new JButton("New Game");
		JButton stats = new JButton("Statistics");
		JButton about = new JButton("About");
		JButton donate = new JButton("Donate");
		JButton quit = new JButton("Quit");
		
		panel.setLayout(null);
		start.setLayout(null);
		about.setLayout(null);
		quit.setLayout(null);
		donate.setLayout(null);
		stats.setLayout(null);
		
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize);

		setLocationRelativeTo(null);
		add(panel);
		start.setBounds(225,225,150,40);
		start.addActionListener(new StartAction());
		panel.add(start);
		
		quit.setBounds(225,295,150,40);
		quit.addActionListener(new QuitAction());
		panel.add(quit);
		
		about.setBounds(225,345,150,40);
		about.addActionListener(new AboutAction());
		panel.add(about);
		
		donate.setBounds(0,0,150,40);
		donate.addActionListener(new DonateAction());
		panel.add(donate);
		
		stats.setBounds(0,0,150,40);
		stats.addActionListener(new StatisticsAction());
		panel.add(stats);
		
		start.setLocation(150,150);
		about.setLocation(30, 320);
		quit.setLocation(250, 320);
		donate.setLocation(150, 250);
		stats.setLocation(150, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class StatisticsAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new StatsFrame();
		}
		
	}
	class AboutAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new AboutFrame();
		}
		
	}
	class DonateAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new DonateFrame();
		}
		
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
