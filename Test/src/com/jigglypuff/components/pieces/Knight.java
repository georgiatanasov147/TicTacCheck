package com.jigglypuff.components.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.components.Color;
import com.jigglypuff.components.Type;
import com.jigglypuff.globals.StaticObjects;

public class Knight extends AbstractPiece{


	public Knight(String imageFile,Color color) {
		super(imageFile,color,StaticObjects.begin+StaticObjects.SL);
		setType(Type.KNIGHT);

	}

	
}
