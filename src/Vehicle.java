import java.awt.*;

/**
 * An abstract class which is extended by other subclasses of vehicle.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public abstract class Vehicle implements Movable {
    private final int nrDoors; // Number of doors on the vehicle
    private final double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private final String modelName; // The vehicle model name
    private double X;   // The x-position of the vehicle
    private double Y;   // The y-position of the vehicle
    private Direction direction;
    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    /**
     * Constructor for creating a vehicle of your choice.
     *
     * @param nrDoors is the number of doors for the vehicle.
     * @param enginePower the value of the vehicles enginePower.
     * @param color the color that is to be set.
     * @param modelName the model name of the vehicle.
     * @param direction sets the direction of the vehicle
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, Direction direction) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
    }

    /**
     * Returns the x-position of the vehicle.
     *
     * @return a double of the x-position of the vehicle.
     */
    public double getX() {
        return X;
    }

    /**
     * Sets the x-position of the vehicle to supplied value.
     *
     * @param x is the new value of X.
     */
    private void setX(double x) {
        X = x;
    }

    /**
     * Returns the y-position of the vehicle.
     *
     * @return a double of the y-position of the vehicle.
     */
    public double getY() {
        return Y;
    }

    /**
     * Sets the y-position of the vehicle to supplied value.
     *
     * @param y is the new value of Y.
     */
    private void setY(double y) {
        Y = y;
    }

    /**
     * Positions the vehicle depending on the coordinates provided
     *
     * @param x is the new value of x
     * @param y is the new value of x
     */
    public void position(double x, double y){
        setX(x);
        setY(y);
    }

    /**
     * Makes the vehicle move in the direction
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
     * Makes the vehicle turn to the left by changing it's direction.
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
     * Makes the vehicle turn right by changing it's direction.
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
     * Returns the variable nrDoors on the vehicle.
     *
     * @return the number of doors on the vehicle.
     */
    public int getNrDoors(){
        return nrDoors;
    }


    /**
     * Returns current enginePower
     *
     * @return the engine power of the vehicle.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Returns the current speed of the vehicle.
     *
     * @return the current speed of the vehicle.
     */

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the current color of the vehicle
     * @return The color of the vehicle
     */
    public Color getColor(){
        return color;
    }


    /**
     *Changes the current color to the supplied clr
     * @param clr is the color the vehicle should become
     */
    public void setColor(Color clr){
        color = clr;
    }


    /**
     * Returns current direction.
     * @return the direction of the vehicle.
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
     * Increments the currentSpeed of the vehicle by the supplied amount.
     * If the speed surpasses the enginePower currentSpeed is set to the value of enginePower instead.
     *
     * @param amount the amount with which the speed is to be incremented
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + amount, getEnginePower());
    }

    /**
     * Decreases the currentSpeed of the vehicle if currentSpeed is larger than 0
     * @param amount the amount with which the speed is to be decremented.
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - amount, 0);
    }

    /**
     * Accelerates the vehicle the method is called on.
     * @param amount is the amount of how much currentSpeed should increase.
     * @param speedFactor is the speedFactor a vehicle has.
     */
    public void gas(double amount, double speedFactor){
        if (amount > 0 && amount <= 1) incrementSpeed(amount * speedFactor);
    }

    /**
     * Decelerates the vehicle the method is called on.
     * @param amount the amount that changes how much currentSpeed is going to decrease
     * @param speedFactor is the speedFactor a vehicle has.
     */
    public void brake(double amount, double speedFactor){
        if (amount > 0 && amount <= 1) decrementSpeed(amount * speedFactor);
    }
}
