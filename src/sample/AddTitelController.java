package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AddTitelController {
    @FXML
    private TextField titel;
    @FXML
    private void add() throws IOException {
        TitelList.addTitel(titel.getText());
        Stage stage = (Stage) titel.getScene().getWindow();
        stage.close();
    }
}
