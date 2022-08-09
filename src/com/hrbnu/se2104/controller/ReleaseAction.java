package com.hrbnu.se2104.controller;

import com.hrbnu.se2104.entity.Piece.ChessPiece;
import com.hrbnu.se2104.entity.PieceType;
import com.hrbnu.se2104.view.ChessBoard;
import com.hrbnu.se2104.view.ChessPane;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.util.Stack;

public class ReleaseAction implements EventHandler<MouseEvent> {
    private ChessPane chessPane;
    static Stack<ChessPiece> stack = new Stack<>();

    public ReleaseAction(ChessPane chessPane) {
        this.chessPane = chessPane;
    }

    @Override
    public void handle(MouseEvent event) {
        chessPane.drawBoard();
        ChessBoard chessBoard = chessPane.getChessBoard();
        int x = (int) ((event.getX() - chessBoard.getStartX()) / (chessBoard.getGridLength()));
        int y = (int) ((event.getY() - chessBoard.getStartY()) / (chessBoard.getGridLength()));

        for (ChessPiece piece : chessPane.getChessPieces()) {
            if (piece.isSelected()) {
                System.out.println(piece.isSelected() + " " + piece.getRow() + " " + piece.getColumn());
                if (chessBoard.getCurrentCamp() == piece.getCamp()) {
                    if (piece.getMoveStrategy().move(x, y, chessPane.getChessPieces())) {
                        if (judgeGameOver(x, y)) {
                            printTip(piece.getCamp());
                        }
                        eatPiece(x, y);
                        stack.push((ChessPiece) piece.clone());// 复制一份放进栈里
                        piece.setColumn(x);
                        piece.setRow(y);

                        chessBoard.changeCamp();// 切换阵营
                    }
                }
                piece.setSelected(false);
                break;
            }
        }
        chessPane.drawPiece();
    }

    public void eatPiece(int x, int y) {
        chessPane.getChessPieces().removeIf(piece -> {
            if (piece.getColumn() == x && piece.getRow() == y) {
                stack.push(piece);
                return true;
            }
            return false;
        });
    }

    public boolean judgeGameOver(int x, int y) {
        for (ChessPiece piece : chessPane.getChessPieces()) {
            if (piece.getColumn() == x && piece.getRow() == y && (piece.getType() == PieceType.KINGBLACK) || (piece.getType() == PieceType.KINGWHITE)) {
                return true;
            }
        }
        return false;
    }

    public void printTip(char camp) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText((camp == 'B' ? "黑" : "白") + "方阵营取得胜利");
        alert.setTitle("游戏已结束！");
        alert.showAndWait();
    }
}
