package controllers;

import bean.EmployeBean;
import bean.EtablissementBean;
import fr.rapplication.rapp.HelloApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Employe;
import model.Etablissement;

import java.io.IOException;

public class EmployeController {
    @FXML
    private TableView<Employe> employeTable;
    @FXML
    private TableColumn<Employe, String> firstNameColumn;
    @FXML
    private TableColumn<Employe, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label ancienneteLabel;
    @FXML
    private Label etablissementLabel;
    @FXML
    private Label roleLabel;
    @FXML
    private Button newEmployeButton;

    private EmployeBean employeBean;
    private HelloApplication helloApplication;

    @FXML
    private void initialize() {
        employeBean = new EmployeBean();
        firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenomEmploye()));
        lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomEmploye()));

        employeTable.setItems(FXCollections.observableList(employeBean.getListeEmployes()));
        showEmployeDetails(null);
        employeTable.getSelectionModel().selectedItemProperty()
                .addListener(((observableValue, oldValue, newValue) -> showEmployeDetails(newValue)));
    }

    private void showEmployeDetails(Employe employe) {
        if (employe != null) {
            firstNameLabel.setText(employe.getNomEmploye());
            lastNameLabel.setText(employe.getPrenomEmploye());
            mailLabel.setText(employe.getMailEmploye());
            ancienneteLabel.setText(Integer.toString(employe.getDateEntreeEmploye()));
            etablissementLabel.setText(employe.getLibelleEtablissement());
            roleLabel.setText(employe.getRole());


        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mailLabel.setText("");
            ancienneteLabel.setText("");
            etablissementLabel.setText("");
            roleLabel.setText("");
        }
    }

    @FXML
    public void addEmploye() throws IOException {
        helloApplication.switchAjoutEmploye();

    }

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

}
