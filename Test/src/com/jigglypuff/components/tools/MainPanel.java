package com.jigglypuff.components.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.globals.StaticObjects;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel() {
		RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public Dimension getPreferredSize() {
		return new Dimension(StaticObjects.WindowSize, StaticObjects.WindowSize);
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//background
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, StaticObjects.WindowSize, StaticObjects.WindowSize);
		//board
		StaticObjects.board.paintBoard(g);
		//pieces

		
		for (AbstractPiece piece: StaticObjects.pieces) {
			g.drawImage(piece.getImage(), piece.getImageX(), piece.getImageY(), this);
		}
	}
}
