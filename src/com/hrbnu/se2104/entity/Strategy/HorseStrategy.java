package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class HorseStrategy implements MoveStrategy {

    private int currentX;
    private int currentY;

    public HorseStrategy(int currentX, int currentY) {
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
        if (HorseOnlyMoveRiZiGe(targetX, targetY)) {
            currentX = targetX;
            currentY = targetY;
            return true;
        } else {
            return false;
        }

    }

    private boolean HorseOnlyMoveRiZiGe(int targetX, int targetY) {
        return (Math.abs(currentY - targetY) == 1) && (Math.abs(currentX - targetX) == 2) || (Math.abs(currentX - targetX) == 1 && Math.abs(currentY - targetY) == 2);
    }
}
