package controllers;

import bean.EmployeBean;
import bean.EtablissementBean;
import bean.PaysBean;
import bean.VilleBean;
import dao.DaoFactory;
import fr.rapplication.rapp.HelloApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Employe;
import model.Etablissement;
import model.Pays;

import java.io.IOException;

public class ModifierEtablissementController {

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


    public HelloApplication getHelloApplication() {
        return helloApplication;
    }


    public void initialize() {
        etablissementBean = new EtablissementBean();
        employeBean = new EmployeBean();
        paysBean = new PaysBean();
        villeBean = new VilleBean();
        paysComboBox.setItems(FXCollections.observableArrayList(paysBean.getListePays()));
        gerantComboBox.setItems(FXCollections.observableList(employeBean.getListeEmployes()));

    }

    @FXML
    public void modifierEtablissement(){
        helloApplication.getEtablissement().setLibelleEtablissement(libelleEtablissementTextField.getText());
        helloApplication.getEtablissement().setNumeroRueEtablissement(numeroRueTextField.getText());
        helloApplication.getEtablissement().setLibelleRueEtablissement(libelleRueTextField.getText());
        helloApplication.getEtablissement().setComplementAdresseEtablissement(complementTextField.getText());
        helloApplication.getEtablissement().setCodePostalEtablissement(codePostalTextField.getText());
        helloApplication.getEtablissement().setNumeroIdentification(numeroIdentificationTextField.getText());
        helloApplication.getEtablissement().setLatitude(latitudeTextField.getText());
        helloApplication.getEtablissement().setLongitude(longitudeTextField.getText());
        helloApplication.getEtablissement().setNumMobileEtablissement(mobileTextField.getText());
        helloApplication.getEtablissement().setNumFixeEtablissement(fixeTextField.getText());
        helloApplication.getEtablissement().getEmploye().setId_employe(gerantComboBox.getSelectionModel().getSelectedItem().getId_employe());

        if(etablissementBean.updateEtablissement(helloApplication.getEtablissement())){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Votre établissement a été modifié !");
            alert.showAndWait();
        }
        helloApplication.getStage2().close();

    }

    public void renseignerChamps() {
        villeTextField.setText(helloApplication.getEtablissement().getVille().getLibelleVille());
        libelleEtablissementTextField.setText(helloApplication.getEtablissement().getLibelleEtablissement());
        numeroRueTextField.setText(helloApplication.getEtablissement().getNumeroRueEtablissement());
        libelleRueTextField.setText(helloApplication.getEtablissement().getLibelleRueEtablissement());
        complementTextField.setText(helloApplication.getEtablissement().getComplementAdresseEtablissement());
        codePostalTextField.setText(helloApplication.getEtablissement().getCodePostalEtablissement());
        numeroIdentificationTextField.setText(helloApplication.getEtablissement().getNumeroIdentification());
        latitudeTextField.setText(helloApplication.getEtablissement().getLatitude());
        longitudeTextField.setText(helloApplication.getEtablissement().getLongitude());
        mobileTextField.setText(helloApplication.getEtablissement().getNumMobileEtablissement());
        fixeTextField.setText(helloApplication.getEtablissement().getNumFixeEtablissement());
    }


    public void onAnnulerclickButton() throws IOException {
        helloApplication.getStage2().close();
        helloApplication.switchEtablissementView();
    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}
