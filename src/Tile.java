public class Tile {
    protected double X;
    protected double Y;

    Tile(double x, double y) {
        X = x;
        Y = y;
    }

    public boolean standing(Entity e) {
        // If the entity is within the bounds horizontally, return whether it is standing.
        if (e.X > X + 1 || e.X + e.width < X)
            return false;
        double heightErrorMargin = 0.1;
        return e.Y - e.height > Y - heightErrorMargin && e.Y - e.height < Y + heightErrorMargin/2;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj.getClass() == Tile.class))
            return false;
        return ((Tile)obj).X == X && ((Tile)obj).Y == Y;
    }

    @Override
    public String toString() {
        return "(" + X + ", " + Y + ")";
    }
}
