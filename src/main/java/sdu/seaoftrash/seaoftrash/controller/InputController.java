package sdu.seaoftrash.seaoftrash.controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import sdu.seaoftrash.seaoftrash.domæne.Initialize;

import java.util.ArrayList;

public class InputController {
    ArrayList<String> keyPressedList = new ArrayList<String>();

    public void checkPlayerInput() {

        if (keyPressedList.contains("LEFT")) {
            //Player.getSpaceShip().setRotation(initialize.getSpaceShip().getRotation() - 3);
        }
        if (keyPressedList.contains("RIGHT")) {
            //Player.getSpaceShip().setRotation(initialize.getSpaceShip().getRotation() + 3);
        }
    }

    public void initializeInputController(Scene mainScene) {
        // The following code stores a key-event in an ArrayList and awaits for the key-input to be used before then removing it.
        ArrayList<String> keyPressedList = new ArrayList<String>();

        mainScene.setOnKeyPressed(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();

                    // To avoid duplicate keys in the ArrayList.
                    if (!keyPressedList.contains(keyName)) {
                        keyPressedList.add(keyName);
                    }
                }
        );

        mainScene.setOnKeyReleased(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    if (keyPressedList.contains(keyName)) {
                        keyPressedList.remove(keyName);
                    }
                }
        );
    }
}
