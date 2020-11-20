import java.awt.*;

/**
 * A car class to create a car.
 * This class extends the abstract class vehicle.
 * The car can be specified by the number of doors, the amount of enginepower, the color of the car, and the model.
 * This class has methods that are general to all cars and should be delegated by subclasses.
 *
 * @author Hanna Adenholm
 * @author Dadi Andrason
 * @author Omar Sulaiman
 */
public class Car extends Vehicle {


    /**
     * Constructor for creating a car of your choice.
     *
     * @param nrDoors is the number of doors for the vehicle.
     * @param enginePower the value of the cars enginePower.
     * @param color the color that is to be set.
     * @param modelName the model name of the vehicle.
     * @param direction sets the direction of the car
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, Vehicle.Direction direction){
        super(nrDoors, enginePower, color, modelName, direction);
    }

}


