public class Entity{
    protected double X;
    protected double Y;
    protected double width;
    protected double height;
    protected double vX;
    protected double vY;
    Entity(double x, double y, double w, double h) {
        X = x;
        Y = y;
        width = w;
        height = h;
    }

    Entity(double x, double y, double w, double h, double vX, double vY) {
        this(x, y, w, h);
        this.vX = vX;
        this.vY = vY;
    }

    public void move() {
        X += vX;
        Y += vY;
    }
}
