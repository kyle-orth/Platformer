public class BreakablePlatform extends TileCollection{
    BreakablePlatform(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    public boolean destroyTile(int x, int y) {
        Tile t = new Tile(x, y);
        return tileArr.remove(t);
    }

    public boolean destroyTile(Tile t) {
        return tileArr.remove(t);
    }
}
