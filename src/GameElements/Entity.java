package GameElements;

/**
 * Entity stores an entity's size, position, and velocity. move() moves the entity based on its
 * current velocity, magnified by the amount of time that has passed since the last call.
 */
public class Entity{
    protected double X;
    protected double Y;
    protected double width;
    protected double height;
    protected double vX;
    protected double vY;
    public Entity(double x, double y, double w, double h) {
        X = x;
        Y = y;
        width = w;
        height = h;
        vY = 0;
        vX = 0;
    }

    public Entity(double x, double y, double w, double h, double vX, double vY) {
        this(x, y, w, h);
        this.vX = vX;
        this.vY = vY;
    }

    public void move(long milliseconds) {
        X += vX*(milliseconds/1000.0);
        Y += vY*(milliseconds/1000.0);
    }

    public void setPos(double x, double y) {
        X = x;
        Y = y;
    }

    public void setVel(double vx, double vy) {
        vX = vx;
        vY = vy;
    }

    public double getX() {return X;}
    public double getY() {return Y;}
    public double getvX() {return vX;}
    public double getvY() {return vY;}
}
