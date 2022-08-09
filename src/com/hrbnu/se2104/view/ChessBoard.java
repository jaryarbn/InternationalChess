package com.hrbnu.se2104.view;

public class ChessBoard {
    static ChessBoard chessBoard = null;
    private int row;
    private int column;
    private double gridLength;
    private double startX;
    private double startY;
    private char currentCamp;

    public ChessBoard(double gridLength, double startX, double startY) {
        this.row = 8;
        this.column = 8;
        this.gridLength = gridLength;
        this.startX = startX;
        this.startY = startY;
        this.currentCamp = 'B';
    }


    public static ChessBoard getChessBoard(double gridLength, double startX, double startY) {
        if (chessBoard == null) {
            return new ChessBoard(gridLength, startX, startY);
        } else {
            return chessBoard;
        }
    }


    public static ChessBoard getChessBoard() {
        return chessBoard;
    }

    public static void setChessBoard(ChessBoard chessBoard) {
        ChessBoard.chessBoard = chessBoard;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getGridLength() {
        return gridLength;
    }

    public void setGridLength(double gridLength) {
        this.gridLength = gridLength;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public char getCurrentCamp() {
        return currentCamp;
    }

    public void setCurrentCamp(char currentCamp) {
        this.currentCamp = currentCamp;
    }

    public void changeCamp() {
        currentCamp = (currentCamp == 'B') ? 'W' : 'B';
    }

}
