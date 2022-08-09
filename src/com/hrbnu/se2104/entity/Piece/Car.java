package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.CarStrategy;

public class Car extends ChessPiece{

    public Car(PieceType type, int row, int column) {
        super(type, row, column);
        setMoveStrategy(new CarStrategy(getColumn(),getRow()));
    }
}
