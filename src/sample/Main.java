package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Kontakt kontakt;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Kontaktsplitter");
        primaryStage.setScene(new Scene(root, 720, 470));
        primaryStage.show();
    }


    public static void main(String[] args) {
        try {
            TitelList.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        kontakt = new Kontakt();

        launch(args);
    }
}
