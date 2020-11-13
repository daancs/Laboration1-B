import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCar {

    @Test
    public void testScania() {
        Scania scania = new Scania();
        scania.raisePlatform(30);
        assertEquals(30, scania.getPlatformAngle(), 0.001);
    }

}
