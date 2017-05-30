package com.jigglypuff.components.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jigglypuff.globals.StaticObjects;

public class DonateFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField pn, rn, am, ib;
	
	public DonateFrame() {
		super("Donate");
		JPanel panel = new JPanel();
		
		JButton send = new JButton("Send");
		
		JLabel playerName = new JLabel("Enter player name: ");
		JLabel realName = new JLabel("Enter your real name: ");
		JLabel amount = new JLabel("Enter donation amount: ");
		JLabel iban = new JLabel("Enter your IBAN: ");
		
		pn = new JTextField("");
		rn = new JTextField("");
		am = new JTextField("");
		ib = new JTextField("");

		send.addActionListener(new MessageAction());
		send.addActionListener(new DonateAction());
		
		panel.setLayout(null);
		
		send.setLayout(null);
		
		playerName.setLayout(null);
		realName.setLayout(null);
		amount.setLayout(null);
		iban.setLayout(null);
		
		pn.setLayout(null);
		rn.setLayout(null);
		am.setLayout(null);
		ib.setLayout(null);
		
		send.setBounds(0,0,100,30);
		playerName.setBounds(0,0,200,20);
		realName.setBounds(0,0,200,20);
		amount.setBounds(0,0,200,20);
		iban.setBounds(0,0,200,20);
		
		pn.setBounds(0,0,100,20);
		rn.setBounds(0,0,100,20);
		am.setBounds(0,0,100,20);
		ib.setBounds(0,0,100,20);
		
		panel.add(playerName);
		panel.add(realName);
		panel.add(amount);
		panel.add(iban);
		panel.add(pn);
		panel.add(rn);
		panel.add(am);
		panel.add(ib);
		panel.add(send);
		
		
		send.setLocation(250,320);
		
		playerName.setLocation(20,20);
		realName.setLocation(20,80);
		amount.setLocation(20,140);
		iban.setLocation(20,200);
		
		pn.setLocation(20,50);
		rn.setLocation(20,110);
		am.setLocation(20,170);
		ib.setLocation(20,230);
		
		
		setSize(StaticObjects.WindowSize,StaticObjects.WindowSize);
		
		setLocationRelativeTo(null);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	class DonateAction implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
			DatabaseController dbc = new DatabaseController("root","newpass");
			String playerName = pn.getText();
			String name = rn.getText();
			String amount = am.getText();
			String IBAN = ib.getText();
			dbc.insertNewDonation(playerName, name, Integer.parseInt(amount), IBAN);
		}
		
	}
	
	class MessageAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Thank you for your support!!!");
		}
		
	}
}
