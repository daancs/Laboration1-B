import java.awt.*;

/**
 * A truck class to create a truck.
 * This truck class extends the abstract class vehicle.
 * Is meant to be delegated by other more specified truck subclasses.
 *
 * @author Dadi Andrason
 * @author Omar Sulaiman
 * @author Hanna Adenholm
 */
public class Truck extends Vehicle {

    /**
     * Constructor for creating a truck of your choice.
     *
     * @param nrDoors     is the number of doors for the  vehicle.
     * @param enginePower the value of the cars enginePower.
     * @param color       the color that is to be set.
     * @param modelName   the model name of the  vehicle.
     * @param direction   is the direction that the truck is facing on creation.
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName, Direction direction) {
        super(nrDoors, enginePower, color, modelName, direction);
    }
}
