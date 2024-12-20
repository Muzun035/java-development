import java.awt.*;

public class Turtle implements IMovable {
    private String name;
    private int power;
    private Point currentLocation;
    public Turtle(String name) {
        this.name = name;
        this.currentLocation = new Point(25, 25);
        this.power = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Point move(int xUnits, int yUnits) {
// the turtle moves the number of units specified in
// the direction specified
        currentLocation.setX(currentLocation.getX() + xUnits);
        currentLocation.setY(currentLocation.getY() + yUnits);
        return currentLocation;
    }
    public void goHome() {
        this.currentLocation = new Point(25, 25);
    }
}