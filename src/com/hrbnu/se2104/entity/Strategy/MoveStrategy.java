package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public interface MoveStrategy {
    boolean move(int targetX, int targetY, Set<ChessPiece> chessPieces);
}
