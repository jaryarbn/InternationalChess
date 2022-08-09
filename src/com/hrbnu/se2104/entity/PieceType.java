package com.hrbnu.se2104.entity;

public enum PieceType {
    KINGBLACK("KingBlack", "com/hrbnu/se2104/img/KingBlack.jpg"),
    QUEENBLACK("QueenBlack", "com/hrbnu/se2104/img/QueenBlack.jpg"),
    CARBLACK("CarBlack", "com/hrbnu/se2104/img/CarBlack.jpg"),
    HORSEBLACK("HorseBlack", "com/hrbnu/se2104/img/HorseBlack.jpg"),
    SOLDIERBLACK("SoldierBlack", "com/hrbnu/se2104/img/SoldierBlack.jpg"),
    KNIGHTBLACK("KnightBlack", "com/hrbnu/se2104/img/KnightBlack.jpg"),

    KINGWHITE("KingWhite", "com/hrbnu/se2104/img/KingWhite.jpg"),
    QUEENWHITE("QueenWhite", "com/hrbnu/se2104/img/QueenWhite.jpg"),
    CARWHITE("CarWhite", "com/hrbnu/se2104/img/CarWhite.jpg"),
    HORSEWHITE("HorseWhite", "com/hrbnu/se2104/img/HorseWhite.jpg"),
    SOLDIERWHITE("SoldierWhite", "com/hrbnu/se2104/img/SoldierWhite.jpg"),
    KNIGHTWHITE("KnightWhite", "com/hrbnu/se2104/img/KnightWhite.jpg");

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
