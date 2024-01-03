module fr.rapplication.rapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;


    opens fr.rapplication.rapp to javafx.fxml;
    exports fr.rapplication.rapp;
}