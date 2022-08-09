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
        // 先拿到棋盘
        chessPane.drawBoard();
        ChessBoard chessBoard = chessPane.getChessBoard();
        // 拿到鼠标当前的坐标
        int x = (int) ((event.getX() - chessBoard.getStartX()) / (chessBoard.getGridLength()));
        int y = (int) ((event.getY() - chessBoard.getStartY()) / (chessBoard.getGridLength()));

        for (ChessPiece piece : chessPane.getChessPieces()) {
            if (piece.isSelected()) {
                System.out.println(piece.isSelected() + " " + piece.getRow() + " " + piece.getColumn());
                // 判断当前阵营
                if (chessBoard.getCurrentCamp() == piece.getCamp()) {
                    // 判断当前棋子是否原地移动
                    if (piece.getColumn() == x && piece.getRow() == y) {
                        System.out.println("棋子无法原地TP");
                    }// 判断当前棋子是否发生移动
                    else if (piece.getMoveStrategy().move(x, y, chessPane.getChessPieces())) {
                        // 先判断游戏是否结束，如果是，弹出提示框
                        if (judgeGameOver(x, y)) {
                            printTip(piece.getCamp());
                        }
                        eatPiece(x, y, piece.getCamp());
                        stack.push((ChessPiece) piece.clone());// 复制一份放进栈里

                        System.out.println(piece.getColumn() + " " + piece.getRow() + " 移动到 " + x + " " + y);
                        piece.setColumn(x);
                        piece.setRow(y);

                        chessBoard.changeCamp();// 切换阵营
                    }
                } else {
                    if (piece.getCamp() == 'B') {
                        System.out.println("请白色阵营移动棋子");
                    } else {
                        System.out.println("请黑色阵营移动棋子");
                    }
                }
                piece.setSelected(false);
                break;
            }
        }
        chessPane.drawPiece();
    }

    public void eatPiece(int x, int y, char camp) {
        chessPane.getChessPieces().removeIf(piece -> {
            // 横纵坐标相同且非同阵营
            if (piece.getColumn() == x && piece.getRow() == y && piece.getCamp() != camp) {
                stack.push(piece);
                return true;
            }
            return false;
        });
    }

    public boolean judgeGameOver(int x, int y) {
        for (ChessPiece piece : chessPane.getChessPieces()) {
            if (piece.getColumn() == x && piece.getRow() == y && (piece.getType() == PieceType.KINGBLACK || (piece.getType() == PieceType.KINGWHITE))) {
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
