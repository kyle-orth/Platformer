import java.util.ArrayList;

public class TileCollection{
    protected int X;
    protected int Y;
    protected int width;
    protected int height;
    protected ArrayList<Tile> tileArr = new ArrayList<>();
    TileCollection(int x, int y, int w, int h) {
        X = x;
        Y = y;
        height = h;
        width = w;
        createTileSet();
    }

    private void createTileSet() {
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++) {
                tileArr.add(new Tile(X + row, Y + col));
            }
        }
    }

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
