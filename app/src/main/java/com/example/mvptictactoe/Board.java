package com.example.mvptictactoe;

public class Board {

    private byte[][] board = new byte[3][3];
    private static byte PLAYER_1_SYMBOL = 1;
    private static byte PLAYER_2_SYMBOL = 2;

    private boolean player1Turn = true;

    BoardListener boardListener;

    public Board(BoardListener boardListener) {
        this.boardListener = boardListener;
    }

    public void move(byte row, byte col){
        if(board[row][col]!= 0) {
            boardListener.invalidPlay(row, col);
            return;
        }
        if(player1Turn){
            board[row][col] = PLAYER_1_SYMBOL;
            boardListener.playerAt(BoardListener.PLAYER_1, row, col);
        }else{
            board[row][col] = PLAYER_2_SYMBOL;
            boardListener.playerAt(BoardListener.PLAYER_2, row, col);
        }
        player1Turn = !player1Turn;
    }
}
