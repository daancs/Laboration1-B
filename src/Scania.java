import java.awt.*;

/**
 * A class that creates an object Scania, which extends the abstract class car.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Scania implements Movable{

    private int platformAngle;
    private Truck truck;

    /**
     * Constructs a Scania99 with 2 doors, engine power 570 and colour blue
     */
    public Scania() {
        truck = new Truck(2, 570, Color.BLUE, "Scania99", Vehicle.Direction.NORTH);
        truck.stopEngine();
    }


    public void move() {
        if(platformAngle == 0) {
            truck.move();
        }
    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void position(double x, double y) {

    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    public double speedFactor() {
        return 1;
    }

    /**
     * Gets the current angle of the platform on the truck.
     * @return the angle of the truck platform.
     */
    public int getPlatformAngle() {
        return platformAngle;
    }

    /**
     * Raises the angle of the platform to the value provided
     * The method only raises the angle if the angle is smaller than the value provided
     * and if the truck is stationary
     * @param angle is the angle that the platform is to be raised to
     */
    public void raisePlatform(int angle){
        if (platformAngle < angle && truck.getCurrentSpeed() < 0.001){
            platformAngle = Math.min(angle,70);
        }
    }

    /**
     * Lowers the angle of the platform on the truck to the value of the parameter angle.
     * If the angle is higher than the platform's current angle, nothing happens.
     * If the angle is lower than 0, the platform's new angle is to be set to 0.
     * @param angle is the angle that the platform is to be lowered to.
     */
    public void lowerPlatform(int angle){
        if (platformAngle > angle) {
            platformAngle = Math.max(angle, 0);
        }
    }


}
