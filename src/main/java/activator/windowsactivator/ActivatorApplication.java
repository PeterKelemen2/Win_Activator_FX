package activator.windowsactivator;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ActivatorApplication extends javafx.application.Application {
    private String iconPath = "icon.png";
    private Image icon = new Image(iconPath);

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ActivatorApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Windows Activator");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}