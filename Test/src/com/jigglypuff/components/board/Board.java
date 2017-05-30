package com.jigglypuff.components.board;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.HashMap;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Piece;
import com.jigglypuff.globals.StaticObjects;

public class Board {

	private int[][] board;
	private Image img;
	public int[][] map2;
	public Board() {
		img = Toolkit.getDefaultToolkit().getImage(Board.class.getResource("board3.png"));
		img = img.getScaledInstance(280, 400, Image.SCALE_AREA_AVERAGING);
		board = new int[16][4];
		map2 = new int[16][3];
//		map2 = new int[4][4];
		initialiseBoard();
		initMap();
	}

	public void initMap() {
		for (int i = 0; i < board.length; i++) {
			map2[i][0] = board[i][0];
			map2[i][1] = board[i][1];
			map2[i][2] = 0;
		}
	}

	public void paintMap() {
		for (int i = 0; i < map2.length; i++) {
			System.out.print(map2[i][2]);
			if (i == 3 || i == 7 || i == 11) {
				System.out.println();
			}
		}
		System.out.println("\n\n");
	}
	
	
	public int checkEndGame(){
		for (int i = 0; i < map2.length ; i +=4) {
//			if(map2[i][0] == map2[i][1] && map2[i][2] == map2[i][3] && map2[i][1] == map2[i][2]){
//				return true;
//			}
			if(map2[i][2] == map2[i+1][2] && map2[i+2][2] == map2[i+3][2] && map2[i+1][2] == map2[i+2][2]){
				if (map2[i][2] == 1 || map2[i][2] == 2) {
					return map2[i][2];
				}
			}

		}
		
		for (int i = 0; i < 4; i++) {
			
			if(map2[i][2] == map2[i+4][2] && map2[i+8][2] == map2[i+12][2] && map2[i+4][2] == map2[i+8][2]){
				if (map2[i][2] == 1 || map2[i][2] == 2) {
					return map2[i][2];
				}
			}
		}
		
		if(map2[0][2] == map2[5][2] && map2[10][2] == map2[15][2] && map2[5][2] == map2[10][2]){
			if (map2[0][2] == 1 || map2[0][2] == 2) {
				return map2[0][2];
			}
		}
		
		if(map2[3][2] == map2[6][2] && map2[9][2] == map2[12][2] && map2[6][2] == map2[9][2]){
			if (map2[3][2] == 1 || map2[3][2] == 2) {
				return map2[3][2];
			}
		}
		
		return 0;
	}

	public void takeSquare(int x, int y, Color c) {
		int value;
		if(c.equals(Color.BLACK)){
			value = 2;
		}else{
			value = 1;
		}
		
		for (int i = 0; i < map2.length; i++) {
			if(x == map2[i][0] && y == map2[i][1]){
				map2[i][2]=value;
				break;
			}
		}
	}

	public void leaveSquare(int x, int y) {

		for (int i = 0; i < map2.length; i++) {
			if(x == map2[i][0] && y == map2[i][1]){
				map2[i][2]=0;
				break;
			}
		}
	}
	// Returns 0, 1 , 2 - empty, white, black
	public int isTaken(int x, int y) {

		for (int i = 0; i < map2.length; i++) {
			if(x == map2[i][0] && y == map2[i][1]){
				return map2[i][2];
			}
		}
		return 0;
	}

	
	public void drawBoard(Graphics g) {
		g.drawImage(img, StaticObjects.begin - 20, StaticObjects.begin - 80, StaticObjects.panel);
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
		// setBackground(Color.GRAY);
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
