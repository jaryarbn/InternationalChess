package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.KnightStrategy;

public class Knight extends ChessPiece {

    public Knight(PieceType type, int row, int column) {
        super(type, row, column);
        setMoveStrategy(new KnightStrategy());
    }
}
