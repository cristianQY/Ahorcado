package dad.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PartidaController implements Initializable {

    private final StringProperty content = new SimpleStringProperty();
    private final StringBuilder usedLetters = new StringBuilder(); // Para almacenar letras usadas

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

    @FXML
    private Label fakeToadsLabel;

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
            if (!usedLetters.toString().contains(letter)) { // Verificar si la letra no está en usedLetters
                usedLetters.append(letter).append(" "); // Agregar la letra al StringBuilder
                usedWordLabel.setText(usedLetters.toString()); // Actualizar el Label con las letras usadas
            } else {
                // Mostrar mensaje temporal en fakeToadsLabel
                fakeToadsLabel.setText("La letra (" + letter + ") ya ha sido usada.");

                // Crear un Timeline para borrar el mensaje después de 2 segundos
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
                    fakeToadsLabel.setText(""); // Limpiar el mensaje
                }));
                timeline.setCycleCount(1); // Solo se ejecuta una vez
                timeline.play();
            }
            letraText.clear(); // Limpiar el campo de texto
        }

    }

    @FXML
    void onLetraAction(ActionEvent event) {

    }

    @FXML
    void onNewGameAction(ActionEvent event) {

    }

    @FXML
    void onSolveAction(ActionEvent event) {

    }

    public GridPane getRoot() {
        return root;
    }
}
