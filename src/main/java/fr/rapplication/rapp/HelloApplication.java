package fr.rapplication.rapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @FXML
    private BorderPane rootLayout;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Reserve App");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/zen.png")));
        this.primaryStage.setResizable(false);
        initRootLayout();
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 460);
        //scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        Stage stage2 = new Stage();
        stage2.setTitle("Reserve App - Mes infos");
        stage2.setResizable(false);
        stage2.setScene(scene);
        stage2.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}