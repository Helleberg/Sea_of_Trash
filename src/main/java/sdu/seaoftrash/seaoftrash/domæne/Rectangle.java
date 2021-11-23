package sdu.seaoftrash.seaoftrash.domæne;

public class Rectangle {
    // x and y are points, representing the top left corner of the rectangle.
    double x, y, width, height;

    public Rectangle() {
        this.setPosition(0, 0);
        this.setSize(1, 1);
    }

    public Rectangle(double x, double y, double width, double height) {
        this.setPosition(x, y);
        this.setSize(width, height);
    }

    // General Purpose Methods (START)
    // 3D space comparison methods (STARTS)
    public boolean overlaps (Rectangle foreignRectangle) {
        // Search: "Separating Axis Theorem (SAT)", for further explanation.
        // (This only works on convex shapes).
        // Case 1/4 - is upper right (this rectangle) corner left of upper left corner (foreign rectangle)?
        // Case 2/4 - is upper right (foreign rectangle) corner left of upper left corner (this rectangle)?
        // Case 3/4 - is lower left (this rectangle) corner below upper left corner (foreign rectangle)?
        // Case 4/4 - is lower left (this rectangle) corner below upper left corner (foreign rectangle)?
        boolean noOverlap =
                this.x + this.width < foreignRectangle.x ||
                        foreignRectangle.x + foreignRectangle.width < this.x ||
                        this.y + this. height < foreignRectangle.y ||
                        foreignRectangle.y + foreignRectangle.height < this.y;

        return !noOverlap;
    }
    // 3D space comparison methods (END)
// General Purpose Methods (END)

    // Getters and Setters (START)
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    // Getters and Setters (END)
}
