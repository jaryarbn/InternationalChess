package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.KnightStrategy;

public class King extends ChessPiece {

    public King(PieceType type, int row, int column) {
        super(type, row, column);
        setMoveStrategy(new KnightStrategy());
    }
}
