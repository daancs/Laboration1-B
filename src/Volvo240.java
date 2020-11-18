import java.awt.*;

/**
 * A class that creates an object Volvo240, which extends the abstract class car.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Volvo240 implements Movable{


    //TODO documentation for class
    /**
     * Gives a value to trimFactor which is used to change the value of speedFactor
     */
    private final static double trimFactor = 1.25;
    private Car car;


    /**
     * Constructs a Volvo240 with 4 doors, engine power 100 and colour black
     * Stops the engine of the car.
     */
    public Volvo240() {
        car = new Car(4, 100, Color.black, "Volvo240", Vehicle.Direction.NORTH);
        car.stopEngine();
    }

    public Volvo240(Vehicle.Direction direction) {
        car = new Car(4, 100, Color.black, "Volvo240", direction);
        car.stopEngine();
    }

    public double getX() {
        return car.getX();
    }

    public double getY() {
        return car.getY();
    }

    public void position(double x, double y) {
        car.position(x, y);
    }

    public int getNrDoors() {
        return car.getNrDoors();
    }

    public double getEnginePower() {
        return car.getEnginePower();
    }

    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    public Color getColor() {
        return car.getColor();
    }

    public void setColor(Color clr) {
        car.setColor(clr);
    }

    public Vehicle.Direction getDirection() {
        return car.getDirection();
    }

    public void startEngine() {
        car.startEngine();
    }

    public void stopEngine() {
        car.stopEngine();
    }

    public void gas(double amount) {
        car.gas(amount, speedFactor());
    }

    /**
     * Takes a double between 1 and 0 and use it to control decrementSpeed
     * @param amount the amount that changes how much currentSpeed is going to decrease
     */
    public void brake(double amount) {
        car.brake(amount, speedFactor());
    }

    public double speedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void move() {
        car.move();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }
}