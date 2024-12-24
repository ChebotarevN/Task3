module app.observer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;


    opens app.observer to javafx.fxml;
    exports app.observer;
}