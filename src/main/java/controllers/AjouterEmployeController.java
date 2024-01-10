package controllers;

import bean.*;
import fr.rapplication.rapp.HelloApplication;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.*;

import java.io.IOException;

public class AjouterEmployeController {
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField mailTextField;
    @FXML
    private DatePicker arriveeDatePicker;
    @FXML
    private ComboBox<Etablissement> etablissementComboBox;
    @FXML
    private ComboBox<Role> roleComboBox;


    private HelloApplication helloApplication;
    private EtablissementBean etablissementBean;
    private EmployeBean employeBean;
    private RoleBean roleBean;


    public void initialize() {
        etablissementBean = new EtablissementBean();
        employeBean = new EmployeBean();
        roleBean = new RoleBean();
        etablissementComboBox.setItems(FXCollections.observableArrayList(etablissementBean.getListeEtablissements()));
        roleComboBox.setItems(FXCollections.observableList(roleBean.getListeRoles()));
    }
}

    /*@FXML
    public void enregistrerEmploye() throws IOException {

        Employe employe = new Employe();

        //employe.setEtablissement(new Etablissement(etablissementComboBox.getValue()));
       // etablissement.getVille().setPays(paysComboBox.getValue());
      //  if (!villeBean.isExisting(etablissement.getVille()))
          //  villeBean.ajouterVille(etablissement.getVille());

        employe.setPrenomEmploye(firstNameTextField.getText());
        employe.setNomEmploye(lastNameTextField.getText());
        employe.setMailEmploye(mailTextField.getText());
        employe.setDateEntreeEmploye(arriveeDatePicker.getValue());
        employe.get
        employe


        employeBean.addEmploye(employe);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(helloApplication.getStage2());
        alert.setTitle("Confirmation");
        alert.setContentText("Votre employé a été ajouté avec succès !");
        alert.showAndWait();

        helloApplication.switchEtablissementView();
    }

    public void onAnnulerclickButton() throws IOException {
        helloApplication.switchEmployeView();
    }


    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

}
*/

