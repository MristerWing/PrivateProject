package com.example.mrwing.chess.chess;

import android.util.Log;

import com.example.mrwing.chess.ChessBoard;
import com.example.mrwing.chess.ChessView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AlphaBetaPlayer extends Player {
    MinimaxAlphaBeta minimax;
    private String color;
    public AlphaBetaPlayer(String color, int maxDepth) {
        super("A.I", color);
        this.color = color;
        minimax = new MinimaxAlphaBeta(color, maxDepth);
    }


    public int[][] getMove(ChessView b){
        int[][] moves = new int[2][2];

        ArrayList<Integer> move = minimax.decision(b);
        ArrayList<ArrayList<Integer>> random = new ArrayList<ArrayList<Integer>>();
        if(move == null) {
            if (color.equals("black")) {
                ChessBoard.setPlayerTurn(color + " A.I's Give up Game");
                ChessView.endGame = true;
            } else {
                ChessBoard.setPlayerTurn(color + " A.I's Give up Game");
                ChessView.endGame = true;
            }
        }else {
            moves[1][0] = move.get(1);
            moves[1][1] = move.get(0);
        }

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(b.board[i][j].getColor().equals(color)) {
                    if(b.board[i][j].aiPath().contains(move)) {
                        ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(j,i));
                        random.add(temp);
                    }
                }
            }
        }
        Random rad = new Random();
        if(random.size() != 0) {
            int de = rad.nextInt(random.size());
            moves[0][0] = random.get(de).get(0);
            moves[0][1] = random.get(de).get(1);
        }
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                System.out.println(moves[j][i]);
        return moves;
    }
}