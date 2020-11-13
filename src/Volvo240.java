import java.awt.*;

/**
 * A class that creates an object Volvo240, which extends the abstract class car.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Volvo240 extends Car {

    /**
     * Gives a value to trimFactor which is used to change the value of speedFactor
     */
    private final static double trimFactor = 1.25;


    /**
     * Constructs a Volvo240 with 4 doors, engine power 100 and colour black
     * Stops the engine of the car.
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240", Direction.NORTH);
        stopEngine();
    }

    public Volvo240(Direction direction) {
        super(4, 100, Color.black, "Volvo240", direction);
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}