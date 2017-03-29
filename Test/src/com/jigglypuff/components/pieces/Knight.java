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

	
	public Knight(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin+StaticObjects.SL);
		setType(Type.KNIGHT);
		
	}
	@Override
	public void initPos(){
		pos[0][0] = getImageX()-StaticObjects.SL*2;
		pos[0][1] = getImageY()-StaticObjects.SL;
		
		pos[1][0] = getImageX()-StaticObjects.SL;
		pos[1][1] = getImageY()-StaticObjects.SL*2;
		
		pos[2][0] = getImageX()+StaticObjects.SL;
		pos[2][1] = getImageY()-StaticObjects.SL*2;
		
		pos[3][0] = getImageX()+StaticObjects.SL*2;
		pos[3][1] = getImageY()-StaticObjects.SL;
		
		pos[4][0] = getImageX()-StaticObjects.SL*2;
		pos[4][1] = getImageY()+StaticObjects.SL;
		
		pos[5][0] = getImageX()-StaticObjects.SL;
		pos[5][1] = getImageY()+StaticObjects.SL*2;
		
		pos[6][0] = getImageX()+StaticObjects.SL*2;
		pos[6][1] = getImageY()+StaticObjects.SL;
		
		pos[7][0] = getImageX()+StaticObjects.SL;
		pos[7][1] = getImageY()+StaticObjects.SL*2;
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
	
}
