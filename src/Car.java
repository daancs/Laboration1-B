import java.awt.*;

/**
 * Abstract class to create a car.
 * The car can be specified by the number of doors, the amount of enginepower, the color of the car, and the model.
 * This class has methods that are general to all cars.
 * Both classes (Volvo240 and Saab95) inherit this class.
 *
 * @author Hanna Adenholm
 * @author Dadi Andrason
 * @author Omar Sulaiman
 */
public abstract class Car implements Movable {


    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private double X;   // The x-position of the car
    private double Y;   // The y-position of the car
    private Direction direction;
    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    /**
     * Constructor for creating a car of your choice.
     *
     * @param nrDoors is the number of doors for the car.
     * @param enginePower the value of the cars enginePower.
     * @param color the color that is to be set.
     * @param modelName the model name of the car.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, Direction direction) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
    }

    /**
     * Returns the x-position of the car.
     *
     * @return a double of the x-position of the car.
     */
    public double getX() {
        return X;
    }

    /**
     * Sets the x-position of the car to supplied value.
     *
     * @param x is the new value of X.
     */
    private void setX(double x) {
        X = x;
    }

    /**
     * Returns the y-position of the car.
     *
     * @return a double of the y-position of the car.
     */
    public double getY() {
        return Y;
    }

    /**
     * Sets the y-position of the car to supplied value.
     *
     * @param y is the new value of Y.
     */
    private void setY(double y) {
        Y = y;
    }

    /**
     * Positions the car depending on the coordinates provided
     *
     * @param x is the new value of x
     * @param y is the new value of x
     */
    public void position(double x, double y){
        setX(x);
        setY(y);
    }

    /**
     * Makes the car move in the direction
     */
    public void move() {
        switch (direction) {
            case NORTH -> setY(getY() - getCurrentSpeed());
            case EAST -> setX(getX() + getCurrentSpeed());
            case SOUTH -> setY(getY() + getCurrentSpeed());
            case WEST -> setX(getX() - getCurrentSpeed());
        }
    }

    /**
     * Makes the car turn to the left by changing it's direction.
     */
    public void turnLeft(){
        switch(direction){
            case NORTH -> direction = Direction.WEST;
            case EAST -> direction = Direction.NORTH;
            case WEST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
        }
    }

    /**
     * Makes the car turn right by changing it's direction.
     */
    public void turnRight() {
        switch (direction) {
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
        }

    }


    /**
     * Returns the variable nrDoors on the car.
     *
     * @return the number of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }


    /**
     * Returns current enginePower
     *
     * @return the engine power of the car.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed of the car.
     *
     * @return the current speed of the car.
     */

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the current color of the car
     * @return The color of the car
     */
    public Color getColor(){
        return color;
    }


    /**
     *Changes the current color to the parameter clr
     * @param clr is the color the car should become
     */
    public void setColor(Color clr){
        color = clr;
    }


    /**
     * Returns current direction.
     * @return the direction of the car.
     */
    public Direction getDirection(){
        return direction;
    }

    /**
     * Starts the engine by setting current speed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Makes currentSpeed zero
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Abstract method to be implemented by subclasses.
     * The speedfactor is to be determined by the enginePower * 0.01 * turbo/trimfactor (if the car has turbo or trimfactor).
     * The turbo/trimfactor can be changed to something else entirely if the car you're creating has something else.
     * @return the speed factor.
     */
    public abstract double speedFactor();

    /**
     * Increments the currentSpeed of the car by the supplied amount times the speedFactor.
     * If the speed surpasses the enginePower currentSpeed is set to the value of enginePower instead.
     *
     * @param amount the amount with which the speed is to be incremented
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    /**
     * Decreases the currentSpeed of the car if currentSpeed is larger than 0
     * @param amount the amount with which the speed is to be decremented.
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Accelerates the car the method is called on.
     * @param amount is the amount of how much currentSpeed should increase.
     */
    public void gas(double amount){
        if (amount > 0 && amount <= 1) incrementSpeed(amount);
    }

    /**
     * Takes a double between 1 and 0 and use it to control decrementSpeed
     * @param amount the amount that changes how much currentSpeed is going to decrease
     */
    public void brake(double amount){
        if (amount > 0 && amount <= 1) decrementSpeed(amount);
    }
}


