import java.util.ArrayList;

public class TileCollection{
    protected int X;
    protected int Y;
    protected int width;
    protected int height;
    private ArrayList<Tile> tileArr = new ArrayList<>();
    TileCollection(int x, int y, int w, int h) {
        X = x;
        Y = y;
        height = h;
        width = w;
        gatherTiles();
    }

    private void gatherTiles() {
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++) {
                tileArr.add(new Tile(X + row, Y + col));
            }
        }
    }

    public boolean standing(Entity e) {
        for(Tile t : tileArr)
            if(t.standing(e))
                return true;
        return false;
    }

    public boolean destroyTile(int x, int y) {
        Tile t = new Tile(x, y);
        return tileArr.remove(t);
    }

    public boolean destroyTile(Tile t) {
        return tileArr.remove(t);
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
