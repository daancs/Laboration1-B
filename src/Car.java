import java.awt.*;

/**
 * Abstract class to create a car.
 * The car can be specified by the number of doors, the amount of enginepower, the color of the car, and the model.
 * This class has methods that are general to all cars.
 *
 *
 * @author Hanna Adenholm
 * @author Dadi Andrason
 * @author Omar Sulaiman
 */
public class Car extends Vehicle implements Movable {

    public Car(int nrDoors, double enginePower, Color color, String modelName, Vehicle.Direction direction){
        super(nrDoors, enginePower, color, modelName, direction);
    }



}


