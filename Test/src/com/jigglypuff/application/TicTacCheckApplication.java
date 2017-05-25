package com.jigglypuff.application;


import com.jigglypuff.components.pieces.Bishop;
import com.jigglypuff.components.pieces.Knight;
import com.jigglypuff.components.pieces.Pawn;
import com.jigglypuff.components.pieces.Rook;
import com.jigglypuff.components.tools.MainFrame;
import com.jigglypuff.components.tools.MenuFrame;
import com.jigglypuff.components.*;

public class TicTacCheckApplication {

	public static MainFrame mf;
	public static MenuFrame menuFrame;
	public static void main(String[] args) {
 
		Bishop white_bishop = new Bishop("images/w_bishop.png",Color.WHITE);
		Knight white_knight = new Knight("images/w_knight.png",Color.WHITE);
		Pawn white_pawn = new Pawn("images/w_pawn.png",Color.WHITE);
		Rook white_rook = new Rook("images/w_rook.png",Color.WHITE);
		
		Bishop black_bishop = new Bishop("images/b_bishop.png",Color.BLACK);
		Knight black_knight = new Knight("images/b_knight.png",Color.BLACK);
		Pawn black_pawn = new Pawn("images/b_pawn.png",Color.BLACK);
		Rook black_rook = new Rook("images/b_rook.png",Color.BLACK);
		
//		mf = new MainFrame("TicTacCheck");
		menuFrame = new MenuFrame("Menu");
	}//main
	

}//class TicTacCheckApplication
