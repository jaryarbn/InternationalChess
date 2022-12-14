package com.hrbnu.se2104.view;

import com.hrbnu.se2104.entity.Piece.Car;
import com.hrbnu.se2104.entity.Piece.ChessPiece;
import com.hrbnu.se2104.entity.Piece.Horse;
import com.hrbnu.se2104.entity.Piece.King;
import com.hrbnu.se2104.entity.Piece.Knight;
import com.hrbnu.se2104.entity.Piece.Queen;
import com.hrbnu.se2104.entity.Piece.Soldier;
import com.hrbnu.se2104.entity.PieceType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Set;

public class ChessPane extends Pane {
    private Set<ChessPiece> chessPieces;
    private final ChessBoard chessBoard;
    private final Canvas canvas;
    private final GraphicsContext graphicsContext;
    public static final double WIDTH = 900, HEIGHT = 900;

    public ChessPane(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        setChessPiece();// 先放棋子
        canvas = new Canvas(WIDTH, HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        draw();
    }

    private void draw() {
        drawBoard();
        drawPiece();
        getChildren().add(canvas);
    }


    public void drawBoard() {
        graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);
        double x = chessBoard.getStartX();
        double y = chessBoard.getStartY();
        double grid = chessBoard.getGridLength();

        boolean flag = false;
        for (int i = 0; i < chessBoard.getRow(); i++) {
            flag = !flag;
            for (int j = 0; j < chessBoard.getColumn(); j++) {
                graphicsContext.setFill(flag ? Color.valueOf("#EDEDED") : Color.valueOf("CDC5BF"));
                graphicsContext.fillRect(x + j * grid, y + i * grid, grid, grid);
                flag = !flag;
            }
        }
        graphicsContext.strokeRect(x, y, grid * chessBoard.getColumn(), grid * chessBoard.getRow());// 给矩形外部描边
    }

    public void drawPiece() {
        double grid = chessBoard.getGridLength();
        chessPieces.forEach(piece -> {
            if (piece.isSelected()) {
                graphicsContext.setFill(Color.valueOf("#6495ED"));
                graphicsContext.fillRect(chessBoard.getStartX() + piece.getColumn() * grid,
                        chessBoard.getStartY() + piece.getRow() * grid,
                        grid, grid);
            }

            Image image = new Image(piece.getType().getUrl());
            graphicsContext.drawImage(image,
                    chessBoard.getStartX() + 10 + piece.getColumn() * grid,
                    chessBoard.getStartY() + 10 + piece.getRow() * grid,
                    grid - 20, grid - 20);
        });
    }

    // 放置棋子
    public void setChessPiece() {
        chessPieces = new HashSet<>();
        chessPieces.add(new Car(PieceType.CARBLACK, 0, 0));
        chessPieces.add(new Horse(PieceType.HORSEBLACK, 1, 0));
        chessPieces.add(new Knight(PieceType.KNIGHTBLACK, 2, 0));
        chessPieces.add(new King(PieceType.KINGBLACK, 3, 0));
        chessPieces.add(new Queen(PieceType.QUEENBLACK, 4, 0));
        chessPieces.add(new Knight(PieceType.KNIGHTBLACK, 5, 0));
        chessPieces.add(new Horse(PieceType.HORSEBLACK, 6, 0));
        chessPieces.add(new Car(PieceType.CARBLACK, 7, 0));
        for (int i = 0; i < 8; i++) {
            chessPieces.add(new Soldier(PieceType.SOLDIERBLACK, i, 1));
        }


        chessPieces.add(new Car(PieceType.CARWHITE, 0, 7));
        chessPieces.add(new Horse(PieceType.HORSEWHITE, 1, 7));
        chessPieces.add(new Knight(PieceType.KNIGHTWHITE, 2, 7));
        chessPieces.add(new King(PieceType.KINGWHITE, 3, 7));
        chessPieces.add(new Queen(PieceType.QUEENWHITE, 4, 7));
        chessPieces.add(new Knight(PieceType.KNIGHTWHITE, 5, 7));
        chessPieces.add(new Horse(PieceType.HORSEWHITE, 6, 7));
        chessPieces.add(new Car(PieceType.CARWHITE, 7, 7));
        for (int i = 0; i < 8; i++) {
            chessPieces.add(new Soldier(PieceType.SOLDIERWHITE, i, 6));
        }
    }

    public Set<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    public void setChessPieces(Set<ChessPiece> chessPieces) {
        this.chessPieces = chessPieces;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}

