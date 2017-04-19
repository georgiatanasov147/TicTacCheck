package com.jigglypuff.components.board;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.globals.StaticObjects;

/* Here we're creating the actual... "virtual"... board, i.e. the coordinates of the valid poisitons */

public class Board {
	
	private int[][] board; /* The board array itself */
	
	private Image img;
	
	public Board() {
		/* get board image and scale it */
		img = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("../../application/images/board3.png"));
		img = img.getScaledInstance(280, 400, Image.SCALE_AREA_AVERAGING);
		
		/* actually define the board array as a 16x4 coordinate array */
		board = new int[16][4];
		initialiseBoard(); /* method to fill the array with data */
	}
	
	/* ...Yes, draw the board */
	public void drawBoard(Graphics g){
		g.drawImage(img, StaticObjects.begin-20, StaticObjects.begin-80, StaticObjects.panel);
	}
	
	
	public void initialiseBoard() {
		
		/*
		 * The board is intended as a 16x4 array, each i-tieth array member holding
		 * the coordinates of the upper left (X and Y coord) and lower right corner 
		 * (X and Y coord) of each and every square of the board.
		 * So for example, board[5]:
		 * 		board[5][0] will hold upper left X;
		 * 		board[5][1] will hold upper left Y;
		 * 		board[5][2] will hold lower right X;
		 * 		board[5][3] will hold lower right Y;
		 * This has been done in order to ease our work later; so we can later say
		 * 'The figure is in THIS EXACT square'. The old algorithm for finding where
		 * a piece on the board is used only the coordinates of the upper left corner...
		 * it was tricky doing stuff like that.
		 */
		
		int x1 = StaticObjects.begin; 						/* upper left X */
		int y1 = StaticObjects.begin; 						/* upper left Y */
		int x2 = StaticObjects.begin + StaticObjects.SL;	/* lower right X */
		int y2 = StaticObjects.begin + StaticObjects.SL;	/* lower right Y */
		
		/* 
		 * StaticObjects.begin is the beginning point of the board (it's upper left corner);
		 * StaticObjects.SL is square length
		 */
		
		for (int i = 0; i < 16; i++) {
			
			/* 
			 * This check has to be before everything else;
			 * Otherwise bad things happen;
			 * 
			 * When we reach the fourth element, i.e. we've finished a whole row,
			 * reset the Xs and increment the Y coordinates.
			 */
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
			/* Filling up the first row, i.e. constant Y coords', so we increment only the Xs */
			x1 += StaticObjects.SL;
			x2 += StaticObjects.SL;
		}
		
		
	}

	/* Deprecated method; removal pending; this is how we used to draw the board
	
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
	
	*/
	
	public int[][] getBoard() {
		return board;
	}
	
	public void setBoard(int[][] board) {
		this.board = board;
	}
}
