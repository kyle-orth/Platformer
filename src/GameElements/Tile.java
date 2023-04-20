package GameElements;

public class Tile {
    protected int X;
    protected int Y;

    public Tile(int x, int y) {
        X = x;
        Y = y;
    }

    public boolean collisionTop(Entity e) {
        // If the entity is within the bounds horizontally, return whether it is standing.
        if (e.X > X + 1 || e.X + e.width < X)
            return false;
        double errorMargin = 0.1;
        return e.Y > Y - errorMargin && e.Y < Y + errorMargin;
    }

    public boolean collisionLeft(Entity e) {
        // If the entity is within the bounds vertically, return whether it is sliding on the left
        if (e.Y + e.height < Y || e.Y > Y+1)
            return false;
        double errorMargin = 0.1;
        return e.X + e.height > X-errorMargin && e.X + e.height < X+errorMargin;
    }
    public boolean collisionRight(Entity e) {
        // If the entity is within the bounds vertically, return whether it is sliding on the left
        if (e.Y + e.height < Y || e.Y > Y+1)
            return false;
        double errorMargin = 0.1;
        return e.X > X + 1 -errorMargin && e.X < X + 1 +errorMargin;
    }

    public boolean collisionBottom(Entity e) {
        // If the entity is within the bounds horizontally, return whether it is standing.
        if (e.X > X + 1 || e.X + e.width < X)
            return false;
        double errorMargin = 0.1;
        return e.Y - e.height > Y - errorMargin && e.Y - e.height < Y + errorMargin/2;
    }

    @Override
    public boolean equals(Object obj) {
        if(Tile.class.isAssignableFrom(obj.getClass())) {
            return ((Tile) obj).X == X && ((Tile) obj).Y == Y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + X + ", " + Y + ")";
    }
}
