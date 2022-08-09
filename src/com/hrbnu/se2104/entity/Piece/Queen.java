package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.QueenStrategy;

public class Queen extends ChessPiece{
    public Queen(PieceType type, int row, int column) {
        super(type, row, column);
        setMoveStrategy(new QueenStrategy());
    }
}
