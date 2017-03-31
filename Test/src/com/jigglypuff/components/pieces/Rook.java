package com.jigglypuff.components.pieces;

import com.jigglypuff.components.Piece;
import java.awt.Graphics;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Rook extends Piece{

	private int[][] pos = new int[12][2]; 

	
	public Rook(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin+3*StaticObjects.SL);
		setType(Type.ROOK);
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
		pos[0][0] = getImageX();
		pos[0][1] = getImageY()-StaticObjects.SL;
		
		pos[1][0] = getImageX();
		pos[1][1] = getImageY()-StaticObjects.SL*2;
		
		pos[2][0] = getImageX();
		pos[2][1] = getImageY()-StaticObjects.SL*3;
		
		pos[3][0] = getImageX();
		pos[3][1] = getImageY()+StaticObjects.SL;
		
		pos[4][0] = getImageX();
		pos[4][1] = getImageY()+StaticObjects.SL*2;
		
		pos[5][0] = getImageX();
		pos[5][1] = getImageY()+StaticObjects.SL*3;
		
		pos[6][0] = getImageX()+StaticObjects.SL;
		pos[6][1] = getImageY();
		
		pos[7][0] = getImageX()+StaticObjects.SL*2;
		pos[7][1] = getImageY();
		
		pos[8][0] = getImageX()+StaticObjects.SL*3;
		pos[8][1] = getImageY();
		
		pos[9][0] = getImageX()-StaticObjects.SL;
		pos[9][1] = getImageY();
		
		pos[10][0] = getImageX()-StaticObjects.SL*2;
		pos[10][1] = getImageY();
		
		pos[11][0] = getImageX()-StaticObjects.SL*3;
		pos[11][1] = getImageY();
		
	}

	@Override
	public boolean moveIsValid(int mouseX, int mouseY) {
		for (int i = 0; i < pos.length; i++) {
			if(mouseX == pos[i][0] && mouseY == pos[i][1]){
				return true;
			}
		}
		return false;
	}


	

	
}
