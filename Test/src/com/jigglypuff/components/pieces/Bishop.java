package com.jigglypuff.components.pieces;

import java.awt.Graphics;

import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Bishop extends AbstractPiece{

	public Bishop(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin);
		setType(Type.BISHOP);
		
	}
	
}
