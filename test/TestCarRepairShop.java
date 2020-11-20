import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class TestCarRepairShop {

    @Test
    public void testRepairShop() {
        CarRepairShop<Volvo240> volvoRepairShop = new CarRepairShop<>(5);
        Volvo240 volvo = new Volvo240();
        volvoRepairShop.loadCar(volvo);
        CarRepairShop<IVehicle> genericRepairShop = new CarRepairShop<>(5);
        Saab95 saab = new Saab95();
        genericRepairShop.loadCar(saab);
        genericRepairShop.loadCar(volvo);
        assertEquals(volvo, volvoRepairShop.getCar());
        assertEquals(saab, genericRepairShop.getCar());
        assertEquals(volvo, genericRepairShop.remove(volvo));
        Volvo240 volvo2 = volvoRepairShop.remove(volvo);
        Volvo240 volvo3 = genericRepairShop.remove(volvo);
        // Saab95 saab2 = volvoRepairShop.remove(saab);
    }

}
