public class StandablePlatform extends TileCollection{

    StandablePlatform(int x, int y, int w, int h){
        super(x, y, w, h);
    }
    public boolean standing(Entity e) {
        // Checks only the top layer of the collection
        for (Tile t : tileArr)
            if (t.Y == Y+height-1 && t.collisionTop(e))
                return true;
        return false;
    }
}
