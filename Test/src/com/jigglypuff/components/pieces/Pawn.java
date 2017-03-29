package com.jigglypuff.components.pieces;

import com.jigglypuff.components.Piece;
import java.awt.Graphics;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Pawn extends Piece{

	private int[][] pos = new int[3][2]; 

	
	public Pawn(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin+2*StaticObjects.SL);
		setType(Type.PAWN);
	}

	@Override
	public void paintPositions(Graphics g) {
		if(StaticObjects.position_switch==1){
			initPos();
		}
		for (int i = 0; i < pos.length; i++) {
			if(!(pos[i][0]<StaticObjects.begin ||
					pos[i][1]<StaticObjects.begin ||
					pos[i][0]>StaticObjects.begin*3||
					pos[i][1]>StaticObjects.begin*3))
			{
				g.drawImage(cross,pos[i][0],pos[i][1],StaticObjects.panel);
			}
		}
	}

	@Override
	public void initPos() {
		if(getColor().equals(Color.WHITE)){
			pos[0][0] = getImageX();
			pos[0][1] = getImageY()-StaticObjects.SL;
			
			pos[1][0] = getImageX()-StaticObjects.SL;
			pos[1][1] = getImageY()-StaticObjects.SL;
			
			pos[2][0] = getImageX()+StaticObjects.SL;
			pos[2][1] = getImageY()-StaticObjects.SL;
		}else{

			pos[0][0] = getImageX();
			pos[0][1] = getImageY()+StaticObjects.SL;
			
			pos[1][0] = getImageX()+StaticObjects.SL;
			pos[1][1] = getImageY()+StaticObjects.SL;
			
			pos[2][0] = getImageX()-StaticObjects.SL;
			pos[2][1] = getImageY()+StaticObjects.SL;
		}
	}
	
	
}
