package com.jigglypuff.components.tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jigglypuff.globals.StaticObjects;

public class AboutFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private BufferedImage image;

	public AboutFrame() {
		super("About");

		JLabel text = new JLabel("<html>&#9;Game rules:<br><br> The game is based on the classical chess and <br> the simple TicTacToe game.<br> It is played by 2 players, one against the other.<br> Each starts with 4 chess figures, which move<br> according to classic chess rules.<br> The goal is to make a line with all four pieces - <br>diagonally, horisontally or vertically.<br> The first player who does that, wins the game.<br><br><br><br><br><br><br><br><br><br><br><br><br>© 2017 v1.0 &#9;&#9;&emsp;&emsp;  Team TicTac</html> ",SwingConstants.CENTER);
		setSize(StaticObjects.WindowSize-150,StaticObjects.WindowSize);	
		try {
			image = ImageIO.read(getClass().getResource("pic.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(image.getScaledInstance(100, 140,Image.SCALE_SMOOTH)));

		picLabel.setSize(100,140);
		picLabel.setLocation(100,210);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add(picLabel);
		getContentPane().add(text);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	

}
