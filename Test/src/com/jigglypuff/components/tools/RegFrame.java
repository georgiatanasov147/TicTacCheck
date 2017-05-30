package com.jigglypuff.components.tools;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jigglypuff.components.board.Board;
import com.jigglypuff.globals.StaticObjects;

public class RegFrame extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNewWhitePlayer,textNewBlackPlayer,textOldWhitePlayer,textOldBlackPlayer;
	
	public RegFrame() {
		super("Registration");
		JPanel panel = new JPanel();

		JButton buttonRegister = new JButton("Register");
		JButton buttonVerify = new JButton("Continue");
		
		JLabel labelNewWhitePlayer = new JLabel("New white player: ");
		JLabel labelExistingWhitePlayer = new JLabel("Existing white player: ");
		
		JLabel labelNewBlackPlayer = new JLabel("New black player: ");
		JLabel labelExistingBlackPlayer = new JLabel("Existing black player: ");
		
		textNewWhitePlayer = new JTextField("");
		textOldWhitePlayer = new JTextField("");
		
		textNewBlackPlayer = new JTextField("");
		textOldBlackPlayer = new JTextField("");
		
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize-130);
		panel.setLayout(null);

		buttonRegister.setLayout(null);
		buttonVerify.setLayout(null);
		
		labelNewWhitePlayer.setLayout(null);
		labelExistingWhitePlayer.setLayout(null);
		
		textNewWhitePlayer.setLayout(null);
		textOldWhitePlayer.setLayout(null);
		
		labelNewBlackPlayer.setLayout(null);
		labelExistingBlackPlayer.setLayout(null);
		
		textNewBlackPlayer.setLayout(null);
		textOldBlackPlayer.setLayout(null);
		
		buttonRegister.setBounds(0,0,100,30);
		buttonVerify.setBounds(0,0,100,30);
		
		labelNewWhitePlayer.setBounds(0,0,150,30);
		labelExistingWhitePlayer.setBounds(0,0,150,30);
		
		textNewWhitePlayer.setBounds(0,0,100,30);
		textOldWhitePlayer.setBounds(0,0,100,30);
		
		labelNewBlackPlayer.setBounds(0,0,150,30);
		labelExistingBlackPlayer.setBounds(0,0,150,30);
		
		textNewBlackPlayer.setBounds(0,0,100,30);
		textOldBlackPlayer.setBounds(0,0,100,30);
		
		
		labelNewWhitePlayer.setLocation(30, 30);
		textNewWhitePlayer.setLocation(30, 180);
		labelNewBlackPlayer.setLocation(30,130);
		textNewBlackPlayer.setLocation(30, 80);
		labelExistingWhitePlayer.setLocation(230,30);
		textOldWhitePlayer.setLocation(230,180);
		labelExistingBlackPlayer.setLocation(230,130);
		textOldBlackPlayer.setLocation(230, 80);
		buttonRegister.setLocation(30, 230);
		buttonVerify.setLocation(230, 230);
		
		buttonRegister.addActionListener(new StartNewAction());
		buttonVerify.addActionListener(new StartOldAction());
		
		panel.add(buttonRegister);
		panel.add(buttonVerify);
		panel.add(labelNewWhitePlayer);
		panel.add(labelExistingWhitePlayer);
		panel.add(textNewWhitePlayer);
		panel.add(textOldWhitePlayer);
		panel.add(labelNewBlackPlayer);
		panel.add(labelExistingBlackPlayer);
		panel.add(textNewBlackPlayer);
		panel.add(textOldBlackPlayer);
		
		setLocationRelativeTo(null);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	class StartOldAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			DatabaseController dbc = new DatabaseController("root", "newpass");
			if (dbc.selectExistingPlayer(textOldWhitePlayer.getText())
					&& dbc.selectExistingPlayer(textOldBlackPlayer.getText())) {
				System.out.println("OUT OF CYCLE");
				StaticObjects.panel = new MainPanel(textOldWhitePlayer.getText(),textOldBlackPlayer.getText());
				StaticObjects.mf=new MainFrame("TicTacCheck");
			} else {
				JOptionPane.showMessageDialog(null, "Player names don't exist. Please register!");
			}
		}
	}
	
	class StartNewAction implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
			DatabaseController dbc = new DatabaseController("root","newpass");
			boolean white = !dbc.selectExistingPlayer(textNewWhitePlayer.getText());
			boolean black = !dbc.selectExistingPlayer(textNewBlackPlayer.getText());
			if(white && black){
				dbc.insertNewPlayer(textNewWhitePlayer.getText());
				dbc.insertNewPlayer(textNewBlackPlayer.getText());
				StaticObjects.panel= new MainPanel(textNewWhitePlayer.getText(),textNewBlackPlayer.getText());
				StaticObjects.mf = new MainFrame("TicTacCheck");
			}else{
				JOptionPane.showMessageDialog(null, "Player names already exist! ");
			}
			
		}
		
	}
	
	class InvalidRegistrationAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Player name taken!");
		}
		
	}
	
	class InvalidVerificationAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Player name doesn't exist!");
		}
		
	}
}
