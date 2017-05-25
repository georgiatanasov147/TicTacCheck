package com.jigglypuff.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.RepaintManager;
import com.jigglypuff.application.TicTacCheckApplication;
import com.jigglypuff.components.pieces.Knight;
import com.jigglypuff.globals.StaticObjects;

public abstract class Piece {
	protected Image image;
	protected int imageWidth = StaticObjects.X, imageHeight = StaticObjects.Y;
	protected int imageX, imageY, initX, initY, oldX, oldY;
	protected Type type;
	protected Color color;
	protected Image cross;
	
	public Piece(String imageFile,Color color,int x) {
		image = Toolkit.getDefaultToolkit().getImage(TicTacCheckApplication.class.getResource(imageFile));
		image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
		cross = Toolkit.getDefaultToolkit().getImage(Piece.class.getResource("../application/images/cross.png"));
		cross = cross.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
		setColor(color);
		setInitialXY(x);
		addToList();
	}
	
	
	public abstract boolean moveIsValid(int newX, int newY);
	public abstract void paintPositions(Graphics g);
	public abstract void initPos();
	

	public boolean isOnBoard()
	{
		if(getOldX() == getInitX() && getOldY() == getInitY())
			return false;
		else
			return true;
	}

	private void setInitialXY(int x){
		setImageX(x);
		if(getColor() == Color.WHITE){
			setImageY((StaticObjects.begin+ 4*StaticObjects.SL)+20);
		}else{
			setImageY((StaticObjects.begin - StaticObjects.SL)-20);
		}
		setInitX(getImageX());
		setInitY(getImageY());
		setOldX(getImageX());
		setOldY(getImageY());
	}
	
	public void goBack() {
		imageX = oldX;
		imageY = oldY;
	}
	
	public void restart() {
		imageX = initX;
		imageY = initY;
		oldX = initX;
		oldY = initY;
	}
	
	public void fixPosition(int mouseX, int mouseY) {
		int newX = getOldX(), newY = getOldY();
		
		for (int i = 0; i < StaticObjects.board.getBoard().length; i++) {
			if((mouseX >= StaticObjects.board.getBoard()[i][0])
			 && mouseX <= StaticObjects.board.getBoard()[i][2]
			 && mouseY >= StaticObjects.board.getBoard()[i][1]
			 && mouseY <= StaticObjects.board.getBoard()[i][3]) 
			{
				newX = StaticObjects.board.getBoard()[i][0];
				newY = StaticObjects.board.getBoard()[i][1];
				break;
			}
			
		}
		if(isOnBoard()){
			if(!moveIsValid(newX,newY)){
				goBack();
				return;
			}
		}
		
		
		boolean permission = checkForOtherPieces(newX, newY);
		if(permission){
			imageX = newX;
			imageY = newY;
			oldX = newX;
			oldY = newY;
		}else{
			goBack();
		}
	}
	
	public boolean checkValidPosition(int newX, int newY){
		//checks if the piece has moved as it should
		return true;
	}
	
	
	public void addToList(){
		StaticObjects.pieces.add(this);
	}
	
	public boolean checkForOtherPieces(int newX,int newY){
		for (Piece piece:StaticObjects.pieces) {
			if(piece.getImageX()==newX && piece.getImageY()==newY){
				if(isOnBoard()){
					if(piece.getColor() != getColor()){
						piece.restart();
						return true;
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	//getters and setters ->
	
	public Type getType()
	{
		return type;
	}

	
	public void setType(Type type)
	{
		this.type = type;
	}

	
	public Color getColor()
	{
		return color;
	}

	
	public void setColor(Color color)
	{
		this.color = color;
	}
	

	public Image getImage()
	{
		return image;
	}
	
	
	public void setImage(Image image)
	{
		this.image = image;
	}
	
	
	public int getImageWidth()
	{
		return imageWidth;
	}
	
	
	public void setImageWidth(int imageWidth)
	{
		this.imageWidth = imageWidth;
	}
	
	
	public int getImageHeight()
	{
		return imageHeight;
	}
	
	
	public void setImageHeight(int imageHeight)
	{
		this.imageHeight = imageHeight;
	}
	
	
	public int getImageX()
	{
		return imageX;
	}
	
	
	public void setImageX(int imageX)
	{
		this.imageX = imageX;
	}
	
	
	public int getImageY()
	{
		return imageY;
	}
	
	
	public void setImageY(int imageY)
	{
		this.imageY = imageY;
	}
	
	
	public int getInitX()
	{
		return initX;
	}
	
	
	public void setInitX(int initX)
	{
		this.initX = initX;
	}
	
	
	public int getInitY()
	{
		return initY;
	}
	
	
	public void setInitY(int initY)
	{
		this.initY = initY;
	}
	
	
	public int getOldX()
	{
		return oldX;
	}
	
	
	public void setOldX(int oldX)
	{
		this.oldX = oldX;
	}
	
	
	public int getOldY()
	{
		return oldY;
	}
	
	
	public void setOldY(int oldY)
	{
		this.oldY = oldY;
	}


}
