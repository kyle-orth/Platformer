package GameElements;

/**
 * SolidPlatform is a TileCollection with collision testing on all four sides.
 */
public class SolidPlatform extends StandablePlatform {
    public SolidPlatform(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public boolean slidingLeft(Entity e) {
        // Checks only the left side
        for(Tile t : tileArr) {
            if (t.X == X && t.collisionLeft(e))
                return true;
        }
        return false;
    }

    public boolean slidingRight(Entity e) {
        // Checks only the right side
        for(Tile t : tileArr) {
            if (t.X == X + width-1 && t.collisionRight(e))
                return true;
        }
        return false;
    }

    public boolean hittingBottom(Entity e) {
        // Checks only the bottom layer
        for (Tile t : tileArr)
            if (t.Y == Y && t.collisionBottom(e))
                return true;
        return false;
    }
}
