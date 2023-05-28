package com.tecmis.project.Student;



import animatefx.animation.FadeIn;
import com.tecmis.project.Admin.getData;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class studentController implements Initializable {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    TimeTable timetableCX = null;

    @FXML
    private TableColumn<?, ?> columdescription1;

    @FXML
    private TableView<MedicalController> medicalform1;
    @FXML
    private TableColumn<?, ?> columTitle1;
    @FXML
    private TableColumn<?, ?> columTDate1;

    @FXML
    private TableColumn<?, ?> columDocument1;

    @FXML
    private AnchorPane timetableform;
    @FXML
    private Button addTimetable_ImageuploadBtn;
    @FXML
    private TextField emailupdatepart;
    @FXML
    private TextField numberupdatepart;
    @FXML
    private Label addressdetails;
    @FXML
    private Label birthdaydetails;
    @FXML
    private Label departmentdetails;
    @FXML
    private TableView<TimeTable> timetableform1;
    @FXML
    private Label emaildetails;
    @FXML
    private AnchorPane update_cdform;
    @FXML
    private Circle addTimetable_imageView;
    @FXML
    private TableColumn<?, ?> columdescription;
    @FXML
    private TableColumn<?, ?> columDocument;

    @FXML
    private TableColumn<?, ?> columTDate;
    @FXML
    private TableColumn<?, ?> CourseCode_course;

    @FXML
    private TableColumn<?, ?> CourseName_course;

    @FXML
    private TableColumn<?, ?> CourseType_course;

    @FXML
    private TableView<CourseController> Coursetable;

    @FXML
    private TableColumn<?, ?> columTitle;

    @FXML
    private Label genderdetails;
    @FXML
    private Label namedetails;
    @FXML
    private Label numberdetails;

    @FXML
    private Label Mobile_number;

    @FXML
    private Label dp_name;

    @FXML
    private Circle UserImage_ViewCircle;
    @FXML
    private Label User_fullName;
    @FXML
    private Button Mydetails;

    @FXML
    private Button Updatecontactdetails;

    @FXML
    private Button Updateprofilepicture;

    @FXML
    private Button atenbtn;

    @FXML
    private AnchorPane atendanceform;

    @FXML
    private Button c_unitbtn;

    @FXML
    private AnchorPane coursewunitform;

    @FXML
    private Button gpabtn;

    @FXML
    private AnchorPane gpaform;

    @FXML
    private Button homebtn;

    @FXML
    private AnchorPane homeform_bottom;

    @FXML
    private AnchorPane homeroomtop;

    @FXML
    private Button medicalbtn;

    @FXML
    private AnchorPane medicalform;

    @FXML
    private AnchorPane mydetailsform;

    @FXML
    private Button signbtn;

    @FXML
    private AnchorPane succcesfullform;

    @FXML
    private Button t_tablebtn;




    @FXML
    private AnchorPane updateprform;

    @FXML
    private TableView<Controller> Attendance_table;


    @FXML
    private TableColumn<?, ?> columCourseCode;

    @FXML
    private TableColumn<?, ?> columDate;

    @FXML
    private TableColumn<?, ?> columState;

    @FXML
    private TableColumn<?, ?> columuser_id;
    @FXML
    private Label Front_name;
    @FXML
    private Label usernuberdetails;
    @FXML
    private TextField adressupdatepart;





    private Image image;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Object database;








    public ObservableList<TimeTable> TimetableController(){
        ObservableList<TimeTable> listTimeTable = FXCollections.observableArrayList();

        String sql = "SELECT * FROM timetable";

        connect = JDBC.getConnection();

        try {

            TimeTable Ttable;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                Ttable = new TimeTable(result.getString("timetable_id")
                        ,result.getString("department_id")
                        , result.getString("timetable_name")
                        , result.getString("creat_date")
                        , result.getString("upnonupPDF")


                );

                listTimeTable.add(Ttable);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listTimeTable;
    }

    private ObservableList<TimeTable> ShowtableTime;




    public void pdfSelect(MouseEvent event){

        if (event.isPrimaryButtonDown() || event.getClickCount() == 1) {


            TimeTable Ttable = timetableform1.getSelectionModel().getSelectedItem();
            int num = timetableform1.getSelectionModel().getSelectedIndex();

            if ((num - 1) < -1) {
                return;
            }




        } else if (event.isPrimaryButtonDown() || event.getClickCount() == 2) {


            TimeTable Ttable = timetableform1.getSelectionModel().getSelectedItem();
            int num = timetableform1.getSelectionModel().getSelectedIndex();

            if ((num - 1) < -1) {
                return;
            }

            timetableCX = timetableform1.getSelectionModel().getSelectedItem();

            try {
                connect = JDBC.getConnection();

                query = "SELECT usepdf FROM timetable WHERE timetable_id='"+timetableCX.getTimetable_id()+"'";

                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){


                    InputStream is = resultSet.getBinaryStream("usepdf");
                    OutputStream os = new FileOutputStream(new File("doc.pdf"));
                    byte[] content = new byte[1024];
                    int size = 0;
                    while ((size = is.read(content)) != -1){
                        os.write(content,0,size);
                    }
                    os.close();
                    is.close();

                    String path = "doc.pdf"; // provide the path to the PDF file
                    File file = new File(path);
                    Desktop.getDesktop().open(file);

                }

            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

    public void  ShowtableTimeTable(){
        ShowtableTime = TimetableController();

        columTitle.setCellValueFactory(new PropertyValueFactory<>("timetable_id"));
        columdescription.setCellValueFactory(new PropertyValueFactory<>("timetable_name"));
        columTDate.setCellValueFactory(new PropertyValueFactory<>("creat_date"));
        columDocument.setCellValueFactory(new PropertyValueFactory<>("upnonupPDF"));

        timetableform1.setItems(ShowtableTime);

    }
//----------------------------------------------------------------------------------------

    public ObservableList<Controller> addController(){
        ObservableList<Controller> listController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM attendance";

        connect = JDBC.getConnection();

        try {

            Controller profileCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                profileCD = new Controller(result.getString("CourseCode")
                        , result.getString("user_id")
                        , result.getString("State")
                        , result.getString("Date")


                );

                listController.add(profileCD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listController;
    }

    private ObservableList<Controller> addProfileCD;

    public void addProfileshowData(){
        addProfileCD = addController();

        columCourseCode.setCellValueFactory(new PropertyValueFactory<>("CourseCode"));
        columuser_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        columState.setCellValueFactory(new PropertyValueFactory<>("State"));
        columDate.setCellValueFactory(new PropertyValueFactory<>("Date"));

        Attendance_table.setItems(addProfileCD);

    }


//-----------------------------------------------------------------
public ObservableList<MedicalController> StudentMedicalController(){
    ObservableList<MedicalController> listMedicalController = FXCollections.observableArrayList();

    String sql = "SELECT * FROM medical";

    connect = JDBC.getConnection();

    try {

        MedicalController medical;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();

        while (result.next()){
            medical = new MedicalController(result.getString("Title")
                    , result.getString("Description")
                    , result.getString("date")
                    , result.getString("document")
                    , result.getString("user_id")


            );

            listMedicalController.add(medical);
        }

    }catch (Exception e){
        e.printStackTrace();
    }
    return listMedicalController;
}

    private ObservableList<MedicalController> addmedical;

    public void addMedicalController(){
        addmedical = StudentMedicalController();
        columTitle1.setCellValueFactory(new PropertyValueFactory<>("Title"));
        columdescription1.setCellValueFactory(new PropertyValueFactory<>("Description"));
        columTDate1.setCellValueFactory(new PropertyValueFactory<>("date"));
        columDocument1.setCellValueFactory(new PropertyValueFactory<>("document"));

        medicalform1.setItems(addmedical);

    }




//-------------------------------------------------------------

    public ObservableList<CourseController> CourseControllercourse(){
        ObservableList<CourseController> listCourseController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM dep_sub";

        connect = JDBC.getConnection();

        try {

            CourseController course;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                course = new CourseController(result.getString("course_id")
                        , result.getString("Course_Code")
                        , result.getString("Course_Name")
                        , result.getString("Course_Type")


                );

                listCourseController.add(course);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listCourseController;
    }

    private ObservableList<CourseController> addcourse;

    public void addCourseController(){
        addcourse = CourseControllercourse();
        CourseCode_course.setCellValueFactory(new PropertyValueFactory<>("Course_Code"));
        CourseName_course.setCellValueFactory(new PropertyValueFactory<>("Course_Name"));
        CourseType_course.setCellValueFactory(new PropertyValueFactory<>("Course_Type"));

        Coursetable.setItems(addcourse);

    }





















//------------------------------------------------------------------------




    public void switchFormx (ActionEvent event){
        if (event.getSource() == homebtn) {

            homeroomtop.setVisible(true);
            homeform_bottom.setVisible(true);
            atendanceform.setVisible(false);
            medicalform.setVisible(false);
            coursewunitform.setVisible(false);
            gpaform.setVisible(false);
            timetableform.setVisible(false);
            update_cdform.setVisible(false);
            updateprform.setVisible(false);
            mydetailsform.setVisible(false);

            loadUserData();

        } else if (event.getSource() == atenbtn) {
            homeroomtop.setVisible(false);
            homeform_bottom.setVisible(false);
            atendanceform.setVisible(true);
            medicalform.setVisible(false);
            coursewunitform.setVisible(false);
            gpaform.setVisible(false);
            timetableform.setVisible(false);
            update_cdform.setVisible(false);
            updateprform.setVisible(false);
            mydetailsform.setVisible(false);
        }else if (event.getSource() == medicalbtn) {
            homeroomtop.setVisible(false);
            homeform_bottom.setVisible(false);
            atendanceform.setVisible(false);
            medicalform.setVisible(true);
            coursewunitform.setVisible(false);
            gpaform.setVisible(false);
            timetableform.setVisible(false);
            update_cdform.setVisible(false);
            updateprform.setVisible(false);
            mydetailsform.setVisible(false);
        } else if (event.getSource() == c_unitbtn) {
            homeroomtop.setVisible(false);
            homeform_bottom.setVisible(false);
            atendanceform.setVisible(false);
            medicalform.setVisible(false);
            coursewunitform.setVisible(true);
            gpaform.setVisible(false);
            timetableform.setVisible(false);
            update_cdform.setVisible(false);
            updateprform.setVisible(false);
            mydetailsform.setVisible(false);
        } else if (event.getSource() == gpabtn) {


            homeroomtop.setVisible(false);
            homeform_bottom.setVisible(false);
            atendanceform.setVisible(false);
            medicalform.setVisible(false);
            coursewunitform.setVisible(false);
            gpaform.setVisible(true);
            timetableform.setVisible(false);
            update_cdform.setVisible(false);
            updateprform.setVisible(false);
            mydetailsform.setVisible(false);
        } else if (event.getSource() == t_tablebtn) {
            homeroomtop.setVisible(false);
            homeform_bottom.setVisible(false);
            atendanceform.setVisible(false);
            medicalform.setVisible(false);
            coursewunitform.setVisible(false);
            gpaform.setVisible(false);
            timetableform.setVisible(true);
            update_cdform.setVisible(false);
            updateprform.setVisible(false);
            mydetailsform.setVisible(false);
        }

    }

        public void switchForm2 (ActionEvent event){
            if (event.getSource() == Mydetails) {
                homeroomtop.setVisible(true);
                homeform_bottom.setVisible(false);
                atendanceform.setVisible(false);
                medicalform.setVisible(false);
                coursewunitform.setVisible(false);
                gpaform.setVisible(false);
                timetableform.setVisible(false);
                update_cdform.setVisible(false);
                updateprform.setVisible(false);
                mydetailsform.setVisible(true);
            } else if (event.getSource() == Updatecontactdetails) {
                homeroomtop.setVisible(true);
                homeform_bottom.setVisible(false);
                atendanceform.setVisible(false);
                medicalform.setVisible(false);
                coursewunitform.setVisible(false);
                gpaform.setVisible(false);
                timetableform.setVisible(false);
                update_cdform.setVisible(true);
                updateprform.setVisible(false);
                mydetailsform.setVisible(false);
            } else if (event.getSource() == Updateprofilepicture) {
                homeroomtop.setVisible(true);
                homeform_bottom.setVisible(false);
                atendanceform.setVisible(false);
                medicalform.setVisible(false);
                coursewunitform.setVisible(false);
                gpaform.setVisible(false);
                timetableform.setVisible(false);
                update_cdform.setVisible(false);
                updateprform.setVisible(true);
                mydetailsform.setVisible(false);
            }

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addController();
        addProfileshowData();
        loadUserData();
        loadUserData1();
        TimetableController();
        ShowtableTimeTable();
        CourseControllercourse();
        addCourseController();
        StudentMedicalController();
        addMedicalController();

//        loadUserData2();
//        loadUserData3();
    }





    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;









    public void loadUserData(){


        try {

            connection = JDBC.getConnection();
            query = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                User_fullName.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name") );

                String uri = "file:" + resultSet.getString("profile_image");
                image = new Image(uri, 0, 0, true, false);

                UserImage_ViewCircle.setFill(new ImagePattern(image));

            }

        }catch (Exception e){e.printStackTrace();
        }

    }

    public void loadUserData1(){


        try {

            connection = JDBC.getConnection();
            query = "SELECT * FROM user WHERE user_id = '"+ UserSession.getUserId() +"'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Front_name.setText(resultSet.getString("email") );
                dp_name.setText(resultSet.getString("department_id") );
                Mobile_number.setText(resultSet.getString("tp_number") );
                namedetails.setText(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                departmentdetails.setText(resultSet.getString("department_id") );
                genderdetails.setText(resultSet.getString("sex") );
                emaildetails.setText(resultSet.getString("email") );
                birthdaydetails.setText(resultSet.getString("dob") );
                addressdetails.setText(resultSet.getString("address") );
                numberdetails.setText(resultSet.getString("tp_number") );
                usernuberdetails.setText(resultSet.getString("user_id") );

            }

        }catch (Exception e){e.printStackTrace();
        }
    }

    public  void addProfileUpdate(){

        String updateData = "UPDATE user SET address ='"+adressupdatepart.getText()+"' , email = '"+emailupdatepart.getText()+"', tp_number = '"+numberupdatepart.getText()+"' WHERE user_id ='"+UserSession.getUserId()+"'";

        connect = JDBC.getConnection();


        try {
            Alert alert;
            if (adressupdatepart.getText().isEmpty()
                    || emailupdatepart.getText().isEmpty()
                    || numberupdatepart.getText().isEmpty()
                    ){

                update_cdform.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                new animatefx.animation.Bounce(update_cdform).play();
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

           }
            else {


                alert= new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
//                alert.setContentText("Are you sure you want to UPDATE User ID '" + addUser_useridC.getText() + "' ?" );
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)){

//                    statement = connect.createStatement();
//                    statement.executeUpdate(updateData);

                   // String upnonupprofile = (uri != null) ? "Updated" : "Non Updated";
                    PreparedStatement preparedStatement = JDBC.getConnection().prepareStatement(updateData);
                  //  preparedStatement.setString(1, upnonupprofile);
                    preparedStatement.executeUpdate();
                    preparedStatement.close();


                    update_cdform.setStyle(null);
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                }else return;
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void addTimetableUploadImage(){

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));



        File file = open.showOpenDialog(updateprform.getScene().getWindow());

        if (file != null){


            image = new Image(file.toURI().toString(),0, 0, true, false );
            addTimetable_imageView.setFill(new ImagePattern(image));
            getData.path = file.getAbsolutePath();

            addTimetable_ImageuploadBtn.setStyle("-fx-background-color: #ff9800;");

        }
    }


    public void ProfileUpdate() throws SQLException {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE user SET profile_image  ='"+uri+"' WHERE user_id ='"+UserSession.getUserId()+"'";

        connect = JDBC.getConnection();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = JDBC.getConnection().prepareStatement(updateData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //  preparedStatement.setString(1, upnonupprofile);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        profileClear();

    }

    public void profileClear(){

        addTimetable_imageView.setFill(null);
        getData.path = "";

    }

    public void allClear(){
        emailupdatepart.setText(null);
        adressupdatepart.setText(null);
        numberupdatepart.setText(null);
    }

    public void SignOut(ActionEvent event)throws IOException
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










}


