import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestScania {

    @Test
    public void testRaisePlatformScania() {
        Scania scania = new Scania();
        scania.raisePlatform(30);
        assertEquals(30, scania.getPlatformAngle(), 0.001);
    }
    @Test
    public void testPlatformScania() {
        Scania scania = new Scania();
        scania.raisePlatform(40);
        scania.lowerPlatform(30);
        assertEquals(30, scania.getPlatformAngle(), 0.001);
    }
}
