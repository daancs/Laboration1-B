/**
 * Makes methods to be used in subclasses
 * @author Hanna Adenholm
 * @author Omar Sulaiman
 * @author Dadi Andrason
 */
public interface Movable {

    void move();
    void turnLeft();
    void turnRight();
    void position(double x, double y);
    double getX();
    double getY();

}
