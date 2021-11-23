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

                initialize.getSpaceShip().update(1.0/60.0);
                initialize.getBackground().render(initialize.getGraphicsContext());
                initialize.getSpaceShip().render(initialize.getGraphicsContext());
                //map.drawGradiant(spaceShip.getPosition().getX(), spaceShip.getPosition().getY(), 800, 800, shadowGraphicsContext);

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