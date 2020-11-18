import java.awt.*;

/**
 * A class that describes an object and control it`s movements
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public class Saab95 implements Movable{


    //TODO documentation for class
    private boolean turboOn;
    private Car car;

    /**
     * Constructs a Saab95 with 2 doors, engine power 125 and colour red.
     * Sets the variable turboOn to false and stops the engine.
     */
    public Saab95(Vehicle.Direction direction){
        car = new Car(2, 125, Color.red, "Saab95", direction);
	    turboOn = false;
        car.stopEngine();
    }

    public Saab95() {
        car = new Car(2, 125, Color.red, "Saab95", Vehicle.Direction.NORTH);
        turboOn = false;
        car.stopEngine();
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


    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return car.getEnginePower() * 0.01 * turbo;
    }

    public void move(){
        car.move();
    }

    public void turnLeft(){
        car.turnLeft();
    }

    public void turnRight(){
        car.turnRight();
    }

    public double getX() {
        return car.getX();
    }

    public double getY() {
        return car.getY();
    }

    public void position(double x, double y) {
        car.position(x, y);
    }

    public int getNrDoors() {
        return car.getNrDoors();
    }

    public double getEnginePower() {
        return car.getEnginePower();
    }

    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    public Color getColor() {
        return car.getColor();
    }

    public void setColor(Color clr) {
        car.setColor(clr);
    }

    public Vehicle.Direction getDirection() {
        return car.getDirection();
    }

    public void startEngine() {
        car.startEngine();
    }

    public void stopEngine() {
        car.stopEngine();
    }

    public void gas(double amount) {
        car.gas(amount, speedFactor());
    }

    /**
     * Takes a double between 1 and 0 and use it to control decrementSpeed
     * @param amount the amount that changes how much currentSpeed is going to decrease
     */
    public void brake(double amount) {
        car.brake(amount, speedFactor());
    }
}
