package dad.tabs;

import dad.controllers.PartidaController;
import javafx.scene.control.Tab;

public class AhorcadoTab extends Tab {

    private final PartidaController controller;

    public AhorcadoTab(String Partida) {

        super(Partida);
        controller = new PartidaController();
        setContent(controller.getRoot());

    }

    public PartidaController getController() {
        return controller;
    }
}
