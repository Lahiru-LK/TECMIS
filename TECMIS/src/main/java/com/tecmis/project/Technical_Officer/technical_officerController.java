package com.tecmis.project.Technical_Officer;

import animatefx.animation.FadeIn;
import com.tecmis.project.Admin.Notices.noticeController;
import com.tecmis.project.Admin.Timetable.TimetableController;
import com.tecmis.project.Admin.getData;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.net.URL;
import java.nio.file.Files;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javafx.stage.FileChooser;
import org.apache.commons.io.IOUtils;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;






public class technical_officerController implements Initializable {


    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label UploadSuccessfullTEXT;

    @FXML
    private Rectangle addNotice_imageViewNew;


    @FXML
    private TextField addUser_userCourseC;

    @FXML
    private TableView<?> medical_view;

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
    private ComboBox<?> addUser_CourseL;

    @FXML
    private Button btnimportimage;


    @FXML
    private ComboBox<?> addUser_roleC;

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
    private TableColumn<?, ?> muser_id;

    @FXML
    private TableColumn<?, ?> mtitile;

    @FXML
    private TableColumn<?, ?> mDescription;

    @FXML
    private TableColumn<?, ?> mdate;

    @FXML
    private TableColumn<?, ?> mdocument;


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

    private byte[] pdfBytes;


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

            addProfileshowData();

        } else if (event.getSource()==btnMedical) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(true);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(false);

            addProfileshowData();

        }else if (event.getSource()==btnNotice) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(true);
            timetableform.setVisible(false);
            mainform.setVisible(false);
            addProfileshowData();


        }else if (event.getSource()==btnTimetable) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(true);
            mainform.setVisible(false);

            addProfileshowData();



        }else if (event.getSource()==btnMain) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(true);

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

//                UploadResultArea.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name") );
//
//                String uri = "file:" + resultSet.getString("profile_image");
//                image = new Image(uri, 0, 0, true, false);
//
////                addLec_imageViewxxx.setFill(new ImagePattern(image));
//                UserImage_ViewCircle.setFill(new ImagePattern(image));
            }

        }catch (Exception e){e.printStackTrace();
        }

    }







    public void addMedicalAdd(){
        String insertDATA = "INSERT INTO medical"
                +"(user_id,Title,Description,date,Document)"
                +"VALUES(?,?,?,?,?)";

        connect = JDBC.getConnection();

        try {

            Alert alert;


            if (muser_id.getText().isEmpty()
                    || mtitile.getText().isEmpty()
                    || mDescription.getText().isEmpty()
                    || mdate.getText().isEmpty()
                   // || addTimetable_DepartmentC.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "" ){

              //  TimeTableDataEnterArea1.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
             //   new animatefx.animation.Bounce(TimeTableDataEnterArea1).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields & 'pdf insertion is mandatory'");
                alert.showAndWait();

            }else {

                //check if the user is already exist

                String checkData = "SELECT user_id FROM medical WHERE user_id = '"
                        +muser_id.getText()+"'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()){

                   // TimeTableDataEnterArea1.setStyle(null);
                   muser_id.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                    new animatefx.animation.Bounce().play();

                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Timetable ID '" + muser_id.getText() + "' was already exist!");
                    alert.showAndWait();

                }else {

                    addUser_useridC.setStyle(null);

                    prepare = connect.prepareStatement(insertDATA);

                    prepare.setString(1, muser_id.getText());
                    //prepare.setString(2,(String)addTimetable_DepartmentC.getSelectionModel().getSelectedItem());
                    prepare.setString(2, mtitile.getText());
                    prepare.setString(3, mDescription.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(4,String.valueOf(sqlDate));


                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(5, uri);

                    byte[] pdf = pdfBytes;
                    prepare.setBytes(6,pdf);


                    if (pdfBytes !=null){
                        String string = "Uploaded";
                        prepare.setString(7, string);

                    } else if (pdfBytes ==null) {
                        String string = "None Uploaded";
                        prepare.setString(7, string);
                    }

                    if (getData.path !="") {
                        String string = "Uploaded";
                        prepare.setString(8, string);
                    }



                    prepare.executeUpdate();

                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    //to update the tableview
                  //  addTimetableShowData();

                    //to clear the fields
                  //  addTimetableClear();

                    //to search th fields
                   // addTimetableSearch();

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addMedicalShowData(){
        addMedicalD = addMedicalController();

        muser_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        mtitile.setCellValueFactory(new PropertyValueFactory<>("Title"));
        mDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        mdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        //addTimetable_C_image.setCellValueFactory(new PropertyValueFactory<>("upload_image"));
      //  addTimetable_C_pdf.setCellValueFactory(new PropertyValueFactory<>("upnonupPDF"));

       // addTimetable_C_pdf.setStyle("    -fx-text-fill: #d62651;" +
         //       " -fx-font-weight: bold;");

      //  addTimetable_C_image.setCellValueFactory(new PropertyValueFactory<>("upnonupIMG"));
      //  addTimetable_C_image.setStyle("    -fx-text-fill: #e73d66;" +
       //         " -fx-font-weight: bold;");

        medical_view.setItems(addMedicalD);
    }

    private Object addMedicalController() {
        return null;
    }


    public void addTimetableClear(){
        addTimetable_ID.setText("");
        addTimetable_Name.setText("");
        getData.path = "";
        addTimetable_imageView.setFill(null);
        TimeTableDataEnterArea1.setStyle(null);
        addTimetable_ID.setStyle(null);
        addTimetable_SearchC.setText("");
        addTimetableSearch();
        addTimetable_PdfuploadBtn.setStyle(null);
        addTimetable_ImageuploadBtn.setStyle(null);
        pdfBytes = null;
        addTimetable_DepartmentC.getSelectionModel().clearSelection();
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
        loadUserData();





    }

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;




}
