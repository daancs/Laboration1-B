import java.awt.*;

/**
 * A class that creates an object Scania, which delegates the class Truck.
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Scania implements IVehicle {

    private int platformAngle;
    private Truck truck;

    /**
     * Constructs a Scania99 with 2 doors, engine power 570 and colour blue with the north direction
     */
    public Scania() {
        truck = new Truck(2, 570, Color.BLUE, "Scania99", Vehicle.Direction.NORTH);
        truck.stopEngine();
    }

    /**
     * Moves the truck using delegation, only if the platformAngle is 0.
     */
    @Override
    public void move() {
        if(platformAngle == 0) {
            truck.move();
        }
    }

    /**
     * Makes the vehicle turn to the left by changing it's direction.
     */
    @Override
    public void turnLeft() {
        truck.turnLeft();
    }

    /**
     * Makes the vehicle turn right by changing it's direction.
     */
    @Override
    public void turnRight() {
        truck.turnRight();
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
     * Returns the current color of the vehicle
     * @return The color of the vehicle
     */
    public Color getColor() {
        return truck.getColor();
    }

    /**
     *Changes the current color to the supplied clr
     * @param clr is the color the vehicle should become
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
     * Accelerates the vehicle the method is called on.
     * @param amount is the amount of how much currentSpeed should increase.
     */
    public void gas(double amount) {
        truck.gas(amount, speedFactor());
    }

    /**
     * Decelerates the vehicle the method is called on.
     * @param amount the amount that changes how much currentSpeed is going to decrease
     */
    public void brake(double amount) {
        truck.brake(amount, speedFactor());
    }


    /**
     * Returns the x-position of the vehicle.
     *
     * @return a double of the x-position of the vehicle.
     */
    @Override
    public double getX() {
        return truck.getX();
    }

    /**
     * Returns the y-position of the vehicle.
     *
     * @return a double of the y-position of the vehicle.
     */
    @Override
    public double getY() {
        return truck.getY();
    }

    /**
     * Positions the vehicle depending on the coordinates provided
     * @param x is the new value of x
     * @param y is the new value of x
     */
    @Override
    public void position(double x, double y) {
        truck.position(x, y);
    }

    /**
     * Sets speedFactor to 1
     * @return returns 1
     */
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
