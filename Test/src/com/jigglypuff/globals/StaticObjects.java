package com.jigglypuff.globals;

 /* 
  * Was used for the brown and white colours:
  * 
  * import java.awt.Color;
  */
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
	public static final int SL = 60; /* SQUARE LENGTH CONSTANT */
	public static final int begin = 100; /* (x, y) = (100, 100) - starting coordinates for the board */
	public static final int WindowSize = 450;
	public static ArrayList<Piece> pieces = new ArrayList<Piece>(); /* All pieces are in a list */
	
	/* 
	 * Deprecated - were used for the old board generation method:
	 *
	 * public static final Color brown = new Color(77,12,0);
	 * public static final Color white = new Color(251,220,155);
	 */
	
	public static boolean flag = false;
	public static int piece_index = 10;
	public static int position_switch = 1;
}
