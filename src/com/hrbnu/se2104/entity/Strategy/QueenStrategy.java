package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class QueenStrategy implements MoveStrategy {
    private int currentX;
    private int currentY;

    public QueenStrategy(int currentX, int currentY) {
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
        if (Math.abs(targetX - currentX) == Math.abs(targetY - currentY) || (targetX != currentX && targetY != currentY)) {
            if (isOverPiece(Math.min(currentX, targetX), Math.min(currentY, targetY), Math.max(currentX, targetX), Math.max(currentY, targetY), chessPieces)) {
                return false;
            }
            currentX = targetX;
            currentY = targetY;
        }
        return false;
    }

    private static boolean isOverPiece(int startX, int startY, int endX, int endY, Set<ChessPiece> chessPieces) {
        for (ChessPiece piece : chessPieces)
            // 如果横纵坐标都不相同，说明无法走直线，用骑士的越子逻辑，否则用车的越子逻辑
            if (piece.getRow() != startY && piece.getColumn() != startX) {
                return KnightStrategy.isOverPiece(startX, startY, endX, endY, chessPieces);
            } else {
                return CarStrategy.isOverPiece(startX, startY, endX, endY, chessPieces);
            }
        return false;
    }
}
