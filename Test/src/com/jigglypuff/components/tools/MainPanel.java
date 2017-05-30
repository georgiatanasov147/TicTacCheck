package com.jigglypuff.components.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;
import com.jigglypuff.components.Piece;
import com.jigglypuff.components.pieces.Knight;
import com.jigglypuff.globals.StaticObjects;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainPanel(String whitePlayer,String blackPlayer) {
		RepaintManager.currentManager(null).setDoubleBufferingEnabled(true);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel white = new JLabel(whitePlayer);
		JLabel black = new JLabel(blackPlayer);
		setLayout(null);
		white.setLayout(null);
		white.setBounds(0,0,100,30);
		white.setLocation(30, 30);
		
		black.setLayout(null);
		black.setBounds(0,0,100,30);
		black.setLocation(30, 380);
		add(white);
		add(black);
	}

	public Dimension getPreferredSize() {
		return new Dimension(StaticObjects.WindowSize, StaticObjects.WindowSize);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// background
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, StaticObjects.WindowSize, StaticObjects.WindowSize);

		// board

		StaticObjects.board.drawBoard(g);

		if (StaticObjects.piece_index <= 7) {
			if (StaticObjects.pieces.get(StaticObjects.piece_index).isOnBoard()) {
				StaticObjects.pieces.get(StaticObjects.piece_index).paintPositions(g);
				StaticObjects.position_switch++;
			}
		}

		// pieces
		for (Piece piece : StaticObjects.pieces) {
			g.drawImage(piece.getImage(), piece.getImageX(), piece.getImageY(), this);
		}
	}
}
