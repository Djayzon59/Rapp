package fr.rapplication.rapp;

import controllers.AjouterEtablissementController;
import controllers.EtablissementController;
import controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Client;

import java.io.IOException;

public class HelloApplication extends Application {

    @FXML
    private BorderPane rootLayout;
    private Stage primaryStage;
    private Stage stage2;
    private Client client;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Reserve App");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/login.jpg")));
        this.primaryStage.setResizable(false);
        this.client = new Client();
        initRootLayout();
        //switchEtablissementView();
    }

    public void initRootLayout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 780, 460);
            LoginController loginController = fxmlLoader.getController();
            loginController.setHelloApplication(this);
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

    public void switchClientView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 460);
        //scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage2 = new Stage();
        stage2.setTitle("Reserve App - Mes infos");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/zen.png")));
        stage2.setScene(scene);
        stage2.show();

    }

    public void switchEtablissementView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("etablissements.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        EtablissementController etablissementOverViewController = fxmlLoader.getController();
        etablissementOverViewController.setHelloApplication(this);
        //scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage2 = new Stage();
        stage2.setTitle("Reserve App - Mes établissements");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/zen.png")));
        stage2.setScene(scene);
        stage2.show();
    }

    public void switchAjoutEtablissement() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajouterEtablissement.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        AjouterEtablissementController ajouterEtablissementController = fxmlLoader.getController();
        ajouterEtablissementController.setHelloApplication(this);
        //scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setTitle("Reserve App - Ajout établissement");
        stage2.getIcons().add(new Image(getClass().getResourceAsStream("/images/zen.png")));
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
}