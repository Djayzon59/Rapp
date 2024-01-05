package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Etablissement;

public class EtablissementOverViewController {

    @FXML
    private TableView<Etablissement> etablissementTable;
    @FXML
    private TableColumn<Etablissement, String> libelleEtablissementColumn;
    @FXML
    private Label libelleEtablissement;
    @FXML
    private Label numeroRueEtablissement;
    @FXML
    private Label libelleRueEtablissement;
    @FXML
    private Label complementAdresseEtablissement;
    @FXML
    private Label codePostalEtablissement;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

}
