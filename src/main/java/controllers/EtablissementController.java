package controllers;

import bean.EtablissementBean;
import fr.rapplication.rapp.HelloApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Etablissement;

import java.io.IOException;

public class EtablissementController {

    @FXML
    private TableView<Etablissement> tableViewEtablissements;
    @FXML
    private TableColumn<Etablissement, String> libelleEtablissementColumn;
    @FXML
    private Label libelleEtablissementLabel;
    @FXML
    private Label libelleRueEtablissementLabel;
    @FXML
    private Label codePostalEtablissementLabel;
    @FXML
    private Label libelleVilleEtablissementLabel;
    @FXML
    private Label numeroIdentificationLabel;
    @FXML
    private Label numMobileEtablissementLabel;
    @FXML
    private Label nomGerantLabel;
    @FXML
    private Button newEtablissementButton;


    private EtablissementBean etablissementBean;
    private HelloApplication helloApplication;


    @FXML
    private void initialize() {
        etablissementBean = new EtablissementBean();
        libelleEtablissementColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibelleEtablissement()));
        tableViewEtablissements.setItems(FXCollections.observableList(etablissementBean.getListeEtablissements()));
        showEtablissementDetails(null);
        tableViewEtablissements.getSelectionModel().selectedItemProperty()
                .addListener(((observableValue, oldValue, newValue) -> showEtablissementDetails(newValue)));


    }

    public void showEtablissementDetails(Etablissement etablissement) {
        if (etablissement != null) {
            libelleEtablissementLabel.setText(etablissement.getLibelleEtablissement());
            libelleRueEtablissementLabel.setText(etablissement.getLibelleRueEtablissement());
            codePostalEtablissementLabel.setText(etablissement.getCodePostalEtablissement());
            //libelleVilleEtablissementLabel.setText(etablissement.getVille().getLibelleVille());
            numeroIdentificationLabel.setText(etablissement.getNumeroIdentification());
            numMobileEtablissementLabel.setText(etablissement.getNumMobileEtablissement());
            //nomGerantLabel.setText(etablissement.getEmploye().getNomEmploye());
        } else {
            libelleEtablissementLabel.setText("");
            libelleRueEtablissementLabel.setText("");
            codePostalEtablissementLabel.setText("");
            libelleVilleEtablissementLabel.setText("");
            numeroIdentificationLabel.setText("");
            numMobileEtablissementLabel.setText("");
            nomGerantLabel.setText("");
        }
    }

    @FXML
    public void addEtablissement() throws IOException {
        helloApplication.switchAjoutEtablissement();

    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}
