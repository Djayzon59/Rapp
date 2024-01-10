package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;

public class ModifierClientController {

    @FXML
    private TextField denominationSociale;
    @FXML
    private TextField mailClient;
    @FXML
    private TextField libelleRueClient;
    @FXML
    private TextField numeroRueClient;
    @FXML
    private TextField complementAdresse;
    @FXML
    private TextField ville;
    @FXML
    private TextField codePostal;
    @FXML
    private TextField numeroTelephone;

    private Stage editStage;

    private Client client;

    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    public void setEditStage(Stage editStage) {
        this.editStage = editStage;
    }

    public void setDenominationSociale(TextField denominationSociale) {
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

    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            client.setDenominationSociale(denominationSociale.getText());
            client.setMailClient(mailClient.getText());
            client.setLibelleRueClient(libelleRueClient.getText());
            client.setNumeroRueCLient(numeroRueClient.getText());
            client.setComplementAdresseClient(complementAdresse.getText());
            //client.setVille(ville.getText());
            client.setCodePostalClient(codePostal.getText());
            client.setNumTelClient(numeroTelephone.getText());

            okClicked = true;
            editStage.close();

        }
    }

    @FXML
    private void handleCancel() {
        editStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (denominationSociale.getText() == null || denominationSociale.getText().length() == 0) {
            errorMessage += "La raison sociale n'est pas valide !\n";
        }

        // if (mailClient.getText() == null || mailClient.getText().length() == 0 || String.format(mailClient.getText()  ) {
        //     errorMessage += "Le prénom n'est pas valide !\n";

        if (libelleRueClient.getText() == null || libelleRueClient.getText().length() == 0) {
            errorMessage += "La rue n'est pas valide !\n";
        }

        if (numeroRueClient.getText() == null || numeroRueClient.getText().length() == 0) {
            errorMessage += "Le numéro n'est pas valide !\n";
        } else{
                try {
                    Integer.parseInt(numeroRueClient.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Le numéro n'est pas valide !\n";
                }
            }

        if (ville.getText() == null || ville.getText().length() == 0) {
            errorMessage += "La ville n'est pas valide !\n";
        }


        if (numeroRueClient.getText() == null || numeroRueClient.getText().length() == 0) {
            errorMessage += "Le numéro n'est pas valide !\n";

        }
        if (codePostal.getText() == null || codePostal.getText().length() == 0) {
            errorMessage += "Le code postal n'est pas valide !\n";
        } else{
                try {
                    Integer.parseInt(codePostal.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Le code postal n'est pas valide !\n";
                }
        }
        if (numeroTelephone.getText() == null || numeroTelephone.getText().length() == 0) {
            errorMessage += "Le numéro n'est pas valide !\n";
        } else{
                try {
                    Integer.parseInt(numeroTelephone.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Le numéro n'est pas valide !\n";
                }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(editStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
