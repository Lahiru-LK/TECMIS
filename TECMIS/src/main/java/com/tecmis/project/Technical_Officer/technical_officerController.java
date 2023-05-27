package com.tecmis.project.Technical_Officer;

import animatefx.animation.FadeIn;
import com.tecmis.project.Admin.Profiles.profileController;
import com.tecmis.project.Admin.getData;
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
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
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
    void addProfileUpdate(ActionEvent event) {

    }

    @FXML
    void addProfileClear(ActionEvent event) {

    }


    @FXML
    private ImageView notice_img1;

    @FXML
    private Label notice_head1;

    @FXML
    private TextArea notice_body1;

    @FXML
    private TextField notice_date1;

    @FXML
    private ImageView notice_img2;

    @FXML
    private Label notice_head2;

    @FXML
    private TextArea notice_body2;

    @FXML
    private TextField notice_date2;


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

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;

    @FXML
    void initialize() {
        assert btnProfile != null : "fx:id=\"btnProfile\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert btnAttendence != null : "fx:id=\"btnAttendence\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert btnMedical != null : "fx:id=\"btnMedical\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert btnNotice != null : "fx:id=\"btnNotice\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert btnTimetable != null : "fx:id=\"btnTimetable\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert btnMain != null : "fx:id=\"btnMain\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert mainform != null : "fx:id=\"mainform\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert profileform != null : "fx:id=\"profileform\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert attendenceform != null : "fx:id=\"attendenceform\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert medicalform != null : "fx:id=\"medicalform\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert noticeform != null : "fx:id=\"noticeform\" was not injected: check your FXML file 'technical_officer.fxml'.";
        assert timetableform != null : "fx:id=\"timetableform\" was not injected: check your FXML file 'technical_officer.fxml'.";

    }
