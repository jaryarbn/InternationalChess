package com.hrbnu.se2104;

import com.hrbnu.se2104.controller.PressedAction;
import com.hrbnu.se2104.controller.ReleaseAction;
import com.hrbnu.se2104.controller.ResetAction;
import com.hrbnu.se2104.view.ChessBoard;
import com.hrbnu.se2104.view.ChessPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ChessBoard chessBoard = ChessBoard.getChessBoard(100, 0, 0);

        Media media = new Media(Paths.get("src/com/hrbnu/se2104/music/BackgroundMusic.mp3").toUri().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        ChessPane pane = new ChessPane(chessBoard);
        pane.setOnMousePressed(new PressedAction(pane, mediaPlayer));
        pane.setOnMouseReleased(new ReleaseAction(pane));

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);


        Button button = new Button("悔棋");
        button.setOnAction(new ResetAction(pane));

        hBox.getChildren().add(button);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 900, 900);
        stage.setScene(scene);
        stage.setTitle("InternationalChess简易版");
        stage.show();
    }
}
