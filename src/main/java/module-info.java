module activator.windowsactivator {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.tinylog.api;


    opens activator.windowsactivator to javafx.fxml;

    exports activator.windowsactivator;
}