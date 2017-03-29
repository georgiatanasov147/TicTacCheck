package com.jigglypuff.components.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import com.jigglypuff.components.Piece;
import com.jigglypuff.components.pieces.Knight;
import com.jigglypuff.globals.StaticObjects;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	public MainPanel() {
		RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
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

		StaticObjects.board.drawBoard(g);
		
		if(StaticObjects.piece_index<=7){
			StaticObjects.pieces.get(StaticObjects.piece_index).paintPositions(g);
			StaticObjects.position_switch++;
		}
			
		
		//pieces
		for (Piece piece: StaticObjects.pieces) {
			g.drawImage(piece.getImage(), piece.getImageX(), piece.getImageY(), this);			
		}
	}
}
