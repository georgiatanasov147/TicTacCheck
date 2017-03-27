package com.jigglypuff.components.tools;

import java.awt.Graphics;

import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.globals.StaticObjects;

public class PaintingThread extends Thread{
	
	private AbstractPiece piece;
	private Graphics g;
	
	public PaintingThread(AbstractPiece piece,Graphics g) {
		this.piece=piece;
		this.g=g;
	}
	
	@Override
	public void run() {
		paintImage();
	}
	
	public synchronized void paintImage(){
		g.drawImage(piece.getImage(), piece.getImageX(), piece.getImageY(), StaticObjects.panel);
	}
	
	
}
