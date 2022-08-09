package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.SoldierStrategy;

public class Soldier extends ChessPiece{
    public Soldier(PieceType type, int row, int column) {
        super(type, row, column);
        setMoveStrategy(new SoldierStrategy(getColumn(),getRow(),getCamp()));
    }
}
