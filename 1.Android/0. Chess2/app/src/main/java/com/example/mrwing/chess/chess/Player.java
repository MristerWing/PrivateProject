package com.example.mrwing.chess.chess;

import com.example.mrwing.chess.ChessView;

public class Player {
	
	private String name;
	private String color;
	
	public Player(String nameIn, String colorIn){
		name = nameIn;
		color = colorIn;
	}
	
	public int[][] getMove(ChessView b){ //x와 y의 배열을 리턴해주는 함수  이 걸로 움직일수 있다.
		int[][] move = new int[2][2];
		return move;
	}

	public String getName() {
		return  name;
	}
}
