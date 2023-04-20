package GameElements;

public class BreakableTile extends Tile{
    public boolean topmost = false;
    public boolean leftmost = false;
    public boolean rightmost = false;
    public boolean bottommost = false;
    BreakableTile(int x, int y) {
        super(x, y);
    }
}
