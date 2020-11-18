import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A class that creates an object Car transport, which extends the abstract class car.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class CarTransport implements IVehicle {


    private boolean rampIsUp;
    private final Deque<IVehicle> loadedCars;
    private final int maxLoadedCars;
    private final Truck truck;



    /**
     *Constructs a Car transport with 2 doors, engine power 700 and colour Cyan.
     * It creates a stack to load the cars in to and sets the value of maximum loaded cars into the ramp
     */
    public CarTransport() {
        truck = new Truck(2, 700, Color.CYAN, "Car transport", Vehicle.Direction.NORTH);
        loadedCars = new ArrayDeque<>();
        maxLoadedCars = 5;
    }

    /**
     * Returns the speedFactor 1
     * @return the speedFactor 1
     */
    public double speedFactor() {return 1;}


    public Deque<IVehicle> getLoadedCars() {
        return loadedCars;
    }

    /**
     * Makes the truck move.
     * The cars that are loaded onto the flatbed get moved with the truck.
     */
    @Override
    public void move(){
        if(rampIsUp){
            truck.move();
            for (IVehicle car: loadedCars){
                car.position(this.getX(), this.getY());
            }
        }
    }

    /**
     * Getter for ramp position.
     * @return true if ramp is up, otherwise false.
     */
    public boolean isRampIsUp() {
        return rampIsUp;
    }

    /**
     * Makes the truck turn left.
     */
    @Override
    public void turnLeft() {
        truck.turnLeft();
    }

    /**
     * Makes the truck turn right.
     */
    @Override
    public void turnRight() {
        truck.turnRight();
    }

    /**
     * Switches the current position of the ramp to the the only other available position and contrariwise
     * works  only if the car transport is stationary
     */
    public void changeRamp() {
        if(truck.getCurrentSpeed() < 0.0001){
            rampIsUp = !rampIsUp;
        }
    }

    /**
     * Validation for loading a car.
     * The validation includes:
     * Checking whether the ramp is up or not,
     * Checking the position of the car relative to the car transport,
     * Checking if the car is not a car transport and,
     * Checking if there is available space on the car transport.
     * @param car is the car that might get loaded onto the car transport.
     * @return a boolean based on all circumstances.
     */
    private boolean validateLoadCircumstances(IVehicle car) {
        return !rampIsUp &&
                Math.abs(car.getX() - truck.getX()) < 10 &&
                Math.abs(car.getY() - truck.getY()) < 10 &&
                !(car.equals(this)) &&
                loadedCars.size() < maxLoadedCars;
    }

    /**
     * Loads the provided car unto the truck if all the conditions in validateLoadCircumstances are met.
     * @param car the car that is to be loaded unto the truck.
     */
    public void loadCar(IVehicle car) {
        if(validateLoadCircumstances(car)) {
            car.position(truck.getX(), truck.getY());
            loadedCars.push(car);
        }
    }

    /**
     * Unloads the last car to be loaded and places it nearby the truck if the ramp is down.
     * if the truck is empty no unloading is done.
     */
    public void unloadCar() {
        if (!rampIsUp && !loadedCars.isEmpty()) {
            IVehicle car = loadedCars.pop();
            car.position(truck.getX() + 10, truck.getY() - 10);
        }
    }

    /**
     * Returns the x-position of the vehicle.
     *
     * @return a double of the x-position of the vehicle.
     */
    public double getX() {
        return truck.getX();
    }

    /**
     * Returns the y-position of the vehicle.
     *
     * @return a double of the y-position of the vehicle.
     */
    public double getY() {
        return truck.getY();
    }

    /**
     * Positions the truck depending on the coordinates provided
     *  @param x is the new value of x
     * @param y is the new value of x
     */
    public void position(double x, double y) {
        truck.position(x, y);
    }

    /**
     * Returns the variable nrDoors on the vehicle.
     *
     * @return the number of doors on the vehicle.
     */
    public int getNrDoors() {
        return truck.getNrDoors();
    }

    /**
     * Returns current enginePower
     *
     * @return the engine power of the vehicle.
     */
    public double getEnginePower() {
        return truck.getEnginePower();
    }

    /**
     * Returns the current speed of the vehicle.
     *
     * @return the current speed of the vehicle.
     */
    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    /**
     * Returns the current color of the car
     * @return The color of the car
     */
    public Color getColor() {
        return truck.getColor();
    }

    /**
     *Changes the current color to the parameter clr
     * @param clr is the color the car should become
     */
    public void setColor(Color clr) {
        truck.setColor(clr);
    }

    /**
     * Returns current direction.
     * @return the direction of the vehicle.
     */
    public Vehicle.Direction getDirection() {
        return truck.getDirection();
    }

    /**
     * Starts the engine by setting current speed to 0.1
     */
    public void startEngine() {
        truck.startEngine();
    }

    /**
     * Makes currentSpeed zero
     */
    public void stopEngine() {
        truck.stopEngine();
    }

    /**
     * Accelerates the car the method is called on.
     * @param amount is the amount of how much currentSpeed should increase.
     */
    public void gas(double amount) {
        truck.gas(amount, speedFactor());
    }

    /**
     * Takes a double between 1 and 0 and use it to control decrementSpeed
     * @param amount the amount that changes how much currentSpeed is going to decrease
     */
    public void brake(double amount) {
        truck.brake(amount, speedFactor());
    }
}
