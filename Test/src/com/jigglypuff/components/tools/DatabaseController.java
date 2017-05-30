package com.jigglypuff.components.tools;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseController {

	private Statement statement;
	
	public DatabaseController(String user, String pass) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/TicTacCheck?user="+user+"&password="+pass);
			Statement statement = (Statement) connection.createStatement();
//			statement.executeUpdate("INSERT INTO Players VALUES (\"Valio\",7,2,3,2,30,4)");

			this.statement=statement;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
	}
	
	public JTable selectStatisticsFromPlayers(){
		JTable table = new JTable(0,7);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] header = {"Name","Games","Wins","Losses","Draws","WinRate","Rating"};
		model.setColumnIdentifiers(header);
		try{
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
		}
		return table;
	}
	
	public void insertNewPlayer(String name){
		try {
			statement.executeUpdate("INSERT INTO `Players` (`name`,`games`,`wins`,`loses`,`draws`,`winPercentage`,`rating`)"
					+ " VALUES ('"+name+"',0,0,0,0,0,0);");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean selectExistingPlayer(String name){	
		try {
			ResultSet result = statement.executeQuery("SELECT * FROM Players WHERE name = '"+name+"'");		
			while(result.next()){
				if( result.getString("name").equals(name)){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insertNewDonation(String playerName, String name, int amount, String IBAN){
		
		String insert = "INSERT INTO `Donations` (`playerName`,`name`,`amount`,`IBAN`) VALUES ('" + playerName + "','" + name + "','" + amount + "','" + IBAN + "');";
		try {
			statement.executeUpdate(insert);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
