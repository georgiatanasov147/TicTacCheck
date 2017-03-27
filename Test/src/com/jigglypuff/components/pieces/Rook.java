package com.jigglypuff.components.pieces;

import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Rook extends AbstractPiece{

	public Rook(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin+3*StaticObjects.SL);
		setType(Type.ROOK);
	}

	
}
