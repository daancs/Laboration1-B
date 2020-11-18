import java.util.ArrayList;
import java.util.List;

public class CarRepairShop<T extends IVehicle> {

    private List<T> cars;
    private int maximumLimit;

    public CarRepairShop (int maximumLimit){
        this.maximumLimit = maximumLimit;
        cars = new ArrayList<>();
    }

    public T getCar(){
        return cars.remove(0);
    }

    public T remove(T car){
        for (int i = 0; i < cars.size(); i ++){
            if (cars.get(i).equals(car)){
                return cars.remove(i);
            }
        }
        return null;
    }

    public void loadCar(T car) {
        if (cars.size() < maximumLimit) {
            cars.add(car);
        }
    }
}
