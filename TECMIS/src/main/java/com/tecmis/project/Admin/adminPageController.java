package com.tecmis.project.Admin;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.tecmis.project.Admin.Courses.courseController;
import com.tecmis.project.Admin.Notices.noticeController;
import com.tecmis.project.Admin.Profiles.profileController;
import com.tecmis.project.UserSession;
import com.tecmis.project.connection_DB.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class adminPageController implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnCourse;
    @FXML
    private Button btnNotice;

    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private AnchorPane profile_form;

    @FXML
    private TableColumn<profileController, String> adduser_createDate;
    @FXML
    private TableColumn<profileController, String> adduser_address;

    @FXML
    private TableColumn<profileController, String> adduser_dob;

    @FXML
    private TableColumn<profileController, String> adduser_email;

    @FXML
    private TableColumn<profileController, String> adduser_firstname;

    @FXML
    private TableColumn<profileController, String> adduser_id;

    @FXML
    private TableColumn<profileController, String> adduser_lastname;

    @FXML
    private TableColumn<profileController, String> adduser_password;

    @FXML
    private TableColumn<profileController, String> adduser_propicture;

    @FXML
    private TableColumn<profileController, String> adduser_role;

    @FXML
    private TableColumn<profileController, String> adduser_sex;

    @FXML
    private TableColumn<profileController, String> adduser_tpnumber;
    @FXML
    private TableView<profileController> adduser_tableView;
    @FXML
    private TextField addUser_AddressC;

    @FXML
    private TextField addUser_EmailC;

    @FXML
    private TextField addUser_FirstNameC;

    @FXML
    private TextField addUser_LastNameC;

    @FXML
    private TextField addUser_PasswordC;

    @FXML
    private TextField addUser_tpNumberC;

    @FXML
    private TextField addUser_useridC;

    @FXML
    private ImageView addUser_imageViewC;
    @FXML
    private JFXComboBox<?> addUser_sexC;
    @FXML
    private JFXComboBox<?> addUser_roleC;
    @FXML
    private DatePicker addUser_dobC;


    @FXML
    private AnchorPane UserDataEnterArea;

    @FXML
    private TextField addProfile_SearchC;
    @FXML
    private AnchorPane userTablearea;
    @FXML
    private TableColumn<profileController, String> adduser_course;
    @FXML
    private JFXComboBox<?> addUser_CourseC;

    @FXML
    private AnchorPane CourseDataEnterArea;

    @FXML
    private TableColumn<courseController, String> availableCourse_C_course;

    @FXML
    private TableColumn<courseController, String> availableCourse_C_degree;

    @FXML
    private TableColumn<courseController, String> availableCourse_C_description;
    @FXML
    private TableColumn<courseController, String> availableCourse_C_creatDate;

    @FXML
    private TextField availableCourse_courseC;

    @FXML
    private TextField availableCourse_degreeC;

    @FXML
    private TextField availableCourse_descriptionC;

    @FXML
    private TableView<courseController> availableCourse_tableView;
    @FXML
    private AnchorPane course_form;

    @FXML
    private AnchorPane notice_form;

    @FXML
    private TextField availableCourse_search;


    @FXML
    private Rectangle addUser_imageViewNew;

    @FXML
    private Rectangle addNotice_imageViewNew;



    @FXML
    private TableColumn<noticeController, String> addNotice_C_bodyOfNotice;

    @FXML
    private TableColumn<noticeController, Date> addNotice_C_creatDate;

    @FXML
    private TableColumn<noticeController, String> addNotice_C_imagepdf;

    @FXML
    private TableColumn<noticeController, String> addNotice_C_noticeID;

    @FXML
    private TableColumn<noticeController, String> addNotice_C_noticeName;

    @FXML
    private TextArea addNotice_bodyLetterC;

    @FXML
    private JFXButton addNotice_clearBtn;

    @FXML
    private ImageView addNotice_imageViewC;

    @FXML
    private TextField addNotice_nameC;

    @FXML
    private TextField addNotice_noticeIDC;

    @FXML
    private TableView<noticeController> addNotice_tableView;

    @FXML
    private JFXButton addNotice_uploadBtn;

    @FXML
    private AnchorPane NoticeDataEnterArea;
    @FXML
    private TextField addNotice_SearchC;

    @FXML
    private AnchorPane timeTable_form;


    @FXML
    private Circle UserImage_View;


    @FXML
    private Label User_firstnameF;

    @FXML
    private Text UserTEXT;


    @FXML
    private Label User_lastnameL;

    @FXML
    private ImageView xxx;

    @FXML
    private Label aaa;

    @FXML
    private Circle UserImage_ViewCircle;

    @FXML
    private Label logeUserName;

    @FXML
    private Label currentAge;
    @FXML
    private Label logeUserPassword;


    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;

























    //combobox
    public void addProfileCourseList(){

        String listCourse = "SELECT * FROM course";

        connect = JDBC.getConnection();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()){
                listC.add(result.getString("course_name"));
            }
            addUser_CourseC.setItems(listC);


        }catch (Exception e){e.printStackTrace();}

    }






    private String[] roleList = {"Admin", "Lecturer", "Technical_Officer", "Student"};
    public void addProfileRoleList(){

        List<String> roleL = new ArrayList<>();

        for(String data: roleList){
            roleL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(roleL);
        addUser_roleC.setItems(ObList);
    }

    private String[] genderList = {"males", "female", "other"};
    public void addProfileGenderList(){

        List<String> genderL = new ArrayList<>();

        for(String data: genderList){
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addUser_sexC.setItems(ObList);
    }


    public void addProfileUploadImage(){

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));



        File file = open.showOpenDialog(profile_form.getScene().getWindow());

        if (file != null){


            image = new Image(file.toURI().toString(),0, 0, true, false );
            addUser_imageViewNew.setFill(new ImagePattern(image));


            getData.path = file.getAbsolutePath();

        }
    }



    public ObservableList<profileController> addProfileController(){
        ObservableList<profileController> listProfileController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM user";

        connect = JDBC.getConnection();

        try {

            profileController profileCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                profileCD = new profileController(result.getString("user_role")
                        , result.getString("user_id")
                        , result.getString("user_password")
                        , result.getString("course")
                        , result.getString("first_name")
                        , result.getString("last_name")
                        , result.getString("email")
                        , result.getDate("dob")
                        , result.getString("sex")
                        , result.getString("address")
                        , result.getString("tp_number")
                        , result.getString("profile_image")
                        , result.getDate("date")
                        );

                listProfileController.add(profileCD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listProfileController;
    }

    private ObservableList<profileController> addProfileCD;

    public void addProfileshowData(){
        addProfileCD = addProfileController();

        adduser_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        adduser_password.setCellValueFactory(new PropertyValueFactory<>("user_password"));
        adduser_role.setCellValueFactory(new PropertyValueFactory<>("user_role"));
        adduser_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        adduser_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        adduser_firstname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        adduser_lastname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        adduser_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        adduser_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        adduser_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        adduser_tpnumber.setCellValueFactory(new PropertyValueFactory<>("tp_number"));
        adduser_propicture.setCellValueFactory(new PropertyValueFactory<>("profile_image"));
        adduser_createDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        adduser_tableView.setItems(addProfileCD);
    }

    public void addProfilesSelect(){

        profileController profileD = adduser_tableView.getSelectionModel().getSelectedItem();
        int num = adduser_tableView.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) {return;}



        addUser_useridC.setText(String.valueOf(profileD.getUser_id()));
        addUser_PasswordC.setText(String.valueOf(profileD.getUser_password()));
        addUser_EmailC.setText(String.valueOf(profileD.getEmail()));
        addUser_FirstNameC.setText(String.valueOf(profileD.getFirst_name()));
        addUser_LastNameC.setText(String.valueOf(profileD.getLast_name()));
        addUser_AddressC.setText(String.valueOf(profileD.getAddress()));
        addUser_tpNumberC.setText(String.valueOf(profileD.getTp_number()));
        addUser_dobC.setValue(LocalDate.parse(String.valueOf(profileD.getDob())));




        String uri = "file:" + profileD.getProfile_image();
        image = new Image(uri, 0, 0, true, false);
        addUser_imageViewNew.setFill(new ImagePattern(image));

        getData.path = profileD.getProfile_image();

    }


    public void addProfileAdd(){
        String insertDATA = "INSERT INTO user"
                +"(user_role,user_id,user_password,course,first_name,last_name,email,dob,sex,address,tp_number,profile_image,date)"
                +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        connect = JDBC.getConnection();

        try {

            Alert alert;


            if (addUser_useridC.getText().isEmpty()
                    || addUser_PasswordC.getText().isEmpty()
                    || addUser_roleC.getSelectionModel().getSelectedItem() == null
                    || addUser_EmailC.getText().isEmpty()
                    || addUser_FirstNameC.getText().isEmpty()
                    || addUser_LastNameC.getText().isEmpty()
                    || addUser_dobC.getValue() == null
                    || addUser_sexC.getSelectionModel().getSelectedItem() == null
                    || addUser_AddressC.getText().isEmpty()
                    || addUser_tpNumberC.getText().isEmpty()
                    || getData.path == null || getData.path == "" ){

                UserDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(UserDataEnterArea).play();
            alert= new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

            }else {

                //check if the user is already exist

                String checkData = "SELECT user_id FROM user WHERE user_id = '"
                        +addUser_useridC.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){

                    UserDataEnterArea.setStyle(null);
                    addUser_useridC.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                    new animatefx.animation.Bounce(addUser_useridC).play();

                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("User ID '" + addUser_useridC.getText() + "' was already exist!");
                    alert.showAndWait();

                }else {

                    addUser_useridC.setStyle(null);
                    prepare = connect.prepareStatement(insertDATA);
                    prepare.setString(1,(String)addUser_roleC.getSelectionModel().getSelectedItem()) ;
                    prepare.setString(2, addUser_useridC.getText());
                    prepare.setString(3, addUser_PasswordC.getText());
                    prepare.setString(4,(String)addUser_CourseC.getSelectionModel().getSelectedItem());
                    prepare.setString(5,addUser_FirstNameC.getText());
                    prepare.setString(6,addUser_LastNameC.getText());
                    prepare.setString(7,addUser_EmailC.getText());
                    prepare.setString(8,String.valueOf(addUser_dobC.getValue()));
                    prepare.setString(9,(String)addUser_sexC.getSelectionModel().getSelectedItem());
                    prepare.setString(10,addUser_AddressC.getText());
                    prepare.setString(11,addUser_tpNumberC.getText());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(12, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(13,String.valueOf(sqlDate));


                    prepare.executeUpdate();

                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //to update the tableview
                    addProfileshowData();

                    //to clear the fields
                    addProfileClear();

                    //to search th fields
                    addProfilesSearch();

                    //main front image and name
                    loadUserData();

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public  void addProfileUpdate(){

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");



        String updateData = " UPDATE user SET "
                + "user_password  = '"+ addUser_PasswordC.getText()
                + "', user_role = '"+ addUser_roleC.getSelectionModel().getSelectedItem()
                + "', course = '"+ addUser_CourseC.getSelectionModel().getSelectedItem()
                + "', email = '"+ addUser_EmailC.getText()
                + "', first_name = '"+ addUser_FirstNameC.getText()
                + "', last_name = '"+ addUser_LastNameC.getText()
                + "', dob = '"+ addUser_dobC.getValue()
                + "', sex = '"+ addUser_sexC.getSelectionModel().getSelectedItem()
                + "', address = '"+ addUser_AddressC.getText()
                + "', tp_number = '"+ addUser_tpNumberC.getText()
                + "', profile_image = '"+ uri +"'WHERE user_id = '" +addUser_useridC.getText()+"'";

        connect = JDBC.getConnection();


        try {
            Alert alert;
            if (addUser_useridC.getText().isEmpty()
                    || addUser_PasswordC.getText().isEmpty()
                    || addUser_roleC.getSelectionModel().getSelectedItem() == null
                    || addUser_EmailC.getText().isEmpty()
                    || addUser_FirstNameC.getText().isEmpty()
                    || addUser_LastNameC.getText().isEmpty()
                    || addUser_dobC.getValue() == null
                    || addUser_sexC.getSelectionModel().getSelectedItem() == null
                    || addUser_AddressC.getText().isEmpty()
                    || addUser_tpNumberC.getText().isEmpty()
                    || getData.path == null || getData.path == "" ){

                UserDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(UserDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {


                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE User ID '" + addUser_useridC.getText() + "' ?" );
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){

                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    UserDataEnterArea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //to update the tableview
                    addProfileshowData();

                    //to clear the fields
                    addProfileClear();

                    //to search th fields
                    addProfilesSearch();

                    //main front image and name
                    loadUserData();




                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }


    public void addProfileDelete(){

        String deleteData = "DELETE FROM user WHERE user_id = '"
                +addUser_useridC.getText()+"'";

        connect = JDBC.getConnection();

        try {
            Alert alert;
            if (addUser_useridC.getText().isEmpty()
                    || addUser_PasswordC.getText().isEmpty()
                    || addUser_roleC.getSelectionModel().getSelectedItem() == null
                    || addUser_EmailC.getText().isEmpty()
                    || addUser_FirstNameC.getText().isEmpty()
                    || addUser_LastNameC.getText().isEmpty()
                    || addUser_dobC.getValue() == null
                    || addUser_sexC.getSelectionModel().getSelectedItem() == null
                    || addUser_AddressC.getText().isEmpty()
                    || addUser_tpNumberC.getText().isEmpty()
                    || getData.path == null || getData.path == "" ){

                UserDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(UserDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {
                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE User ID '" + addUser_useridC.getText() + "' ?" );


                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    UserDataEnterArea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //to update the tableview
                    addProfileshowData();

                    //to clear the fields
                    addProfileClear();

                    //to search th fields
                    addProfilesSearch();

                    //main front image and name
                    loadUserData();


                }else return;

            }

        }catch (Exception e){e.printStackTrace();}
    }


    public void addProfileClear(){
        addUser_useridC.setText("");
        addUser_PasswordC.setText("");
        addUser_roleC.getSelectionModel().clearSelection();
        addUser_CourseC.getSelectionModel().clearSelection();
        addUser_EmailC.setText("");
        addUser_FirstNameC.setText("");
        addUser_LastNameC.setText("");
        addUser_dobC.setValue(null);
        addUser_sexC.getSelectionModel().clearSelection();
        addUser_AddressC.setText("");
        addUser_tpNumberC.setText("");
        addUser_imageViewNew.setFill(null);
        getData.path = "";
        UserDataEnterArea.setStyle(null);
        addUser_useridC.setStyle(null);
        addProfile_SearchC.setText("");

        addProfilesSearch();
    }



    public ObservableList<courseController> availableCourseListData(){
        ObservableList<courseController> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course";

        connect = JDBC.getConnection();

        try {

            courseController courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                courseD = new courseController(result.getString("course_name")
                        , result.getString("description")
                        , result.getString("degree")
                        , result.getDate("date")
                );

                listData.add(courseD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<courseController> availableCourseD;

    public void availableCourseShowData(){
        availableCourseD = availableCourseListData();

        availableCourse_C_course.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        availableCourse_C_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        availableCourse_C_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));
        availableCourse_C_creatDate.setCellValueFactory(new PropertyValueFactory<>("date"));


        availableCourse_tableView.setItems(availableCourseD);
    }


    public void availableCourseSelect(){

        courseController courseD = availableCourse_tableView.getSelectionModel().getSelectedItem();
        int num = availableCourse_tableView.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) {return;}

        availableCourse_courseC.setText(String.valueOf(courseD.getCourse_name()));
        availableCourse_descriptionC.setText(String.valueOf(courseD.getDescription()));
        availableCourse_degreeC.setText(String.valueOf(courseD.getDegree()));

    }

    public void availableCourseAdd(){

        String insertDATA = "INSERT INTO course"
                +"(course_name,description,degree,date)"
                +"VALUES(?,?,?,?)";

        connect = JDBC.getConnection();

        try {

            Alert alert;


            if (availableCourse_courseC.getText().isEmpty()
                    || availableCourse_descriptionC.getText().isEmpty()
                    || availableCourse_degreeC.getText().isEmpty()){

                CourseDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(CourseDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {

                //check if the course is already exist

                String checkData = "SELECT course_name FROM course WHERE course_name = '"
                        +availableCourse_courseC.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){

                    CourseDataEnterArea.setStyle(null);
                    availableCourse_courseC.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                    new animatefx.animation.Bounce(availableCourse_courseC).play();

                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Course ID '" + availableCourse_courseC.getText() + "' was already exist!");
                    alert.showAndWait();

                }else {

                    availableCourse_courseC.setStyle(null);
                    prepare = connect.prepareStatement(insertDATA);


                    prepare.setString(1, availableCourse_courseC.getText());
                    prepare.setString(2, availableCourse_descriptionC.getText());
                    prepare.setString(3,availableCourse_degreeC.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(4,String.valueOf(sqlDate));


                    prepare.executeUpdate();

                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //to update the tableview
                    availableCourseShowData();

                    //to clear the fields
                    availableCourseClear();


                    //to search the fields
                    availableCourseSearch();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void availableCourseClear(){
        availableCourse_courseC.setText("");
        availableCourse_descriptionC.setText("");
        availableCourse_degreeC.setText("");
        CourseDataEnterArea.setStyle(null);
        availableCourse_courseC.setStyle(null);
        availableCourse_search.setText("");

        addNoticeSearch();

    }

    public  void availableCourseUpdate(){

        String updateData = " UPDATE course SET "
                + "description  = '"+ availableCourse_descriptionC.getText()
                + "', degree = '"+ availableCourse_degreeC.getText() +"'";

        connect = JDBC.getConnection();


        try {
            Alert alert;
            if (availableCourse_courseC.getText().isEmpty()
                    || availableCourse_descriptionC.getText().isEmpty()
                    || availableCourse_degreeC.getText().isEmpty()){

                CourseDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(CourseDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {


                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Course ID '" + availableCourse_courseC.getText() + "' ?" );

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){

                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    CourseDataEnterArea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //to update the tableview
                    availableCourseShowData();

                    //to clear the fields
                    availableCourseClear();


                    //to saearch the fields
                    availableCourseSearch();


                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void availableCourseDelete(){

        String deleteData = "DELETE FROM course WHERE course_name = '"
                +availableCourse_courseC.getText()+"'";

        connect = JDBC.getConnection();

        try {
            Alert alert;
            if (availableCourse_courseC.getText().isEmpty()
                    || availableCourse_descriptionC.getText().isEmpty()
                    || availableCourse_degreeC.getText().isEmpty()){

                CourseDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(CourseDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {
                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course ID '" + availableCourse_courseC.getText() + "' ?" );


                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    availableCourse_courseC.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //to update the tableview
                    availableCourseShowData();

                    //to clear the fields
                    availableCourseClear();

                    //to saearch the fields
                    availableCourseSearch();

                }else return;

            }

        }catch (Exception e){e.printStackTrace();}
    }

    public void SignOutButtonAction(ActionEvent event)throws IOException
    {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to Logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)){

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("..//login.fxml")));
                new FadeIn(root).play();

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root, 600,400);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
                stage.resizableProperty().setValue(false);

            }else return;



        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public void addProfilesSearch(){

        FilteredList<profileController> filteredList = new FilteredList<>(addProfileCD, e-> true);

        addProfile_SearchC.textProperty().addListener((Observable, oldValue, newValue) ->{

            filteredList.setPredicate(predicateProfleController ->{

                if (newValue == null || newValue.isEmpty()){
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateProfleController.getUser_id().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getFirst_name().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getSex().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getUser_role().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getLast_name().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getTp_number().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getDob().toString().contains(searchKey)) {
                    return true;
                }
                else {return false;}
            });
        });

        SortedList<profileController> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(adduser_tableView.comparatorProperty());
        adduser_tableView.setItems(sortedList);
    }

    public void availableCourseSearch(){

        FilteredList<courseController> filteredList = new FilteredList<>(availableCourseD, e-> true);

        availableCourse_search.textProperty().addListener((Observable, oldValue, newValue) ->{

            filteredList.setPredicate(predicateProfleController ->{

                if (newValue == null || newValue.isEmpty()){
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateProfleController.getCourse_name().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getDegree().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateProfleController.getDescription().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateProfleController.getDate().toString().contains(searchKey)) {
                    return true;
                }
                else {return false;}
            });
        });

        SortedList<courseController> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(availableCourse_tableView.comparatorProperty());
        availableCourse_tableView.setItems(sortedList);
    }

    public void addNoticeSearch(){

        FilteredList<noticeController> filteredList = new FilteredList<>(addNoticeListD, e-> true);

        addNotice_SearchC.textProperty().addListener((Observable, oldValue, newValue) ->{

            filteredList.setPredicate(predicateNoticeController ->{

                if (newValue == null || newValue.isEmpty()){
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateNoticeController.getNotice_id().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateNoticeController.getNotice_name().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateNoticeController.getBodyof_notice().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateNoticeController.getNotice_createdate().toString().contains(searchKey)) {
                    return true;
                }
                else {return false;}
            });
        });

        SortedList<noticeController> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(addNotice_tableView.comparatorProperty());
        addNotice_tableView.setItems(sortedList);
    }





    public void addNoticeUploadImage(){

        FileChooser open = new FileChooser();
        open.setTitle("Open Image/PDF File");

        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));
//        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*pdf"));

        File file = open.showOpenDialog(notice_form.getScene().getWindow());

        if (file != null){


            image = new Image(file.toURI().toString(),0, 0, true, false );
            addNotice_imageViewNew.setFill(new ImagePattern(image));

            getData.path = file.getAbsolutePath();

        }
    }


    public ObservableList<noticeController> addNoticeListData(){
        ObservableList<noticeController> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM notice";

        connect = JDBC.getConnection();

        try {

            noticeController noticeD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                noticeD = new noticeController(result.getString("notice_id")
                        , result.getString("notice_name")
                        , result.getString("bodyof_notice")
                        , result.getString("notice_imagepdf")
                        , result.getDate("notice_createdate")
                );

                listData.add(noticeD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<noticeController> addNoticeListD;

    public void addNoticeShowData(){
        addNoticeListD = addNoticeListData();

        addNotice_C_noticeID.setCellValueFactory(new PropertyValueFactory<>("notice_id"));
        addNotice_C_noticeName.setCellValueFactory(new PropertyValueFactory<>("notice_name"));
        addNotice_C_bodyOfNotice.setCellValueFactory(new PropertyValueFactory<>("bodyof_notice"));
        addNotice_C_imagepdf.setCellValueFactory(new PropertyValueFactory<>("notice_imagepdf"));
        addNotice_C_creatDate.setCellValueFactory(new PropertyValueFactory<>("notice_createdate"));

        addNotice_tableView.setItems(addNoticeListD);
    }


    public void addNoticeSelect(){

        noticeController noticeD = addNotice_tableView.getSelectionModel().getSelectedItem();
        int num = addNotice_tableView.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) {return;}



        addNotice_noticeIDC.setText(String.valueOf(noticeD.getNotice_id()));
        addNotice_nameC.setText(String.valueOf(noticeD.getNotice_name()));
        addNotice_bodyLetterC.setText(String.valueOf(noticeD.getBodyof_notice()));

        String uri = "file:" + noticeD.getNotice_imagepdf();
        image = new Image(uri, 0, 0, true, false);
        addNotice_imageViewNew.setFill(new ImagePattern(image));

        getData.path = noticeD.getNotice_imagepdf();

    }

    public void addNoticeAdd(){
        String insertDATA = "INSERT INTO notice"
                +"(notice_id,notice_name,bodyof_notice,notice_createdate,notice_imagepdf)"
                +"VALUES(?,?,?,?,?)";

        connect = JDBC.getConnection();

        try {

            Alert alert;


            if (addNotice_noticeIDC.getText().isEmpty()
                    || addNotice_nameC.getText().isEmpty()
                    || addNotice_bodyLetterC.getText().isEmpty()
                    || getData.path == null || getData.path == "" ){

                NoticeDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(NoticeDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {

                //check if the user is already exist

                String checkData = "SELECT notice_id FROM notice WHERE notice_id = '"
                        +addNotice_noticeIDC.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){

                    NoticeDataEnterArea.setStyle(null);
                    addNotice_noticeIDC.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                    new animatefx.animation.Bounce(addNotice_noticeIDC).play();

                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Notice ID '" + addNotice_noticeIDC.getText() + "' was already exist!");
                    alert.showAndWait();

                }else {

                    addNotice_noticeIDC.setStyle(null);
                    prepare = connect.prepareStatement(insertDATA);

                    prepare.setString(1, addNotice_noticeIDC.getText());
                    prepare.setString(2, addNotice_nameC.getText());
                    prepare.setString(3,addNotice_bodyLetterC.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(4,String.valueOf(sqlDate));


                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(5, uri);



                    prepare.executeUpdate();

                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //to update the tableview
                    addNoticeShowData();

                    //to clear the fields
                    addNoticeClear();

                    //to search th fields
                    addNoticeSearch();

                    //get to session data
                    loadUserData();

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void addNoticeClear(){
        addNotice_nameC.setText("");
        addNotice_bodyLetterC.setText("");
        addNotice_noticeIDC.setText("");
        addUser_FirstNameC.setText("");
        addNotice_SearchC.setText("");
        addNotice_imageViewNew.setFill(null);
        getData.path = "";
        NoticeDataEnterArea.setStyle(null);
        addNotice_noticeIDC.setStyle(null);

        addNoticeSearch();

    }



    public  void addNoticeUpdate(){

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");



        String updateData = " UPDATE notice SET "
                + " notice_name = '"+ addNotice_nameC.getText()
                + "', bodyof_notice = '"+ addNotice_bodyLetterC.getText()
                + "', notice_imagepdf = '"+ uri +"'WHERE notice_id = '" +addNotice_noticeIDC.getText()+"'";

        connect = JDBC.getConnection();


        try {
            Alert alert;

            if (addNotice_noticeIDC.getText().isEmpty()
                    || addNotice_nameC.getText().isEmpty()
                    || addNotice_bodyLetterC.getText().isEmpty()
                    || getData.path == null || getData.path == "" ){

                NoticeDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(NoticeDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {


                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Notice ID '" + addNotice_noticeIDC.getText() + "' ?" );
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){

                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    NoticeDataEnterArea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //to update the tableview
                    addNoticeShowData();

                    //to clear the fields
                    addNoticeClear();

                    //to search th fields
                    addNoticeSearch();

                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void addCourseDelete(){

        String deleteData = "DELETE FROM notice WHERE notice_id = '"
                +addNotice_noticeIDC.getText()+"'";

        connect = JDBC.getConnection();

        try {
            Alert alert;
            if (addNotice_noticeIDC.getText().isEmpty()
                    || addNotice_nameC.getText().isEmpty()
                    || addNotice_bodyLetterC.getText().isEmpty()
                    || getData.path == null || getData.path == "" ){

                NoticeDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(NoticeDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {
                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Notice ID '" + addNotice_noticeIDC.getText() + "' ?" );


                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    NoticeDataEnterArea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //to update the tableview
                    addNoticeShowData();

                    //to clear the fields
                    addNoticeClear();

                    //to search th fields
                    addNoticeSearch();


                }else return;

            }

        }catch (Exception e){e.printStackTrace();}
    }











//-----------------------------------------------------------------------------------------------------------------------------------


    public void switchForm(ActionEvent event) {
        if (event.getSource()==btnDashboard){
            dashboard_form.setVisible(true);
            profile_form.setVisible(false);
            course_form.setVisible(false);
            course_form.setVisible(false);
            notice_form.setVisible(false);

            btnDashboard.setStyle("-fx-background-color: #d62651;");
            btnProfile.setStyle("-fx-background-color: transparent");
            btnCourse.setStyle("-fx-background-color: transparent");
            btnNotice.setStyle("-fx-background-color: transparent");





        } else if (event.getSource()==btnProfile) {
            dashboard_form.setVisible(false);
            profile_form.setVisible(true);
            course_form.setVisible(false);
            notice_form.setVisible(false);

            btnDashboard.setStyle("-fx-background-color:transparent ;");
            btnProfile.setStyle("-fx-background-color: #d62651");
            btnCourse.setStyle("-fx-background-color: transparent");
            btnNotice.setStyle("-fx-background-color: transparent");


            //to become updared once you click the add stuydent button on nav
            addProfileshowData();
            addProfileRoleList();
            addProfileGenderList();
            addProfileCourseList();
            addProfilesSearch();

        } else if (event.getSource()==btnCourse) {
            dashboard_form.setVisible(false);
            profile_form.setVisible(false);
            course_form.setVisible(true);
            notice_form.setVisible(false);


            btnDashboard.setStyle("-fx-background-color:transparent ;");
            btnProfile.setStyle("-fx-background-color: transparent");
            btnCourse.setStyle("-fx-background-color: #d62651");
            btnNotice.setStyle("-fx-background-color: transparent");

            availableCourseShowData();
            availableCourseSearch();



        }else if (event.getSource()==btnNotice) {
            dashboard_form.setVisible(false);
            profile_form.setVisible(false);
            course_form.setVisible(false);
            notice_form.setVisible(true);


            btnDashboard.setStyle("-fx-background-color:transparent ;");
            btnProfile.setStyle("-fx-background-color: transparent");
            btnCourse.setStyle("-fx-background-color: transparent");
            btnNotice.setStyle("-fx-background-color: #d62651");

            addNoticeShowData();
            addNoticeSearch();


        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnDashboard.setStyle("-fx-background-color: #d62651;");

        loadUserData();

        //to show immediately when we open the dashboard
        addProfileshowData();
        availableCourseShowData();
        addNoticeShowData();
        addProfileRoleList();
        addProfileGenderList();
        addProfileCourseList();



    }



    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;

    //Usiing session get to name and Image

    public void loadUserData(){


        try {


            connection = JDBC.getConnection();
            query = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                User_firstnameF.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name") );
                logeUserName.setText(resultSet.getString("user_id") );
                logeUserPassword.setText(resultSet.getString("user_password"));


                Date dob = resultSet.getDate("dob"); // Retrieve the date of birth from the ResultSet

                long diffInMillis = System.currentTimeMillis() - dob.getTime();// Calculate the time difference between the date of birth and now
                long ageInMillis = TimeUnit.MILLISECONDS.toDays(diffInMillis) / 365;// Convert the time difference to years
                int age = (int) ageInMillis;

                currentAge.setText(String.valueOf(age)); // Set the age in a text field, label, or wherever else you need it

                String uri = "file:" + resultSet.getString("profile_image");
                image = new Image(uri, 0, 0, true, false);

                UserImage_ViewCircle.setFill(new ImagePattern(image));

            }

        }catch (Exception e){e.printStackTrace();
        }

    }

}



