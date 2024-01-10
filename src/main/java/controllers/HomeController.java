package controllers;


import fr.rapplication.rapp.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label clientLabel;
    private HelloApplication helloApplication;

    public void initialize(){
        //clientLabel.setText(helloApplication.getClient().getDenominationSociale());
    }

    public void onEtablissementButtonClick() throws IOException {
        helloApplication.switchEtablissementView();
    }
    public void onEmployesButtonClick() throws IOException {
        helloApplication.switchEmployeView();
    }
    public void onParametresButtonClick() throws IOException {
    }

    public HelloApplication getHelloApplication() {
        return helloApplication;
    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}
