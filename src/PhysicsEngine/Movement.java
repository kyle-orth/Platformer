package PhysicsEngine;

import GameElements.Entity;

/**
 * The Movement class handles simple game physics, excluding collisions. This class handles movement
 * based on an Entity's velocity, as well as acceleration based on the forces applying to the Entity.
 */
public class Movement {
    private static final double GRAV_CONST = 9.88;
    private static final double MAX_FREE_FALL = -55.55;
    private static final double FRICTION_EFFECT = 0.5;

    public static void move(Entity e, long milliseconds) {
        double x = e.getX() + e.getvX()*milliseconds/1000.0;
        double y = e.getY() + e.getvY()*milliseconds/1000.0;
        e.setPos(x, y);
    }

    public static void applyGravity(Entity e, long milliseconds) {
        double acc = GRAV_CONST*milliseconds/1000.0;
        double vY = Math.max(e.getvY() - acc, MAX_FREE_FALL);
        e.setVel(e.getvX(), vY);
    }

    public static void applyGravity(Entity e, long milliseconds, double gravModifier) {
        double acc = gravModifier*GRAV_CONST*milliseconds/1000.0;
        double newvY = Math.max(e.getvY() - acc, Math.pow(gravModifier, 2)*MAX_FREE_FALL);
        e.setVel(e.getvX(), newvY);
    }

    public static void applyFriction(Entity e, long milliseconds) {
        double friction = Math.max(e.getvX()/(1.0 + FRICTION_EFFECT), Math.exp(Math.pow(e.getvX(), 2)*milliseconds));
        double newvX = Math.max(e.getvX() - friction - FRICTION_EFFECT*(1000.0/milliseconds), 0);
        if (e.getvX() < 0)
            newvX *= -1;
        e.setVel(newvX, e.getvY());
    }
}