//
//
//
//
//    public void addLecDepartmentList(){
//
//        String listDepartment = "SELECT * FROM department";
//
//        connect = JDBC.getConnection();
//
//        try {
//
//            ObservableList listC = FXCollections.observableArrayList();
//
//            prepare = connect.prepareStatement(listDepartment);
//            result = prepare.executeQuery();
//
//            while (result.next()){
//                listC.add(result.getString("department_id"));
//            }
//            addUser_DepartmentListC.setItems(listC);
//
//        }catch (Exception e){e.printStackTrace();}
//
//
//
//    }
//
//
//    private String[] roleList = {"Admin", "Lecturer", "Technical_Officer", "Student"};
//    public void addLecProfileRoleList(){
//
//        java.util.List<String> roleL = new ArrayList<>();
//
//        for(String data: roleList){
//            roleL.add(data);
//        }
//
//        ObservableList ObList = FXCollections.observableArrayList(roleL);
//        addUser_roleC.setItems(ObList);
//    }
//
//
//
//    private String[] genderList = {"Males", "Female", "Other"};
//    public void addlecGenList(){
//
//
//        List<String> genderL = new ArrayList<>();
//
//        for(String data: genderList){
//            genderL.add(data);
//        }
//
//        ObservableList ObList = FXCollections.observableArrayList(genderL);
//
//     addUser_genderC.setItems(ObList);
//
//    }


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




    public void switchForm(ActionEvent event) {
        if (event.getSource()==btnProfile){
            profileform.setVisible(true);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(false);
//
//
//            btnMedical.setStyle("-fx-background-color: #d62651;");
//            btnProfile.setStyle("-fx-background-color: transparent");
//            btnAttendence.setStyle("-fx-background-color: transparent");
//            btnNotice.setStyle("-fx-background-color: transparent");
//            btnTimetable.setStyle("-fx-background-color: transparent");
//
//
////
////            DashboardDisplayNumberofUser();
////            DashboardDisplayNumberofStduntUser();
////            DashboardDisplayNumberofLecturerUser();
////            DashboardDisplayNumberOfUserChart();
////            DashboardDisplayNumberOfUserRoleChart();
////            DashboardDisplayNumberOfUserChart2();
//
//
//
    } else if (event.getSource()==btnAttendence) {
            profileform.setVisible(false);
            attendenceform.setVisible(true);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(false);
//
//
//            btnProfile.setStyle("-fx-background-color:transparent ;");
//            btnMedical.setStyle("-fx-background-color: #d62651");
//            btnAttendence.setStyle("-fx-background-color: transparent");
//            btnNotice.setStyle("-fx-background-color: transparent");
//            btnTimetable.setStyle("-fx-background-color: transparent");
//
//
//
//            //to become updared once you click the add stuydent button on nav
            addProfileshowData();
//          addProfileRoleList();
//           addProfileGenderList();
////            addProfileCourseList();
////            addProfileDepartmentList();
////            addProfilesSearch();
//
      } else if (event.getSource()==btnMedical) {
           profileform.setVisible(false);
           attendenceform.setVisible(false);
           medicalform.setVisible(true);
           noticeform.setVisible(false);
           timetableform.setVisible(false);
           mainform.setVisible(false);
//
//
//
//            btnMedical.setStyle("-fx-background-color:transparent ;");
//            btnProfile.setStyle("-fx-background-color: transparent");
//            btnAttendence.setStyle("-fx-background-color: #d62651");
//            btnNotice.setStyle("-fx-background-color: transparent");
//            btnTimetable.setStyle("-fx-background-color: transparent");
//
////
////            availableCourseShowData();
////            availableCourseSearch();
//
//
//
       }else if (event.getSource()==btnNotice) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(true);
            timetableform.setVisible(false);
            mainform.setVisible(false);
//
//
//
//            btnMain.setStyle("-fx-background-color:transparent ;");
//            btnProfile.setStyle("-fx-background-color: transparent");
//            btnMedical.setStyle("-fx-background-color: transparent");
//            btnNotice.setStyle("-fx-background-color: #d62651");
//            btnAttendence.setStyle("-fx-background-color: transparent");
//            btnTimetable.setStyle("-fx-background-color: transparent");
//
//
////            addNoticeShowData();
////            addNoticeSearch();
//
//
        }else if (event.getSource()==btnTimetable) {
           profileform.setVisible(false);
           attendenceform.setVisible(false);
           medicalform.setVisible(false);
           noticeform.setVisible(false);
           timetableform.setVisible(true);
           mainform.setVisible(false);


        }else if (event.getSource()==btnMain) {
            profileform.setVisible(false);
            attendenceform.setVisible(false);
            medicalform.setVisible(false);
            noticeform.setVisible(false);
            timetableform.setVisible(false);
            mainform.setVisible(true);



//
//
//            btnAttendence.setStyle("-fx-background-color:transparent ;");
//            btnProfile.setStyle("-fx-background-color: transparent");
//            btnMedical.setStyle("-fx-background-color: transparent");
//            btnNotice.setStyle("-fx-background-color: transparent");
//            btnTimetable.setStyle("-fx-background-color: #d62651");

//            addTimetableShowData();
//            addTimetableSearch();
//            addProfileDepartmentList();


        }

    }



    public ObservableList<profileController> addProfileController(){
        ObservableList<profileController> listProfileController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM USER WHERE user_id='" + UserSession.getUserId() + "'";


        connect = JDBC.getConnection();

        try {

            profileController profileCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
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

        }catch (Exception e){
            e.printStackTrace();
        }
        return listProfileController;
    }

    private ObservableList<profileController> addProfileCD;


    public void addProfileshowData() {
        addProfileCD =  addProfileController();



        for (profileController profileCD : addProfileCD) {

            addUser_useridC.setText(String.valueOf(profileCD.getUser_id()));

       //   addUser_CourseCxxx.setText(String.valueOf(profileCD.getCourse_id()));

            addUser_PasswordC.setText(String.valueOf(profileCD.getUser_password()));
            addUser_EmailC.setText(String.valueOf(profileCD.getEmail()));
            addUser_FirstNameC.setText(String.valueOf(profileCD.getFirst_name()));
            addUser_LastNameC.setText(String.valueOf(profileCD.getLast_name()));
            addUser_dobC.setValue(LocalDate.parse(String.valueOf(profileCD.getDob())));
            addUser_AddressC.setText(String.valueOf(profileCD.getAddress()));
            addUser_tpNumberC.setText(String.valueOf(profileCD.getTp_number()));



            if (profileCD.getUser_id().equals("admin001") || profileCD.getUser_id().equals("admin002")) {
                addUser_DepartmentListC.getSelectionModel().select(0);
            } else if (profileCD.getUser_id().equals("lec001") || profileCD.getUser_id().equals("lec002") || profileCD.getUser_id().equals("lec003")) {
                addUser_DepartmentListC.getSelectionModel().select(1);
            } else if (profileCD.getUser_id().equals("techoff001") || profileCD.getUser_id().equals("techoff002")) {
                addUser_DepartmentListC.getSelectionModel().select(2);
            } else {
                addUser_DepartmentListC.getSelectionModel().select(3);
            }

            if (profileCD.getSex().equals("Males")) {
                addUser_genderC.getSelectionModel().select(0);
            } else if (profileCD.getSex().equals("Female")) {
                addUser_genderC.getSelectionModel().select(1);
            } else {
                addUser_genderC.getSelectionModel().select(2);
            }
////
//           if(profileCD.getUser_id().equals("admin001 || admin002")){
//                addUser_DepartmentListC.getSelectionModel().select(0);
//            } else if (profileCD.getUser_id().equals("lec001 || lec002 || lec003")) {
//               addUser_DepartmentListC.getSelectionModel().select(1);
//            }else if (profileCD.getUser_id().equals("techoff001 || techoff002")) {
//               addUser_DepartmentListC.getSelectionModel().select(2);
//            }else{
//               addUser_DepartmentListC.getSelectionModel().select(3);
//            }
//
//            if(profileCD.getSex().equals("Males")){
//                addUser_genderC.getSelectionModel().select(0);
//            } else if (profileCD.getSex().equals("Female")) {
//                addUser_genderC.getSelectionModel().select(1);
//            }else{
//                addUser_genderC.getSelectionModel().select(2);
//            }
////


            String uri = "file:" + profileCD.getProfile_image();
            image = new Image(uri, 0, 0, true, false);
            add_userimageC2.setFill(new ImagePattern(image));

            getData.path = profileCD.getProfile_image();
        }
    }


    public ObservableList<noticeController> addnoticeController(){
        ObservableList<noticeController> listnoticeController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM NOTICE WHERE notice_id='" + NoticeSession.getnotice_id() + "'";


        connect = JDBC.getConnection();

        try {

            noticeController noticeCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
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

        }catch (Exception e){
            e.printStackTrace();
        }
        return listProfileController;
    }


    private ObservableList<noticeController> addNoticeCD;
    public void noticeShowData()
    {
        addNoticeCD = addnoticeController();

        for (noticeController NoticeCD : addNoticeCD) {

            if (NoticeCD.getnotice_id().equals("Not001")){
                notice_head1.setText(String.valueOf(noticeCD.getnotice_name()));
                notice_body1.setText(String.valueOf(noticeCD.getbodyof_notice()));
                notice_date1.setText(String.valueOf(noticeCD.getnotice_createdate()));

                String uri = "file:" + noticeCD.getnotice_imagepdf();
                image = new Image(uri, 0, 0, true, false);
                notice_img1.setFill(new ImagePattern(image));

                getData.path = NoticeCD.getnotice_imagepdf();

            }else if (NoticeCD.getnotice_id().equals("Not002")){
                notice_head2.setText(String.valueOf(NoticeCD.getnotice_name()));
                notice_body2.setText(String.valueOf(NoticeCD.getbodyof_notice()));
                notice_date2.setText(String.valueOf(NoticeCD.getnotice_createdate()));

                String uri = "file:" + NoticeCD.getnotice_imagepdf();
                image = new Image(uri, 0, 0, true, false);
                notice_img2.setFill(new ImagePattern(image));

                getData.path = NoticeCD.getnotice_imagepdf();

            }


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
//                + "', user_role = '"+ addUser_roleC.getSelectionModel().getSelectedItem()
//                + "', course_id = '"+ addUser_CourseCxxx.getText()
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
//                    || addUser_roleC.getSelectionModel().getSelectedItem() == null
//                    || addUser_CourseCxxx.getSelectionModel().getSelectedItem() == null
                    || addUser_FirstNameC.getText().isEmpty()
                    || addUser_LastNameC.getText().isEmpty()
                    || addUser_EmailC.getText().isEmpty()
                    || addUser_AddressC.getText().isEmpty()
                    || addUser_tpNumberC.getText().isEmpty()
                    || addUser_genderC.getSelectionModel().getSelectedItem() == null
                    || addUser_DepartmentListC.getSelectionModel().getSelectedItem() == null
                    || addUser_dobC.getValue() == null

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
                   addProfileClear();

                    //to search th fields
                    //addProfilesSearch();

                    //main front image and name
                    //loadUserData();




                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }


    public void addProfileClear(){
        addUser_useridC.setText("");
        addUser_PasswordC.setText("");
       //addUser_roleC.getSelectionModel().clearSelection();
      //  addUser_CourseC.getSelectionModel().clearSelection();
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
        UserDataEnterArea.setStyle(null);
        addUser_useridC.setStyle(null);
        //addProfile_SearchC.setText("");
        btnimportimage.setStyle(null);

        //addProfilesSearch();
    }









//    public void loadUserData(){
//
//
//        try {
//
//
//            connection = JDBC.getConnection();
//            query = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";
//            preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//
//            while (resultSet.next()){
//
//                UploadResultArea.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name") );
//
//                String uri = "file:" + resultSet.getString("profile_image");
//                image = new Image(uri, 0, 0, true, false);
//
////                addLec_imageViewxxx.setFill(new ImagePattern(image));
//                UserImage_ViewCircle.setFill(new ImagePattern(image));
//            }
//
//        }catch (Exception e){e.printStackTrace();
//        }
//
//    }
//




















    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addProfileshowData();

       // addLecDepartmentList();
    // addLecProfileRoleList();
     //addlecGenList();

    }

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;




}
