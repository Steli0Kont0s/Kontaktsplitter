package sample;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class MainWindowController {
    @FXML
    private TextField input;
    @FXML
    private TextField name;
    @FXML
    private TextField vorname;
    @FXML
    private TextField geschlecht;
    @FXML
    private TextField titel;
    @FXML
    private TextField anrede;
    @FXML
    private TextField briefanrede;
    @FXML
    private GridPane MainWindow;


    /**
     * Eingabe parsen und ausgeben
     */
    @FXML
    private void umwandeln(){
        if(this.input.getText().length() < 1)
            return;
        Main.kontakt = NameParser.parse(this.input.getText());
        Main.kontakt.generateAnrede();
        this.name.setText(Main.kontakt.getName());
        this.vorname.setText(Main.kontakt.getVorname());
        this.geschlecht.setText(Main.kontakt.getGeschlecht());
        this.titel.setText(Main.kontakt.getTitel());
        this.anrede.setText(Main.kontakt.getAnrede());
        this.briefanrede.setText(Main.kontakt.getBriefanrede());
    }

    /**
     * Kontakt mit manuellen Änderungen aktualisieren
     */
    @FXML
    private void aktualisieren(){
        Main.kontakt.setGeschlecht(geschlecht.getText());
        Main.kontakt.setAnrede(anrede.getText());
        Main.kontakt.setName(name.getText());
        Main.kontakt.setVorname(vorname.getText());
        Main.kontakt.setTitel(titel.getText());
        Main.kontakt.generateAnrede();
        this.briefanrede.setText(Main.kontakt.getBriefanrede());
    }

    /**
     * Neuen Titel der Liste und Datei hinzufügen
     * @throws IOException
     */
    @FXML
    private void addTitel() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddTitel.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Titel Hinzufügen");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    /**
     * Kontakt in Textdatei speichern
     * @throws IOException
     */
    @FXML
    private void speichern() throws IOException {
        aktualisieren();
        if(Main.kontakt.korrekt == false)
            return;
        List<String> lines = new LinkedList<>();
        lines.add("Eingabe: " + Main.kontakt.getInput());
        lines.add("Name: " + Main.kontakt.getName());
        lines.add("Vorname: " + Main.kontakt.getVorname());
        lines.add("Titel: " + Main.kontakt.getTitel());
        lines.add("Anrede: " + Main.kontakt.getAnrede());
        lines.add("Sprache: " + Main.kontakt.getSprache());
        lines.add("Briefanrede: " + Main.kontakt.getBriefanrede());
        lines.add("");

        Files.write(Paths.get("Save.txt"), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

}
