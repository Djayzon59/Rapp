package controllers;

import bean.EmployeBean;
import bean.EtablissementBean;
import bean.PaysBean;
import bean.VilleBean;
import fr.rapplication.rapp.HelloApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Employe;
import model.Etablissement;
import model.Pays;
import model.Ville;

import java.io.IOException;

public class AjouterEtablissementController {
    @FXML
    private TextField libelleEtablissementTextField;
    @FXML
    private TextField numeroRueTextField;
    @FXML
    private TextField libelleRueTextField;
    @FXML
    private TextField complementTextField;
    @FXML
    private TextField codePostalTextField;
    @FXML
    private TextField numeroIdentificationTextField;
    @FXML
    private TextField latitudeTextField;
    @FXML
    private TextField longitudeTextField;
    @FXML
    private TextField mobileTextField;
    @FXML
    private TextField fixeTextField;
    @FXML
    private ComboBox<Employe> gerantComboBox;
    @FXML
    private ComboBox<Pays> paysComboBox;
    @FXML
    private TextField villeTextField;

    private HelloApplication helloApplication;
    private EtablissementBean etablissementBean;
    private EmployeBean employeBean;
    private PaysBean paysBean;
    private VilleBean villeBean;


    public void initialize() {
        etablissementBean = new EtablissementBean();
        employeBean = new EmployeBean();
        paysBean = new PaysBean();
        villeBean = new VilleBean();
        paysComboBox.setItems(FXCollections.observableArrayList(paysBean.getListePays()));
        gerantComboBox.setItems(FXCollections.observableList(employeBean.getListeEmployes()));
    }


    @FXML
    public void enregistrerEtablissement() throws IOException {

        Etablissement etablissement = new Etablissement();

        etablissement.setVille(new Ville(villeTextField.getText()));
        etablissement.getVille().setPays(paysComboBox.getValue());
        if (!villeBean.isExisting(etablissement.getVille()))
            villeBean.ajouterVille(etablissement.getVille());

        etablissement.setLibelleEtablissement(libelleEtablissementTextField.getText());
        etablissement.setNumeroRueEtablissement(numeroRueTextField.getText());
        etablissement.setLibelleRueEtablissement(libelleRueTextField.getText());
        etablissement.setComplementAdresseEtablissement(complementTextField.getText());
        etablissement.setCodePostalEtablissement(codePostalTextField.getText());
        etablissement.setNumeroIdentification(numeroIdentificationTextField.getText());
        etablissement.setLatitude(latitudeTextField.getText());
        etablissement.setLongitude(longitudeTextField.getText());
        etablissement.setNumMobileEtablissement(mobileTextField.getText());
        etablissement.setNumFixeEtablissement(fixeTextField.getText());

        etablissement.getEmploye().setId_employe(gerantComboBox.getValue().getId_employe());
        etablissement.getClient().setId_client(7);
        etablissement.getVille().setId_ville(villeBean.recupererIdVille(etablissement.getVille()));

        etablissementBean.addEtablissement(etablissement);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(helloApplication.getStage2());
        alert.setTitle("Confirmation");
        alert.setContentText("Votre établissement a été ajouté avec succès !");
        alert.showAndWait();

        helloApplication.switchEtablissementView();
    }

    public void onAnnulerclickButton() throws IOException {
        helloApplication.getStage2().close();
        helloApplication.switchEtablissementView();
    }


    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

}
