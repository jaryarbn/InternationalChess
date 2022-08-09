package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class KingStrategy implements MoveStrategy {
    private int currentX;
    private int currentY;

    public KingStrategy(int currentX, int currentY) {
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
        if (Math.abs(currentX - targetX) <= 1 && Math.abs(currentY - targetY) <= 1) {
            currentX = targetX;
            currentY = targetY;
            return true;
        } else {
            return false;
        }
    }
}
