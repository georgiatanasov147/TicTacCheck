package com.jigglypuff.components.tools;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.jigglypuff.components.Color;
import com.jigglypuff.components.Piece;
import com.jigglypuff.globals.StaticObjects;

public class MouseController implements MouseMotionListener, MouseListener{


	private Piece p = null;
	private boolean turn = true;
	public Point currentPoint(MouseEvent e){
		Point p = e.getLocationOnScreen();
		SwingUtilities.convertPointFromScreen(p, StaticObjects.panel);
		return p;
	}
	
	public boolean isOnPiece(Point b, Piece piece) {
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

		for (Piece piece: StaticObjects.pieces) {
			if (isOnPiece(currentPoint(e),piece)) {
				if(turn && piece.getColor().equals(Color.WHITE)){
					p = piece;
					StaticObjects.flag=true;
					StaticObjects.piece_index = StaticObjects.pieces.indexOf(piece);
					StaticObjects.panel.repaint();

				}else if(!turn && piece.getColor().equals(Color.BLACK)){
					p = piece;
					StaticObjects.flag=true;
					StaticObjects.piece_index = StaticObjects.pieces.indexOf(piece);
					StaticObjects.panel.repaint();

				}else{
					p = null;
				}
				
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (p != null) {
			p.fixPosition((int)currentPoint(e).getX(),(int)currentPoint(e).getY());
			if(p.isChanged()){
				turn = !turn;
			}
			System.out.println("Changed: "+p.isChanged());
			StaticObjects.panel.repaint();
			
		}
		p = null;
		StaticObjects.piece_index=10;
		StaticObjects.position_switch = 1;
		StaticObjects.board.paintMap();

		int winner = StaticObjects.board.checkEndGame();
		if(winner == 1){
			JOptionPane.showMessageDialog(null, "White is victorious!");
			StaticObjects.mf.dispose();
		}else if(winner == 2){
			JOptionPane.showMessageDialog(null, "Black is victorious!");
			StaticObjects.mf.dispose();
		}
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
