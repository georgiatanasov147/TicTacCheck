package com.jigglypuff.globals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import com.jigglypuff.components.Piece;
import com.jigglypuff.components.board.Board;
import com.jigglypuff.components.tools.MainPanel;

public class StaticObjects {
	
	public static MainPanel panel = new MainPanel();
	public static Board board = new Board();
	public static Scanner input = new Scanner(System.in);
	public static final int X = 60, Y = 60;
	public static final int SL = 60; //SQUARE LENGTH
	public static final int begin = 100;
	public static final int WindowSize = 450;
	public static ArrayList<Piece> pieces = new ArrayList<Piece>();
	public static final Color brown = new Color(77,12,0);
	public static final Color white = new Color(251,220,155);
	public static boolean flag = false;
	public static int piece_index = 10;
	public static int position_switch = 1;
	
	
}
