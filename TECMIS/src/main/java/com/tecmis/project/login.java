package com.tecmis.project;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class login extends Application {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(login.class.getResource("login.fxml"));
       // primaryStage.initStyle(StageStyle.UNDECORATED); //title close and minimise button hide karanne me code eken
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(TitleIcon.class.getResourceAsStream("image/logo.png")));
        primaryStage.setTitle("TECMIS");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}