import java.awt.*;

/**
 * A class that describes an object and control it`s movements
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Constructs a Saab95 with 2 doors, engine power 125 and colour red.
     * Sets the variable turboOn to false and stops the engine.
     */
    public Saab95(Direction direction){
        super(2, 125, Color.red, "Saab95", direction);
	    turboOn = false;
        stopEngine();
    }

    public Saab95() {
        super(2, 125, Color.red, "Saab95", Direction.NORTH);
        turboOn = false;
        stopEngine();
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


    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
