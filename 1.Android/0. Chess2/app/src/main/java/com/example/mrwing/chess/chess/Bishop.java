package com.example.mrwing.chess.chess;

import com.example.mrwing.chess.ChessView;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by osj45 on 2018-12-05.
 */

public class Bishop extends Square{

    private int x, y;
    private ArrayList<ArrayList<Integer>> attackPath;
    private ArrayList<ArrayList<Integer>> movePath;
    private ArrayList<ArrayList<Integer>> checkPath;

    public Bishop(String color, int y, int x) {
        super(color, "bishop");

        if(color == "white"){
            setSymbol("WBi");
        }
        else{
            setSymbol("BBi");
        }
        this.x = x;
        this.y = y;
        setValue(3);
    }

    public boolean moveCheck(int[] from, int[] to, String plyColor, boolean afterMoveCheck) {

        int fromX = from[0];
        int fromY = from[1];
        int toX = to[0];
        int toY = to[1];

        int moveDistance = Math.abs(toX - fromX);

        if(afterMoveCheck){
            return false;
        }

        String direction; //방향

        if(toX > fromX){
            if(toY < fromY){
                direction = "topRite";
            }
            else{
                direction = "botRite";
            }
        }
        else{
            if(toY < fromY){
                direction = "topLeft";
            }
            else{
                direction = "botLeft";
            }
        }


        Square testSquare;
        int compairX = 9, compairY = 9;

        for(int diagMoveAway = 1; diagMoveAway <= moveDistance; diagMoveAway++){

            if(direction == "topRite"){
                testSquare = ChessView.board[fromY - diagMoveAway][fromX + diagMoveAway];
                if(diagMoveAway == moveDistance) {
                    compairX = fromX + diagMoveAway;
                    compairY = fromY - diagMoveAway;
                }
            }
            else if(direction == "botRite"){
                testSquare = ChessView.board[fromY + diagMoveAway][fromX + diagMoveAway];
                if(diagMoveAway == moveDistance) {
                    compairX = fromX + diagMoveAway;
                    compairY = fromY + diagMoveAway;
                }
            }
            else if(direction == "topLeft"){
                testSquare = ChessView.board[fromY - diagMoveAway][fromX - diagMoveAway];
                if(diagMoveAway == moveDistance) {
                    compairX = fromX - diagMoveAway;
                    compairY = fromY - diagMoveAway;
                }
            }
            else{ //botLeft
                testSquare = ChessView.board[fromY + diagMoveAway][fromX - diagMoveAway];
                if(diagMoveAway == moveDistance) {
                    compairX = fromX - diagMoveAway;
                    compairY = fromY + diagMoveAway;
                }
            }

            if((testSquare.getType() != "none") && (diagMoveAway != moveDistance)){
                return false;
            }
            else if(((toX == compairX) && (toY == compairY)) && ((testSquare.getColor() != plyColor) || (testSquare.getType() == "none"))){
                y = toY;
                x = toX;
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<ArrayList<Integer>> attackPathCheck() {
        attackPath = new ArrayList<ArrayList<Integer>>();
        if(this.getColor() == "white") {
            //북서
            int j = x - 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "BKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j--;
            }
            //북동
            j = x + 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "BKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j++;
            }
            //남서
            j = x - 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "BKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j--;
            }
            //남동
            j = x + 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "BKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j++;
            }
        }else if(this.getColor() == "black") {
            //북서
            int j = x - 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "WKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j--;
            }
            //북동
            j = x + 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "WKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j++;
            }
            //남서
            j = x - 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "WKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j--;
            }
            //남동
            j = x + 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                attackPath.add(tmp);
                if(ChessView.board[i][i].getSymbol() != "WKi") {
                    if(ChessView.board[i][j].getType() != "none") {
                        break;
                    }
                }
                j++;
            }
        }
        return attackPath;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public ArrayList<ArrayList<Integer>> movePathCheck() {
        movePath = new ArrayList<ArrayList<Integer>>();
        if(this.getColor() == "white") {
            //북서
            int j = x - 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j--;
            }
            //북동
            j = x + 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));

                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j++;
            }
            //남서
            j = x - 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));

                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j--;
            }
            //남동
            j = x + 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j++;
            }
        }else if(this.getColor() == "black") {
            //북서
            int j = x - 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));

                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j--;
            }
            //북동
            j = x + 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));

                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j++;
            }
            //남서
            j = x - 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));

                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j--;
            }
            //남동
            j = x + 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                if(ChessView.board[i][j].getType() != "none") {
                    break;
                }
                movePath.add(tmp);
                j++;
            }
        }
        return movePath;
    }

    @Override
    public ArrayList<ArrayList<Integer>> checkPathCheck() {
        checkPath = new ArrayList<ArrayList<Integer>>();
        if(this.getColor() == "white") {
            //북서
            int j = x - 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "BKi") {
                    return checkPath;
                }
                j--;
            }
            //북동
            j = x + 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "BKi") {
                    return checkPath;
                }
                j++;
            }
            //남서
            j = x - 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "BKi") {
                    return checkPath;
                }
                j--;
            }
            //남동
            j = x + 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "BKi") {
                    return checkPath;
                }
                j++;
            }
        }else if(this.getColor() == "black") {
            //북서
            int j = x - 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "WKi") {
                    return checkPath;
                }
                j--;
            }
            //북동
            j = x + 1;
            for(int i = y - 1; i >= 0; i--) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "WKi") {
                    return checkPath;
                }
                j++;
            }
            //남서
            j = x - 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j<0) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "WKi") {
                    return checkPath;
                }
                j--;
            }
            //남동
            j = x + 1;
            for(int i = y + 1; i <= 7; i++) {
                if(j>7) break;
                ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
                checkPath.add(tmp);
                if(ChessView.board[i][j].getSymbol() == "WKi") {
                    return checkPath;
                }
                j++;
            }
        }
        return null;
    }

    public ArrayList<ArrayList<Integer>> aiPath(){
        ArrayList<ArrayList<Integer>> aiPath = new ArrayList<ArrayList<Integer>>();
        //북서
        int j = x - 1;
        for(int i = y - 1; i >= 0; i--) {
            if(j<0) break;
            ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
            if(ChessView.board[i][j].getColor() == getColor())  break;
            if(ChessView.board[i][j].getColor() != getColor()) {
                aiPath.add(tmp);
                if(ChessView.board[i][j].getColor() != "none") break;
            }
            j--;
        }
        //북동
        j = x + 1;
        for(int i = y - 1; i >= 0; i--) {
            if(j>7) break;
            ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
            if(ChessView.board[i][j].getColor() == getColor())  break;
            if(ChessView.board[i][j].getColor() != getColor()) {
                aiPath.add(tmp);
                if(ChessView.board[i][j].getColor() != "none") break;
            }
            j++;
        }
        //남서
        j = x - 1;
        for(int i = y + 1; i <= 7; i++) {
            if(j<0) break;
            ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
            if(ChessView.board[i][j].getColor() == getColor())  break;
            if(ChessView.board[i][j].getColor() != getColor()) {
                aiPath.add(tmp);
                if(ChessView.board[i][j].getColor() != "none") break;
            }
            j--;
        }
        //남동
        j = x + 1;
        for(int i = y + 1; i <= 7; i++) {
            if(j>7) break;
            ArrayList<Integer> tmp = new ArrayList<Integer>(Arrays.asList(i, j));
            if(ChessView.board[i][j].getColor() == getColor())  break;
            if(ChessView.board[i][j].getColor() != getColor()) {
                aiPath.add(tmp);
                if(ChessView.board[i][j].getColor() != "none") break;
            }
            j++;
        }

        int kY = -1, kX = -1;
        if(this.getColor() == "white"){
            kY = ChessView.wKYX.get(0); kX = ChessView.wKYX.get(1);
        }else{
            kY = ChessView.bKYX.get(0); kX = ChessView.bKYX.get(1);
        }

        if(ChessView.board[kY][kX].isCheck()){
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            if(aiPath.contains(ChessView.checker)){
                aiPath.clear();
                aiPath.add(new ArrayList<Integer>(Arrays.asList(ChessView.checker[0],ChessView.checker[1])));
            }else{
                for(int i = 0; i < ChessView.afterAmdPath.size(); i++){
                    if(aiPath.contains(ChessView.afterAmdPath.get(i))){
                        tmp.add(ChessView.afterAmdPath.get(i));
                    }
                }
            }
            aiPath.clear();
            aiPath.addAll(tmp);
        }

        return aiPath;
    }
}
