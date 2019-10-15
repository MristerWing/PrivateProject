package com.example.mrwing.chess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.mrwing.chess.chess.AlphaBetaPlayer;
import com.example.mrwing.chess.chess.Bishop;
import com.example.mrwing.chess.chess.BlankSpace;
import com.example.mrwing.chess.chess.King;
import com.example.mrwing.chess.chess.Knight;
import com.example.mrwing.chess.chess.Pawn;
import com.example.mrwing.chess.chess.Queen;
import com.example.mrwing.chess.chess.Rook;
import com.example.mrwing.chess.chess.Square;
import com.example.mrwing.chess.chess.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessView extends View implements View.OnTouchListener {

    //디바이스의 너비
    private int width;

    //왕 위치
    public static ArrayList<Integer> wKYX = null;
    public static ArrayList<Integer> bKYX = null;

    //나이트 위치
    public static ArrayList<Integer> wNYX = null;
    public static ArrayList<Integer> bNYX = null;

    //Players
    private static Player whitePlayer;
    private static Player blackPlayer;

    //막을 수 있는지 여부
    private boolean canBlock = false;

    //모든 말의 공격경로
    public static ArrayList<ArrayList<Integer>> allWAttackPath = null;
    public static ArrayList<ArrayList<Integer>> allBAttackPath = null;

    //AI구동용 배열
    public static ArrayList<ArrayList<Integer>> allW = null;
    public static ArrayList<ArrayList<Integer>> allB = null;
    private static int aiMoves[][] = new int[0][];

    //공격자 위치
    public static int[] checker = {9, 9};

    //afterMoveDanger확인용 Path
    public static List<ArrayList<Integer>> afterAmdPath = new ArrayList<ArrayList<Integer>>();

    public static List<ArrayList<Integer>> wKAiPath = new ArrayList<ArrayList<Integer>>();
    public static List<ArrayList<Integer>> bKAiPath = new ArrayList<ArrayList<Integer>>();

    private boolean firstDraw = true; //처음 그리기 플래그
    private boolean chooseSet = false; //선택확인 플래그
    private boolean moveSet = false; //움직일 말 플래그
    private boolean updateFlag = false; //onDraw플레그
    private boolean checking = false; //체크 플래그
    private boolean afterSet = false; //amd이후 확인 플래그
    public static boolean endGame = false;

    //선택된 말의 위치
    private int chooseX = 9;
    private int chooseY = 9;

    //좌표
    public static Square[][] board = new Square[8][8];
    private int[][] boardPoint = new int[8][8];
    private int[] boardPointY = new int[8];

    //board
    Bitmap boardPiece2;
    Bitmap boardPiece1;

    //black piece
    Bitmap blackRook;
    Bitmap blackKnight;
    Bitmap blackBishop;
    Bitmap blackQueen;
    Bitmap blackKing;
    Bitmap blackPawn;

    //플레이어 순서, true = white / false = black
    private String playerTurn = "white";

    //white piece
    Bitmap whiteRook;
    Bitmap whiteKnight;
    Bitmap whiteBishop;
    Bitmap whiteQueen;
    Bitmap whiteKing;
    Bitmap whitePawn;

    //생성자
    public ChessView(Context context, int width, String p1, String p2) {
        super(context);
        this.width = width;
        int pieceSize = width / 8;

        if(p1.equals("A.I")) {
            whitePlayer = new AlphaBetaPlayer("white", 1);
        }else {
            whitePlayer = new Player(p1, "white");
        }

        if(p2.equals("A.I")) {
            blackPlayer = new AlphaBetaPlayer("black", 1);
        }else {
            blackPlayer = new Player(p2, "black");
        }


        //보드를 백그라운드로 설정
        boardPiece2 = BitmapFactory.decodeResource(getResources(),R.drawable.square_brown_dark_png_shadow);
        boardPiece2 = Bitmap.createScaledBitmap(boardPiece2, width / 8, width / 8, false);
        boardPiece1 = BitmapFactory.decodeResource(getResources(),R.drawable.square_brown_light_png_shadow);
        boardPiece1 = Bitmap.createScaledBitmap(boardPiece1, width / 8, width / 8, false);

        //검은색 말
        blackRook = BitmapFactory.decodeResource(getResources(),R.drawable.b_rook_png_shadow_128px);
        blackRook = Bitmap.createScaledBitmap(blackRook, pieceSize, pieceSize, false);
        blackKnight = BitmapFactory.decodeResource(getResources(),R.drawable.b_knight_png_shadow_128px);
        blackKnight = Bitmap.createScaledBitmap(blackKnight, pieceSize, pieceSize, false);
        blackBishop = BitmapFactory.decodeResource(getResources(),R.drawable.b_bishop_png_shadow_128px);
        blackBishop = Bitmap.createScaledBitmap(blackBishop,pieceSize , pieceSize, false);
        blackQueen = BitmapFactory.decodeResource(getResources(),R.drawable.b_queen_png_shadow_128px);
        blackQueen = Bitmap.createScaledBitmap(blackQueen, pieceSize, pieceSize, false);
        blackKing = BitmapFactory.decodeResource(getResources(),R.drawable.b_king_png_shadow_128px);
        blackKing = Bitmap.createScaledBitmap(blackKing, pieceSize, pieceSize, false);
        blackPawn = BitmapFactory.decodeResource(getResources(),R.drawable.b_pawn_png_shadow_128px);
        blackPawn = Bitmap.createScaledBitmap(blackPawn, pieceSize, pieceSize, false);

        //흰색말
        whiteRook = BitmapFactory.decodeResource(getResources(),R.drawable.w_rook_png_shadow_128px);
        whiteRook = Bitmap.createScaledBitmap(whiteRook, pieceSize, pieceSize, false);
        whiteKnight = BitmapFactory.decodeResource(getResources(),R.drawable.w_knight_png_shadow_128px);
        whiteKnight = Bitmap.createScaledBitmap(whiteKnight, pieceSize, pieceSize, false);
        whiteBishop = BitmapFactory.decodeResource(getResources(),R.drawable.w_bishop_png_shadow_128px);
        whiteBishop = Bitmap.createScaledBitmap(whiteBishop, pieceSize, pieceSize, false);
        whiteQueen = BitmapFactory.decodeResource(getResources(),R.drawable.w_queen_png_shadow_128px);
        whiteQueen = Bitmap.createScaledBitmap(whiteQueen, pieceSize, pieceSize, false);
        whiteKing = BitmapFactory.decodeResource(getResources(),R.drawable.w_king_png_shadow_128px);
        whiteKing = Bitmap.createScaledBitmap(whiteKing, pieceSize, pieceSize, false);
        whitePawn = BitmapFactory.decodeResource(getResources(),R.drawable.w_pawn_png_shadow_128px);
        whitePawn = Bitmap.createScaledBitmap(whitePawn, pieceSize, pieceSize, false);

        setFocusable(true);
        this.setOnTouchListener(this);
    }

    //보드 그리기
    private Bitmap backgroundBit() {
        int bcount = 1;
        int x = 0;
        int y = 0;
        Bitmap bit = Bitmap.createScaledBitmap(boardPiece2 ,width, width, true);
        Canvas bgCanvas = new Canvas(bit);
        for (int i = 0; i < width; i += (width / 8)) {
            for (int j = 0; j < width; j += (width / 4)) {
                if (bcount % 2 != 0) {
                    //판그리기
                    bgCanvas.drawBitmap(boardPiece1, j, i, null);
                    bgCanvas.drawBitmap(boardPiece2, (j + width / 8), i, null);
                }
                else if(bcount % 2 == 0) {
                    bgCanvas.drawBitmap(boardPiece2, j, i, null);
                    bgCanvas.drawBitmap(boardPiece1, (j + width / 8), i, null);
                }
                if(firstDraw) {
                    board[y][x] = new BlankSpace();
                    board[y][x + 1] = new BlankSpace();
                    boardPoint[y][x] = j;
                    boardPoint[y][x + 1] = j + width / 8;
                }
                x += 2;
            }
            if(firstDraw) boardPointY[y] = i;
            x = 0;
            y++;
            bcount++;
        }
        return bit;
    }

    //초기 말 배치
    private void drawFirstPiece() { //Canvas canvas, Paint paint
        int count = 1;
        int pieceSetCount = 0;
        int x = 0;
        int y = 0;
        int pieceSize = width / 8 ;
        for (int i = 0; i < width; i += (width / 8)) {
            for (int j = 0; j < width; j += (width / 4)) {
                switch (count) {
                    case 1: //검은색 특수 말 배치
                        switch (pieceSetCount) {
                            case 0: //Rook, Knight
                                board[y][0] = new Rook("black", 0, 0);
                                board[y][1] = new Knight("black", 0, 1);
                                break;
                            case 1: //Bishop, Queen
                                board[y][2] = new Bishop("black", 0, 2);
                                board[y][3] = new Queen("black", 0, 3);
                                break;
                            case 2: //King, Bishop
                                board[y][4] = new King("black", 0, 4);
                                bKYX = new ArrayList<Integer>(Arrays.asList(y, 4));
                                board[y][5] = new Bishop("black", 0, 5);
                                break;
                            case 3: //Knight, Rook
                                board[y][6] = new Knight("black", 0, 6);
                                board[y][7] = new Rook("black", 0, 7);
                                break;
                        }
                        break;
                    case 2: //검은색 폰 배치
                        board[y][x] = new Pawn("black", y, x);
                        board[y][x + 1] = new Pawn("black", y, x + 1);
                        break;
                    case 7: //흰색 폰 배치
                        board[y][x] = new Pawn("white", y, x);
                        board[y][x + 1] = new Pawn("white", y, x + 1);
                        break;
                    case 8: //흰색 특수 말 배치
                        switch (pieceSetCount) {
                            case 0: //Rook, Knight
                                board[y][x] = new Rook("white", y, x);
                                board[y][x + 1] = new Knight("white", y, x + 1);
                                break;
                            case 1: //Bishop, Queen
                                board[y][x] = new Bishop("white", y, x);
                                board[y][x + 1] = new Queen("white", y, x + 1);
                                break;
                            case 2: //King, Bishop
                                board[y][x] = new King("white", y, x);
                                board[y][x + 1] = new Bishop("white", y, x + 1);
                                wKYX = new ArrayList<Integer>(Arrays.asList(y, x));
                                break;
                            case 3: //Knight, Rook
                                board[y][x] = new Knight("white", y, x);
                                board[y][x + 1] = new Rook("white", y, x + 1);
                                break;
                        }
                        break;
                }
                pieceSetCount++;
                x += 2;
            }
            x = 0;
            y++;
            pieceSetCount = 0;
            count++;
        }
    }

    //보드 업데이트
    private void updateBoard(Canvas canvas, Paint paint) {
        int y = 0;
        int x = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if (!board[i][j].getType().equals("none")) {
                    //Black
                    if(board[i][j].getColor().equals("black")) {
                        y = boardPointY[i];
                        x = boardPoint[i][j];
                        switch (board[i][j].getType()) {
                            case "pawn":
                                canvas.drawBitmap(blackPawn, x, y, paint);
                                break;
                            case "rook":
                                canvas.drawBitmap(blackRook, x, y, paint);
                                break;
                            case "knight":
                                canvas.drawBitmap(blackKnight, x, y, paint);
                                break;
                            case "queen":
                                canvas.drawBitmap(blackQueen, x, y, paint);
                                break;
                            case "bishop":
                                canvas.drawBitmap(blackBishop, x, y, paint);
                                break;
                            case "king":
                                canvas.drawBitmap(blackKing, x, y, paint);
                                break;
                        }
                    }

                    //white
                    else if(board[i][j].getColor().equals("white")) {
                        y = boardPointY[i];
                        x = boardPoint[i][j];
                        switch (board[i][j].getType()) {
                            case "pawn":
                                canvas.drawBitmap(whitePawn, x, y, paint);
                                break;
                            case "rook":
                                canvas.drawBitmap(whiteRook, x, y, paint);
                                break;
                            case "knight":
                                canvas.drawBitmap(whiteKnight, x, y, paint);
                                break;
                            case "queen":
                                canvas.drawBitmap(whiteQueen, x, y, paint);
                                break;
                            case "bishop":
                                canvas.drawBitmap(whiteBishop, x, y, paint);
                                break;
                            case "king":
                                canvas.drawBitmap(whiteKing, x, y, paint);
                                break;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        Paint choosePaint = new Paint();

        //이동할 위치
        int moveX = 9;
        int moveY = 9;

        //공격 가능 위치
        int attackX = 9;
        int attackY = 9;

        //배경그리기
        canvas.drawBitmap(backgroundBit(), 0, 0, paint);
        if(!firstDraw && !stalemate() && checkmate() == 0) ChessBoard.setPlayerTurn(playerTurn + "'s turn");

        //최초배치
        if(firstDraw) {
            endGame = false;
            ChessBoard.setPlayerTurn(playerTurn + "'s turn");
            drawFirstPiece(); //canvas, paint
            updateAttack();
            updateFlag = true;
            firstDraw = false;
        }

        int[] tmp = {chooseY, chooseX};
        afterMoveDanger(tmp, playerTurn);

        if((playerTurn.equals("white") && !whitePlayer.getName().equals("A.I")) || (playerTurn.equals("black") && !blackPlayer.getName().equals("A.I"))) {
            //선택(선택된 말)
            if (chooseSet) {
                choosePaint.setColor(Color.argb(227, 172, 15, 27));
                canvas.drawRect(boardPoint[chooseY][chooseX], boardPointY[chooseY], boardPoint[chooseY][chooseX] + width / 8, boardPointY[chooseY] + width / 8, choosePaint);
            }
        }else { //A.I 이동
            if(!chooseSet) {
                if(!moveSet) {
                    updateAttack();
                    check();
                }

                //체크일시 ai경로 조작

                //A.I가 존재할경우 이동경로를 계산
                //player1이(가) A.I일경우
                if(whitePlayer.getName().equals("A.I") && playerTurn.equals("white")) {
                    if(checking) {
                        ArrayList<ArrayList<Integer>> old_allW = new ArrayList<ArrayList<Integer>>();
                        boolean aicheck = false;
                        for(int i = 0; i < allW.size(); i++) {
                            aicheck = afterAmdPath.contains(allW.get(i));
                            if(aicheck) {
                                old_allW.add(allW.get(i));

                                if (allW.contains(new ArrayList<Integer>(Arrays.asList(checker[0], checker[1]))))
                                    old_allW.add(allW.get(i));
                            }
                        }
                        if(aicheck) old_allW.addAll(board[wKYX.get(0)][wKYX.get(1)].aiPath());
                        allW.clear();
                        allW.addAll(old_allW);

                        if(!aicheck) {
                            //King
                            allW.addAll(board[wKYX.get(0)][wKYX.get(1)].aiPath());
                            //Knight
                            for(int i = 0; i < board[wNYX.get(0)][wNYX.get(1)].aiPath().size(); i++) {
                                boolean notingOtherPieces = afterAmdPath.contains(board[wNYX.get(0)][wNYX.get(1)].aiPath().get(i));
                                if(notingOtherPieces) {
                                    allW.add(board[wNYX.get(0)][wNYX.get(1)].aiPath().get(i));
                                }
                            }
                        }
                    }
                    aiMoves = whitePlayer.getMove(this);
                }//player2이(가) A.I일경우
                if(blackPlayer.getName().equals("A.I") && playerTurn.equals("black")) {
                    if(checking) {
                        ArrayList<ArrayList<Integer>> old_allB = new ArrayList<ArrayList<Integer>>();
                        boolean aicheck = false;
                        for(int i = 0; i < allB.size(); i++) {
                            aicheck = afterAmdPath.contains(allB.get(i));
                            if(aicheck) {
                                old_allB.add(allB.get(i));
                                if (allB.contains(new ArrayList<Integer>(Arrays.asList(checker[0], checker[1]))))
                                    old_allB.add(allB.get(i));
                            }
                        }
                        if(aicheck) old_allB.addAll(board[bKYX.get(0)][bKYX.get(1)].aiPath());
                        allB.clear();
                        allB.addAll(old_allB);
                        if(!aicheck) {
                            //King
                            allB.addAll(board[bKYX.get(0)][bKYX.get(1)].aiPath());
                            //Knight
                            for(int i = 0; i < board[bNYX.get(0)][bNYX.get(1)].aiPath().size(); i++) {
                                boolean notingOtherPieces = afterAmdPath.contains(board[bNYX.get(0)][bNYX.get(1)].aiPath().get(i));
                                if(notingOtherPieces) {
                                    allB.add(board[bNYX.get(0)][bNYX.get(1)].aiPath().get(i));
                                }
                            }
                        }
                    }
                    aiMoves = blackPlayer.getMove(this);
                }

                //check check
                if (playerTurn.equals("white") && board[wKYX.get(0)][wKYX.get(1)].isCheck()) {
                    ChessBoard.setPlayerTurn(playerTurn + "'s Check!");
                }
                if (playerTurn.equals("black") && board[bKYX.get(0)][bKYX.get(1)].isCheck()) {
                    ChessBoard.setPlayerTurn(playerTurn + "'s Check!");
                }

                //Stalemate check
                if (stalemate()) {
                    ChessBoard.setPlayerTurn(playerTurn + "Stalemate!!");
                    endGame = true;
                    this.setOnTouchListener(null);
                    ChessBoard.gameOver();
                }

                //Checkmate check
                if (checkmate() == 1 && !canBlock) {
                    if (!canBlock) ChessBoard.setPlayerTurn(playerTurn + "'s Checkmate!!!");
                    endGame = true;
                    this.setOnTouchListener(null);
                    ChessBoard.gameOver();
                } else if (checkmate() == 2 && !canBlock) {
                    if (!canBlock) ChessBoard.setPlayerTurn(playerTurn + "'s Checkmate!!!");
                    endGame = true;
                    this.setOnTouchListener(null);
                    ChessBoard.gameOver();
                }



                if(!endGame) aiLutin(aiMoves[0]);
                if(chooseSet) moveSet = true;
            }
        }

        /////////////////////////////AI Setting End//////////////////////////////////////////////////////////////////////////////////////////////////////

        //갱신값
        if(updateFlag) {
            updateBoard(canvas, paint);
            if(whitePlayer.getName().equals("A.I") && blackPlayer.getName().equals("A.I")) SystemClock.sleep(500);
        }
        if(((playerTurn.equals("white") && !whitePlayer.getName().equals("A.I")) || (playerTurn.equals("black") && !blackPlayer.getName().equals("A.I")))) {

            //공격경로를 업데이트하여 공격자 탐색, 체크 여부 확인

            if ((playerTurn.equals("white") && !whitePlayer.getName().equals("A.I")) || (playerTurn.equals("black") && !blackPlayer.getName().equals("A.I"))) {
                if (!firstDraw) updateAttack();
                check();
            }
            //check check
            if (playerTurn.equals("white") && board[wKYX.get(0)][wKYX.get(1)].isCheck()) {
                ChessBoard.setPlayerTurn(playerTurn + "'s Check!");
            }
            if (playerTurn.equals("black") && board[bKYX.get(0)][bKYX.get(1)].isCheck()) {
                ChessBoard.setPlayerTurn(playerTurn + "'s Check!");
            }

            //Stalemate check
            if (stalemate()) {
                ChessBoard.setPlayerTurn(playerTurn + "Stalemate!!");
                endGame = true;
                this.setOnTouchListener(null);
                ChessBoard.gameOver();
            }

            //Checkmate check
            if (checkmate() == 1 && !canBlock) {
                if (!canBlock) ChessBoard.setPlayerTurn(playerTurn + "'s Checkmate!!!");
                endGame = true;
                this.setOnTouchListener(null);
                ChessBoard.gameOver();
            } else if (checkmate() == 2 && !canBlock) {
                if (!canBlock) ChessBoard.setPlayerTurn(playerTurn + "'s Checkmate!!!");
                endGame = true;
                this.setOnTouchListener(null);
                ChessBoard.gameOver();
            }

            ////////////////////////////////////////////Game End Check End/////////////////////////////////////////////////////////////////////////////

            //선택 (이동경로)
            if (chooseSet) {
                if (!board[chooseY][chooseX].getType().equals("none")) {
                    //이동경로 추가

                    //체크 당했을때
                    //선택한 말이 이동시 위험하여 한정된 경로만을 이동할 수 있을 경우
                    if (afterSet || checking) {
                        for (int i = 0; i < board[chooseY][chooseX].movePathCheck().size(); i++) {
                            boolean amdMoveCheck = afterAmdPath.contains(board[chooseY][chooseX].movePathCheck().get(i));
                            moveY = board[chooseY][chooseX].movePathCheck().get(i).get(0);
                            moveX = board[chooseY][chooseX].movePathCheck().get(i).get(1);
                            if (amdMoveCheck) {
                                choosePaint.setColor(Color.argb(110, 255, 175, 175));
                                canvas.drawRect(boardPoint[moveY][moveX], boardPointY[moveY], boardPoint[moveY][moveX] + width / 8, boardPointY[moveY] + width / 8, choosePaint);
                            }
                        }
                    }
                    //평상시 이동
                    else {
                        for (int indexCH = 0; indexCH < board[chooseY][chooseX].movePathCheck().size(); indexCH++) {
                            moveY = board[chooseY][chooseX].movePathCheck().get(indexCH).get(0);
                            moveX = board[chooseY][chooseX].movePathCheck().get(indexCH).get(1);

                            choosePaint.setColor(Color.argb(110, 255, 175, 175));
                            canvas.drawRect(boardPoint[moveY][moveX], boardPointY[moveY], boardPoint[moveY][moveX] + width / 8, boardPointY[moveY] + width / 8, choosePaint);
                        }
                    }

                    //공격경로 추가
                    for (int indexCH = 0; indexCH < board[chooseY][chooseX].attackPathCheck().size(); indexCH++) {
                        attackY = board[chooseY][chooseX].attackPathCheck().get(indexCH).get(0);
                        attackX = board[chooseY][chooseX].attackPathCheck().get(indexCH).get(1);

                        //체크시 공격자 외에는 공격 불가능
                        if (afterSet || checking) {
                            boolean amdMoveCheck = afterAmdPath.contains(board[chooseY][chooseX].attackPathCheck().get(indexCH));
                            if (amdMoveCheck) {
                                if(board[attackY][attackX].getColor().equals(playerTurn)) continue;
                                if(board[attackY][attackX].getType().equals("none")) continue;
                                choosePaint.setColor(Color.argb(110, 175, 175, 255));
                                canvas.drawRect(boardPoint[attackY][attackX], boardPointY[attackY], boardPoint[attackY][attackX] + width / 8, boardPointY[attackY] + width / 8, choosePaint);
                            }
                        }else {
                            //폰일경우 앙파상을 확인을 위해 그려줌
                            if (board[chooseY][chooseX].getType().equals("pawn")) {
                                choosePaint.setColor(Color.argb(110, 175, 175, 255));
                                if(board[chooseY][attackX].getEnpasant())
                                    canvas.drawRect(boardPoint[attackY][attackX], boardPointY[attackY], boardPoint[attackY][attackX] + width / 8, boardPointY[attackY] + width / 8, choosePaint);
                                if(!board[attackY][attackX].getType().equals("none"))
                                    canvas.drawRect(boardPoint[attackY][attackX], boardPointY[attackY], boardPoint[attackY][attackX] + width / 8, boardPointY[attackY] + width / 8, choosePaint);
                            } else if (!board[attackY][attackX].getType().equals("none") && !board[attackY][attackX].getColor().equals(playerTurn)) {
                                choosePaint.setColor(Color.argb(110, 175, 175, 255));
                                canvas.drawRect(boardPoint[attackY][attackX], boardPointY[attackY], boardPoint[attackY][attackX] + width / 8, boardPointY[attackY] + width / 8, choosePaint);
                            }
                        }
                    }

                    moveSet = true; //이동활성화
                }
            }
        }
        else {
            if(chooseSet) {
                if(!endGame)aiLutin(aiMoves[1]);
            }
        }
    }

    //판 업데이트
    private void update(int[] origLoc, int[] newLoc){
        board[newLoc[1]][newLoc[0]] = board[origLoc[1]][origLoc[0]];
        board[origLoc[1]][origLoc[0]] = new BlankSpace();
    }

    //공격 경로 갱신
    private void updateAttack() {

        allWAttackPath = new ArrayList<ArrayList<Integer>>();
        allBAttackPath = new ArrayList<ArrayList<Integer>>();
        allW = new ArrayList<ArrayList<Integer>>();
        allB = new ArrayList<ArrayList<Integer>>();

        allW.clear();
        allWAttackPath.clear();
        allB.clear();
        allBAttackPath.clear();
        wKAiPath.clear();
        bKAiPath.clear();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(!board[i][j].getType().equals("king")) {
                    if(board[i][j].getColor().equals("white")) {
                        allW.addAll(board[i][j].aiPath());
                        allWAttackPath.addAll(board[i][j].attackPathCheck());

                        //공격자 위치 탐색
                        for(int index = 0; index < board[i][j].attackPathCheck().size(); index++) {
                            if(board[i][j].attackPathCheck().get(index).equals(bKYX)) {
                                checker[0] = i;
                                checker[1] = j;
                            }
                        }
                    }
                    else if(board[i][j].getColor().equals("black")) {
                        allB.addAll(board[i][j].aiPath());
                        allBAttackPath.addAll(board[i][j].attackPathCheck());
                        //공격자 위치탐색
                        for(int index = 0; index < board[i][j].attackPathCheck().size(); index++) {
                            if(board[i][j].attackPathCheck().get(index).equals(wKYX)) {
                                checker[0] = i;
                                checker[1] = j;
                            }
                        }

                    }
                }
                else {
                    if(board[i][j].getColor().equals("white")) {
                        wKAiPath.addAll(board[i][j].aiPath());
                    }
                    else {
                        bKAiPath.addAll(board[i][j].aiPath());
                    }
                }
                if(whitePlayer.getName().equals("A.I") && !board[i][j].getType().equals("null")) {
                    board[i][j].movePathCheck();
                }
            }
        }
    }

    //체크
    private void check() {
        int count = 0;
        int checkerIndex = 0;

        ArrayList<ArrayList<Integer>> checkerRange = null;
        ArrayList<Integer> tmp = null;

        //Black
        for(int i = 0; i < allWAttackPath.size(); i++) {
            if(allWAttackPath.get(i).equals(bKYX) ) {
                count++;
            }
        }

        //공격자와 왕 사이 경로
        if(count == 1) {
            checkerRange = new ArrayList<ArrayList<Integer>>();
            if(board[checker[0]][checker[1]].attackPathCheck().indexOf(bKYX) == 0) checkerIndex = board[checker[0]][checker[1]].attackPathCheck().indexOf(bKYX);
            else checkerIndex = board[checker[0]][checker[1]].attackPathCheck().indexOf(bKYX) - 1;

            //공격자의 공격경로 계산
            while(true) {
                if(board[checker[0]][checker[1]].getType().equals("knight")) break;
                //좌우 바로 옆일 경우
                if(bKYX.get(0) == checker[0] && (Math.abs(bKYX.get(1) - checker[1]) == 1) ||
                        bKYX.get(1) == checker[1] && (Math.abs(bKYX.get(0) - checker[0]) == 1)) break;
                //대각선 바로 옆일경우
                if((Math.abs(bKYX.get(1) - checker[1]) == 1) && (Math.abs(bKYX.get(1) - checker[1]) == 1)) break;

                //그외
                tmp = new ArrayList<Integer>(Arrays.asList(board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(0), board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(1)));
                checkerRange.add(tmp);
                if(Math.abs(checker[0] - board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(0)) == 1 ||
                        Math.abs(checker[1] - board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(1)) == 1)
                    break;
                checkerIndex--;
            }

            // 왕을 방어할수 있는 말
            for(int i = 0; i < 8; i ++) {
                for(int j = 0; j < 8; j++) {
                    if(board[checker[0]][checker[1]].getType().equals("knight")) break;
                    if(!board[i][j].getType().equals("none") && board[i][j].getColor().equals("black") &&
                            !board[i][j].getType().equals("king")) {

                        //경로 방어
                        for(int k = 0; k < checkerRange.size(); k ++) {
                            if(board[i][j].movePathCheck().contains(checkerRange.get(k))) {
                                canBlock = true;
                                break;
                            }
                            canBlock = false;
                        }
                    }
                    if(!board[i][j].getType().equals("none") && board[i][j].getColor().equals("black")) {
                        //공격하여 방어
                        for(int index = 0; index < board[i][j].attackPathCheck().size(); index++) {
                            if(board[i][j].attackPathCheck().get(index).get(0) == checker[0] &&
                                    board[i][j].attackPathCheck().get(index).get(1) == checker[1]) {
                                canBlock = true;
                                break;
                            }
                            canBlock =false;
                        }
                    }

                }
            }
            if(board[checker[0]][checker[1]].getType().equals("knight")) {
                boolean canAck = allWAttackPath.contains(Arrays.asList(checker[0], checker[1]));
                if(canAck) canBlock = true;
            }
        }

        if(count > 0) {
            board[bKYX.get(0)][bKYX.get(1)].setCheck(true);
            checking = true;
        }
        else {
            board[bKYX.get(0)][bKYX.get(1)].setCheck(false);
        }
        count = 0;

        for(int i = 0; i < allBAttackPath.size(); i++) {
            if(allBAttackPath.get(i).equals(wKYX) ) {
                count++;
            }
        }


        if(count == 1) {
            checkerRange = new ArrayList<ArrayList<Integer>>();
            if(board[checker[0]][checker[1]].attackPathCheck().indexOf(wKYX) == 0) checkerIndex = board[checker[0]][checker[1]].attackPathCheck().indexOf(wKYX);
            else checkerIndex = board[checker[0]][checker[1]].attackPathCheck().indexOf(wKYX) - 1;

            //공격자의 공격경로 계산
            while(true) {
                //나이트일 경우
                if(board[checker[0]][checker[1]].getType().equals("knight")) break;
                //좌우 바로 옆일 경우
                if(wKYX.get(0) == checker[0] && (Math.abs(wKYX.get(1) - checker[1]) == 1) ||
                        wKYX.get(1) == checker[1] && (Math.abs(wKYX.get(0) - checker[0]) == 1)) break;
                //대각선 바로 옆일경우
                if((Math.abs(wKYX.get(1) - checker[1]) == 1) && (Math.abs(wKYX.get(1) - checker[1]) == 1)) break;

                //그외
                tmp = new ArrayList<Integer>(Arrays.asList(board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(0), board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(1)));
                checkerRange.add(tmp);
                if(Math.abs(checker[0] - board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(0)) == 1 ||
                        Math.abs(checker[1] - board[checker[0]][checker[1]].attackPathCheck().get(checkerIndex).get(1)) == 1)
                    break;
                checkerIndex--;
            }

            // 왕을 방어할수 있는 말
            for(int i = 0; i < 8; i ++) {
                for(int j = 0; j < 8; j++) {
                    if(board[checker[0]][checker[1]].getType().equals("knight")) break;
                    if(!board[i][j].getType().equals("none") && board[i][j].getColor().equals("white") && !board[i][j].getType().equals("king")) {

                        //경로 방어
                        for(int k = 0; k < checkerRange.size(); k ++) {
                            if(board[i][j].movePathCheck().contains(checkerRange.get(k))) {
                                canBlock = true;
                            }
                        }
                    }
                    if(!board[i][j].getType().equals("none") && board[i][j].getColor().equals("black")) {
                        //공격하여 방어
                        for(int index = 0; index < board[i][j].attackPathCheck().size(); index++) {
                            if(board[i][j].attackPathCheck().get(index).get(0) == checker[0] &&
                                    board[i][j].attackPathCheck().get(index).get(1) == checker[1]) {
                                canBlock = true;
                            }
                        }
                    }

                }
            }
            if(board[checker[0]][checker[1]].getType().equals("knight")) {
                boolean canAck = allWAttackPath.contains(Arrays.asList(checker[0], checker[1]));
                if(canAck) canBlock = true;
            }
        }


        if(count > 0) {
            board[wKYX.get(0)][wKYX.get(1)].setCheck(true);
            checking = true;
        }
        else {
            board[wKYX.get(0)][wKYX.get(1)].setCheck(false);
        }
    }

    //체크 메이트
    private int checkmate() {
        // 0 : 체크메이트 없음, 1 : 흰색 체크메이트, 2 : 검정색 체크메이트
        ArrayList<ArrayList<Integer>> all;

        if(board[wKYX.get(0)][wKYX.get(1)].isCheck()) {
            all = new ArrayList<ArrayList<Integer>>(allBAttackPath);
            all.addAll(board[bKYX.get(0)][bKYX.get(1)].attackPathCheck());
            if(all.containsAll(board[wKYX.get(0)][wKYX.get(1)].movePathCheck()))
                return 1;
        }else if(board[bKYX.get(0)][bKYX.get(1)].isCheck()) {
            all = new ArrayList<ArrayList<Integer>>(allWAttackPath);
            all.addAll(board[wKYX.get(0)][wKYX.get(1)].attackPathCheck());
            if(all.containsAll(board[bKYX.get(0)][bKYX.get(1)].movePathCheck()))
                return 2;
        }

        return 0;
    }
    //스테일메이트
    private boolean stalemate() {
        ArrayList<ArrayList<Integer>> all;
        if(allWAttackPath.isEmpty()) {
            all = new ArrayList<ArrayList<Integer>>(allBAttackPath);
            all.addAll(board[bKYX.get(0)][bKYX.get(1)].attackPathCheck());
            if(!board[wKYX.get(0)][wKYX.get(1)].isCheck()) {
                return all.containsAll(board[wKYX.get(0)][wKYX.get(1)].attackPathCheck());
            }
        }
        if(allBAttackPath.isEmpty()) {
            all = new ArrayList<ArrayList<Integer>>(allWAttackPath);
            ArrayList<ArrayList<Integer>>tmp = new ArrayList<ArrayList<Integer>>(board[wKYX.get(0)][wKYX.get(1)].attackPathCheck());
            all.addAll(tmp);
            if(!board[bKYX.get(0)][bKYX.get(1)].isCheck()) {
                return all.containsAll(board[bKYX.get(0)][bKYX.get(1)].attackPathCheck());
            }
        }
        return false;
    }
    // 체크가 아닌데 움직인 뒤 왕이 체크가 되면 못움직이게
    private boolean afterMoveDanger(int[] From, String color) {
        List<Integer> from = new ArrayList<Integer>(Arrays.asList(From[1],From[0]));
        List<ArrayList<Integer>> cvtPath = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(color.equals("white")) {
                    if(board[i][j].getColor().equals("black")){
                        if(board[i][j].checkPathCheck() != null) {
                            int index = board[i][j].checkPathCheck().size() - 1;
                            for(int k = index; k >= 0; k--) {
                                int y = board[i][j].checkPathCheck().get(k).get(0);
                                int x = board[i][j].checkPathCheck().get(k).get(1);
                                if(k != 0) {
                                    int by = board[i][j].checkPathCheck().get(k-1).get(0);
                                    int bx = board[i][j].checkPathCheck().get(k-1).get(1);
                                    cvtPath.add(board[i][j].checkPathCheck().get(k));
                                    if(Math.abs(y - by) > 1 || Math.abs(x - bx) > 1) break;
                                }else {
                                    cvtPath.add(board[i][j].checkPathCheck().get(k));
                                }
                            }
                            cvtPath.add(new ArrayList<>(Arrays.asList(i,j)));
                            afterAmdPath.clear();
                            afterAmdPath = cvtPath;

                            if(cvtPath.contains(wKYX) && cvtPath.contains(from)) {
                                return true;
                            }
                        }
                    }
                }else {
                    if(board[i][j].getColor().equals("white")) {
                        if(board[i][j].checkPathCheck() != null) {
                            int index = board[i][j].checkPathCheck().size() - 1;
                            for(int k = index; k >= 0; k--) {
                                int y = board[i][j].checkPathCheck().get(k).get(0);
                                int x = board[i][j].checkPathCheck().get(k).get(1);
                                if(k != 0) {
                                    int by = board[i][j].checkPathCheck().get(k-1).get(0);
                                    int bx = board[i][j].checkPathCheck().get(k-1).get(1);
                                    cvtPath.add(board[i][j].checkPathCheck().get(k));
                                    if(Math.abs(y - by) > 1 || Math.abs(x - bx) > 1) break;
                                }else {
                                    cvtPath.add(board[i][j].checkPathCheck().get(k));
                                }
                            }
                            cvtPath.add(new ArrayList<>(Arrays.asList(i,j)));
                            afterAmdPath.clear();
                            afterAmdPath = cvtPath;

                            if(cvtPath.contains(bKYX) && cvtPath.contains(from)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //선택 알고리즘
    private void chessAlgorithmSet(int indexY, int indexX) {
        //좌표 최초선택
        chooseY = indexY;
        chooseX = indexX;
        int[] tmp = {chooseY, chooseX};
        afterMoveDanger(tmp, playerTurn);

        //턴구분
        if (board[chooseY][chooseX].getColor().equals(playerTurn)) {
            //이동경로 확인, 폰의 경우 이동경로와 공격경로가 다르므로 2번확인
            if (!board[chooseY][chooseX].getType().equals("pawn") && board[chooseY][chooseX].movePathCheck().size() == 0) {
                boolean isTeam = false; //말의 공격로에 아군이 있을시
                boolean canACK = false;
                for (int i = 0; i < board[chooseY][chooseX].attackPathCheck().size(); i++) {
                    int ackCheckY = board[chooseY][chooseX].attackPathCheck().get(i).get(0);
                    int ackCheckX = board[chooseY][chooseX].attackPathCheck().get(i).get(1);
                    if (!board[ackCheckY][ackCheckX].getColor().equals(playerTurn)) canACK = true;
                    //공격로가 아군말이면 움직이는게 불가능 하므로 break
                    if (board[chooseY][chooseX].attackPathCheck().size() == 0 ||
                            (i == board[chooseY][chooseX].attackPathCheck().size() - 1 && board[ackCheckY][ackCheckX].getColor().equals(playerTurn))) {
                        if (canACK) break;
                        //Toast.makeText(this.getContext(), "움직일 수 없는 말 입니다.", Toast.LENGTH_SHORT).show();
                        isTeam = true;
                        break;
                    }
                } //일반확인
                if (isTeam) return;
                //폰확인
            } else if (board[chooseY][chooseX].getType().equals("pawn") && board[chooseY][chooseX].attackPathCheck().size() == 0 &&
                    board[chooseY][chooseX].movePathCheck().size() == 0) {
                //Toast.makeText(this.getContext(), "움직일 수 없는 말 입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            //체크당했을 경우
            if (checking) {
                //왕을 움직여도 왕이 위험할 경우
                if (board[indexY][indexX].getType().equals("king")) {
                    boolean kingMove = false;
                    boolean canMove = false;
                    for (int i = 0; i < board[chooseY][chooseX].movePathCheck().size(); i++) {
                        kingMove = afterAmdPath.contains(board[chooseY][chooseX].movePathCheck().get(i));
                        if (!afterAmdPath.contains(board[chooseY][chooseX].movePathCheck().get(i))) {
                            if (canMove) continue;
                            canMove = !afterAmdPath.contains(board[chooseY][chooseX].movePathCheck().get(i));
                        }
                    }
                    if (canMove) kingMove = false;
                    if (!kingMove) { //왕이 움직일수 있으면
                        chooseSet = true;
                    } else { //왕의 이동경로가 없으면
                        boolean isCanAck = false; //공격경로 확인부분
                        for (int j = 0; j < board[chooseY][chooseX].attackPathCheck().size(); j++) {
                            if (board[chooseY][chooseX].attackPathCheck().get(j).get(0) == checker[0] &&
                                    board[chooseY][chooseX].attackPathCheck().get(j).get(1) == checker[1])
                                isCanAck = true; //공격이 가능하면 true로 선언하여공격
                        }
                        if (!isCanAck) { //공격 불가능하면 break
                            //Toast.makeText(this.getContext(), "왕이 위험하여 움직일 수 없습니다.", Toast.LENGTH_SHORT).show();
                        } else { //가능하면 선택을 함
                            chooseSet = true;
                        }
                    }
                }
                //그외, 말로 막을경우
                else {
                    //Move
                    afterMoveDanger(tmp, playerTurn);
                    boolean canMove = false;
                    for (int i = 0; i < board[chooseY][chooseX].movePathCheck().size(); i++) {
                        canMove = afterAmdPath.contains(board[chooseY][chooseX].movePathCheck().get(i));
                        if (canMove) break;
                    }
                    if (canMove) {
                        chooseSet = true;
                    } else {
                        boolean isCanAck = false; //공격경로 확인부분
                        for (int j = 0; j < board[chooseY][chooseX].attackPathCheck().size(); j++) {
                            if (board[chooseY][chooseX].attackPathCheck().get(j).get(0) == checker[0] && board[chooseY][chooseX].attackPathCheck().get(j).get(1) == checker[1])
                                isCanAck = true; //공격이 가능하면 true로 선언하여공격
                        }
                        if (!isCanAck) { //공격 불가능하면 break
                            //Toast.makeText(this.getContext(), "이 말은 왕이 위험하여 움직일 수 없습니다.", Toast.LENGTH_SHORT).show();
                        } else { //가능하면 선택을 함
                            chooseSet = true;
                        }
                    }
                }
            } //체크확인 끝

            //체크가 아닌 선택
            else {
                boolean iswKMove = false;
                if (board[chooseY][chooseX].getType().equals("king")) {
                    if (board[chooseY][chooseX].getColor().equals("white")) {
                        if (board[indexY][indexX].movePathCheck().size() == 1)
                            iswKMove = allBAttackPath.contains(board[indexY][indexX].movePathCheck().get(0));
                    } else {
                        if (board[indexY][indexX].movePathCheck().size() == 1)
                            iswKMove = allWAttackPath.contains(board[indexY][indexX].movePathCheck().get(0));
                    }
                    if (iswKMove) {
                        //Toast.makeText(this.getContext(), "왕은 위험한곳으로 이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        chooseSet = true;
                    }
                } else {
                    //말이 이동시 위험할 경우
                    int[] from = {chooseX, chooseY};
                    boolean amd = afterMoveDanger(from, playerTurn);
                    boolean isNotBlank = false;
                    if (amd) {
                        for (int i = 0; i < board[indexY][indexX].aiPath().size(); i++) {
                            for (ArrayList<Integer> key : afterAmdPath) {
                                if (!board[key.get(0)][key.get(1)].getType().equals("none")) {
                                    if (board[key.get(0)][key.get(1)].getType().equals("king"))
                                        break;
                                    if (board[key.get(0)][key.get(1)].equals(board[chooseY][chooseX]))
                                        continue;
                                    isNotBlank = true;
                                    break;
                                }
                            }
                            if (isNotBlank) {
                                break;
                            } else {
                                //Toast.makeText(this.getContext(), "이 말이 이동하면 왕이 위험합니다.", Toast.LENGTH_SHORT).show();
                                afterSet = true;
                                break;
                            }
                        }

                    }
                    //평범한 이동
                    chooseSet = true;
                }
            }
        } else if (board[chooseY][chooseX].getType().equals("none")) {
            //Toast.makeText(this.getContext(), "빈칸 입니다.", Toast.LENGTH_SHORT).show();
            chooseY = 9;
            chooseX = 9;
        } else {
            chooseY = 9;
            chooseX = 9;
            //Toast.makeText(this.getContext(), "자신의 말을 선택해 주세요", Toast.LENGTH_SHORT).show();
        }

    }
    //이동 알고리즘
    private void chessAlgorithmMove(int indexY, int indexX) {
        //좌표 선택후 이동선택
        //이동가능할경우
        int[] from = {chooseX, chooseY};
        int[] to = {indexX, indexY};
        //이동
        //왕이 이동 후에 왕이 위험하면
        if (board[chooseY][chooseX].getType().equals("king")) {
            boolean iswKingMove = false;
            for (int j = 0; j < board[chooseY][chooseX].movePathCheck().size(); j++) {
                if (board[chooseY][chooseX].movePathCheck().get(j).get(0) == indexY && board[chooseY][chooseX].movePathCheck().get(j).get(1) == indexX) {
                    if (board[chooseY][chooseX].getColor().equals("white")) {
                        iswKingMove = allBAttackPath.contains(board[chooseY][chooseX].movePathCheck().get(j));
                    } else if (board[chooseY][chooseX].getColor().equals("black")) {
                        iswKingMove = allWAttackPath.contains(board[chooseY][chooseX].movePathCheck().get(j));
                    }
                }
            }
            if (iswKingMove) {
                //Toast.makeText(this.getContext(), "왕은 위험한곳으로 이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                moveSet = false;
                chooseSet = false;
                return;
            }
        } //왕확인 끝
        ///////////그 외의 말/////////////////////////////
        else {
            ////////말이 이동했을 때 왕이 위험할 경우 + 체크당했을 시///////////////////
            afterMoveDanger(from, playerTurn);
            if (afterSet || checking) {
                boolean iswPieceMove = false;
                for (int j = 0; j < afterAmdPath.size(); j++) {
                    //선택한 말의 이동 경로가 적 공격로에 있으면
                    if (afterAmdPath.get(j).get(0) == indexY && afterAmdPath.get(j).get(1) == indexX) {
                        iswPieceMove = true;
                        break;
                    }
                    if(indexY == checker[0] && indexX == checker[1]){
                        iswPieceMove = true;
                        break;
                    }
                }
                //없을 경우 잘못된 선택이므로 return
                if (!iswPieceMove) {
                    //Toast.makeText(this.getContext(), "왕이 위험하여 움직일 수 없습니다.", Toast.LENGTH_SHORT).show();
                    moveSet = false;
                    chooseSet = false;
                    afterSet = false;
                    return;
                }
            }
        }

        if (board[chooseY][chooseX].moveCheck(from, to, playerTurn, false)) {
            update(from, to); //말의 위치 업데이트
        }
        //잘못된 이동일 경우
        else {
            moveSet = false;
            chooseSet = false;
            //Toast.makeText(this.getContext(), "잘못된 이동", Toast.LENGTH_SHORT).show();
            return;
        }

        if (checking) checking = false;
        afterSet = false;
        moveSet = false;
        chooseSet = false;

        //playTurn update
        if (playerTurn.equals("white")) playerTurn = "black";
        else if (playerTurn.equals("black")) playerTurn = "white";

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //터치시
                float x = event.getX();
                float y = event.getY();
                updateFlag = true;


                for (int indexY = 0; indexY < 8; indexY++) {
                    for (int indexX = 0; indexX < 8; indexX++) {
                        if ((y >= boardPointY[indexY] && y <= boardPointY[indexY] + width / 8) && (x >= boardPoint[indexY][indexX] && x <= boardPoint[indexY][indexX] + width / 8)) {
                            if(!moveSet)chessAlgorithmSet(indexY, indexX);
                            else chessAlgorithmMove(indexY, indexX);
                        } //메인 if끝
                        //왕위치 탐색
                        if (board[indexY][indexX].getSymbol().equals("WKi")) {
                            wKYX = new ArrayList<>(Arrays.asList(indexY, indexX));
                        } else if (board[indexY][indexX].getSymbol().equals("BKi")) {
                            bKYX = new ArrayList<>(Arrays.asList(indexY, indexX));
                        }
                    } //x루프 끝
                } //y루프 끝
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        postInvalidate();
        return true;
    }//onTouch end

    //A.I 작동루틴
    private void aiLutin(int move[]) {
        int y = move[1];
        int x = move[0];
        updateFlag = true;

        for (int indexY = 0; indexY < 8; indexY++) {
            for (int indexX = 0; indexX < 8; indexX++) {

                if (y == indexY && x == indexX) {
                    if(!moveSet) chessAlgorithmSet(indexY, indexX);
                    else chessAlgorithmMove(indexY, indexX);
                } //메인 if끝
                //왕위치 탐색
                if (board[indexY][indexX].getSymbol().equals("WKi")) {
                    wKYX = new ArrayList<>(Arrays.asList(indexY, indexX));
                } else if (board[indexY][indexX].getSymbol().equals("BKi")) {
                    bKYX = new ArrayList<>(Arrays.asList(indexY, indexX));
                }
                //나이트 탐색
                if (board[indexY][indexX].getSymbol().equals("WKi")) {
                    wNYX = new ArrayList<>(Arrays.asList(indexY, indexX));
                } else if (board[indexY][indexX].getSymbol().equals("BKi")) {
                    bNYX = new ArrayList<>(Arrays.asList(indexY, indexX));
                }
            } //x루프 끝
        } //y루프 끝
        postInvalidate();
    }
}//View end
