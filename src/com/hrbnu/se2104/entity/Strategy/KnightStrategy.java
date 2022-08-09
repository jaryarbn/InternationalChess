package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class KnightStrategy implements MoveStrategy {
    private int currentX;
    private int currentY;

    public KnightStrategy(int currentX, int currentY) {
        this.currentX = currentX;
        this.currentY = currentY;
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

    @Override
    public boolean move(int targetX, int targetY, Set<ChessPiece> chessPieces) {
        if (Math.abs(targetX - currentX) == Math.abs(targetY - currentY)) {
            if (isOverPiece(Math.min(currentX, targetX), Math.max(currentX, targetX), Math.min(currentY, targetY), Math.max(currentY, targetY), chessPieces)) {
                return false;
            }
            currentX = targetX;
            currentY = targetY;
            return true;
        }
        return false;
    }

    public static boolean isOverPiece(int startX, int startY, int endX, int endY, Set<ChessPiece> chessPieces) {
        for (ChessPiece piece : chessPieces) {
            if (piece.getColumn() - startX == endX - piece.getColumn() && endY - piece.getRow() == piece.getRow() - startY) {
                System.out.println(piece.isSelected() + " " + piece.getRow() + " " + piece.getColumn());
                return true;
            }
        }

        return false;
    }

}
