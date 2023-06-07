package com.tecmis.project.Technical_Officer;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import com.tecmis.project.Admin.Courses.courseController;
import com.tecmis.project.Admin.Notices.noticeController;
import com.tecmis.project.Admin.Timetable.TimetableController;
import com.tecmis.project.Admin.getData;
import com.tecmis.project.Technical_Officer.Attendence.attendenceController;
import com.tecmis.project.Technical_Officer.Medical.medicalController;
import com.tecmis.project.Technical_Officer.TechProfile.techProfileControllerX;
import com.tecmis.project.UserSession;
import com.tecmis.project.connection_DB.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.List;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import org.apache.commons.io.IOUtils;

import static com.tecmis.project.UserSession.cleanUserSession;


public class technical_officerController implements Initializable {


    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Rectangle UserImage_ViewCircle;





    @FXML
    private Label messagepromt_medical;

    @FXML
    private TextField logeUserId;

    @FXML
    private TextField logeUserDepartment;

    @FXML
    private TextField logeUserNumber;

    @FXML
    private TextField User_lastnameF;

    @FXML
    private TextField User_firstnameF;

    @FXML
    private TextField logeUserRole;

    @FXML
    private TextField logeUserEmail;

    @FXML
    private Label UploadSuccessfullTEXT;

    @FXML
    private AnchorPane attendence_entryarea;


    @FXML
    private Rectangle addNotice_imageViewNew;

    @FXML
    private AnchorPane MedicalDataEnterArea;

    @FXML
    private TextField addUser_userCourseC;

    @FXML
    private Button addMedical_addBtn;

    @FXML
    private Button addmedical_clearbtn;


    @FXML
    void addMedicalClear(ActionEvent event) {


    }

    @FXML
    void addMedicalSelect(MouseEvent event) {

    }


    @FXML
    private TableView<medicalController> medical_view;

    @FXML
    private TableColumn<?, ?> muser_id;

    @FXML
    private TableColumn<?, ?> mm_id;

    @FXML
    private TableColumn<?, ?> mdecription;

    @FXML
    private TableColumn<?, ?> mdate;

    @FXML
    private TableColumn<?, ?> mpdf;

    @FXML
    private Rectangle addmedical_pdf;


    @FXML
    private TextField addmedical_id;

    @FXML
    private TextField addmedical_uid;

    @FXML
    private DatePicker addmedical_date;


    @FXML
    private DatePicker xxxxxxxx;

    @FXML
    private TextField attendence_status;


    @FXML
    private TextField addmedical_desc;

    @FXML
    private TableView<attendenceController> attendence_tableView;

//    @FXML
//    void addProfileUpdate(ActionEvent event) {
//
//    }
//
//    @FXML
//    void addProfileClear(ActionEvent event) {
//
//    }

    @FXML
    private TextField attendence_uid;

    @FXML
    private TextField attendence_hours;

    @FXML
    private TextField attendence_id;

    @FXML
    private TextField attendence_subject;



    @FXML
    private DatePicker attendence_date;

    @FXML
    private TableColumn<?, ?> attend_id;

    @FXML
    private TableColumn<?, ?> attend_uid;

    @FXML
    private TableColumn<?, ?> attend_sub;

    @FXML
    private TableColumn<?, ?> attend_date;

    @FXML
    private TableColumn<?, ?> attend_status;

    @FXML
    private TableColumn<?, ?> attend_hours;

    @FXML
    private Button pdfinsert1;

    @FXML
    void addMedicalDelete(ActionEvent event) {

    }

    @FXML
    private ComboBox<?> addUser_CourseL;

    @FXML
    private Button btnimportimage;


    @FXML
    private ComboBox<?> addUser_roleC;


    @FXML
    void addMedicalUpdate(ActionEvent event) {

    }




    @FXML
    private ComboBox<?> add_gen;

    @FXML
    private ComboBox<?> add_dept;

    @FXML
    private TextField addUser_CourseCxxx;
    @FXML
    private Rectangle add_userimageC2;
    @FXML
    private ImageView add_userimageC;

    @FXML
    private TextField addUser_useridC;

    @FXML
    private TextField addUser_PasswordC;

