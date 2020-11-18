import java.awt.*;

/**
 * A class that creates an object Volvo240, which delegates the class Car.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Volvo240 implements IVehicle {


    /**
     * Gives a value to trimFactor which is used to change the value of speedFactor
     */
    private final static double trimFactor = 1.25;

    /**
     * Creates a car object in which we can use delegation
     */
    private Car car;


    /**
     * Constructs a Volvo240 with 4 doors, engine power 100 and colour black in the direction north
     * Stops the engine of the car.
     */
    public Volvo240() {
        car = new Car(4, 100, Color.black, "Volvo240", Vehicle.Direction.NORTH);
        car.stopEngine();
    }

    /**
     * Constructs a Volvo240 with 4 doors, engine power 100 and colour black int the direction north
     * stops the engine of the car
     * @param direction gives the volvo240 object a  direction
     */
    public Volvo240(Vehicle.Direction direction) {
        car = new Car(4, 100, Color.black, "Volvo240", direction);
        car.stopEngine();
    }

    /**
     * shows the position of the car in the xy diagram.
     * @return returns the x value in the xy diagram
     */
    @Override
    public double getX() {
        return car.getX();
    }

    /**
     * shows the posin f the car in the xy diagram
     * @return returns the y value in the xy diagram
     */
    @Override
    public double getY() {
        return car.getY();
    }

    /**
     * gives the exact position of the car in the xy diagram
     * @param x the x position of the car
     * @param y the y position of the car
     */
    @Override
    public void position(double x, double y) {
        car.position(x, y);
    }

    /**
     * Returns the variable nrDoors on the car.
     * @return the number of doors on the car.
     */
    public int getNrDoors() {
        return car.getNrDoors();
    }

    /**
     * Returns current enginePower
     * @return the engine power of the car.
     */
    public double getEnginePower() {
        return car.getEnginePower();
    }

    /**
     * Returns current speed of the car.
     * @return the current speed of the car
     */
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    /**
     * Returns the color of the car
     * @return the color of the car
     */
    public Color getColor() {
        return car.getColor();
    }

    /**
     * Sets the color of the vehicle to the specified parameter.
     * @param clr is the color the car is to be changed to.
     */
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    /**
     * Returns the current direction the car is facing.
     * @return the current direction of the car
     */
    public Vehicle.Direction getDirection() {
        return car.getDirection();
    }

    /**
     * Starts the engine of the car by putting current speed to 0.1
     */
    public void startEngine() {
        car.startEngine();
    }

    /**
     * Stops the engine of the car by putting current speed to 0.
     */
    public void stopEngine() {
        car.stopEngine();
    }

    /**
     * Accelerates the car the method is called on.
     * @param amount is the amount of how much currentSpeed should increase.
     */
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

    /**
     * Multiplies the cars enginePower with 0.01 and the trimfactor to get the cars SpeedFactor.
     * @return the cars speedFactor
     */
    public double speedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Calls the move-method on the car object
     */
    @Override
    public void move() {
        car.move();
    }

    /**
     * Calls the turnLeft-method on the car object
     */
    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    /**
     * Calls the turnRight-method on the car object
     */
    @Override
    public void turnRight() {
        car.turnRight();
    }
}