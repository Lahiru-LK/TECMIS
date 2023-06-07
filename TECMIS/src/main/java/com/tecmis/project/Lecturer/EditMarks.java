package com.tecmis.project.Lecturer;


import animatefx.animation.Shake;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.tecmis.project.connection_DB.JDBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class EditMarks implements Initializable {
    @FXML
    private Label error;

    @FXML
    private JFXComboBox<String> Course_combo_2;
    @FXML
    private JFXComboBox<String> Exam_combo_2;

    @FXML
    private JFXComboBox<String> RegNo_combo_2;

    @FXML
    private JFXButton editsubjectmarksDel_btn;

    @FXML
    private JFXButton editsubjectmarksEdit_btn;

    @FXML
    private TextField marks_F_2;

    @FXML
    void clearMarksEdit(ActionEvent event) {

    }

    @FXML
    void editMarksEdit(ActionEvent event) {

    }

    private Scene scene;
    private Stage stage;
    String etype;

    private Connection connect;

    private PreparedStatement prepare;

    private List<String> fetchDataFromDataSourceForExam() {
        // Connect to your database and execute a query to fetch the exam values
        // Store the retrieved values in a List<String> and return it
        // Example implementation:
        List<String> examValues = new ArrayList<>();
        try ( Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/tecmis", "root", "");
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT etype FROM marks")) {
            while (resultSet.next()) {
                String etype = resultSet.getString("etype");
                examValues.add(etype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examValues;
    }

    private List<String> fetchDataFromDataSourceForCourse() {
        // Connect to your database and execute a query to fetch the course values
        // Store the retrieved values in a List<String> and return it
        // Example implementation:
        List<String> courseValues = new ArrayList<>();
        try ( Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/tecmis", "root", "");
             Statement statement = connect.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT Subject_code  FROM marks")) {
            while (resultSet.next()) {
                String Subject_code  = resultSet.getString("Subject_code");
                courseValues.add(Subject_code);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseValues;
    }

    private List<String> fetchDataFromDataSourceForRegNo() {
        // Connect to your database and execute a query to fetch the course values
        // Store the retrieved values in a List<String> and return it
        // Example implementation:
        List<String> regNoValues = new ArrayList<>();
        try ( Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/tecmis", "root", "");
              Statement statement = connect.createStatement();
              ResultSet resultSet = statement.executeQuery("SELECT user_id FROM marks")) {
            while (resultSet.next()) {
                String user_id  = resultSet.getString("user_id");
                regNoValues.add(user_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regNoValues;
    }



    @FXML
    public void editMarksEdit(javafx.event.ActionEvent event) throws SQLException, IOException {
        if (Exam_combo_2.getValue() == null || Course_combo_2.getValue() == null ||
                RegNo_combo_2.getValue() == null || marks_F_2.getText().isEmpty()) {
            new Shake(error).play();
            error.setText("Please fill the marks Field");
        } else {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Update Marks");
            alert1.setContentText("Are you sure you want to update these Marks?");
            Optional<ButtonType> aresult = alert1.showAndWait();

            if (aresult.get() == ButtonType.OK) {
                String user_id = RegNo_combo_2.getValue();
                Float marks = Float.parseFloat(marks_F_2.getText());

                connect = JDBC.getConnection();
                String query = "UPDATE marks SET marks = ? WHERE user_id = ? AND etype = ?";
                prepare = connect.prepareStatement(query);
                prepare.setFloat(1, marks);
                prepare.setString(2, user_id);
                prepare.setString(3, Exam_combo_2.getValue());
                prepare.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successfully Updated");
                alert.setContentText("Marks have been successfully updated.");
                Optional<ButtonType> result = alert.showAndWait();

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditMarks.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.close();
            }
        }
    }

    public void reset() {
        marks_F_2.setText("");
    }

    public void showInformation(String exam_Id, String e_type, String course_name,
                                String user_id, Float marks) {
        this.etype = e_type;
        Exam_combo_2.setValue(e_type);
        Course_combo_2.setValue(course_name);
        RegNo_combo_2.setValue(user_id);
        marks_F_2.setText(Float.toString(marks));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code goes here if needed
        fetchDataFromDataSourceForExam();
        fetchDataFromDataSourceForCourse();

        Exam_combo_2.getItems().clear();
        // Clear previous items
        // Fetch exam values from the data source and add them to the ComboBox
        List<String> examValues = fetchDataFromDataSourceForExam();
        // Replace with your data retrieval logic
        Exam_combo_2.getItems().addAll(examValues);
        // Populate Course_combo_2 with existing values
        Course_combo_2.getItems().clear();
       // Clear previous items

        List<String> courseValues = fetchDataFromDataSourceForCourse(); // Replace with your data retrieval logic
        Course_combo_2.getItems().addAll(courseValues);


        RegNo_combo_2.getItems().clear(); // Clear previous items

        List<String> regNoValues = fetchDataFromDataSourceForRegNo(); // Replace with your data retrieval logic
        RegNo_combo_2.getItems().addAll(regNoValues);
    }


}
