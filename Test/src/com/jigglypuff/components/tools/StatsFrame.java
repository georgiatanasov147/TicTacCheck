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

		JTable table = getData("root","newpass");
		JScrollPane scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		setSize(StaticObjects.WindowSize+150,StaticObjects.WindowSize);
		
		panel.setLayout(new FlowLayout());
		panel.add(table);
		panel.add(scroll);

		setLocationRelativeTo(null);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private JTable getData(String user, String pass){
		JTable table = new JTable(0,7);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = {"Name","Games","Wins","Losses","Draws","WinRate","Rating"};
		model.addRow(row);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/TicTacCheck?user="+user+"&password="+pass);
			Statement statement = (Statement) connection.createStatement();
//			statement.executeUpdate("INSERT INTO Players VALUES (\"Valio\",7,2,3,2,30,4)");
			ResultSet result = statement.executeQuery("SELECT * FROM Players");
			while (result.next()) {
				String name = result.getString("name");
				String games = result.getString("games");
				String wins = result.getString("wins");
				String losses = result.getString("loses");
				String draws = result.getString("draws");
				String winPercentage = result.getString("winPercentage");
				String rating = result.getString("rating");
				Object[] newrow = {name,games,wins,losses,draws,winPercentage,rating};
				model.addRow(newrow);	
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		return table;
	}

}
