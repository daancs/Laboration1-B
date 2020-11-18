import java.util.ArrayList;
import java.util.List;

/**
 * creates a car repair shop in which cars that only implements IVehicle can be stored in the shop
 * Creates different workshops that can only load a specific class or can load any car
 *
 * @param <T> sets a limit to which objects can be used in the class,
 */
public class CarRepairShop<T extends IVehicle> {

    private List<T> cars;
    private int maximumLimit;

    public CarRepairShop (int maximumLimit){
        this.maximumLimit = maximumLimit;
        cars = new ArrayList<>();
    }

    /**
     * Removes and returns the first car in the shop
     * @return the first car in the list
     */
    public T getCar(){
        return cars.remove(0);
    }

    /**
     * Removes the provided car from the list.
     * Returns null if car not found in list
     * @param car the car that´s to be removed.
     * @return returns the removed car if found, otherwise null.
     */
    public <B extends T> B remove(B car){
        for (int i = 0; i < cars.size(); i ++){
            if (cars.get(i).equals(car)){
                cars.remove(i);
                return car;
            }
        }
        return null;
    }

    /**
     * Effectively loads a repair shop with the supplied car.
     * Will give static error if car is not of correct type.
     * @param car is the car to be loaded into the repair shop.
     */
    public void loadCar(T car) {
        if (cars.size() < maximumLimit) {
            cars.add(car);
        }
    }
}
