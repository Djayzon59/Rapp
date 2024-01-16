package controllers;

import bean.EtablissementBean;
import dao.DaoFactory;
import fr.rapplication.rapp.HelloApplication;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class EtablissementController {


    @FXML
    private ImageView currentEtablissement;
    @FXML
    private ImageView previousEtablissement;
    @FXML
    private ImageView nextEtablissement;
    @FXML
    private Label  libelleEtablissementLabel;
    @FXML
    private Label numRueLabel;
    @FXML
    private Label libelleRueLabel;
    @FXML
    private Label cplmtAdresseLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label villeLabel;
    @FXML
    private Label latitudeLabel;
    @FXML
    private Label longitudeLabel;
    @FXML
    private Label mobileLabel;
    @FXML
    private Label fixeLabel;
    @FXML
    private Label identificationLabel;
    @FXML
    private Label gerantLabel;
    @FXML
    private Button newEtablissementButton;
    @FXML
    private Label nbEtablissementLabel;

    private EtablissementBean etablissementBean;
    private HelloApplication helloApplication;
    private int current;


    @FXML
    private void initialize() {
        this.etablissementBean = new EtablissementBean();
        this.current = 0;
        this.nbEtablissementLabel.setText(" " + String.valueOf(current) + " " + "/" + " " + String.valueOf(etablissementBean.getListeEtablissements().size()-1));
    }

    @FXML
    private void onNextClick(){
        if(this.current < etablissementBean.getListeEtablissements().size()-1){
            ++current;
            incrémenterCompteur();
            setEtablissement();

            FadeTransition fadeOut = new FadeTransition(Duration.millis(900), currentEtablissement);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);

            TranslateTransition transition = new TranslateTransition(Duration.millis(400), nextEtablissement);
            transition.setToX(-120);

            FadeTransition fadeIn = new FadeTransition(Duration.millis(900), currentEtablissement);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);

            transition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    nextEtablissement.setTranslateX(0);
                    currentEtablissement.setOpacity(1.0);
                }
            });
            fadeOut.play();
            transition.play();
            fadeIn.play();
        }
    }
    @FXML
    private void onPreviousClick(){
        if(this.current != 0){
            --current;
            decrementerCompteur();
            setEtablissement();

            FadeTransition fadeOut = new FadeTransition(Duration.millis(900), currentEtablissement);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);

            TranslateTransition transition = new TranslateTransition(Duration.millis(400), previousEtablissement);
            transition.setToX(120);

            FadeTransition fadeIn = new FadeTransition(Duration.millis(900), currentEtablissement);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            transition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    previousEtablissement.setTranslateX(0);
                    currentEtablissement.setOpacity(1.0);
                }
            });
            fadeOut.play();
            transition.play();
            fadeIn.play();
        }
    }

    @FXML
    public void onModifierClick() throws IOException {
        helloApplication.setEtablissement(etablissementBean.getListeEtablissements().get(current));
        helloApplication.switchModifierEtablissement();
    }
    @FXML
    public void addEtablissement() throws IOException {
        helloApplication.switchAjoutEtablissement();
    }
    @FXML
    public void onSupprimerEtablissementClick(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setContentText("Vous êtes sur le point de supprimer cet établissement, souhaitez-vous continuez ?");
        ButtonType cancelButtonType = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().add(cancelButtonType);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            if (etablissementBean.deleteEtablissement(etablissementBean.getListeEtablissements().get(current))){
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("L'établissement à bien été supprimé !");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void onMesInformationsClick() throws IOException {
        helloApplication.switchHomeView();
    }
    @FXML
    private void onDeconnexionClick(){
        helloApplication.initRootLayout();
    }
    @FXML
    private void onMesEmployesClick() throws IOException {
        helloApplication.switchEmployeView();
    }

    public void setEtablissement(){
        this.libelleEtablissementLabel.setText(etablissementBean.getListeEtablissements().get(current).getLibelleEtablissement());
        this.numRueLabel.setText(etablissementBean.getListeEtablissements().get(current).getNumeroRueEtablissement());
        this.libelleRueLabel.setText(etablissementBean.getListeEtablissements().get(current).getLibelleRueEtablissement());
        this.cplmtAdresseLabel.setText(etablissementBean.getListeEtablissements().get(current).getComplementAdresseEtablissement());
        this.codePostalLabel.setText(etablissementBean.getListeEtablissements().get(current).getCodePostalEtablissement());
        this.villeLabel.setText(etablissementBean.getListeEtablissements().get(current).getVille().getLibelleVille());
        this.latitudeLabel.setText(etablissementBean.getListeEtablissements().get(current).getLatitude());
        this.longitudeLabel.setText(etablissementBean.getListeEtablissements().get(current).getLongitude());
        this.mobileLabel.setText(etablissementBean.getListeEtablissements().get(current).getNumMobileEtablissement());
        this.fixeLabel.setText(etablissementBean.getListeEtablissements().get(current).getNumFixeEtablissement());
        this.gerantLabel.setText(etablissementBean.getListeEtablissements().get(current).getEmploye().getNomEmploye());
        this.identificationLabel.setText(etablissementBean.getListeEtablissements().get(current).getNumeroIdentification());
    }
    private void decrementerCompteur() {
        this.nbEtablissementLabel.setText(" " + String.valueOf(current) + " " + "/" + " " + String.valueOf(etablissementBean.getListeEtablissements().size()-1));
    }
    private void incrémenterCompteur(){
        this.nbEtablissementLabel.setText(" " + String.valueOf(current) + " " + "/" + " " + String.valueOf(etablissementBean.getListeEtablissements().size()-1));
    }
    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }
}
