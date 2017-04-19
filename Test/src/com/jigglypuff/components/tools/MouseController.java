package com.jigglypuff.components.tools;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;
import com.jigglypuff.components.Piece;
import com.jigglypuff.globals.StaticObjects;

public class MouseController implements MouseMotionListener, MouseListener{


	private Piece p = null;
	
	public Point currentPoint(MouseEvent e){
		Point p = e.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(p, StaticObjects.panel);
		return p;
	}
	
	public boolean isOnPiece(Point b, Piece piece) {
		int mousePointerX = (int) b.getX();
		int mousePointerY = (int) b.getY();
		int imageX = piece.getImageX();
		int imageY = piece.getImageY();
		
		if (mousePointerX > imageX 
				&& mousePointerY > imageY 
				&& mousePointerX < (imageX + StaticObjects.X)
				&& mousePointerY < (imageY + StaticObjects.Y) ) {
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

		for (Piece piece: StaticObjects.pieces) {
			if (isOnPiece(currentPoint(e),piece)) {
				p = piece;
				StaticObjects.flag=true;
				StaticObjects.piece_index = StaticObjects.pieces.indexOf(piece);
				StaticObjects.panel.repaint();
			}
		}
	}

	/*
	 * When mouse is released, i.e. when we've finished moving our piece,
	 * we snap the piece's position to the board grid by calling fixPosition(),
	 * repaint, set piece_index to the arbitrary value 10 and set 
	 * position_switch to 1, meaning 'I've stopped moving pieces now.'
	 */
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (p != null) {
			p.fixPosition((int)currentPoint(e).getX(),(int)currentPoint(e).getY());
			StaticObjects.panel.repaint();
		}
		p = null;
		StaticObjects.piece_index=10;
		StaticObjects.position_switch = 1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * When the mouse is dragged, centre the piece's image to the mouse pointer,
	 * hence SquareLength - SL divided by 2.
	 */
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(p!=null){
			p.setImageX((int)currentPoint(e).getX()-StaticObjects.SL/2);
			p.setImageY((int)currentPoint(e).getY()-StaticObjects.SL/2);
			StaticObjects.panel.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