    @FXML
    private TextField addUser_FirstNameC;

    @FXML
    private TextField addUser_LastNameC;

    @FXML
    private TextField addUser_EmailC;

    @FXML
    private TextField addUser_AddressC;

    @FXML
    private TextField addUser_tpNumberC;

    @FXML
    private ComboBox<?> addUser_genderC;

    @FXML
    private ComboBox<?> addUser_DepartmentListC;

    @FXML
    private DatePicker addUser_dobC;









    @FXML
    void addMedicalAdd(ActionEvent event) {

    }




    @FXML
    private Label UserDataEnterArea;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnAttendence;

    @FXML
    private Button btnMedical;

    @FXML
    private Button btnNotice;

    @FXML
    private Button btnTimetable;

    @FXML
    private Button btnMain;


    @FXML
    private AnchorPane mainform;

    @FXML
    private AnchorPane profileform;

    @FXML
    private AnchorPane attendenceform;

    @FXML
    private AnchorPane medicalform;

    @FXML
    private AnchorPane noticeform;

    @FXML
    private AnchorPane timetableform;

    @FXML
    private TableColumn<?, ?> addNotice_C_noticeID;

    @FXML
    private TableColumn<?, ?> addNotice_C_noticeName;

    @FXML
    private TableColumn<?, ?> add_nBody;

    @FXML
    private TableColumn<?, ?> addNotice_C_imagepdf;

    @FXML
    private TableColumn<?, ?> NCreateDate;

    @FXML
    private TableColumn<?, ?> nStatus;

    @FXML
    private TableView<noticeController> addNotice_tableView;

    @FXML
    private TableView<TimetableController> addTimetable_tableView;

    @FXML
    private TableColumn<?, ?> timetable_id;

    @FXML
    private TableColumn<?, ?> dept_id;

    @FXML
    private TableColumn<?, ?> timetable_name;

    @FXML
    private TableColumn<?, ?> timetable_date;

    @FXML
    private TableColumn<?, ?> timetable_img;

    @FXML
    private TableColumn<?, ?> pdf_status;

    @FXML
    private TableColumn<?, ?> image_status;



    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;



    public void addTechDepartmentList(){

        String listDepartment = "SELECT * FROM department";

        connect = JDBC.getConnection();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listDepartment);
            result = prepare.executeQuery();

