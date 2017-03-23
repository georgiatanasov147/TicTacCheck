package com.jigglypuff.components.board;

import java.awt.Graphics;

import com.jigglypuff.globals.StaticObjects;

public class Board {
	
	private int[][] board;
	

	
	public Board() {
		board = new int[16][2];
		initialiseBoard();
	}
	public void initialiseBoard() {
		int x = StaticObjects.begin;
		int y = StaticObjects.begin;
		for (int i = 0; i < 16; i++) {
			if (i == 4 || i == 8 || i == 12) {
				x = StaticObjects.begin;
				y += StaticObjects.SL;
			}
			board[i][0] = x;
			board[i][1] = y;
			x += StaticObjects.SL;
		}
	}

	public void paintBoard(Graphics g) {
		int X = StaticObjects.begin;
		int Y = StaticObjects.begin;
//		setBackground(Color.GRAY);
		g.setColor(StaticObjects.brown);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				g.fillRect(X, Y, StaticObjects.SL, StaticObjects.SL);
				X += StaticObjects.SL;
				if (g.getColor().equals(StaticObjects.brown)) {
					g.setColor(StaticObjects.white);
				} else {
					g.setColor(StaticObjects.brown);
				}
			}
			X = StaticObjects.begin;
			g.fillRect(X, Y, StaticObjects.SL, StaticObjects.SL);
			Y += StaticObjects.SL;
			if (g.getColor().equals(StaticObjects.brown)) {
				g.setColor(StaticObjects.white);
			} else {
				g.setColor(StaticObjects.brown);
			}
		}
	}
	
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
}
