package com.example.loginpagedemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class HelloController {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMassageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void  loginButtonOnAction(ActionEvent e) {

        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){
           // loginMassageLabel.setText("You try to login");
            validateLogin();
        }else {
            loginMassageLabel.setText("Please enter username and password");
        }
    }

    public void  cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DataBaseConnection connectionNow = new DataBaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {

            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginMassageLabel.setText("Welcome!");
                }else {
                    loginMassageLabel.setText("Invalid Login. Please try again");
                }
            }

        }catch (Exception e){


        }

    }

}