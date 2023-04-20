package GameElements;

public class BreakablePlatform extends TileCollection{
    public BreakablePlatform(int x, int y, int w, int h){
        super(x, y, w, h, true);
    }


    private void updateTiles(int x, int y) {
        Tile up = new Tile(x, y+1);
        Tile down = new Tile(x, y-1);
        Tile left = new Tile(x-1, y);
        Tile right = new Tile(x+1, y);

        for (Tile t : tileArr) {
            assert t instanceof BreakableTile : "Not BreakableTile Object";
            if(up.equals(t))
                ((BreakableTile)t).bottommost = true;
            else if(down.equals(t))
                ((BreakableTile)t).topmost = true;
            else if(left.equals(t))
                ((BreakableTile)t).rightmost = true;
            else if(right.equals(t))
                ((BreakableTile)t).leftmost = true;
        }
    }
    public boolean destroyTile(int x, int y) {
        Tile t = new Tile(x, y);
        for (int i = 0; i < tileArr.size(); i++) {
            if (t.equals(tileArr.get(i))) {
                tileArr.remove(i);
                updateTiles(x, y);
                return true;
            }
        }
        return false;
    }

    public boolean destroyTile(Tile t) {
        t = new Tile(t.X, t.Y);
        for (int i = 0; i < tileArr.size(); i++) {
            if (t.equals(tileArr.get(i))) {
                tileArr.remove(i);
                updateTiles(t.X, t.Y);
                return true;
            }
        }
        return false;
    }
    public boolean slidingLeft(Entity e) {
        // Checks only the left side
        for(Tile t : tileArr) {
            if (((BreakableTile)t).leftmost && t.collisionLeft(e))
                return true;
        }
        return false;
    }

    public boolean slidingRight(Entity e) {
        // Checks only the right side
        for(Tile t : tileArr) {
            if (((BreakableTile)t).rightmost && t.collisionRight(e))
                return true;
        }
        return false;
    }
    public boolean standing(Entity e) {
        // Checks only the top layer of the collection
        for (Tile t : tileArr)
            if (((BreakableTile)t).topmost && t.collisionTop(e))
                return true;
        return false;
    }
    public boolean hittingBottom(Entity e) {
        // Checks only the bottom layer
        for (Tile t : tileArr)
            if (((BreakableTile) t).bottommost && t.collisionBottom(e))
                return true;
        return false;
    }
}
