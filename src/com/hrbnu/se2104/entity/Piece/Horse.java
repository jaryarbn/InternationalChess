package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.HorseStrategy;

public class Horse extends ChessPiece{

    public Horse(PieceType type, int row, int column) {
        super(type, row, column);
        setMoveStrategy(new HorseStrategy());
    }
}