            while (result.next()){
                listC.add(result.getString("department_id"));
            }
            addUser_DepartmentListC.setItems(listC);

        }catch (Exception e){e.printStackTrace();}



    }


    private String[] roleList = {"Admin", "Lecturer", "Technical_Officer", "Student"};
    public void addTechProfileRoleList(){

        java.util.List<String> roleL = new ArrayList<>();

        for(String data: roleList){
            roleL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(roleL);
        addUser_roleC.setItems(ObList);
    }



    private String[] genderList = {"Males", "Female", "Other"};
    public void addTechGenList(){


        List<String> genderL = new ArrayList<>();

        for(String data: genderList){
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);

     addUser_genderC.setItems(ObList);

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

        cleanUserSession();

    }






    public ObservableList<techProfileControllerX> addProfileController(){
        ObservableList<techProfileControllerX> listProfileController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";

        connect = JDBC.getConnection();

        try {

            techProfileControllerX profileCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                profileCD = new techProfileControllerX(result.getString("user_role")
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

        }catch (Exception e){
            e.printStackTrace();
        }
        return listProfileController;
    }
    private ObservableList<techProfileControllerX> addProfileCD;


    public void addProfileshowData() {
        addProfileCD = addProfileController();

        for (techProfileControllerX profileCD : addProfileCD) {
            addUser_useridC.setText(String.valueOf(profileCD.getUser_id()));
            addUser_userCourseC.setText(String.valueOf(profileCD.getCourse_id()));
            addUser_PasswordC.setText(String.valueOf(profileCD.getUser_password()));
            addUser_EmailC.setText(String.valueOf(profileCD.getEmail()));
            addUser_FirstNameC.setText(String.valueOf(profileCD.getFirst_name()));
            addUser_LastNameC.setText(String.valueOf(profileCD.getLast_name()));
            addUser_dobC.setValue(LocalDate.parse(String.valueOf(profileCD.getDob())));
            addUser_AddressC.setText(String.valueOf(profileCD.getAddress()));
            addUser_tpNumberC.setText(String.valueOf(profileCD.getTp_number()));

            String userRole = profileCD.getUser_role();
            if (userRole.equals("Admin")) {
                addUser_roleC.getSelectionModel().select(0);
            } else if (userRole.equals("Lecturer")) {
                addUser_roleC.getSelectionModel().select(1);
            } else if (userRole.equals("Technical_Officer")) {
                addUser_roleC.getSelectionModel().select(2);
            } else {
                addUser_roleC.getSelectionModel().select(3);
            }

            // Select the appropriate gender
            String gender = profileCD.getSex();
            if (gender.equals("Males")) {
                addUser_genderC.getSelectionModel().select(0);
            } else if (gender.equals("Female")) {
                addUser_genderC.getSelectionModel().select(1);
            } else {
                addUser_genderC.getSelectionModel().select(2);
            }

            // Uncomment and modify the following code for selecting the course
        /*
        String course = profileCD.getCourse_id();
        if (course.equals("BBT")) {
            addUser_CourseL.getSelectionModel().select(0);
        } else if (course.equals("BET")) {
            addUser_CourseL.getSelectionModel().select(1);
        } else if (course.equals("BICT")) {
            addUser_CourseL.getSelectionModel().select(2);
        } else {
            addUser_CourseL.getSelectionModel().select(3);
        }
        */

            // Select the appropriate department
            String department = profileCD.getDepartment_id();
            if (department.equals("DBT")) {
                addUser_DepartmentListC.getSelectionModel().select(0);
            } else if (department.equals("DET")) {
                addUser_DepartmentListC.getSelectionModel().select(1);
            } else if (department.equals("DICT")) {
                addUser_DepartmentListC.getSelectionModel().select(2);
            } else {
                addUser_DepartmentListC.getSelectionModel().select(3);
            }





            String uri = "file:" + profileCD.getProfile_image();
            image = new Image(uri, 0, 0, true, false);
            add_userimageC2.setFill(new ImagePattern(image));

            getData.path = profileCD.getProfile_image();
        }
    }






    public void addProfileUploadImage(){

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));



        File file = open.showOpenDialog(profileform.getScene().getWindow());

        if (file != null){


            image = new Image(file.toURI().toString(),0, 0, true, false );
            add_userimageC2.setFill(new ImagePattern(image));
            getData.path = file.getAbsolutePath();

            btnimportimage.setStyle("-fx-background-color: #ff9800;");


        }
    }




    public  void addProfileUpdatex(){


        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");



        String updateData = "UPDATE user SET "
                + "user_password  = '"+ addUser_PasswordC.getText()
                + "', department_id = '"+ addUser_DepartmentListC.getSelectionModel().getSelectedItem()
                + "', user_role = '"+ addUser_roleC.getSelectionModel().getSelectedItem()
                + "', course_id = '"+ addUser_userCourseC.getText()
                + "', email = '"+ addUser_EmailC.getText()
                + "', first_name = '"+ addUser_FirstNameC.getText()
                + "', last_name = '"+ addUser_LastNameC.getText()
                + "', dob = '"+ addUser_dobC.getValue()
                + "', sex = '"+ addUser_genderC.getSelectionModel().getSelectedItem()
                + "', address = '"+ addUser_AddressC.getText()
                + "', tp_number = '"+ addUser_tpNumberC.getText()
                + "', upnonupuserIMG = ?"
                + ", profile_image = '"+ uri +"' WHERE user_id = '" +addUser_useridC.getText()+"'";


        connect = JDBC.getConnection();


        try {
            Alert alert;
            if (addUser_useridC.getText().isEmpty()
                    || addUser_PasswordC.getText().isEmpty()
                    || addUser_roleC.getSelectionModel().getSelectedItem() == null
                    || addUser_userCourseC.getText().isEmpty()
                    || addUser_DepartmentListC.getSelectionModel().getSelectedItem() == null
                    || addUser_EmailC.getText().isEmpty()
                    || addUser_FirstNameC.getText().isEmpty()
                    || addUser_LastNameC.getText().isEmpty()
                    || addUser_dobC.getValue() == null
                    || addUser_genderC.getSelectionModel().getSelectedItem() == null
                    || addUser_AddressC.getText().isEmpty()
                    || addUser_tpNumberC.getText().isEmpty()
                    || getData.path == null || getData.path == ("") ){

                profileform.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(profileform).play();
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

                    UploadSuccessfullTEXT.setText("Upload Successfull 👍");

//                    statement = connect.createStatement();
//                    statement.executeUpdate(updateData);

                    String upnonupprofile = (uri != null) ? "Updated" : "Non Updated";
                    PreparedStatement preparedStatement = JDBC.getConnection().prepareStatement(updateData);
                    preparedStatement.setString(1, upnonupprofile);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();


                    profileform.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //to update the tableview
                    addProfileshowData();

                    //to clear the fields
                    addProfileClearX();

                    //to search th fields
//                    addProfilesSearch();

                    //main front image and name
                    loadUserData();




                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }


    public void addProfileClearX(){
        addUser_useridC.setText("");
        addUser_PasswordC.setText("");
        addUser_DepartmentListC.getSelectionModel().clearSelection();
        addUser_EmailC.setText("");
        addUser_FirstNameC.setText("");
        addUser_LastNameC.setText("");
        addUser_dobC.setValue(null);
        addUser_genderC.getSelectionModel().clearSelection();
        addUser_AddressC.setText("");
        addUser_tpNumberC.setText("");
        add_userimageC2.setFill(null);
        getData.path = "";
        UploadSuccessfullTEXT.setText("");
        profileform.setStyle(null);
        addUser_useridC.setStyle(null);
        btnimportimage.setStyle(null);
        addUser_roleC.setItems(null);
        addUser_userCourseC.setText("");
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
                        , result.getString("upnonupnotice")
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
        add_nBody.setCellValueFactory(new PropertyValueFactory<>("bodyof_notice"));
        addNotice_C_imagepdf.setCellValueFactory(new PropertyValueFactory<>("notice_imagepdf"));
        NCreateDate.setCellValueFactory(new PropertyValueFactory<>("notice_createdate"));

        nStatus.setCellValueFactory(new PropertyValueFactory<>("upnonupnotice"));

        addNotice_tableView.setItems(addNoticeListD);

//        addNotice_C_imagepdf.setStyle("    -fx-text-fill: #e73d66;" +
//                " -fx-font-weight: bold;");
    }


//    public void addNoticeSelect(){
//
//        noticeController noticeD = addNotice_tableView.getSelectionModel().getSelectedItem();
//        int num = addNotice_tableView.getSelectionModel().getSelectedIndex();
//
//        if((num - 1) < -1) {return;}
//
//
//
//        addNotice_C_noticeID.setText(String.valueOf(noticeD.getNotice_id()));
//        addNotice_C_noticeName.setText(String.valueOf(noticeD.getNotice_name()));
//        add_nBody.setText(String.valueOf(noticeD.getBodyof_notice()));
//
//        String uri = "file:" + noticeD.getNotice_imagepdf();
//        image = new Image(uri, 0, 0, true, false);
//        addNotice_imageViewNew.setFill(new ImagePattern(image));
//
//        getData.path = noticeD.getNotice_imagepdf();
//
//    }


    public ObservableList<TimetableController> addTimetableController(){
        ObservableList<TimetableController> listTimetableController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM timetable";

        connect = JDBC.getConnection();

        try {

            TimetableController timetableD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                timetableD = new TimetableController(result.getString("timetable_id")
                        , result.getString("department_id")
                        , result.getString("timetable_name")
                        , result.getDate("creat_date")
                        , result.getString("upload_image")
                        , result.getString("usepdf")
                        , result.getString("upnonupPDF")
                        , result.getString("upnonupIMG")

                );

                listTimetableController.add(timetableD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listTimetableController;
    }

    private ObservableList<TimetableController> addTimetableD;


    public void addTimetableShowData(){
        addTimetableD = addTimetableController();

        timetable_id.setCellValueFactory(new PropertyValueFactory<>("timetable_id"));
        dept_id.setCellValueFactory(new PropertyValueFactory<>("department_id"));
       timetable_name.setCellValueFactory(new PropertyValueFactory<>("timetable_name"));
        timetable_date.setCellValueFactory(new PropertyValueFactory<>("creat_date"));
       timetable_img.setCellValueFactory(new PropertyValueFactory<>("upload_image"));
        pdf_status.setCellValueFactory(new PropertyValueFactory<>("upnonupPDF"));

//        pdf_status.setStyle("    -fx-text-fill: #d62651;" +
//                " -fx-font-weight: bold;");

        image_status.setCellValueFactory(new PropertyValueFactory<>("upnonupIMG"));
//        image_status.setStyle("    -fx-text-fill: #e73d66;" +
//                " -fx-font-weight: bold;");

        addTimetable_tableView.setItems(addTimetableD);
    }







    public void switchForm(ActionEvent event) {

        if (event.getSource()==btnProfile){
            profileform.setVisible(true);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(false);

            btnProfile.setStyle("-fx-background-color: #d62651;");
            btnAttendence.setStyle("-fx-background-color: transparent");
            btnMedical.setStyle("-fx-background-color: transparent");
            btnNotice.setStyle("-fx-background-color: transparent");
            btnTimetable.setStyle("-fx-background-color: transparent");
            btnMain.setStyle("-fx-background-color: transparent");


            addTechDepartmentList();
            addTechProfileRoleList();
            addTechGenList();


            addProfileshowData();






        } else if (event.getSource()==btnAttendence) {
            profileform.setVisible(false);
            attendenceform.setVisible(true);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(false);


            btnProfile.setStyle("-fx-background-color: transparent");
            btnAttendence.setStyle("-fx-background-color: #d62651;");
            btnMedical.setStyle("-fx-background-color: transparent");
            btnNotice.setStyle("-fx-background-color: transparent");
            btnTimetable.setStyle("-fx-background-color: transparent");
            btnMain.setStyle("-fx-background-color: transparent");


            addProfileshowData();

        } else if (event.getSource()==btnMedical) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(true);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(false);

            btnProfile.setStyle("-fx-background-color: transparent");
            btnAttendence.setStyle("-fx-background-color: transparent");
            btnMedical.setStyle("-fx-background-color:  #d62651;");
            btnNotice.setStyle("-fx-background-color: transparent");
            btnTimetable.setStyle("-fx-background-color: transparent");
            btnMain.setStyle("-fx-background-color: transparent");


            addProfileshowData();

        }else if (event.getSource()==btnNotice) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(true);
            timetableform.setVisible(false);
            mainform.setVisible(false);


            btnProfile.setStyle("-fx-background-color: transparent");
            btnAttendence.setStyle("-fx-background-color: transparent");
            btnMedical.setStyle("-fx-background-color:  transparent");
            btnNotice.setStyle("-fx-background-color: #d62651;");
            btnTimetable.setStyle("-fx-background-color: transparent");
            btnMain.setStyle("-fx-background-color: transparent");


            addProfileshowData();


        }else if (event.getSource()==btnTimetable) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(true);
            mainform.setVisible(false);

            btnProfile.setStyle("-fx-background-color: transparent");
            btnAttendence.setStyle("-fx-background-color: transparent");
            btnMedical.setStyle("-fx-background-color:  transparent");
            btnNotice.setStyle("-fx-background-color: transparent");
            btnTimetable.setStyle("-fx-background-color: #d62651;");
            btnMain.setStyle("-fx-background-color: transparent");


            addProfileshowData();



        }else if (event.getSource()==btnMain) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(true);

            btnProfile.setStyle("-fx-background-color: transparent");
            btnAttendence.setStyle("-fx-background-color: transparent");
            btnMedical.setStyle("-fx-background-color:  transparent");
            btnNotice.setStyle("-fx-background-color: transparent");
            btnTimetable.setStyle("-fx-background-color: transparent");
            btnMain.setStyle("-fx-background-color: #d62651;");

            addProfileshowData();


        }

    }


    public void loadUserData(){

        try {


            connection = JDBC.getConnection();
            query = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                User_firstnameF.setText(resultSet.getString("first_name"));
                User_lastnameF.setText(resultSet.getString("last_name"));
                logeUserId.setText(resultSet.getString("user_id") );
                logeUserDepartment.setText(resultSet.getString("department_id"));
                logeUserNumber.setText(resultSet.getString("tp_number"));
                logeUserRole.setText(resultSet.getString("user_role"));
                logeUserEmail.setText(resultSet.getString("email"));



                String uri = "file:" + resultSet.getString("profile_image");
                image = new Image(uri, 0, 0, true, false);

                UserImage_ViewCircle.setFill(new ImagePattern(image));

            }

        }catch (Exception e){e.printStackTrace();
        }

    }





    public void addMedicalAddX(){
        String insertDATA = "INSERT INTO medical"
                +"(Medical_id,user_id,Description,date,PDF_status,Document)"
                +"VALUES(?,?,?,?,?,?)";

        connect = JDBC.getConnection();

        try {

            Alert alert;


            if (addmedical_id.getText().isEmpty()
                    || addmedical_uid.getText().isEmpty()
                    || addmedical_desc.getText().isEmpty()
                   || getData.path == null || getData.path == "" ){

                MedicalDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(MedicalDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {

                //check if the user is already exist

                String checkData = "SELECT user_id FROM medical WHERE user_id = '"
                        +addmedical_id.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){

                    MedicalDataEnterArea.setStyle(null);
                    addmedical_uid.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                    new animatefx.animation.Bounce(addmedical_uid).play();

                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("User ID '" + addmedical_uid.getText() + "' was already exist!");
                    alert.showAndWait();

                }else {

                    addmedical_id.setStyle(null);
                    prepare = connect.prepareStatement(insertDATA);

                    prepare.setString(1, addmedical_id.getText());
                    prepare.setString(2, addmedical_uid.getText());
                    prepare.setString(3,addmedical_desc.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(4,String.valueOf(sqlDate));





                    if (pdfBytes !=null) {
                        String string = "Uploaded";
                        prepare.setString(5, string);
                    }else if (pdfBytes ==null) {
                        String string = "Not Uploaded";
                        prepare.setString(5, string);
                    }

                    byte[] pdf = pdfBytes;
                    prepare.setBytes(6,pdf);

                    prepare.executeUpdate();

                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //to update the tableview
                   //
                     addMedicalShowData();

                    //to clear the fields
                    addMedicalClearX();


                    //get to session data
                    loadUserData();

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public void addMedicalClearX(){
       addmedical_id.setText("");
        addmedical_uid.setText("");
        addmedical_desc.setText("");
        addmedical_date.setValue(null);

        getData.path = "";
        MedicalDataEnterArea.setStyle(null);
        addmedical_id.setStyle(null);
        pdfinsert1.setStyle(null);

    }


    public ObservableList<medicalController> addMedicalListData(){
        ObservableList<medicalController> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM medical";

        connect = JDBC.getConnection();

        try {

            medicalController medicalD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                medicalD = new medicalController(result.getString("Medical_id")
                        , result.getString("user_id")
                        , result.getString("Description")
                        , result.getDate("date")
                        , result.getString("Document")
                        , result.getString("PDF_status")
                );

                listData.add(medicalD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<medicalController> addMedicalListD;




    public void addMedicalShowData(){
        addMedicalListD = addMedicalListData();

        muser_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
       mm_id.setCellValueFactory(new PropertyValueFactory<>("Medical_id"));
        mdecription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        mdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        mpdf.setCellValueFactory(new PropertyValueFactory<>("PDF_status"));
        mpdf.setStyle("    -fx-text-fill: #d62651;" +
                " -fx-font-weight: bold;");


        medical_view.setItems(addMedicalListD);



    }




    public void addMedicalUpdateX() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE medical SET "
                + "Description = '" + addmedical_desc.getText() + "' "
                + (pdfBytes != null ? ", Document = ? " : "") +
                "WHERE Medical_id = '" + addmedical_id.getText() + "'";


        connect = JDBC.getConnection();

        try {
            Alert alert;

            if (addmedical_id.getText().isEmpty()
                    || addmedical_uid.getText().isEmpty()
                    || addmedical_desc.getText().isEmpty())


            {

                MedicalDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(MedicalDataEnterArea).play();
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Medical id '" + addmedical_id.getText() + "' ?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);


                    MedicalDataEnterArea.setStyle(null);
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // to update the tableview
                    addMedicalShowData();

                    // to clear the fields
                    addMedicalClearX();


                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public void addMedicalDeleteX(){

        String deleteData = "DELETE FROM medical WHERE Medical_id = '"
                +addmedical_id.getText()+"'";

        connect = JDBC.getConnection();

        try {
            Alert alert;
            if (addmedical_id.getText().isEmpty()
                    || addmedical_uid.getText().isEmpty()
                    || addmedical_desc.getText().isEmpty()){

                MedicalDataEnterArea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(MedicalDataEnterArea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {
                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Medical id '" + addmedical_id.getText() + "' ?" );


                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    addmedical_id.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //to update the tableview
                    addMedicalShowData();

                    //to clear the fields
                    addMedicalClearX();



                }else return;

            }

        }catch (Exception e){e.printStackTrace();}
    }



    byte[] pdfBytes;

    @FXML
    void choosePdf(ActionEvent event) {
        try {
            FileChooser fileopen = new FileChooser();

            fileopen.setTitle("Open PDF File");

            fileopen.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pdf File", "*pdf"));

            File pdfFile = fileopen.showOpenDialog(medicalform.getScene().getWindow());

            pdfBytes = readPDF(pdfFile);

            if (pdfFile != null) {
                pdfinsert1.setStyle("-fx-background-color: #ff9800;");


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("load pdf...");
                alert.setHeaderText(null);
                alert.setContentText("pdf file is loaded. Please fill in the fields and click the add button.");
                alert.showAndWait();
            }


        } catch (Exception e) {
        }
    }
    private byte[] readPDF(File file) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            IOUtils.copy(inputStream, outputStream);
            return outputStream.toByteArray();
        }
    }




    public void addMedicalSelect(){

        medicalController medicalD = medical_view.getSelectionModel().getSelectedItem();
        int num = medical_view.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) {return;}



       addmedical_id.setText(String.valueOf(medicalD.getMedical_id()));
        addmedical_uid.setText(String.valueOf(medicalD.getUser_id()));
       addmedical_desc.setText(String.valueOf(medicalD.getDescription()));
        mpdf.setText(String.valueOf(medicalD.getPDF_status()));

       addmedical_date.setValue(LocalDate.parse(String.valueOf(medicalD.getDate())));


        String uri = "file:" + medicalD.getDocument();
       pdfinsert1.textFillProperty();
        pdfinsert1.setStyle("-fx-background-color: #ff9800;");

        getData.path = medicalD.getDocument();

    }










//Attendence Controll


    public ObservableList<attendenceController> attendenceListData(){
        ObservableList<attendenceController> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM attendence";

        connect = JDBC.getConnection();

        try {

            attendenceController attendenceD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                attendenceD = new attendenceController(result.getString("Attendence_id")
                        , result.getString("user_id")
                        , result.getString("Subject_id")
                        , result.getInt("Hours")
                        , result.getString("State")
                        , result.getDate("Date")
                );

                listData.add(attendenceD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<attendenceController> availableAttendenceD;

    public void attendenceShowData(){
        availableAttendenceD = attendenceListData();

        attend_id.setCellValueFactory(new PropertyValueFactory<>("Attendence_id"));
        attend_uid.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        attend_sub.setCellValueFactory(new PropertyValueFactory<>("Subject_id"));
        attend_hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
        attend_status.setCellValueFactory(new PropertyValueFactory<>("State"));
        attend_date.setCellValueFactory(new PropertyValueFactory<>("Date"));


        attendence_tableView.setItems( availableAttendenceD);
    }


    public void availableattendenceSelect(){

        attendenceController attendenceD =  attendence_tableView.getSelectionModel().getSelectedItem();
        int num =  attendence_tableView.getSelectionModel().getSelectedIndex();

        if((num - 1) < -1) {return;}

        attendence_id.setText(String.valueOf(attendenceD.getAttendence_id()));
        attendence_uid.setText(String.valueOf(attendenceD.getUser_id()));
        attendence_subject.setText(String.valueOf(attendenceD.getSubject_id()));
        attendence_date.setValue(LocalDate.parse(String.valueOf(attendenceD.getDate())));
        attendence_status.setText(String.valueOf(attendenceD.getState()));
        attendence_hours.setText(String.valueOf(attendenceD.getHours()));


    }

    public void attendenceAdd(){

        String insertDATA = "INSERT INTO attendence"
                +"(Attendence_id,user_id,Subject_id,Date,State,Hours)"
                +"VALUES(?,?,?,?,?,?)";

        connect = JDBC.getConnection();

        try {

            Alert alert;


            if (attendence_id.getText().isEmpty()
                    || attendence_uid.getText().isEmpty()
                    || attendence_subject.getText().isEmpty()
                    || attendence_status.getText().isEmpty()){

                attendence_entryarea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new Bounce(attendence_entryarea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {

                //check if the course is already exist

                String checkData = "SELECT Attendence_id FROM attendence WHERE Attendence_id = '"
                        +attendence_id.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){

                    attendence_entryarea.setStyle(null);
                   attendence_id.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                    new Bounce(attendence_id).play();

                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Attendence ID '" + attendence_id.getText() + "' was already exist!");
                    alert.showAndWait();

                }else {

                    attendence_id.setStyle(null);
                    prepare = connect.prepareStatement(insertDATA);


                    prepare.setString(1, attendence_id.getText());
                    prepare.setString(2, attendence_uid.getText());
                    prepare.setString(3,attendence_subject.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(4,String.valueOf(sqlDate));

                    prepare.setString(5,attendence_status.getText());
                    prepare.setString(6,attendence_hours.getText());


                    prepare.executeUpdate();

                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //to update the tableview
                    attendenceShowData();

                    //to clear the fields
                  attendenceClear();


                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void attendenceClear(){
        attendence_id.setText("");
       attendence_uid.setText("");
        attendence_subject.setText("");
       attendence_entryarea.setStyle(null);
       attendence_status.setText("");
        attendence_hours.setText("");
        attendence_date.setValue(null);


    }

    public  void attendenceUpdate(){

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");


        String updateData = "UPDATE attendence SET "
                + "Hours = " + attendence_hours.getText() + ", "
                + "State = '" + attendence_status.getText() + "' WHERE Attendence_id = '" + attendence_id.getText() + "'";

        connect = JDBC.getConnection();


        try {
            Alert alert;
            if (attendence_id.getText().isEmpty()
                    || attendence_uid.getText().isEmpty()
                    || attendence_subject.getText().isEmpty()
                    || attendence_status.getText().isEmpty()){

                attendence_entryarea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(attendence_entryarea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {


                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Attendence ID '" + attendence_id.getText() + "' ?" );

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){

                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                   attendence_entryarea.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //to update the tableview
                    attendenceShowData();

                    //to clear the fields
                    attendenceClear();




                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void attendenceDelete(){

        String deleteData = "DELETE FROM attendence WHERE Attendence_id = '"
                +attendence_id.getText()+"'";

        connect = JDBC.getConnection();

        try {
            Alert alert;
            if (attendence_id.getText().isEmpty()
                    || attendence_uid.getText().isEmpty()
                    || attendence_subject.getText().isEmpty()
                    || attendence_hours.getText().isEmpty()
                    || attendence_status.getText().isEmpty()){

               attendence_entryarea.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(attendence_entryarea).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {
                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Attendence ID '" + attendence_id.getText() + "' ?" );


                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    attendence_id.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //to update the tableview
                    attendenceShowData();

                    //to clear the fields
                    attendenceClear();

                }else return;

            }

        }catch (Exception e){e.printStackTrace();}
    }













    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addProfileshowData();

        addTechDepartmentList();
        addTechProfileRoleList();
        addTechGenList();


        addProfileshowData();
        addNoticeShowData();
        addTimetableShowData();
        addMedicalShowData();
        attendenceShowData();
        loadUserData();





    }

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;




}
