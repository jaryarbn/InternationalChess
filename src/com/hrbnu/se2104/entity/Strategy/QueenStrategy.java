package com.hrbnu.se2104.entity.Strategy;

import com.hrbnu.se2104.entity.Piece.ChessPiece;

import java.util.Set;

public class QueenStrategy implements MoveStrategy{
    @Override
    public boolean move(int x, int y, Set<ChessPiece> chessPieces) {
        return false;
    }
}
