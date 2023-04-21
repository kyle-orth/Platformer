package GameElements;

import java.util.ArrayList;

/**
 * TileCollection stores an array of Tiles (or BreakableTiles) in a rectangular shape.
 * The contains method returns whether a Tile with the specified coordinates is in the collection.
 * Shape can be changed using the subclass BreakablePlatform.
 */
public class TileCollection{
    protected int X;
    protected int Y;
    protected int width;
    protected int height;
    protected ArrayList<Tile> tileArr = new ArrayList<>();
    public TileCollection(int x, int y, int w, int h) {
        X = x;
        Y = y;
        height = h;
        width = w;
        createTileSet();
    }
    public TileCollection(int x, int y, int w, int h, boolean breakable) {
        X = x;
        Y = y;
        height = h;
        width = w;
        if(breakable)
            createBreakableTileSet();
        else
            createTileSet();
    }

    private void createTileSet() {
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++) {
                tileArr.add(new Tile(X + row, Y + col));
            }
        }
    }

    private void createBreakableTileSet() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                BreakableTile t = new BreakableTile(X+row, Y+col);
                if(row == 0) {t.bottommost = true;}
                if(row == height-1) {t.topmost = true;}
                if(col == 0) {t.leftmost = true;}
                if(col == width-1) {t.rightmost = true;}
                tileArr.add(t);
            }
        }
    }

    public ArrayList<Tile> getTileArr() { return tileArr;}

    public boolean contains(int x, int y) {
        for (Tile t : tileArr)
            if(t.equals(new Tile(x, y)))
                return true;
        return false;
    }

    public boolean contains(Tile tile) {
        for (Tile t : tileArr)
            if(t.equals(tile))
                return true;
        return false;
    }

    public String tilesToString() {
        StringBuilder tileStr = new StringBuilder();
        for(Tile t : tileArr)
            tileStr.append(t.toString()).append("\n");
        return tileStr.toString();
    }

    public String toString() {
        return "(" + X + ", " + Y + ") to (" + (X+width) + ", " + (Y+height) + ")";
    }
}
