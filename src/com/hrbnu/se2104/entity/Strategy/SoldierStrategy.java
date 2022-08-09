package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class SoldierStrategy implements MoveStrategy {
    private int currentX;
    private int currentY;
    private char camp;
    private boolean firstMove = true;

    public SoldierStrategy(int currentX, int currentY, char camp) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.camp = camp;
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

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public boolean move(int targetX, int targetY, Set<ChessPiece> chessPieces) {

        // 纵坐标一样时直线移动
        if (currentY == targetY) {
            switch (camp) {
                case 'B': {
                    if (isFirstMove() && (targetX == currentX + 1 || currentX + 2 == targetX)) {
                        if (isOverPiece(currentX, targetX, chessPieces)) {
                            return false;
                        }
                        setFirstMove(false);
                        currentY = targetY;
                        currentX = targetX;
                        return true;
                    } else if (!isFirstMove() && currentX + 1 == targetX) {
                        currentY = targetY;
                        currentX = targetX;
                        return true;
                    }
                    break;
                }

                case 'W': {
                    if (isFirstMove() && (targetX == currentX - 1 || targetX == currentX - 2)) {
                        if (isOverPiece(currentX, targetX, chessPieces))
                            setFirstMove(false);
                        currentY = targetY;
                        currentX = targetX;
                        return true;
                    } else if (!isFirstMove() && currentX - 1 == targetX) {
                        currentY = targetY;
                        currentX = targetX;
                        return true;
                    }
                    break;
                }
            }
        }

        //否则斜着走可以吃子
        for (ChessPiece e : chessPieces) {
            if (Math.abs(e.getRow() - currentY) == 1) {
                if (e.getColumn() - currentX == 1 && e.getCamp() == 'W' ||
                        currentX - e.getColumn() == 1 && e.getCamp() == 'B') {
                    currentY = targetY;
                    currentX = targetX;
                    return true;
                }
            }
        }

        return false;

    }

    public boolean isOverPiece(int startX, int targetX, Set<ChessPiece> chessPieces) {
        for (ChessPiece piece : chessPieces) {
            if (Math.abs(targetX - piece.getColumn()) == 1 && Math.abs(targetX - startX) == 2) {
                return true;
            }
        }
        return false;
    }
}
