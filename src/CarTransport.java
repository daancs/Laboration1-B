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
     *
     */
    public CarTransport() {
        super(2, 700, Color.CYAN, "Car transport", Direction.NORTH);
        loadedCars = new ArrayDeque<>();
        maxLoadedCars = 5;
    }


    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    public void move(){
        if(rampIsUp){
            super.move();
            for (Car car: loadedCars){
                car.position(this.getX(), this.getY());
            }
        }
    }

    public void changeRamp() {
        if(getCurrentSpeed() < 0.0001){
            rampIsUp = !rampIsUp;
        }
    }

    private boolean validateLoadCircumstances(Car car) {
        return !rampIsUp &&
                Math.abs(car.getX() - this.getX()) < 10 &&
                Math.abs(car.getY() - this.getY()) < 10 &&
                !(car instanceof CarTransport) &&
                loadedCars.size() < maxLoadedCars;
    }


    private void loadCar(Car car) {
        if(validateLoadCircumstances(car)) {
            car.position(this.getX(), this.getY());
            loadedCars.push(car);
        }
    }


    private void unloadCar() {
        if (!rampIsUp && !loadedCars.isEmpty()) {
            Car car = loadedCars.pop();
            car.position(this.getX() + 10, this.getY() - 10);
        }
    }
}
