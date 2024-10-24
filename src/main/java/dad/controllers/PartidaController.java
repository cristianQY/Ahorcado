package dad.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PartidaController implements Initializable {

    private final StringProperty content = new SimpleStringProperty();
    private StringBuilder usedLetters = new StringBuilder(); // Para almacenar letras usadas

    @FXML
    private Label hiddenLabel;

    @FXML
    private GridPane root;

    @FXML
    private Button letraButtom;

    @FXML
    private TextField letraText;

    @FXML
    private Label puntosLabel;

    @FXML
    private Label usedWordLabel;

    public PartidaController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/partidaView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Agregar un manejador al botón de letra
        letraButtom.setOnAction(event -> addUsedLetter());
    }

    private void addUsedLetter() {
        String letter = letraText.getText().trim(); // Obtener el texto del campo de entrada
        if (letter.length() == 1) { // Comprobar que solo se ingrese una letra
            usedLetters.append(letter).append(" "); // Agregar la letra al StringBuilder
            usedWordLabel.setText(usedLetters.toString()); // Actualizar el Label con las letras usadas
            letraText.clear(); // Limpiar el campo de texto
        }
    }

    @FXML
    void onLetraAction(ActionEvent event) {

    }

    @FXML
    void onSolveAction(ActionEvent event) {

    }

    public GridPane getRoot() {
        return root;
    }
}
