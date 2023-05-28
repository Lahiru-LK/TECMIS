package com.tecmis.project.Lecturer;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class UpdateMarksController implements Initializable {
    @FXML
    private TextField Final_theory_F;

    @FXML
    private TextField assessment_F;

    @FXML
    private TextField final_practical_F;

    @FXML
    private TextField grade_F;

    @FXML
    private TextField mid_term_F;

    @FXML
    private TextField quizzes_F;

    @FXML
    private TextField subjct_code_F;

    @FXML
    private JFXButton subjectmarksAdd_btn;

    @FXML
    private JFXButton subjectmarksdel_btn;

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void addMarks(ActionEvent event) {

    }

    @FXML
    void clearMarks(ActionEvent event) {

    }

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    String examId=null;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
