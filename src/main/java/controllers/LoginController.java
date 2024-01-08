package controllers;

import bean.ClientBean;
import fr.rapplication.rapp.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField mailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button connectButton;
    @FXML
    private Label alerteConnexionLabel;

    private ClientBean clientBean;
    private boolean isConnectionValide;

    private HelloApplication helloApplication;


    public void initialize() {
        clientBean = new ClientBean();
        helloApplication = new HelloApplication();
    }

    @FXML
    protected void onConnectClickButton() throws IOException {

        String email = mailTextField.getText();
        String passWord = passwordTextField.getText();
        isConnectionValide = clientBean.isValidConnection(email, passWord);
        if (!isConnectionValide) {
            alerteConnexionLabel.setText("Login ou Mot de passe invalide !!");
        } else {
            helloApplication.setClient(clientBean.recupererClient(email,passWord));
            helloApplication.getPrimaryStage().close();
            helloApplication.switchClientView();
        }


    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}