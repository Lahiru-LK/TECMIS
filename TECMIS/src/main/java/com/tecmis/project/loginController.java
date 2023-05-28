package com.tecmis.project;


import animatefx.animation.FadeIn;
import com.tecmis.project.connection_DB.JDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class loginController  implements Initializable{

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label loginMassageLable;
    @FXML
    private Label loginMassageLable2;
    @FXML
    private TextField username,password;

    String User_ID;
    String User_Name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }


    public void loginButtonAction(ActionEvent event)throws Exception {

        if (username.getText().isBlank()==true)
        {
            loginMassageLable.setText("You try to login!");
            loginMassageLable2.setText("Please Enter Username & password");
            new animatefx.animation.Bounce(loginMassageLable2).play();

            username.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
            new animatefx.animation.Shake(username).play(); //animated field
        }
        else
        {
            username.setStyle(null);
        }

        if (password.getText().isBlank()==true)
        {
            loginMassageLable.setText("You try to login!");
            loginMassageLable2.setText("Please Enter Username & Password");
            new animatefx.animation.Bounce(loginMassageLable2).play();

            password.setStyle("-fx-border-color:red;-fx-border-width:2px;");
            new animatefx.animation.Shake(password).play();
        }
        else
        {
            password.setStyle(null);
        }

        if (username.getText().isBlank()==false && password.getText().isBlank()==false)
        {



            JDBC connectNow = new JDBC();
            Connection connectDB = connectNow.getConnection();



            String verifyLogin = "SELECT COUNT(1) FROM user WHERE user_id ='" + username.getText() + "'AND user_password ='" + password.getText() + "' ";

            try {
                Statement statement = connectDB.createStatement();  //interface  --> can sql query run programe
                ResultSet queryResult = statement.executeQuery(verifyLogin);       //resulset kiyanne java hambewena interface ekak


                while (queryResult.next())
                {


                    if(queryResult.getInt(1)==1)
                    {

                        String verifycheckRole = "SELECT * FROM user WHERE user_id ='" + username.getText() + "'AND user_password ='" + password.getText() + "' ";

                        Statement statement2 = connectDB.createStatement();
                        ResultSet queryResult2 = statement2.executeQuery(verifycheckRole);

                        while (queryResult2.next()) //
                        {
                            String Role = queryResult2.getString(1); //database eke role eka selectr karanwa


                            if (Role.equals("Admin"))
                            {

                                User_ID = queryResult2.getString("user_id");
                                User_Name = queryResult2.getString("first_name");

                                UserSession.getInstance(User_Name,User_ID);

//                                System.out.println(UserSession.getUserId());




                                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Admin/admin.fxml")));
                                new FadeIn(root).play();
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root, 1200,700);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();
                                stage.resizableProperty().setValue(false);




                            } else if (Role.equals("Student")) {

                                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Student/student.fxml")));
                                new FadeIn(root).play();
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root, 1200,700);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();
                                stage.resizableProperty().setValue(false);


                            }else if (Role.equals("Lecturer")) {

                                User_ID = queryResult2.getString("user_id");
                                User_Name = queryResult2.getString("first_name");

                                UserSession.getInstance(User_Name,User_ID);

                                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Lecturer/lecturer.fxml")));
                                new FadeIn(root).play();
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();
                                stage.resizableProperty().setValue(false);

                            }else if (Role.equals("Technical_Officer")) {

                                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Technical_Officer/technical_officer.fxml")));
                                new FadeIn(root).play();
                                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root, 1200,700);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();
                                stage.resizableProperty().setValue(false);
                            }





                        }



                    }else{
                        loginMassageLable.setText("You try to login!");
                        loginMassageLable2.setText("Invalid Login. Please Try Again");
                        new animatefx.animation.Bounce(loginMassageLable2).play();

                        password.setStyle("-fx-border-color:red;-fx-border-width:2px;");
                        new animatefx.animation.Shake(password).play();
                        username.setStyle("-fx-border-color:red;-fx-border-width:2px;"); // filed color red
                        new animatefx.animation.Shake(username).play();
                    }

                }

            }catch (Exception e){
                e.printStackTrace();//error print
                e.getCause();
            }




        }



    }



}