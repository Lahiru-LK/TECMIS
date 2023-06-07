package com.tecmis.project.Lecturer;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.tecmis.project.Admin.Notices.noticeController;
import com.tecmis.project.Admin.Profiles.profileController;
import com.tecmis.project.Admin.getData;
import com.tecmis.project.Lecturer.SdetailMedical.SdetailMedicalController;
import com.tecmis.project.Lecturer.coursematerials.coursematerialscontroller;
import com.tecmis.project.UserSession;
import com.tecmis.project.connection_DB.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lecturerController implements Initializable {


    @FXML
    private AnchorPane Profile_form;
    @FXML
    private Rectangle addLec_imageViewxxx;
    @FXML
    private Label UploadResultArea;
    @FXML
    private JFXComboBox<?> www;
    @FXML
    private JFXComboBox<?> addLec_SexC;

    @FXML
    private JFXComboBox<?> addLec_DepartmentListC;
    @FXML
    private JFXButton addLec_UpdateBtn;
    @FXML
    private JFXButton addLec_ClearBtn;
    @FXML
    private AnchorPane UserDataEnterArea;
    @FXML
    private Rectangle addUser_imageViewC;
    @FXML
    private TextField addUser_AddressC;


    @FXML
    private DatePicker addUser_DOBC;

    @FXML
    private JFXComboBox<?> addUser_DepartmentC;


    @FXML
    private Label UploadSuccessfullTEXT;

    @FXML
    private TextField addUser_EmailC;

    @FXML
    private TextField addUser_FirstNameC;

    @FXML
    private TextField addUser_IdC;

    @FXML
    private TextField addUser_LastNameC;

    @FXML
    private TextField addUser_PasswordC;

    @FXML
    private JFXComboBox<?> addUser_RoleC;

    @FXML
    private JFXComboBox<?> addUser_SexC;

    @FXML
    private TextField addUser_TelNumberC;

    @FXML
    private JFXButton AddMaterial_btn;

    @FXML
    private TableColumn<?, ?> Attendence_column;

    @FXML
    private JFXButton Clear_btn;

    @FXML
    private Label User_firstnameF;

    @FXML
    private AnchorPane CourseDataEnterArea1;


    @FXML
    private JFXButton Course_btn;

    @FXML
    private AnchorPane Course_form;

    @FXML
    private JFXButton Dashboard_btn;

    @FXML
    private AnchorPane Dashboard_form;

    @FXML
    private JFXButton DeleteMaterial_btn;

    @FXML
    private TextField Material_Name;

    @FXML
    private TableColumn<coursematerialscontroller, String> MaterialName_Clm;


    @FXML
    private TableColumn<?, ?> Email_column;

    @FXML
    private TableColumn<?, ?> FirstName_column;

    @FXML
    private TableColumn<?, ?> GPA_column;

    @FXML
    private TableColumn<?, ?> ICT01_column;

    @FXML
    private TableColumn<?, ?> ICT02_column;

    @FXML
    private TableColumn<?, ?> ICT03_column;

    @FXML
    private TableColumn<?, ?> ICT04_column;

    @FXML
    private TableColumn<?, ?> LastName_column;

    @FXML
    private TableColumn<coursematerialscontroller, String> LecCourseMaterials_view;

    @FXML
    private TableColumn<?, ?> MedicalRecords_column;

    @FXML
    private JFXButton Notices_bar;

    @FXML
    private JFXButton Notices_btn;

    @FXML
    private AnchorPane Notices_form;

    @FXML
    private JFXButton Profile_bar;

    @FXML
    private JFXButton Profile_btn;


    @FXML
    private TextField SDetails_Search;

    @FXML
    private JFXButton SDetails_bar;

    @FXML
    private JFXButton SDetails_btn;

    @FXML
    private AnchorPane SDetails_form;

    @FXML
    private TableColumn<?, ?> Sex_column;

    @FXML
    private TableColumn<?, ?> Telephone_column;

    @FXML
    private TableColumn<?, ?> UpdateMarks_column;

    @FXML
    private JFXButton UpdateMaterial_btn;

    @FXML
    private JFXButton UploadMarks_bar;

    @FXML
    private JFXButton UploadMarks_btn;

    @FXML
    private AnchorPane UploadMarks_form;

    @FXML
    private AnchorPane UploadMarks_view;


    @FXML
    private AnchorPane UserDataEnterArea1;

    @FXML
    private TableColumn<?, ?> UserId_column;

    @FXML
    private Circle UserImage_ViewCircle;

    @FXML
    private TableView<coursematerialscontroller> addNotice_tableView;

    @FXML
    private JFXButton addUser_AddBtn;

    @FXML
    private TextField addUser_Address;


    @FXML
    private JFXComboBox<?> addUser_Department;

    @FXML
    private DatePicker addUser_DOB;

    @FXML
    private TextField addUser_Email;

    @FXML
    private TextField addUser_FirstName;

    @FXML
    private TextField addUser_Id;

    @FXML
    private TextField addLecUser_CourseC;
    @FXML
    private TextField addUser_CourseC2;
    @FXML
    private TextField addUser_LastName;

    @FXML
    private TextField addUser_Password;

    @FXML
    private JFXComboBox<?> addUser_Role;

    @FXML
    private JFXComboBox<?> addUser_Sex;

    @FXML
    private TextField addUser_TelNumber;


    @FXML
    private JFXButton addProfile_uploadBtn;

    @FXML
    private JFXButton addUser_UpdateBtn;

    @FXML
    private JFXButton addUser_UploadBtn;

    @FXML
    private Rectangle addUser_imageView;

    @FXML
    private TableView<?> adduser_tableView;

    @FXML
    private JFXButton signOutButton;

    @FXML
    private Object Course_bar;

    @FXML
    private TableView<coursematerialscontroller> courseMaterial_tableView;

    @FXML
    private TableView<MarksInformation> marks_Table;

    @FXML
    private JFXButton uploadMarks_Updatebtn;


    @FXML
    private TableColumn<?, ?> uploadMarks_regNo_clm;

    @FXML
    private TableColumn<?, ?> uploadMarks_Name_clm;

    @FXML
    private TableColumn<?,?> uploadMarks_Course_clm;

    @FXML
    private TableColumn<?, ?> uploadMarks_Type_clm;

    @FXML
    private TableColumn<?, ?> sub;

    @FXML
    private TableColumn<?, ?> uploadMarks_Marks_clm;

    @FXML
    private TableView<noticeController> Notice_tableView1;

    @FXML
    private TableColumn<?, ?> noticeBON_clm;

    @FXML
    private TableColumn<?, ?> noticeNoticeDate_clm;

    @FXML
    private TableColumn<?, ?> noticeNoticeImg_clm;

    @FXML
    private TableColumn<?, ?> noticeNoticeName_clm;

    @FXML
    private TableColumn<?, ?> noticeNotice_Id_Clm;

    @FXML
    private TextField UploadMarks_Search;

    @FXML
    private JFXButton uploadMarks_Editbtn;

    @FXML
    private JFXButton uploadMarks_Deletebtn;

    @FXML
    private TableColumn<?, ?> SDetails_Course_Id;

    @FXML
    private TableColumn<?, ?> SDetails_Date;

    @FXML
    private TableColumn<?, ?> SDetails_Eligibility;


    @FXML
    private TableColumn<?, ?> SDetails_State;

    @FXML
    private TableColumn<?, ?> SDetails_User_Id;

    @FXML
    private TableColumn<String, SdetailMedicalController> SDtails_MedicalRecords;

    @FXML
    private TableView<Controller> SDetails_Table_View;

    @FXML
    private TableColumn<String, SdetailMedicalController> SDtails_MedicalReg_no;

    @FXML
    private TableView<SdetailMedicalController> SDetails_MedicalTable_View;



    @FXML
    void SignOutButtonAction(ActionEvent event) {

    }

    @FXML
    void addNoticeSelect(MouseEvent event) {

    }

    @FXML
    void addProfileClear(ActionEvent event) {

    }

    @FXML
    void addProfileCourseList(ActionEvent event) {

    }
    @FXML
    private JFXComboBox<?> addUser_roleC;
    @FXML
    private JFXComboBox<?> addUser_CourseC;

    @FXML
    void addProfileGenderList(ActionEvent event) {

    }

    @FXML
    void addProfileRoleList(ActionEvent event) {

    }


    @FXML
    void addProfileUploadImage(ActionEvent event) {

    }

    @FXML
    void addProfilesSelect(MouseEvent event) {

    }

    @FXML
    void availableCourseAdd(ActionEvent event) {

    }

    @FXML
    void availableCourseClear(ActionEvent event) {

    }

    @FXML
    void availableCourseDelete(ActionEvent event) {

    }

    @FXML
    void availableCourseUpdate(ActionEvent event) {

    }

    @FXML
    void addLecProfileUpdate(ActionEvent event) {

    }

    @FXML
    void DeleteLecMaterial(ActionEvent event) {

    }

    @FXML
    void updateCourseMaterial(ActionEvent event) {

    }

    @FXML
    void addLecMaterial(ActionEvent event) {

    }

    @FXML
    void chooseMaterial(ActionEvent event) {

    }

    @FXML
    void uploadmarksUpdate(ActionEvent event) {

    }

    @FXML
    void uploadmarksEdit(ActionEvent event) {

    }

    @FXML
    void courseMaterialSelect(MouseEvent event) {

    }


    @FXML
    private void switchForm() {

    }

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Connection connect;
    private PreparedStatement prepare;

    private MarksInformation marksDetails;
    private PreparedStatement prepareCheck;
    private Statement statement;
    private ResultSet result;
    private Image image;

    // Declare chosenFilePath as a class variable
    private String chosenFilePath;

    private FileChooser fileChooser;

    private FileInputStream fis;
    private File file;
    private Desktop desktop = Desktop.getDesktop();



    private double x=0;
    private double y=0;

    private String LecId;




    public void switchForm(ActionEvent event) {

        if (event.getSource() == Dashboard_btn) {

            Dashboard_form.setVisible(true);
            Profile_form.setVisible(false);
            Course_form.setVisible(false);
            UploadMarks_form.setVisible(false);
            SDetails_form.setVisible(false);
            Notices_form.setVisible(false);

        } else if (event.getSource() == Profile_btn) {
            Dashboard_form.setVisible(false);
            Profile_form.setVisible(true);
            Course_form.setVisible(false);
            UploadMarks_form.setVisible(false);
            SDetails_form.setVisible(false);
            Notices_form.setVisible(false);

            addProfileshowData();
            loadUserData();

        } else if (event.getSource() == Profile_bar) {
            Dashboard_form.setVisible(false);
            Profile_form.setVisible(true);
            Course_form.setVisible(false);
            UploadMarks_form.setVisible(false);
            SDetails_form.setVisible(false);
            Notices_form.setVisible(false);

            addProfileshowData();
            loadUserData();

        } else if (event.getSource() == Course_btn || event.getSource() == Course_bar) {
            Dashboard_form.setVisible(false);
            Profile_form.setVisible(false);
            Course_form.setVisible(true);
            UploadMarks_form.setVisible(false);
            SDetails_form.setVisible(false);
            Notices_form.setVisible(false);

            showMaterialDetail();

        } else if (event.getSource() == UploadMarks_btn || event.getSource() == UploadMarks_bar) {
            Dashboard_form.setVisible(false);
            Profile_form.setVisible(false);
            Course_form.setVisible(false);
            UploadMarks_form.setVisible(true);
            SDetails_form.setVisible(false);
            Notices_form.setVisible(false);



        } else if (event.getSource() == SDetails_btn || event.getSource() == SDetails_bar) {
            Dashboard_form.setVisible(false);
            Profile_form.setVisible(false);
            Course_form.setVisible(false);
            UploadMarks_form.setVisible(false);
            SDetails_form.setVisible(true);
            Notices_form.setVisible(false);

        }else if(event.getSource() == Notices_btn || event.getSource() == Notices_bar) {
            Dashboard_form.setVisible(false);
            Profile_form.setVisible(false);
            Course_form.setVisible(false);
            UploadMarks_form.setVisible(false);
            SDetails_form.setVisible(false);
            Notices_form.setVisible(true);

        }

    }








    public void addLecDepartmentList(){

        String listDepartment = "SELECT * FROM department";

        connect = JDBC.getConnection();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listDepartment);
            result = prepare.executeQuery();

            while (result.next()){
                listC.add(result.getString("department_id"));
            }
            addLec_DepartmentListC.setItems(listC);

        }catch (Exception e){e.printStackTrace();}



    }


    private String[] roleList = {"Admin", "Lecturer", "Technical_Officer", "Student"};
    public void addLecProfileRoleList(){

        List<String> roleL = new ArrayList<>();

        for(String data: roleList){
            roleL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(roleL);
        addUser_roleC.setItems(ObList);
    }



    private String[] genderList = {"Males", "Female", "Other"};
    public void addlecGenList(){


        List<String> genderL = new ArrayList<>();

        for(String data: genderList){
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);

        addLec_SexC.setItems(ObList);

    }
//    public void addLecProfileCourseList(){
//
//        String listCourse = "SELECT * FROM course";
//
//        connect = JDBC.getConnection();
//
//        try {
//
//            ObservableList listC = FXCollections.observableArrayList();
//
//            prepare = connect.prepareStatement(listCourse);
//            result = prepare.executeQuery();
//
//            while (result.next()){
//                listC.add(result.getString("course_id"));
//            }
//            addUser_CourseC.setItems(listC);
//
//
//        }catch (Exception e){e.printStackTrace();}
//
//    }


    public void logout(ActionEvent event)throws IOException
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



    private ObservableList<profileController> addProfileCD;

    public ObservableList<profileController> addLecProfileController() {
        ObservableList<profileController> listProfileController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM USER WHERE user_id='" + UserSession.getUserId() + "'";


        connect = JDBC.getConnection();

        try {

            profileController profileCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                profileCD = new profileController(result.getString("user_role")
                        , result.getString("user_id")
                        , result.getString("user_password")
                        , result.getString("course_id")
                        , result.getString("department_id")
                        , result.getString("first_name")
                        , result.getString("last_name")
                        , result.getString("email")
                        , result.getDate("dob")
                        , result.getString("sex")
                        , result.getString("address")
                        , result.getString("tp_number")
                        , result.getString("profile_image")
                        , result.getDate("date")
                        , result.getString("upnonupuserIMG")

                );

                listProfileController.add(profileCD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProfileController;
    }



    public void addProfileshowData() {
        addProfileCD = addLecProfileController();



        for (profileController profileCD : addProfileCD) {

            addUser_IdC.setText(String.valueOf(profileCD.getUser_id()));

            addUser_CourseC2.setText(String.valueOf(profileCD.getCourse_id()));

            addUser_PasswordC.setText(String.valueOf(profileCD.getUser_password()));
            addUser_EmailC.setText(String.valueOf(profileCD.getEmail()));
            addUser_FirstNameC.setText(String.valueOf(profileCD.getFirst_name()));
            addUser_LastNameC.setText(String.valueOf(profileCD.getLast_name()));
            addUser_DOBC.setValue(LocalDate.parse(String.valueOf(profileCD.getDob())));
            addUser_AddressC.setText(String.valueOf(profileCD.getAddress()));
            addUser_TelNumberC.setText(String.valueOf(profileCD.getTp_number()));


            if(profileCD.getUser_role().equals("Admin")){
                addUser_roleC.getSelectionModel().select(0);
            } else if (profileCD.getUser_role().equals("Lecturer")) {
                addUser_roleC.getSelectionModel().select(1);
            }else if (profileCD.getUser_role().equals("Technical_Officer")) {
                addUser_roleC.getSelectionModel().select(2);
            }else{
                addUser_roleC.getSelectionModel().select(3);
            }

            if(profileCD.getCourse_id().equals("DBT")){
                addLec_DepartmentListC.getSelectionModel().select(0);
            } else if (profileCD.getCourse_id().equals("DET")) {
                addLec_DepartmentListC.getSelectionModel().select(1);
            }else if (profileCD.getCourse_id().equals("DICT")) {
                addLec_DepartmentListC.getSelectionModel().select(2);
            }else{
                addLec_DepartmentListC.getSelectionModel().select(3);
            }

            if(profileCD.getSex().equals("Males")){
                addLec_SexC.getSelectionModel().select(0);
            } else if (profileCD.getSex().equals("Female")) {
                addLec_SexC.getSelectionModel().select(1);
            }else{
                addLec_SexC.getSelectionModel().select(2);
            }


            String uri = "file:" + profileCD.getProfile_image();
            image = new Image(uri, 0, 0, true, false);
            addLec_imageViewxxx.setFill(new ImagePattern(image));

            getData.path = profileCD.getProfile_image();
        }
    }



    public void addLecProfileUploadImage(){

            FileChooser open = new FileChooser();
            open.setTitle("Open Image File");
            open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));



            File file = open.showOpenDialog(Profile_form.getScene().getWindow());

            if (file != null){


                image = new Image(file.toURI().toString(),0, 0, true, false );
                addLec_imageViewxxx.setFill(new ImagePattern(image));
                getData.path = file.getAbsolutePath();

                addProfile_uploadBtn.setStyle("-fx-background-color: #ff9800;");


            }
        }

    public  void addLecProfileUpdats(){


        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");



        String updateData = "UPDATE user SET "
                + "user_password  = '"+ addUser_PasswordC.getText()
                + "', department_id = '"+ addLec_DepartmentListC.getSelectionModel().getSelectedItem()
                + "', user_role = '"+ addUser_roleC.getSelectionModel().getSelectedItem()
                + "', course_id = '"+ addUser_CourseC2.getText()
                + "', email = '"+ addUser_EmailC.getText()
                + "', first_name = '"+ addUser_FirstNameC.getText()
                + "', last_name = '"+ addUser_LastNameC.getText()
                + "', dob = '"+ addUser_DOBC.getValue()
                + "', sex = '"+ addLec_SexC.getSelectionModel().getSelectedItem()
                + "', address = '"+ addUser_AddressC.getText()
                + "', tp_number = '"+ addUser_TelNumberC.getText()
                + "', upnonupuserIMG = ?"
                + ", profile_image = '"+ uri +"' WHERE user_id = '" +addUser_IdC.getText()+"'";


        connect = JDBC.getConnection();


        try {
            Alert alert;
            if (addUser_IdC.getText().isEmpty()
                    || addUser_PasswordC.getText().isEmpty()
                    || addUser_roleC.getSelectionModel().getSelectedItem() == null
                    || addUser_CourseC2.getText().isEmpty()
                    || addLec_DepartmentListC.getSelectionModel().getSelectedItem() == null
                    || addUser_EmailC.getText().isEmpty()
                    || addUser_FirstNameC.getText().isEmpty()
                    || addUser_LastNameC.getText().isEmpty()
                    || addUser_DOBC.getValue() == null
                    || addLec_SexC.getSelectionModel().getSelectedItem() == null
                    || addUser_AddressC.getText().isEmpty()
                    || addUser_TelNumberC.getText().isEmpty()
                    || getData.path == null || getData.path == ("") ){

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
                alert.setContentText("Are you sure you want to UPDATE User ID '" + addUser_IdC.getText() + "' ?" );
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){

                    UploadSuccessfullTEXT.setText("Upload Successfull 👍");

//                    statement = connect.createStatement();
//                    statement.executeUpdate(updateData);

                    String upnonupprofile = (uri != null) ? "Updated" : "Non Updated";
                    PreparedStatement preparedStatement = JDBC.getConnection().prepareStatement(updateData);
                    preparedStatement.setString(1, upnonupprofile);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();


                    UserDataEnterArea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //to update the tableview
                    addProfileshowData();

                    //to clear the fields
                    addLecProfileClear();

                    //to search th fields
//                    addProfilesSearch();

                    //main front image and name
                    loadUserData();




                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }


























    public void addLecProfileClear(){

        UploadSuccessfullTEXT.setText("");

        addUser_IdC.setText("");
        addUser_PasswordC.setText("");


        addLec_DepartmentListC.getSelectionModel().clearSelection();
//        addUser_CourseC.getSelectionModel().clearSelection();
        addUser_roleC.getSelectionModel().clearSelection();
        addUser_CourseC2.setText("");
        addUser_EmailC.setText("");
        addUser_FirstNameC.setText("");
        addUser_LastNameC.setText("");
        addUser_DOBC.setValue(null);


        addLec_SexC.getSelectionModel().clearSelection();
        addUser_AddressC.setText("");
        addUser_TelNumberC.setText("");
        addLec_imageViewxxx.setFill(null);
        getData.path = "";
        UserDataEnterArea.setStyle(null);
        addUser_IdC.setStyle(null);
        addProfile_uploadBtn.setStyle(null);


//        addProfilesSearch();

    }


//------------------------------------------------------------------------------------------------------------------------------------------------
//Course Form Code
public ObservableList<coursematerialscontroller>courseMaterialsDetails() {
    ObservableList<coursematerialscontroller> DList = FXCollections.observableArrayList();

    String sql = "SELECT * FROM course_materials WHERE user_id = '"+UserSession.getUserId()+"'";

    connect = JDBC.getConnection();

    try{
        coursematerialscontroller materialD;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()){
            materialD = new coursematerialscontroller(result.getString("course_material_no")
                    ,result.getString("user_id")
                    , result.getString("material_name")
                    , result.getString("course_material")

            );
            DList.add(materialD);
        }
    }catch (Exception e){
        e.printStackTrace();
    }

    return DList;

}




    public void addLecMaterialX() {
        String insertData = "INSERT INTO course_materials (user_id,material_name, course_material) VALUES (?, ?, ?)";

        connect = JDBC.getConnection();

        try {
            Alert alert;

            if (Material_Name.getText().isEmpty()) {
                CourseDataEnterArea1.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                new animatefx.animation.Bounce(CourseDataEnterArea1).play();
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please Give Material Name");
                alert.showAndWait();
            } else {
                chooseMaterialx();

                Material_Name.setStyle(null);
                prepare = connect.prepareStatement(insertData, Statement.RETURN_GENERATED_KEYS);

                prepare.setString(1, UserSession.getUserId());
                prepare.setString(2, Material_Name.getText());
                prepare.setString(3, chosenFilePath);

                String checkData = "SELECT material_name FROM course_materials WHERE material_name = ?";
                try (PreparedStatement prepareCheck = connect.prepareStatement(checkData)) {
                    prepareCheck.setString(1, Material_Name.getText());
                    try (ResultSet result = prepareCheck.executeQuery()) {
                        if (result.next()) {
                            CourseDataEnterArea1.setStyle(null);
                            Material_Name.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
                            new animatefx.animation.Bounce(Material_Name).play();

                            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Material Name '" + Material_Name.getText() + "' already exists!");
                            alert.showAndWait();
                        } else {
                            if (!chosenFilePath.isEmpty()) {
                                String string = "Uploaded";
                                prepare.executeUpdate();
                                try (ResultSet generatedKeys = prepare.getGeneratedKeys()) {
                                    if (generatedKeys.next()) {
                                        int generatedId = generatedKeys.getInt(1);
                                        System.out.println("Generated ID: " + generatedId);
                                    }
                                }
                            }
                            showMaterialDetail();
                            availableCourseClearX();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void chooseMaterialx() {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image File", "*.jpg", "*.png"),
                (new FileChooser.ExtensionFilter("PDF Files", "*.pdf")));

        File file = open.showOpenDialog(Course_form.getScene().getWindow());

        if (file != null) {
            chosenFilePath = file.getAbsolutePath();
            AddMaterial_btn.setStyle("-fx-background-color: #ff9800;");
        }
    }

    public void availableCourseClearX() {

        Material_Name.setText("");
        AddMaterial_btn.setStyle(null);
    }


    public void courseMaterialSelect(){

        coursematerialscontroller courseMaterialsD = courseMaterial_tableView.getSelectionModel().getSelectedItem();
        int num = courseMaterial_tableView.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) {return;}



        Material_Name.setText(String.valueOf(courseMaterialsD.getMaterial_name()));


    }


    public void updateCourseMaterialX() {
        coursematerialscontroller selectedCourseMaterial = courseMaterial_tableView.getSelectionModel().getSelectedItem();

        String updateData = "UPDATE course_materials SET material_name = ?, course_material = ? WHERE course_material_no = ?";

        try {
            if (Material_Name.getText().isEmpty()) {
                CourseDataEnterArea1.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // field color red
                new animatefx.animation.Bounce(CourseDataEnterArea1).play();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE course material '" + Material_Name.getText() + "' ?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    PreparedStatement preparedStatement = JDBC.getConnection().prepareStatement(updateData);
                    preparedStatement.setString(1, Material_Name.getText());
                    preparedStatement.setString(2, selectedCourseMaterial.getCourse_material());
                    preparedStatement.setString(3, selectedCourseMaterial.getCourse_material_no());
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    

                    selectedCourseMaterial.setMaterial_name(Material_Name.getText());
                    courseMaterial_tableView.refresh();

                    CourseDataEnterArea1.setStyle(null);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // To update the table view
                    showMaterialDetail();

                    // To clear the fields
                    availableCourseClearX();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void DeleteLecMaterialX() {

        coursematerialscontroller selectedCourseMaterial = courseMaterial_tableView.getSelectionModel().getSelectedItem();

        if (selectedCourseMaterial == null) {
            // No row selected, return or show an error message
            return;
        }

        String courseId = selectedCourseMaterial.getCourse_material_no();

        String deleteData = "DELETE FROM course_materials WHERE course_material_no = ?";

        connect = JDBC.getConnection();

        try {
            prepare = connect.prepareStatement(deleteData);
            prepare.setString(1, courseId);
            prepare.executeUpdate();

            // Remove the selected course material from the table view
            courseMaterial_tableView.getItems().remove(selectedCourseMaterial);
            courseMaterial_tableView.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deletion Successful");
            alert.setHeaderText(null);
            alert.setContentText("Course material deleted successfully!");
            alert.showAndWait();


            showMaterialDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private ObservableList<coursematerialscontroller> courseMaterialsD;
    public void showMaterialDetail() {
        courseMaterialsD = courseMaterialsDetails();

        MaterialName_Clm.setCellValueFactory(new PropertyValueFactory<>("material_name"));
        LecCourseMaterials_view.setCellValueFactory(new PropertyValueFactory<>("course_material"));

        courseMaterial_tableView.setItems(courseMaterialsD);
    }






//------------------------------------------------------------------------------------------------------------------------------------------------
//Upload Marks Code

ObservableList<MarksInformation> marksList = FXCollections.observableArrayList();

    public void loadMarksData(){
        connect = JDBC.getConnection();

       uploadMarks_regNo_clm.setCellValueFactory(new PropertyValueFactory<>("user_id"));
       uploadMarks_Name_clm.setCellValueFactory(new PropertyValueFactory<>("first_name"));
       uploadMarks_Course_clm.setCellValueFactory(new PropertyValueFactory<>("Subject_code"));
       uploadMarks_Type_clm.setCellValueFactory(new PropertyValueFactory<>("e_type"));
       uploadMarks_Marks_clm.setCellValueFactory(new PropertyValueFactory<>("marks"));

        marks_Table.setItems(marksList);
        new FadeIn(marks_Table).play();

    }


    void refreshTable() {
        connect = JDBC.getConnection();
        try {
            marksList.clear();

            String query = "SELECT marks.user_id, user.first_name, marks.Subject_code, marks.etype, marks.marks " +
                    "FROM marks " +
                    "JOIN user ON marks.user_id = user.user_id " +
                    "JOIN subject ON marks.Subject_code = subject.Subject_code";
            prepare = connect.prepareStatement(query);
            result = prepare.executeQuery();

            while (result.next()) {
                marksList.add(new MarksInformation(
                        result.getString("user_id"),
                        result.getString("first_name"),
                        result.getString("Subject_code"),
                        result.getString("etype"),
                        result.getFloat("marks")
                ));
            }

            marks_Table.setItems(marksList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadmarksUpdateX(){


        try {

            marksDetails = marks_Table.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateMarks.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Marks");
//            javafx.scene.image.Image image = new Image("images/appIcon.png");
//            stage.getIcons().add(image);
            stage.resizableProperty().setValue(false);
            stage.setScene(new Scene(root));
            stage.show();


        } catch (IOException ex) {
            Logger.getLogger(lecturerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void refreshUpdateMarksTable(){
        refreshTable();
    }
    @FXML
    public void uploadmarksEditX(){

        if(marks_Table.getSelectionModel().getSelectedItem() != null){
            try {
                marksDetails = marks_Table.getSelectionModel().getSelectedItem();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditMarks.fxml"));
                Parent root = (Parent) fxmlLoader.load();

                EditMarks senddata = fxmlLoader.getController();
                senddata.showInformation(marksDetails.getExam_Id(),marksDetails.getE_type(),marksDetails.getSubjectCode(),marksDetails.getUser_id(),marksDetails.getMarks());

                Stage stage = new Stage();
                stage.setTitle("Edit Marks");
//                javafx.scene.image.Image image = new Image("images/appIcon.png");
//                stage.getIcons().add(image);
                stage.resizableProperty().setValue(false);
                stage.setScene(new Scene(root));
                stage.show();


            } catch (IOException ex) {
                Logger.getLogger(lecturerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("First you select the row that you want to update");
            alert.showAndWait();
        }

    }

    @FXML
    private void uploadmarksDelete(javafx.event.ActionEvent event) throws SQLException {
        if (marks_Table.getSelectionModel().getSelectedItem() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Marks");
            alert.setContentText("Are you sure you want to delete this Marks?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    marksDetails = marks_Table.getSelectionModel().getSelectedItem();

                    String query = "DELETE FROM marks WHERE user_id='" + marksDetails.getUser_id() + "' AND Subject_code='" + marksDetails.getSubject_code() + "' AND etype='" + marksDetails.getE_type() + "'";


                    connect = JDBC.getConnection();
                    Statement stmt = connect.createStatement();
                    stmt.executeUpdate(query);

                    refreshTable();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("If you want to delete any student marks, you must first select the row you want to delete.");
            alert.showAndWait();
        }
    }

//    public void parseMarksDataToCAMarks() {
//        connect = JDBC.getConnection();
//
//        try {
//            String query = "INSERT INTO `ca_marks`(`user_id`, `Subject_code`, `Quiz_1`, `Quiz_2`, `Quiz_3`, `Assessment_1`, `Assessment_2`, `Mid term`, `Final_theory`, `Final_practical`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            prepare = connect.prepareStatement(query);
//
//            for (MarksInformation marksInfo : marksList) {
//                prepare.setString(1, marksInfo.getUser_id());
//                prepare.setString(2, marksInfo.getSubjectCode());
//                prepare.setFloat(3, marksInfo.getMarksByEType("Quiz_1"));
//                prepare.setFloat(4, marksInfo.getMarksByEType("Quiz_2"));
//                prepare.setFloat(5, marksInfo.getMarksByEType("Quiz_3"));
//                prepare.setFloat(6, marksInfo.getMarksByEType("Assessment_1"));
//                prepare.setFloat(7, marksInfo.getMarksByEType("Assessment_2"));
//                prepare.setFloat(8, marksInfo.getMarksByEType("Mid term"));
//                prepare.setFloat(9, marksInfo.getMarksByEType("Final_theory"));
//                prepare.setFloat(10, marksInfo.getMarksByEType("Final_practical"));
//
//                prepare.executeUpdate();
//            }
//
//            // Optional: Clear marksList after parsing the data
//            marksList.clear();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // Close resources (PreparedStatement, ResultSet, Connection) here
//        }
//    }
//
//    public float getMarksByEType(String eType) {
//        switch (eType) {
//            case "Quiz_1":
//                return marksInfo.getQuiz1Marks(); // Assuming you have a method to retrieve Quiz_1 marks in the MarksInformation class
//            case "Quiz_2":
//                return marksInfo.getQuiz2Marks(); // Assuming you have a method to retrieve Quiz_2 marks in the MarksInformation class
//            case "Quiz_3":
//                return marksInfo.getQuiz3Marks(); // Assuming you have a method to retrieve Quiz_3 marks in the MarksInformation class
//            case "Assessment_1":
//                return marksInfo.getAssessment1Marks(); // Assuming you have a method to retrieve Assessment_1 marks in the MarksInformation class
//            case "Assessment_2":
//                return marksInfo.getAssessment2Marks(); // Assuming you have a method to retrieve Assessment_2 marks in the MarksInformation class
//            case "Mid term":
//                return marksInfo.getMidTermMarks(); // Assuming you have a method to retrieve Mid term marks in the MarksInformation class
//            case "Final_theory":
//                return marksInfo.getFinalTheoryMarks(); // Assuming you have a method to retrieve Final_theory marks in the MarksInformation class
//            case "Final_practical":
//                return marksInfo.getFinalPracticalMarks(); // Assuming you have a method to retrieve Final_practical marks in the MarksInformation class
//            default:
//                return 0.0f; // or return a default value if needed
//        }
//    }





//----------------------------------------------------------------------------------------------------------------------------------------------
    //Student Details

        public ObservableList<Controller> addController(){
            ObservableList<Controller> listController = FXCollections.observableArrayList();

            String sql = "SELECT user_id, Subject_id, State, Date FROM attendence ORDER BY user_id";


            connect = JDBC.getConnection();

            try {

                Controller sdetailsD;
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()){

                    sdetailsD = new Controller(result.getString("user_id")
                            , result.getString("Subject_id")
                            , result.getString("State")
                            , result.getDate("Date")


                    );

                    listController.add(sdetailsD);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        return listController;
    }

    private ObservableList<Controller> sdetailsD;

    public void showSDetails(){

        sdetailsD = addController();
        SDetails_User_Id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        SDetails_Course_Id.setCellValueFactory(new PropertyValueFactory<>("Subject_id"));
        SDetails_State.setCellValueFactory(new PropertyValueFactory<>("State"));
        SDetails_Date.setCellValueFactory(new PropertyValueFactory<>("Date"));


        SDetails_Table_View.setItems(sdetailsD);

    }


    public ObservableList<SdetailMedicalController> MedicalData() {
        ObservableList<SdetailMedicalController> DataList = FXCollections.observableArrayList();

        connect = JDBC.getConnection();

        try {
            String sql = "SELECT * FROM medical";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                SdetailMedicalController sdetailMedicalD = new SdetailMedicalController(
                        result.getString("user_id"),
                        result.getString("Description")

                );

                DataList.add(sdetailMedicalD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return DataList;
    }

    private ObservableList<SdetailMedicalController> medicalData;

    public void showSDetailMedicalDetails() {
        medicalData = MedicalData();

        SDtails_MedicalReg_no.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        SDtails_MedicalRecords.setCellValueFactory(new PropertyValueFactory<>("Description"));

        SDetails_MedicalTable_View.setItems(medicalData);
    }






//-----------------------------------------------------------------------------------------------------------------------------------------------
//Notices code


    public ObservableList<noticeController> addNoticeListData() {
        ObservableList<noticeController> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM notice";

        try {
            connect = JDBC.getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                noticeController noticeD = new noticeController(
                        resultSet.getString("notice_id"),
                        resultSet.getString("notice_name"),
                        resultSet.getString("bodyof_notice"),
                        resultSet.getString("notice_imagepdf"),
                        resultSet.getDate("notice_createdate"),
                        resultSet.getString("upnonupnotice")
                );

                listData.add(noticeD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<noticeController> noticeData;

    public void showNoticeData() {

        noticeData = addNoticeListData();

        noticeNotice_Id_Clm.setCellValueFactory(new PropertyValueFactory<>("notice_id"));
        noticeNoticeName_clm.setCellValueFactory(new PropertyValueFactory<>("notice_name"));
        noticeBON_clm.setCellValueFactory(new PropertyValueFactory<>("bodyof_notice"));
        noticeNoticeImg_clm.setCellValueFactory(new PropertyValueFactory<>("notice_imagepdf"));
        noticeNoticeDate_clm.setCellValueFactory(new PropertyValueFactory<>("notice_createdate"));



        Notice_tableView1.setItems(noticeData);


        }






    //-------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addlecGenList();
        addLecDepartmentList();
//        addLecProfileCourseList();
        addLecProfileRoleList();
        loadUserData();
        showMaterialDetail();
        courseMaterialsDetails();
        loadMarksData();
        showNoticeData();
        addProfileshowData();
        showSDetails();
        addController();
        refreshTable();
//        parseMarksDataToCAMarks();
        showSDetailMedicalDetails();
    }














//    String query = null;
//    Connection connection = null ;
//    PreparedStatement preparedStatement = null ;
//    ResultSet resultSet = null ;

    public void loadUserData(){
       Connection connection=JDBC.getConnection();


        try {
            Statement stmt = connection.createStatement();
           String   query = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()){

                UploadResultArea.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name") );

                String uri = "file:" + resultSet.getString("profile_image");
                image = new Image(uri, 0, 0, true, false);

//                addLec_imageViewxxx.setFill(new ImagePattern(image));
                UserImage_ViewCircle.setFill(new ImagePattern(image));

            }

        }catch (Exception e){e.printStackTrace();
        }

    }

}
