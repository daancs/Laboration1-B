import java.awt.*;

/**
 * A class that describes an object and control it`s movements
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Saab95 implements IVehicle {



    private boolean turboOn;

    /**
     * Creates a car object in which we can use delegation
     */
    private Car car;

    /**
     * Constructs a Saab95 with 2 doors, engine power 125 and colour red.
     * Sets the variable turboOn to false and stops the engine.
     * @param direction sets the direction of the car
     */
    public Saab95(Vehicle.Direction direction){
        car = new Car(2, 125, Color.red, "Saab95", direction);
	    turboOn = false;
        car.stopEngine();
    }

    /**
     * Constructs a Saab95 with 2 doors, engine power 125 and color red.
     * Sets the variable turboOn to false and stops the engine
     */
    public Saab95() {
        car = new Car(2, 125, Color.red, "Saab95", Vehicle.Direction.NORTH);
        turboOn = false;
        car.stopEngine();
    }


    /**
     * Checks if turbo is on
     * @return true if turbo is on, otherwise false.
     */
    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Sets turboOn to true.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Makes turboOn False
     */
    public void setTurboOff(){
	    turboOn = false;
    }


    /**
     * Multiplies the cars engine power with 0.01 and turbo.
     * If turbo is on, the enginepower is to be multiplied with 1.3, otherwise, 1.0
     * @return the speedfactor of the car
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return car.getEnginePower() * 0.01 * turbo;
    }

    /**
     * Moves the car in the direction it is facing
     */
    @Override
    public void move(){
        car.move();
    }

    /**
     * Returns the x-position of the vehicle.
     *
     * @return a double of the x-position of the vehicle.
     */
    @Override
    public double getX() {
        return car.getX();
    }

    /**
     * Returns the y-position of the vehicle.
     *
     * @return a double of the y-position of the vehicle.
     */
    @Override
    public double getY() {
        return car.getY();
    }


    /**
     * Makes the car turn to the left by changing it's direction.
     */
    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    /**
     * Makes the car turn right by changing it's direction.
     */
    @Override
    public void turnRight() {
        car.turnRight();
    }

    /**
     * Returns the variable nrDoors on the car.
     * @return the number of doors on the car.
     */
    public int getNrDoors() {
        return car.getNrDoors();
    }

    /**
     * Returns current enginePower.
     * @return the engine power of the car.
     */
    public double getEnginePower() {
        return car.getEnginePower();
    }

    /**
     * Returns the current speed of the car.
     * @return the current speed of the car
     */
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    /**
     * Returns the color of the car.
     * @return the color of the car.
     */
    public Color getColor() {
        return car.getColor();
    }

    /**
     * Sets the color of the car.
     * @param clr the new colour.
     */
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    /**
     * Returns the direction of the car.
     * @return the direction the car i facing.
     */
    public Vehicle.Direction getDirection() {
        return car.getDirection();
    }

    /**
     * Starts the cars engine.
     */
    public void startEngine() {
        car.startEngine();
    }

    /**
     * Stops the cars engine.
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
     * Positions the car depending on the coordinates provided
     *
     * @param x is the new value of x
     * @param y is the new value of x
     */
    @Override
    public void position(double x, double y){
       car.position(x,y);
    }
}
