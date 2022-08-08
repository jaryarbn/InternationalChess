package com.hrbnu.se2104.view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

public class ChessBoard {
    public void chessBoard() {
        Stage stage =new Stage();
        GridPane pane=new GridPane();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                Rectangle rectangle=new Rectangle(80,80);
                rectangle.setFill(Color.BLACK);
                if ((i+j)%2==0){
                    pane.add(rectangle,i,j);
                }
            }
        }
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
