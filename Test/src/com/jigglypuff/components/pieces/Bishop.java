package com.jigglypuff.components.pieces;


import java.awt.Graphics;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Piece;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

/*
 * Define Bishop; extends Piece which is an abstract class - hence the overriden abstract methods
 */

public class Bishop extends Piece{

	private int[][] pos = new int[12][2];
	/*
	 * Array of valid positions for the green 'X', i.e. possible moves; 
	 * APPLIES FOR THE BISHOP ONLY NOW
	 */

	
	public Bishop(String imageFile,Color color) {
		/* 
		 * Call Piece constructor with the image file name, the current piece colour (given in main() )
		 * and the starting coordinate - 100
		 */
		super(imageFile,color,StaticObjects.begin);
		setType(Type.BISHOP);
		
	}

	@Override
	public void paintPositions(Graphics g) {
		
		if(StaticObjects.position_switch==1){
			/* 
			 * position_switch is used to estimate 'are we dragging any piece at the current moment?'
			 * If position switch is 1 (which in our case means 'no, I'm not moving any pieces'),
			 * then fill the pos[] array for the current piece with all possible moves
			 * for that piece from its current position;
			 * If we're dragging any of the pieces, then don't calculate the possible moves,
			 * don't fill the pos[] array with the new possible moves from the current position
			 * of the given piece, i.e. don't call initPos().
			 */
			initPos();
		}
		
		for (int i = 0; i < pos.length; i++) {
			/* 
			 * If the coordinates saved in the i-th member of pos[] don't correspond to
			 * a position outside the board, then draw the green X (marking possible moves).
			 */
			if(!(pos[i][0]<StaticObjects.begin ||
					 pos[i][1]<StaticObjects.begin ||
					 pos[i][0]>StaticObjects.begin*3 ||
					 pos[i][1]>StaticObjects.begin*3) )
			{
				g.drawImage(cross,pos[i][0],pos[i][1],StaticObjects.panel);
			}
		}
	}

	/* 
	 * Calculate all possible moves for the given piece, based on its current position,
	 * and populate pos[] with the possible moves' coordinates.
	 */
	
	@Override
	public void initPos() {
		
		/* Possible green 'X' positions (hence possible moves) for the Bishop are: */
		
		/* diagonal to upper left; */
		
		pos[0][0] = getImageX()-StaticObjects.SL;
		pos[0][1] = getImageY()-StaticObjects.SL;
		
		pos[1][0] = getImageX()-StaticObjects.SL*2;
		pos[1][1] = getImageY()-StaticObjects.SL*2;
		
		pos[2][0] = getImageX()-StaticObjects.SL*3;
		pos[2][1] = getImageY()-StaticObjects.SL*3;
		
		/* diagonal to lower right; */
		
		pos[3][0] = getImageX()+StaticObjects.SL;
		pos[3][1] = getImageY()+StaticObjects.SL;
		
		pos[4][0] = getImageX()+StaticObjects.SL*2;
		pos[4][1] = getImageY()+StaticObjects.SL*2;
		
		pos[5][0] = getImageX()+StaticObjects.SL*3;
		pos[5][1] = getImageY()+StaticObjects.SL*3;
		
		/* diagonal to upper right; */
		
		pos[6][0] = getImageX()+StaticObjects.SL;
		pos[6][1] = getImageY()-StaticObjects.SL;
		
		pos[7][0] = getImageX()+StaticObjects.SL*2;
		pos[7][1] = getImageY()-StaticObjects.SL*2;
		
		pos[8][0] = getImageX()+StaticObjects.SL*3;
		pos[8][1] = getImageY()-StaticObjects.SL*3;
		
		/* diagonal to lower left; */
		
		pos[9][0] = getImageX()-StaticObjects.SL;
		pos[9][1] = getImageY()+StaticObjects.SL;
		
		pos[10][0] = getImageX()-StaticObjects.SL*2;
		pos[10][1] = getImageY()+StaticObjects.SL*2;
		
		pos[11][0] = getImageX()-StaticObjects.SL*3;
		pos[11][1] = getImageY()+StaticObjects.SL*3;
		
	}

	@Override
	public boolean moveIsValid(int newX, int newY) {
		/* 
		 * The newX and newY coordinates are taken after fixPosition() has done its job,
		 * i.e. the current piece has been fixed (snapped) to the board grid
		 */
		for (int i = 0; i < pos.length; i++) {
			if(newX == pos[i][0] && newY == pos[i][1]){
				return true;
			}
		}
		return false;
	}
}
