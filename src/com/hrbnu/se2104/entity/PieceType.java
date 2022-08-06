package com.hrbnu.se2104.entity;

public enum PieceType {
    KINGBLACK("KingBlack", "img/KingBlack.jpg"),
    QUEENBLACK("QueenBlack", "img/QueenBlack.jpg"),
    CARBLACK("CarBlack", "img/CarBlack.jpg"),
    HORSEBLACK("HorseBlack", "img/HorseBlack.jpg"),
    SOLDIERBLACK("SoldierBlack", "img/SoldierBlack.jpg"),
    KNIGHTBLACK("KnightBlack", "img/KnightBlack.jpg"),

    KINGWHITE("KingWhite", "img/KingWhite.jpg"),
    QUEENWHITE("QueenWhite", "img/QueenWhite.jpg"),
    CARWHITE("CarWhite", "img/CarWhite.jpg"),
    HORSEWHITE("HorseWhite", "img/HorseWhite.jpg"),
    SOLDIERWHITE("SoldierWhite", "img/SoldierWhite.jpg"),
    KNIGHTWHITE("KnightWhite", "img/KnightWhite.jpg");

    private String desc;
    private String url;

    PieceType(String desc, String url) {
        this.desc = desc;
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }
}
