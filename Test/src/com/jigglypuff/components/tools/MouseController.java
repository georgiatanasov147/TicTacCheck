package com.jigglypuff.components.tools;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.components.AbstractPiece;
import com.jigglypuff.globals.StaticObjects;

public class MouseController implements MouseMotionListener, MouseListener{


	private AbstractPiece p = null;
	
	public Point currentPoint(MouseEvent e){
		Point p = e.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(p, StaticObjects.panel);
		return p;
	}
	
	public boolean isOnPiece(Point b, AbstractPiece piece) {
		int mouse_x = (int) b.getX();
		int mouse_y = (int) b.getY();
		int iX = piece.getImageX();
		int iY = piece.getImageY();
		
		if (mouse_x > iX && mouse_y > iY && mouse_x < (iX + StaticObjects.X)
				&& mouse_y < (iY + StaticObjects.Y)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		for (AbstractPiece piece: StaticObjects.pieces) {
			if (isOnPiece(currentPoint(e),piece)) {
				p = piece;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (p != null) {
			p.fixPosition(e.getX()-StaticObjects.SL/2, e.getY()-StaticObjects.SL/2);
			StaticObjects.panel.repaint();
		}
		p = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(p!=null){
			p.setImageX(e.getX()-StaticObjects.SL/2);
			p.setImageY(e.getY()-StaticObjects.SL/2);
			StaticObjects.panel.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
