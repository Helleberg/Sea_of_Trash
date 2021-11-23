package sdu.seaoftrash.seaoftrash.domæne;

public class Vector {
    private double x, y;

    Vector() {
        this.setXAndY(0, 0);
    }

    Vector(double x, double y) {
        this.setXAndY(x, y);
    }

    // General Purpose Methods (START)
    // Vector Arithmetics (START)
    public void addVector(double addX, double addY) {
        this.x += addX;
        this.y += addY;
    }


    public void multiplyVector(double vectorMultiply) {
        this.x *= vectorMultiply;
        this.y *= vectorMultiply;
    }
    // Vector Arithmetics (END)
    // General Purpose Methods (END)

    // Getters and Setters (START)
    public double getVectorAngle() {
        return Math.toDegrees(Math.atan2(this.y, this.x));
    }

    public void setVectorAngle(double vectorAngle) {
        double currentVectorLength = getVectorLength();
        double vectorAngleInRadians = Math.toRadians(vectorAngle);

        this.x = currentVectorLength * Math.cos(vectorAngleInRadians);
        this.y = currentVectorLength * Math.sin(vectorAngleInRadians);
    }

    public double getVectorLength() {
        return  Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public void setVectorLength(double vectorLength) {
        double currentVectorLength = this.getVectorLength();

        // Prevents division by zero.
        if (currentVectorLength == 0) {
            return;
        }

        // Scale vector to have a length of 1.
        this.multiplyVector(1 / vectorLength);

        // Scale vector to have the length of the method input.
        this.multiplyVector(vectorLength);
    }

    public void setXAndY(double x, double y) {
        this.x = x;
        this.y = y;
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
    // Getters and Setters (END)

}