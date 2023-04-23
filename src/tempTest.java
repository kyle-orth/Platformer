import GameElements.Entity;

/**
 * Random temporary test cases. Should not be confused with the formal test cases in the Testing class.
 */
public class tempTest {
    private static final double GRAV_CONST = 9.88;
    private static final double MAX_FREE_FALL = -55.55;
    private static final double FRICTION_EFFECT = 0.5;

    public static void main(String[] args) {
        //jumpLength();
        frictionEffect();
    }

    public static void applyGravity(Entity e, long milliseconds) {
        double acc = GRAV_CONST*milliseconds/1000.0;
        double vY = Math.max(e.getvY() - acc, MAX_FREE_FALL);
        e.setVel(e.getvX(), vY);
    }

    public static void jumpLength() {
        Entity e = new Entity(2, 2, 2, 2, 0, 10);
        double perSecond = 60;
        for (int i=0; i<600; i++) {
            applyGravity(e, (long)(1000.0/perSecond));
            System.out.println("" + i + ":\t" + e.getvY());
        }
    }

    public static void frictionEffect() {
        double value = 20;
        double perSecond = 60;
        for (int i=0; i<50; i++) {
            double friction = Math.min(value /(1.0 + FRICTION_EFFECT), Math.exp(Math.pow(value, 2)*(1.0/perSecond)));
            value = Math.max(value - friction - FRICTION_EFFECT/perSecond, 0);
            System.out.println("" + i + ":\t" + value);
        }
    }
}
