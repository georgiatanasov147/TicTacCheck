package com.jigglypuff.components.board;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.globals.StaticObjects;

public class Board {
	
	private int[][] board;
	
	private Image img;
	
	public Board() {
		img = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("board.jpg"));
		img = img.getScaledInstance(240, 240, Image.SCALE_AREA_AVERAGING);
		board = new int[16][4];
		initialiseBoard();
	}
	
	public void drawBoard(Graphics g){
		g.drawImage(img, StaticObjects.begin, StaticObjects.begin, StaticObjects.panel);
	}
	
	
	public void initialiseBoard() {
		int x1 = StaticObjects.begin;
		int y1 = StaticObjects.begin;
		int x2 = StaticObjects.begin + StaticObjects.SL;
		int y2 = StaticObjects.begin + StaticObjects.SL;
		
		for (int i = 0; i < 16; i++) {
			if (i == 4 || i == 8 || i == 12) {
				x1 = StaticObjects.begin;
				y1 += StaticObjects.SL;
				x2 = StaticObjects.begin + StaticObjects.SL;
				y2 += StaticObjects.SL;
			}
			board[i][0] = x1;
			board[i][1] = y1;
			board[i][2] = x2;
			board[i][3] = y2;
			x1 += StaticObjects.SL;
			x2 += StaticObjects.SL;
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
