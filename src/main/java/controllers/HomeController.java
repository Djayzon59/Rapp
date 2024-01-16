package controllers;


import fr.rapplication.rapp.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Client;

import java.io.IOException;

public class HomeController {

    @FXML
    private Label denominationLabel;
    @FXML
    private Label mailClientLabel;
    @FXML
    private Label numeroRueLabel;
    @FXML
    private Label libelleRueLabel;
    @FXML
    private Label complementLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label numTvaLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label villeClientLabel;

    private HelloApplication helloApplication;

    public void initialize(){
    }

    public void setClient(Client client){
        this.denominationLabel.setText(client.getDenominationSociale());
        this.mailClientLabel.setText(client.getMailClient());
        this.numeroRueLabel.setText(client.getNumeroRueCLient());
        this.libelleRueLabel.setText(client.getLibelleRueClient());
        this.complementLabel.setText(client.getComplementAdresseClient());
        this.codePostalLabel.setText(client.getCodePostalClient());
        this.numTvaLabel.setText(client.getNumeroTva());
        this.telephoneLabel.setText(client.getNumTelClient());
        this.villeClientLabel.setText(client.getVille().getLibelleVille());
    }

    public void onEtablissementButtonClick() throws IOException {
        helloApplication.switchEtablissementView();
    }
    public void onEmployesButtonClick() throws IOException {
        helloApplication.switchEmployeView();
    }
    public void onParametresButtonClick() throws IOException {
    }

    public void onModifierClientBouttonClick() throws IOException {
        helloApplication.switchModifierInfoCLient();
    }

    public HelloApplication getHelloApplication() {
        return helloApplication;
    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}
