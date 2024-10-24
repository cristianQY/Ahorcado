package dad;

import dad.controllers.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AhorcadoApp extends Application {

    RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);

        primaryStage.setTitle("Ahorcado");
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();

    }
}
