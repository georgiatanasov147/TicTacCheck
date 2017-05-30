package com.jigglypuff.components.tools;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.globals.StaticObjects;

public class AboutFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private JPanel panel;
	public AboutFrame() {
		super("About");
		RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
		image = Toolkit.getDefaultToolkit().getImage(TicTacCheckApplication.class.getResource("pic.png"));
		image = image.getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING);
		JPanel panel = new JPanel();
		this.panel=panel;
		JLabel text = new JLabel("<html>&#9;Game rules:<br><br> The game is based on the classical chess and <br> the simple TicTacToe game.<br> It is played by 2 players, one against the other.<br> Each starts with 4 chess figures, which move<br> according to classic chess rules.<br> The goal is to make a line with all four pieces - <br>diagonally, horisontally or vertically.<br> The first player who does that, wins the game.<br><br><br><br><br><br><br><br><br><br><br><br><br>© 2017 v1.0 &#9;&#9;&emsp;&emsp;  Team TicTac</html> ",SwingConstants.CENTER);
			
		setSize(StaticObjects.WindowSize-150,StaticObjects.WindowSize);
		
		setLocationRelativeTo(null);
		add(panel);
		panel.add(text);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(image, 40, 40, panel);
	}
}
