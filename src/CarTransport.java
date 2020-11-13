import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A class that creates an object Car transport, which extends the abstract class car.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class CarTransport extends Car {

    private boolean rampIsUp;
    private final Deque<Car> loadedCars;
    private final int maxLoadedCars;


    /**
     *Constructs a Car transport with 2 doors, engine power 700 and colour Cyan.
     * It creates a stack to load the cars in to and sets the value of maximum loaded cars into the ramp
     */
    public CarTransport() {
        super(2, 700, Color.CYAN, "Car transport", Direction.NORTH);
        loadedCars = new ArrayDeque<>();
        maxLoadedCars = 5;
    }

    /**
     * Returns the speedFactor 1
     * @return the speedFactor 1
     */
    @Override
    public double speedFactor() {
        return 1;
    }

    /**
     * Makes the truck move.
     * The cars that are loaded onto the flatbed get moved with the truck.
     */
    @Override
    public void move(){
        if(rampIsUp){
            super.move();
            for (Car car: loadedCars){
                car.position(this.getX(), this.getY());
            }
        }
    }

    /**
     * Switches the current position of the ramp to the the only other available position and contrariwise
     * works  only if the car transport is stationary
     */
    public void changeRamp() {
        if(getCurrentSpeed() < 0.0001){
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
    private boolean validateLoadCircumstances(Car car) {
        return !rampIsUp &&
                Math.abs(car.getX() - this.getX()) < 10 &&
                Math.abs(car.getY() - this.getY()) < 10 &&
                !(car instanceof CarTransport) &&
                loadedCars.size() < maxLoadedCars;
    }

    /**
     * Loads the provided car unto the truck if all the conditions in validateLoadCircumstanses are met.
     * @param car the car that is to be loaded unto the truck.
     */
    private void loadCar(Car car) {
        if(validateLoadCircumstances(car)) {
            car.position(this.getX(), this.getY());
            loadedCars.push(car);
        }
    }

    /**
     * Unloads the last car to be loaded and places it nearby the truck if the ramp is down.
     * if the truck is empty no unloading is done.
     */
    private void unloadCar() {
        if (!rampIsUp && !loadedCars.isEmpty()) {
            Car car = loadedCars.pop();
            car.position(this.getX() + 10, this.getY() - 10);
        }
    }
}
