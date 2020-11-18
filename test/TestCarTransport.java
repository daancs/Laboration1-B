import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCarTransport {

    @Test
    public void LoadCar() {
        Volvo240 volvo = new Volvo240();
        CarTransport c = new CarTransport();
        c.loadCar(volvo);

        assertEquals(c.getX(), volvo.getX(), 0.001);
        assertEquals(c.getY(), volvo.getY(), 0.001);
        assertEquals(1, c.getLoadedCars().size());
        assertEquals(volvo, c.getLoadedCars().peek());
    }



}
