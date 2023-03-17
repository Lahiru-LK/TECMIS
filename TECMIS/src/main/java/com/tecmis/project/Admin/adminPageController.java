package com.tecmis.project.Admin;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.tecmis.project.Admin.Profiles.profileController;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;


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
    private Button btnTimetable;
    @FXML
    private ComboBox<String> ComboList1;
    @FXML
    private ComboBox<String> ComboList2;

    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private AnchorPane profile_form;

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
    private TableColumn<profileController, String> adduser_no;

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
    private JFXButton addProfile_uploadBtn;

    @FXML
    private JFXButton addUser_addBtn;

    @FXML
    private JFXButton addUser_updateBtn;

    @FXML
    private JFXButton addUser_clearBtn;

    @FXML
    private JFXButton addUser_deleteBtn;

    @FXML
    private AnchorPane UserDataEnterArea;

    @FXML
    private TextField addProfile_SearchC;
    @FXML
    private AnchorPane userTablearea;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;




    //combobox
    private String[] roleList = {"admin", "lecturer", "technician_officer", "student"};
    public void addProfileRoleList(){

        List<String> roleL = new ArrayList<>();

        for(String data: roleList){
            roleL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(roleL);
        addUser_roleC.setItems(ObList);
    }

    private String[] genderList = {"male", "female", "other"};
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


            image = new Image(file.toURI().toString(),200, 200, true, false );
            addUser_imageViewC.setImage(image);


            getData.path = file.getAbsolutePath();

        }
    }



    public ObservableList<profileController> addProfileController()
    {
        ObservableList<profileController> listProfileController = FXCollections.observableArrayList();

        String sql = "SELECT * FROM user";

        connect = JDBC.getConnection();

        try {

            profileController profileCD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){
                profileCD = new profileController(result.getString("user_role")
                        , result.getInt("user_no")
                        , result.getString("user_id")
                        , result.getString("user_password")
                        , result.getString("first_name")
                        , result.getString("last_name")
                        , result.getString("email")
                        , result.getDate("dob")
                        , result.getString("sex")
                        , result.getString("address")
                        , result.getString("tp_number")
                        , result.getString("profile_image")
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

        adduser_no.setCellValueFactory(new PropertyValueFactory<>("user_no"));
        adduser_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        adduser_password.setCellValueFactory(new PropertyValueFactory<>("user_password"));
        adduser_role.setCellValueFactory(new PropertyValueFactory<>("user_role"));
        adduser_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        adduser_firstname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        adduser_lastname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        adduser_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        adduser_sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        adduser_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        adduser_tpnumber.setCellValueFactory(new PropertyValueFactory<>("tp_number"));
        adduser_propicture.setCellValueFactory(new PropertyValueFactory<>("profile_image"));

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
        image = new Image(uri, 200, 200, true, false);
        addUser_imageViewC.setImage(image);

        getData.path = profileD.getProfile_image();

    }


    public void addProfileAdd(){
        String insertDATA = "INSERT INTO user"
                +"(user_role,user_id,user_password,first_name,last_name,email,dob,sex,address,tp_number,profile_image,date)"
                +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

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
                    prepare.setString(4,addUser_FirstNameC.getText());
                    prepare.setString(5,addUser_LastNameC.getText());
                    prepare.setString(6,addUser_EmailC.getText());
                    prepare.setString(7,String.valueOf(addUser_dobC.getValue()));
                    prepare.setString(8,(String)addUser_sexC.getSelectionModel().getSelectedItem());
                    prepare.setString(9,addUser_AddressC.getText());
                    prepare.setString(10,addUser_tpNumberC.getText());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(11, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(12,String.valueOf(sqlDate));


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

                }else return;

            }

        }catch (Exception e){e.printStackTrace();}
    }




    public void addProfileClear(){
        addUser_useridC.setText("");
        addUser_PasswordC.setText("");
        addUser_roleC.getSelectionModel().clearSelection();
        addUser_EmailC.setText("");
        addUser_FirstNameC.setText("");
        addUser_LastNameC.setText("");
        addUser_dobC.setValue(null);
        addUser_sexC.getSelectionModel().clearSelection();
        addUser_AddressC.setText("");
        addUser_tpNumberC.setText("");
        addUser_imageViewC.setImage(null);
        getData.path = "";
        UserDataEnterArea.setStyle(null);
        addUser_useridC.setStyle(null);
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


//    public void addProfilesSearch(){
//
//        FilteredList<profileController> filteredList = new FilteredList<>(addProfileCD, e-> true);
//
//        addProfile_SearchC.textProperty().addListener((Observable, oldValue, newValue) ->{
//
//            filteredList.setPredicate(predicateProfleController ->{
//
//                if (newValue == null || newValue.isEmpty()){
//                    return true;
//                }
//
//                String searchKey = newValue.toLowerCase();
//
//                if (predicateProfleController.getUser_no().toString().contains(searchKey)){
//                    return true;
//                } else if (predicateProfleController.getUser_id().toLowerCase().contains(searchKey)) {
//                    return true;
//                } else if (predicateProfleController.getFirst_name().toLowerCase().contains(searchKey)) {
//                    return true;
//                }else {return false;}
//            });
//        });
//
//        SortedList<profileController> sortedList = new SortedList<>(filteredList);
//        sortedList.comparatorProperty().bind(adduser_tableView.comparatorProperty());
//        adduser_tableView.setItems(sortedList);
//    }



//-----------------------------------------------------------------------------------------------------------------------------------


    public void switchForm(ActionEvent event) {
        if (event.getSource()==btnDashboard){
            dashboard_form.setVisible(true);
            profile_form.setVisible(false);



        } else if (event.getSource()==btnProfile) {
            dashboard_form.setVisible(false);
            profile_form.setVisible(true);


            //to become updared once you click the add stuydent button on nav
            addProfileshowData();
            addProfileRoleList();
            addProfileGenderList();
//            addProfilesSearch();

        } else if (event.getSource()==btnCourse) {
            dashboard_form.setVisible(false);
            profile_form.setVisible(false);


        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //to show immediately when we open the dashboard
        addProfileshowData();
        addProfileRoleList();
        addProfileGenderList();

    }

}
