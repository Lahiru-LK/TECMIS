package com.tecmis.project.Admin;

import com.tecmis.project.TitleIcon;
import com.tecmis.project.login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class adminPageController implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void SignOutButtonAction(ActionEvent event)throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("..//login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600,400);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        stage.resizableProperty().setValue(false);
    }
}
