package sdu.seaoftrash.seaoftrash.domæne;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sdu.seaoftrash.seaoftrash.controller.InputController;
import sdu.seaoftrash.seaoftrash.domæne.map.Map;

import java.util.ArrayList;

public class Initialize {
    // Stage attributes:
    private Stage mainStage;
    private Scene mainScene;
    private Sprite background;
    private Sprite spaceShip;
    private GraphicsContext graphicsContext;
    private double canvasWidth, canvasHeight;
    InputController inputController = new InputController();
    Map map = new Map();

    public Initialize (Stage stage) {
        this.mainStage = stage;
        this.canvasWidth = 800;
        this.canvasHeight = 800;
    }

    public Map getMap() {
        return map;
    }

    public void initializeAll() {
        // Initialize presentation layer.
        initializeStage(this.mainStage);
        this.inputController.initializeInputController(this.mainScene);

        // Initialize

        this.map.generateMap();

    }

    private void initializeStage (Stage stage) {
        stage.setTitle("Sea of Trash");

        // Create the BorderPane (layout manager) as the root of the main Scene, and then attach the Main Scene to the Main Stage.
        BorderPane root = new BorderPane();
        this.mainScene = new Scene(root);
        this.mainStage.setScene(mainScene);

        // Create a Canvas to display the graphics on, by drawing them with a GraphicsContext object, and finally add the canvas to the root.
        Canvas canvas = new Canvas(this.canvasWidth, this.canvasHeight);
        this.graphicsContext = canvas.getGraphicsContext2D(); // Context object comes from the canvas.
        root.setCenter(canvas); // Sets the canvas to the center child of the BorderPane.

       /* this.background = new Sprite("file:src/main/java/images/Space800x800-WithStars.png");
        this.background.getPosition().setXAndY(this.canvasHeight / 2, this.canvasHeight / 2);

        this.spaceShip = new Sprite("file:src/main/java/images/SpaceShip-ButSmoll.png");
        this.spaceShip.getPosition().setXAndY(100, this.canvasHeight / 2);
        this.spaceShip.getVelocity().setXAndY(50, 0); */

        this.mainStage.show();
    }

    public double getCanvasHeight() {
        return canvasHeight;
    }

    public double getCanvasWidth() {
        return canvasWidth;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public Sprite getSpaceShip() {
        return spaceShip;
    }

    public Sprite getBackground() {
        return background;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}
