package dad.controllers;

import dad.tabs.AhorcadoTab;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private final ObjectProperty<Tab> selectedTab = new SimpleObjectProperty<>();

    @FXML
    private TabPane menuTabPane;

    @FXML
    private BorderPane root;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //eliminación de las pestañas iniciales
        menuTabPane.getTabs().clear();

        selectedTab.bind(menuTabPane.getSelectionModel().selectedItemProperty());

        AhorcadoTab partidaTab = new AhorcadoTab("Partida");
        menuTabPane.getTabs().add(partidaTab);  // Añadir la pestaña al TabPane



    }

    private PartidaController getSelectedEditor() {
        return ((AhorcadoTab) selectedTab.get()).getController();
    }


    public BorderPane getRoot() {
        return root;
    }
}
