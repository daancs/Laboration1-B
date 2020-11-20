import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestCar {


    //TODO tests for CarTransport

    @Test
    public void testSaabEnginePower() {
        Saab95 saab = new Saab95();
        Assert.assertEquals(125, saab.getEnginePower(), 0);
    }

    @Test
    public void testVolvoEnginePower() {
        Volvo240 volvo = new Volvo240();
        assertEquals(100, volvo.getEnginePower(), 0);
    }

    @Test
    public void TestnrDoorsSaab() {
        Saab95 saab = new Saab95();
        Assert.assertEquals(2, saab.getNrDoors(), 0);

    }

    @Test
    public void TestnrDoorsVolvo() {
        Volvo240 volvo = new Volvo240();
        Assert.assertEquals(4, volvo.getNrDoors(), 0);

    }


    @Test
    public void testSaabTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertTrue(saab.isTurboOn());
    }

    @Test
    public void testSaabTurboOff() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        assertFalse(saab.isTurboOn());
    }

    @Test
    public void testCarTurnRight() {
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(Car.Direction.EAST, saab.getDirection());
        saab.turnRight();
        assertEquals(Car.Direction.SOUTH, saab.getDirection());
        saab.turnRight();
        assertEquals(Car.Direction.WEST, saab.getDirection());
        saab.turnRight();
        assertEquals(Car.Direction.NORTH, saab.getDirection());
    }
    @Test
    public void testCarTurnLeft() {
        Saab95 saab = new Saab95(Car.Direction.EAST);
        saab.turnLeft();
        assertEquals(Car.Direction.NORTH, saab.getDirection());
        saab.turnLeft();
        assertEquals(Car.Direction.WEST, saab.getDirection());
        saab.turnLeft();
        assertEquals(Car.Direction.SOUTH, saab.getDirection());
        saab.turnLeft();
        assertEquals(Car.Direction.EAST, saab.getDirection());
    }


    @Test
    public void testStartEngine() {
        Saab95 saab = new Saab95();
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testStopEngine() {
        Saab95 saab = new Saab95();
        saab.stopEngine();
        assertEquals(0, saab.getCurrentSpeed(), 0.001);
    }


    @Test
    public void testMove() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1);
        volvo.move();
        assertEquals(-1.35, volvo.getY(), 0.001);
        assertEquals(0, volvo.getX(), 0.001);
        volvo.turnLeft();
        volvo.move();
        assertEquals(-1.35, volvo.getY(), 0.001);
        assertEquals(-1.35, volvo.getX(), 0.001);
        volvo.turnLeft();
        volvo.move();
        assertEquals(0, volvo.getY(), 0.001);
        assertEquals(-1.35, volvo.getX(), 0.001);
        volvo.turnLeft();
        volvo.move();
        assertEquals(0, volvo.getY(), 0.001);
        assertEquals(0, volvo.getX(), 0.001);
    }




    @Test
    public void testSaabSetColor() {
        Saab95 saab = new Saab95();
        saab.setColor(Color.BLUE);
        assertEquals(Color.BLUE,saab.getColor());
    }


    @Test
    public void testVolvoGetColor() {
        Volvo240 volvo = new Volvo240();
        assertEquals(Color.BLACK,volvo.getColor());
    }

    @Test
    public void testGas() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(0.5);
        assertEquals(0.725, volvo.getCurrentSpeed(), 0.001);
    }

    @Test
    public void testBrake() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1);
        volvo.brake(0.5);
        assertEquals(0.725, volvo.getCurrentSpeed(), 0.001);
    }



}
