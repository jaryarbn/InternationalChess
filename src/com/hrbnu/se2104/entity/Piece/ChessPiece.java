package com.hrbnu.se2104.entity.Piece;

import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.entity.Strategy.MoveStrategy;

import java.util.Objects;

public class ChessPiece implements Cloneable {
    private int id;
    private PieceType type;
    private MoveStrategy moveStrategy;
    private boolean selected;
    private int row;
    private int column;
    private char camp;
    private static int auto_id = 0;

    public ChessPiece(PieceType type, int row, int column) {
        this.id = ++auto_id;
        this.type = type;
        this.selected = false;
        this.row = row;
        this.column = column;
        this.camp = type.getDesc().endsWith("Black") ? 'B' : 'W';
    }


    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getCamp() {
        return camp;
    }

    public void setCamp(char camp) {
        this.camp = camp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "id=" + id +
                ", type=" + type +
                ", moveStrategy=" + moveStrategy +
                ", selected=" + selected +
                ", row=" + row +
                ", column=" + column +
                ", camp=" + camp +
                '}';
    }
}
