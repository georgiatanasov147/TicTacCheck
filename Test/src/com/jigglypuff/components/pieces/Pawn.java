package com.jigglypuff.components.pieces;

import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Pawn extends AbstractPiece{

	public Pawn(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin+2*StaticObjects.SL);
		setType(Type.PAWN);
	}
}
