package com.example.mvptictactoe;

import android.view.View;

public class BoardPresenter implements BoardListener{
    BoardView view;
    Board board;

    public BoardPresenter(BoardView boardView) {
        view = boardView;
        board = new Board(this);

    }
    public void move(byte row, byte col){
        board.move(row, col);
    }
    static class CellClickListener implements View.OnClickListener, com.example.mvptictactoe.CellClickListener {
        BoardPresenter presenter;
        byte row;
        byte col;
        public CellClickListener(BoardPresenter presenter, byte row, byte col){
            this.presenter = presenter;
            this.row = row;
            this.col= col;

        }

        @Override
        public void onClick(View v) {
            presenter.move(row,col);
        }
    }


    public void playerAt(byte player, byte row, byte col) {
        if(player== BoardListener.PLAYER_1){
            view.putSymbol(BoardView.PLAYER_1_SYMBOL, row , col);
        }else if(player== BoardListener.PLAYER_2) {
            view.putSymbol(BoardView.PLAYER_2_SYMBOL, row, col);
        }
    }

    public void gameEnded(byte winner){
        switch (winner){
            case BoardListener.NO_ONE:
                view.gameEnded(BoardView.DRAW);
                break;
            case BoardListener.PLAYER_1:
                view.gameEnded(BoardView.PLAYER_1_WINNER);
                break;
            case BoardListener.PLAYER_2:
                view.gameEnded(BoardView.PLAYER_2_WINNER);
        }
    }
    public void invalidPlay(byte row, byte col){
        view.invalidPlay(row,col);
    }
}
