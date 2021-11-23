package sdu.seaoftrash.seaoftrash.domæne.map;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sdu.seaoftrash.seaoftrash.domæne.Sprite;

public class Dirt extends Tile {

    Dirt(double positionX, double positionY) {
        this.colorID = Color.rgb(0, 0, 0, 1.0);
        this.imageFileName = "file:sdu/seaoftrash/seaoftrash/MapImages/Dirt32.png"; // TODO: Add filepath.
        this.tileBody = new Sprite(this.imageFileName, positionX, positionY);
    }
}
