import java.awt.*;

public class Truck extends Vehicle {

    /**
     * Constructor for creating a car of your choice.
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
