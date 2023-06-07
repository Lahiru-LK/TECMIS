package com.tecmis.project.Lecturer;

import animatefx.animation.Shake;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.tecmis.project.UserSession;
import com.tecmis.project.connection_DB.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class UpdateMarksController implements Initializable {
    @FXML
    private JFXComboBox<String> Course_combo;

    @FXML
    private JFXComboBox<String> Exam_combo;

    @FXML
    private JFXComboBox<String> RegNo_combo;

    @FXML
    private TextField marks_F;

    @FXML
    private Label error;

    @FXML
    private JFXButton subjectmarksAdd_btn;

    @FXML
    private JFXButton subjectmarksdel_btn;

    @FXML
    private TableView<MarksInformation> marks_Table;


    @FXML
    void addMarks(ActionEvent event) {

    }

    @FXML
    void clearMarks(ActionEvent event) {

    }


    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;

    private Stage stage;
    private Scene scene;

    String query = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    String exam_Id=null;



//    public void  CourseDataLoad(){
//        try {
//           // int depId= Integer.parseInt(UserSession.getUserDepId());
//            connect = JDBC.getConnection();
//            query="SELECT * FROM course WHERE course.course_id="+depId+"";
//            preparedStatement = connect.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            ObservableList data = FXCollections.observableArrayList();
//
//            while (resultSet.next()){
//                data.add(new String(resultSet.getString("description")));
//            }
//            Course_combo.setItems(data);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//

//    public void  userDataLoad(){
//        try {
//            int depId= Integer.parseInt(UserSession.getUserDepId());
//            connect = JDBC.getConnection();
//            query="SELECT * FROM user,department WHERE user.department_id =department.department_id  AND user_roll='Student' AND user.department_id="+depId+"";
//            preparedStatement = connect.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            ObservableList data = FXCollections.observableArrayList();
//
//            while (resultSet.next()){
//                data.add(new String(resultSet.getString("user_id")));
//            }
//            RegNo_combo.setItems(data);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
    @FXML
    void clearMarks(javafx.event.ActionEvent event) {
        reset();
    }

    @FXML
    void addMarks(javafx.event.ActionEvent event) throws SQLException {
        if (Exam_combo.getValue() == null || Course_combo.getValue() == null || RegNo_combo.getValue() == null || marks_F.getText().isEmpty()) {
            new Shake(error).play();
            error.setText("Please fill all fields");
        } else {
            try {
                String e_type = Exam_combo.getValue();
                String subject_code = Course_combo.getValue();
                String user_id = RegNo_combo.getValue();
                Float marks = Float.parseFloat(marks_F.getText());

                connect = JDBC.getConnection();

                // Check if the data already exists in the database
                query = "SELECT * FROM marks WHERE user_id = ? AND Subject_code = ? AND etype = ?";
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, user_id);
                preparedStatement.setString(2, subject_code);
                preparedStatement.setString(3, e_type);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Data already exists, show an alert
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Duplicate Entry");
                    alert.setHeaderText(null);
                    alert.setContentText("The data you entered already exists in the database!");
                    alert.showAndWait();
                } else {
                    // Data doesn't exist, insert it into the database
                    query = "INSERT INTO marks(user_id, marks, Subject_code, etype) VALUES (?, ?, ?, ?)";
                    preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, user_id);
                    preparedStatement.setFloat(2, marks);
                    preparedStatement.setString(3, subject_code);
                    preparedStatement.setString(4, e_type);
                    preparedStatement.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Marks added successfully!");
                    alert.showAndWait();



                    reset();

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UpdateMarks.fxml")));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.close();


                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void reset(){
        marks_F.setText("");
        RegNo_combo.setValue("");
        Course_combo.setValue("");
        Exam_combo.setValue("");
    }


    public void addProfileCourseList(){

        String listCourse = "SELECT * FROM subject";

        connect = JDBC.getConnection();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()){
                listC.add(result.getString("Subject_code"));
            }
            Course_combo.setItems(listC);


        }catch (Exception e){e.printStackTrace();}

    }

    public void addProfileUserList(){

        String listCourse = "SELECT * FROM user where user.user_role='Student'";

        connect = JDBC.getConnection();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()){
                listC.add(result.getString(2));
            }
            RegNo_combo.setItems(listC);


        }catch (Exception e){e.printStackTrace();}

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Exam_combo.setItems(FXCollections.observableArrayList("Quiz 1","Quiz 2","Quiz 3","Assessment 1","Assessment 2","Mid term","Final theory","Final practical"));
//        userDataLoad();
//        CourseDataLoad();
        addProfileCourseList();
        addProfileUserList();



    }
}
