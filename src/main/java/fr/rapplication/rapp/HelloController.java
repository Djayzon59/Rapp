package fr.rapplication.rapp;

import bean.ClientBean;
import bean.EmployeBean;
import bean.PaysBean;
import bean.RoleBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    EmployeBean employeBean;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){

        employeBean = new EmployeBean();


    }
}