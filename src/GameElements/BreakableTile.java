package GameElements;

/**
 * Subclass of Tile.
 * Holds values corresponding to its relative position in the platform. This enables collision
 * capabilities for non-rectangular platforms.
 */
public class BreakableTile extends Tile{
    public boolean topmost;
    public boolean leftmost;
    public boolean rightmost;
    public boolean bottommost;
    public BreakableTile(int x, int y) {
        super(x, y);
    }
}
