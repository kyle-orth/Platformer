package PhysicsEngine;

import GameElements.Entity;

public class Movement {
    public static void move(Entity e, long milliseconds) {
        double x = e.getX() + e.getvX()*milliseconds/1000.0;
        double y = e.getY() + e.getvY()*milliseconds/1000.0;
        e.setPos(x, y);
    }

}
