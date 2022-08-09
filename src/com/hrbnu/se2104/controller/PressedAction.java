package com.hrbnu.se2104.controller;

import com.hrbnu.se2104.view.ChessBoard;
import com.hrbnu.se2104.view.ChessPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class PressedAction implements EventHandler<MouseEvent> {
    private final ChessPane chessPane;
    private final MediaPlayer mediaPlayer;

    public PressedAction(ChessPane chessPane, MediaPlayer mediaPlayer) {
        this.chessPane = chessPane;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void handle(MouseEvent event) {
        ChessBoard chessBoard = chessPane.getChessBoard();
        int mouseExistX = (int) ((event.getX() - chessBoard.getStartX()) / (chessBoard.getGridLength()));
        int mouseExistY = (int) ((event.getY() - chessBoard.getStartY()) / (chessBoard.getGridLength()));


        chessPane.getChessPieces().forEach(chessPiece -> {
            if (chessPiece.getColumn() == mouseExistX && chessPiece.getRow() == mouseExistY) {
                chessPiece.setSelected(true);
                chessPane.drawPiece();
            }
        });
        mediaPlayer.play();
    }
}
