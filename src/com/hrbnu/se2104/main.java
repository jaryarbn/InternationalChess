package com.hrbnu.se2104;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Optional;

public class main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button button = new Button("百度");
        BorderPane borderPane = new BorderPane(button);
        button.setOnAction(
                event -> {
                    getHostServices().showDocument("https://www.baidu.com");
                }
        );

        Platform.setImplicitExit(false);
        stage.setOnCloseRequest(event -> {
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("提示信息");
            alert.setHeaderText(null);
            alert.setContentText("您是否要退出国际象棋？");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Platform.exit();
            }
        });


        Scene scene = new Scene(borderPane, 400, 400);

        stage.setScene(scene);
        stage.setTitle("国际象棋");
        stage.show();
    }
}
