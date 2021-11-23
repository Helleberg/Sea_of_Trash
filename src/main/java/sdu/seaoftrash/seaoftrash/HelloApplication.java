package sdu.seaoftrash.seaoftrash;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import sdu.seaoftrash.seaoftrash.domæne.Initialize;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        // Initialize game assets and UI.
        Initialize initialize = new Initialize(mainStage);

        // Initializes everything.
        initialize.initializeAll();

        AnimationTimer gameloop = new AnimationTimer() {
            @Override
            public void handle(long nanoTime) {
                // TODO: find render
                initialize.getMap().renderMap(initialize.getGraphicsContext());
            }
        };
        gameloop.start();
    }

    public static void main(String[] args) {
        try {
            launch(args); // This calls the "start" method.
        } catch (Exception launchError) {
            launchError.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}