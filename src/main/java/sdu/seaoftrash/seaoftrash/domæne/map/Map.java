package sdu.seaoftrash.seaoftrash.domæne.map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Map {
    Image pixelMap;
    Color black, white, grey;
    ImageView imageView;
    Tile[][] tiles;

    public Map() {
        this.pixelMap = new Image("file:sdu/seaoftrash/seaoftrash/MapImages/Map100x100.png"); // TODO: Reference image.
        this.black = Color.rgb(0, 0, 0, 1.0);
        this.grey = Color.rgb(128, 128, 128, 1.0);
        this.white = Color.rgb(255, 255, 255, 1.0);
        this.imageView = new ImageView();
        this.tiles = new Tile[(int)this.pixelMap.getWidth()][(int)this.pixelMap.getHeight()];
    }

    public void generateMap() {
        PixelReader pixelReader = this.pixelMap.getPixelReader();

        // TODO: this is f'ed.
        for (int x = 0; x < this.pixelMap.getWidth(); x++) {
            for (int y = 0; y < this.pixelMap.getHeight(); y++) {
                if (pixelReader.getColor(x,y).equals(this.black)) {
                    this.tiles[x][y] = new Dirt(x * 32, y * 32);
                } else if (pixelReader.getColor(x, y).equals(this.white)) {
                    this.tiles[x][y] = new Water(x * 32, y * 32);
                } else {
                    this.tiles[x][y] = new Air(x * 32, y * 32);
                }
            }
        }
    }

    public void renderMap (GraphicsContext graphicsContext) {
        for (int x = 0; x < this.pixelMap.getWidth(); x++) {
            for (int y = 0; y < this.pixelMap.getHeight(); y++) {
                this.tiles[x][y].tileBody.render(graphicsContext);
            }
        }
    }
}
