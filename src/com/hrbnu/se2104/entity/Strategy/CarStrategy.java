package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class CarStrategy implements MoveStrategy {
    private int currentX;
    private int currentY;

    public CarStrategy() {

    }

    public CarStrategy(int currentX, int currentY) {
        this.currentX = currentX;
        this.currentY = currentY;
    }

    @Override
    public boolean move(int targetX, int targetY, Set<ChessPiece> chessPieces) {
        // 只能直走
        if (targetX != currentX && targetY != currentY)
            return false;
        // 如果隔子，就不能走
        if (isOverPiece(Math.min(currentX, targetX), Math.min(currentY, targetY),
                Math.max(currentX, targetX), Math.max(currentY, targetY), chessPieces))
            return false;
        else {
            currentX = targetX;
            currentY = targetY;
            return true;
        }
    }

    public static boolean isOverPiece(int startX, int startY, int endX, int endY, Set<ChessPiece> chessPieces) {
        for (ChessPiece e : chessPieces) {
            if (NotExistChessInMiddle(startX, startY, endX, endY, e)) {
                return true;
            }
        }
        return false;
    }

    private static boolean NotExistChessInMiddle(int startX, int startY, int endX, int endY, ChessPiece e) {
        return (e.getRow() > startY && e.getRow() < endY) && e.getColumn() == startX ||
                (e.getColumn() > startX && e.getColumn() < endX && e.getRow() == startY);
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
}
