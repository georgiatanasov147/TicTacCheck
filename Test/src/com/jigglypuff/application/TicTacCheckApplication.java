package com.jigglypuff.application;

import com.jigglypuff.globals.StaticObjects;

public class TicTacCheckApplication {

	public static void main(String[] args) {
		System.out.println("Another one... I mean, git push.");
		String word = StaticObjects.input.nextLine();
		for (int i = 0; i < 4; i++)
		{
			System.out.println(i+word);
		}//for
		
		function();
		
	}//main
	
	public static void function()
	{
		System.out.println("Naaaaaa Sivaniaaaaa I have no ideaaaaa...");
	}//function
	
}//class TicTacCheckApplication
