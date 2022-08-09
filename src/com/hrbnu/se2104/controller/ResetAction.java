package com.hrbnu.se2104.controller;

import com.hrbnu.se2104.entity.Piece.ChessPiece;
import com.hrbnu.se2104.view.ChessPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.Stack;

public class ResetAction implements EventHandler<MouseEvent> {
    private final ChessPane chessPane;

    public ResetAction(ChessPane chessPane) {
        this.chessPane = chessPane;
    }

    @Override
    public void handle(MouseEvent event) {
        Stack<ChessPiece> stack = ReleaseAction.stack;
        if (!stack.empty()) {
            chessPane.getChessPieces().removeIf(piece -> piece.equals(stack.peek())); // 去除原来的棋子
            chessPane.getChessPieces().add(stack.pop()); // 将以前压入栈的棋子重新加入

            chessPane.drawBoard();
            chessPane.drawPiece();
        }
    }
}
