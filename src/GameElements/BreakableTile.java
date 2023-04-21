package GameElements;

public class BreakableTile extends Tile{
    public boolean topmost;
    public boolean leftmost;
    public boolean rightmost;
    public boolean bottommost;
    public BreakableTile(int x, int y) {
        super(x, y);
    }
}
