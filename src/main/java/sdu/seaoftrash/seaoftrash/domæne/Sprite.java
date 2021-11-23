package sdu.seaoftrash.seaoftrash.domæne;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private Vector position, velocity;
    private double rotation;
    private Rectangle boundary;
    private Image spriteImage;

    public Sprite(double positionX, double positionY) {
        this.position = new Vector(positionX, positionY);
        this.velocity = new Vector();
        this.boundary = new Rectangle();
        this.rotation = 0;
    }

    public Sprite(String filename, double positionX, double positionY) {
        this(positionX, positionY);
        this.setSpriteImageWithBoundary(filename);
    }

    // General Purpose Methods (START)
    // 3D space comparison methods (STARTS)
    public boolean overlaps(Sprite foreignSprite) {
        return this.getBoundaryWithUpdatedPosition().overlaps(foreignSprite.getBoundaryWithUpdatedPosition());
    }
    // 3D space comparison methods (END)

    // Real time 3D updates (START)
    public void update(double deltaTime) {
        // Updates position according to the current velocity.
        this.position.addVector((this.velocity.getX() * deltaTime), (this.velocity.getY() * deltaTime));
    }

    public void render(GraphicsContext graphicsContext) {
        graphicsContext.save();

        graphicsContext.translate(this.position.getX(), this.position.getY());
        graphicsContext.rotate(this.rotation);
        // Finds center of sprite image (top left corner by default), will be sued for rotation of sprite.
        graphicsContext.translate((-this.spriteImage.getWidth()) / 2, (-this.spriteImage.getHeight()) / 2);
        graphicsContext.drawImage(this.spriteImage, 0, 0);

        graphicsContext.restore();
    }


    // Real time 3D updates (END)
    // General Purpose Methods (END)

    // Getters and Setters (START)
    public Rectangle getBoundaryWithUpdatedPosition() {
        this.boundary.setPosition(this.position.getX(), this.position.getY());
        return this.boundary;
    }

    public void setSpriteImageWithBoundary(String fileName) {
        this.spriteImage = new Image(fileName);

        // Transforms object boundary to image size.
        this.boundary.setSize(this.spriteImage.getWidth(), this.spriteImage.getHeight());
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }

    public Image getSpriteImage() {
        return spriteImage;
    }

    public void setSpriteImage(Image spriteImage) {
        this.spriteImage = spriteImage;
    }
    // Getters and Setters (END)
}
