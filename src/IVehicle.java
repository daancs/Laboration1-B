/**
 * Makes methods to be used in certain classes
 */
public interface IVehicle extends Movable{
    void position(double x, double y);
    double getX();
    double getY();
    void gas(double amount);
    void brake(double amount);
}
