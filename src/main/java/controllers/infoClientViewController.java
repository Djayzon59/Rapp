package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Client;

public class infoClientViewController {
    @FXML
    private Label denominationSociale;
    @FXML
    private Label mailClient;
    @FXML
    private Label libelleRueClient;
    @FXML
    private Label numeroRueClient;
    @FXML
    private Label complementAdresse;
    @FXML
    private Label ville;
    @FXML
    private Label codePostal;
    @FXML
    private Label numeroTelephone;
    @FXML
    private Label numeroTVA;

    private Stage infoShower;

    private Client client;

    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setInfoShower(Stage infoShower) {
        this.infoShower = infoShower;
    }

    public void setDenominationSociale(Label denominationSociale) {
        this.denominationSociale = denominationSociale;
    }

    public void setClient(Client client) {
        this.client = client;

        denominationSociale.setText(client.getDenominationSociale());
        mailClient.setText(client.getMailClient());
        libelleRueClient.setText(client.getLibelleRueClient());
        numeroRueClient.setText(client.getNumeroRueCLient());
        complementAdresse.setText(client.getComplementAdresseClient());
        //ville.setText(client.getVille().getId_ville());
        codePostal.setText(client.getCodePostalClient());
        numeroTelephone.setText(client.getNumTelClient());
        numeroTVA.setText(client.getNumeroTva());

    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleSignOut() {
    }
}