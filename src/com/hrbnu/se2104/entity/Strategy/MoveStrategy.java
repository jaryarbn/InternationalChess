package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public interface MoveStrategy {
    boolean move(int x, int y, Set<ChessPiece> chessPieces);
}
