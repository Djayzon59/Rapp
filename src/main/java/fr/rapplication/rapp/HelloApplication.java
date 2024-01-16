package fr.rapplication.rapp;

import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Client;
import model.Etablissement;

import java.io.IOException;

public class HelloApplication extends Application {

    @FXML
    private BorderPane rootLayout;
    private Stage primaryStage;
    private Stage stage2;
    private Client client;
    Etablissement etablissement;


    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Reserve App");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/login.jpg")));
        this.primaryStage.setResizable(false);
        this.client = new Client();
        initRootLayout();

    }

    public void initRootLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            rootLayout = (BorderPane) fxmlLoader.load();
            LoginController loginController = fxmlLoader.getController();
            loginController.setHelloApplication(this);
            Scene scene = new Scene(rootLayout, 880, 560);
            scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
            this.primaryStage.setScene(scene);
            this.primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void switchHomeView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        AnchorPane clientView =(AnchorPane) fxmlLoader.load();
        rootLayout.setCenter(clientView);
        Scene scene = primaryStage.getScene();
        HomeController homeController = fxmlLoader.getController();
        homeController.setHelloApplication(this);
        scene.getStylesheets().add(getClass().getResource("home.css").toExternalForm());
        homeController.setClient(this.client);
    }

    public void switchEtablissementView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("etablissements.fxml"));
        AnchorPane etablissementView = fxmlLoader.load();
        rootLayout.setCenter(etablissementView);
        Scene scene = primaryStage.getScene();
        EtablissementController etablissementController = fxmlLoader.getController();
        etablissementController.setHelloApplication(this);
        etablissementController.setEtablissement();
        scene.getStylesheets().add(getClass().getResource("etablissement.css").toExternalForm());
    }

    public void switchAjoutEtablissement() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajouterEtablissement.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        AjouterEtablissementController ajouterEtablissementController = fxmlLoader.getController();
        ajouterEtablissementController.setHelloApplication(this);
        stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Reserve App - Ajout établissement");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/login.jpg")));
        stage2.setScene(scene);
        stage2.setResizable(false);
        stage2.show();
    }

    public void switchModifierEtablissement() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("modifierEtablissement.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        ModifierEtablissementController modifierEtablissementController = fxmlLoader.getController();
        modifierEtablissementController.setHelloApplication(this);
        modifierEtablissementController.renseignerChamps();
        stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Reserve App - Modifier établissement");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/login.jpg")));
        stage2.setScene(scene);
        stage2.setResizable(false);
        stage2.show();
    }

    public void switchEmployeView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("employes.fxml"));
        AnchorPane employeView = (AnchorPane) fxmlLoader.load();
        rootLayout.setCenter(employeView);
        Scene scene = primaryStage.getScene();
        EmployeController employeController = fxmlLoader.getController();
        employeController.setHelloApplication(this);

    }

    public void switchAjoutEmploye() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajouterEmploye.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        AjouterEmployeController ajouterEmployeController = fxmlLoader.getController();
        //ajouterEmployeController.setHelloApplication(this);
        //scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Reserve App - Ajout employé");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/zen.png")));
        stage2.setScene(scene);
        stage2.show();
    }
    public void switchModifierInfoCLient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("modifierInfoClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),550,650);
        ModifierClientController modifierClientController = fxmlLoader.getController();
        modifierClientController.setHelloApplication(this);
        stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Reserve App - Modifier mes infos");
        //stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/zen.png")));
        stage2.setScene(scene);
        stage2.show();
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getStage2() {
        return stage2;
    }

    public void setStage2(Stage stage2) {
        this.stage2 = stage2;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}