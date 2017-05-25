package com.jigglypuff.components.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Piece;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Knight extends Piece{

	
	private int[][] pos = new int[8][2];
	/*
	 * Array, which we will later fill with the valid possible moves for the Knight,
	 * i.e. green 'X' positions.
	 */
	private boolean lock = true;
	
	/* Knight constructor */
	public Knight(String imageFile,Color color)
	{
		super(imageFile,color,StaticObjects.begin+StaticObjects.SL);
		setType(Type.KNIGHT);
		
	}
	
	@Override
	public void initPos(){
		
		/* Valid moves for the knight (taking into account it's current position): */
		
		/* Two left, one up; */
		
		pos[0][0] = getImageX()-StaticObjects.SL*2;
		pos[0][1] = getImageY()-StaticObjects.SL;
		
		/* One left, two up; */
		
		pos[1][0] = getImageX()-StaticObjects.SL;
		pos[1][1] = getImageY()-StaticObjects.SL*2;
		
		/* One right, two up; */
		
		pos[2][0] = getImageX()+StaticObjects.SL;
		pos[2][1] = getImageY()-StaticObjects.SL*2;
		
		/* Two right, one up; */
		
		pos[3][0] = getImageX()+StaticObjects.SL*2;
		pos[3][1] = getImageY()-StaticObjects.SL;
		
		/* Two left, one down; */
		
		pos[4][0] = getImageX()-StaticObjects.SL*2;
		pos[4][1] = getImageY()+StaticObjects.SL;
		
		/* One left, two down; */
		
		pos[5][0] = getImageX()-StaticObjects.SL;
		pos[5][1] = getImageY()+StaticObjects.SL*2;
		
		/* Two right, one down; */
		
		pos[6][0] = getImageX()+StaticObjects.SL*2;
		pos[6][1] = getImageY()+StaticObjects.SL;
		
		/* One right, two down. */
		
		pos[7][0] = getImageX()+StaticObjects.SL;
		pos[7][1] = getImageY()+StaticObjects.SL*2;
	}
	
	@Override
	public void paintPositions(Graphics g) 
	{
		if (StaticObjects.position_switch==1){
			initPos();
		}
		for (int i = 0; i < pos.length; i++) {
			lock=true;
			/*
			 * Checking for the bounds of the board...
			 * If we're not trying to draw the possible positions (the green 'X')
			 * outside of the board, then go ahead and show us where we can move.
			 */
			if (!(pos[i][0]<StaticObjects.begin ||
				pos[i][1]<StaticObjects.begin ||
				pos[i][0]>StaticObjects.begin*3 ||
				pos[i][1]>StaticObjects.begin*3))
			{
				for (Piece piece : StaticObjects.pieces)
				{
					if (piece.getOldX() == pos[i][0] && piece.getOldY() == pos[i][1])
					{
						if (!(piece.getColor().equals(this.getColor())))
						{
							g.drawImage (cross, pos[i][0], pos[i][1], StaticObjects.panel);
							break;
						}
						else
						{
							lock = false;
						}
						
					} /* End if (piece.getOldX() == pos[i][0] && piece.getOldY() == pos[i][1]) */
					
				} /* End for (Piece piece : StaticObjects.pieces) */
				
				if (lock == true)
				{
					g.drawImage(cross,pos[i][0],pos[i][1],StaticObjects.panel);
				} /* End if (lock == true) */
				
			}/* End if (!(pos[i][0]<StaticObjects.begin || ........*/
			
		}/* End for (int i = 0; i < pos.length; i++) */
		
	} /* End paintPositions() */
	
	/*
	 * Passing the newX and newY, because we're calling moveIsValid() after we already know
	 * that the piece is on the board (we're not trying to place it somewhere outside).
	 * Here we're just checking if the newX and newY coordinates coincide with the position
	 * of any of the green 'X's (i.e. we've made a valid move).
	 */
	@Override
	public boolean moveIsValid(int newX, int newY) {
		for (int i = 0; i < pos.length; i++) {
			if(newX == pos[i][0] && newY == pos[i][1]){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}
