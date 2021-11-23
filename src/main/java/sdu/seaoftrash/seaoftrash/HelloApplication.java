package sdu.seaoftrash.seaoftrash;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sdu.seaoftrash.seaoftrash.domæne.Initialize;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        // Initialize game assets and UI.
        Initialize initialize = new Initialize(mainStage);
        initialize.setStage(mainStage);

        // Player UI inputs move to controller
        ArrayList<String> keyPressedList = new ArrayList<String>();

        // The following code stores a key event in an ArrayList and awaits for the key-input to be used before then removing it.
        initialize.getMainScene().setOnKeyPressed(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();

                    // To avoid duplicate keys in the ArrayList.
                    if (!keyPressedList.contains(keyName)) {
                        keyPressedList.add(keyName);
                    }
                }
        );

        initialize.getMainScene().setOnKeyReleased(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    if (keyPressedList.contains(keyName)) {
                        keyPressedList.remove(keyName);
                    }
                }
        );

        AnimationTimer gameloop = new AnimationTimer() {
            @Override
            public void handle(long nanoTime) {

                if (keyPressedList.contains("LEFT")) {
                    initialize.getSpaceShip().setRotation(initialize.getSpaceShip().getRotation() - 3);
                }
                if (keyPressedList.contains("RIGHT")) {
                    initialize.getSpaceShip().setRotation(initialize.getSpaceShip().getRotation() + 3);
                }

                initialize.getSpaceShip().update(1.0/60.0);
                initialize.getBackground().render(initialize.getGraphicsContext());
                initialize.getSpaceShip().render(initialize.getGraphicsContext());
                //map.drawGradiant(spaceShip.getPosition().getX(), spaceShip.getPosition().getY(), 800, 800, shadowGraphicsContext);

            }
        };

        gameloop.start();

        mainStage.show();
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