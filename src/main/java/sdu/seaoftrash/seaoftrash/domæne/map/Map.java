package sdu.seaoftrash.seaoftrash.domæne.map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

public class Map {
    Image pixelMap;
    Color black, white, grey;
    ImageView imageView;

    Map() {
        this.pixelMap = new Image(""); // TODO: Reference image.
        this.black = Color.color(0, 0, 0, 1.0);
        this.grey = Color.color(128, 128, 128, 1.0);
        this.white = Color.color(255, 255, 255, 1.0);
        this.imageView = new ImageView();
    }

    private void generateMap() {
        PixelReader pixelReader = this.pixelMap.getPixelReader();
        for (int x = 0; x < this.pixelMap.getWidth(); x++) {
            for (int y = 0; y < this.pixelMap.getHeight(); y++) {
                if (pixelReader.getColor(x,y).equals(this.black)) {

                } else if (pixelReader.getColor(x, y).equals(this.white)) {

                } else {

                }
            }
        }

    }


}
