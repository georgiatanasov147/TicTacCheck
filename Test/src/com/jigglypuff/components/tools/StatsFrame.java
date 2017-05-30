package com.jigglypuff.components.tools;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jigglypuff.globals.StaticObjects;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class StatsFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public StatsFrame() {
		super("Statistics");
		JPanel panel = new JPanel();
		DatabaseController dbc  = new DatabaseController("root","newpass");
		JTable table = dbc.selectStatisticsFromPlayers();
		JScrollPane scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		setSize(StaticObjects.WindowSize+150,StaticObjects.WindowSize);
		panel.setLayout(new FlowLayout());
		panel.add(scroll);

		setLocationRelativeTo(null);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}
