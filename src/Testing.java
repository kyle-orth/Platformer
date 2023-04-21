import GameElements.*;

import java.util.ArrayList;

public class Testing {
    private static boolean passed;
    private static int totalPassedCount;
    private static int totalTestCount;
    public static void main(String[] args) {
        System.out.println("Test Cases [Platformer]:");

        GameElements();

        System.out.println("Total [Platformer]: " + totalPassedCount + " passed of " + totalTestCount);
    }

    private static void GameElements() {
        // Total Tests = 12
        System.out.println("\nTests for GameElements:");

        Tile();
        BreakableTile();
        TileCollection();
        StandablePlatform();
        SolidPlatform();
        BreakablePlatform();
        Entity();
        Player();

        System.out.println("GameElements result: " + totalPassedCount + " passed of " + totalTestCount);
    }

    private static void Tile() {
        totalTestCount += 3;
        System.out.println("\n***GameElements.Tile***");
        Tile t = new Tile(5, 8);

        System.out.println("---toString()");
        passed = t.toString().equals("(5, 8)");
        if (passed) totalPassedCount++;
        System.out.println("\tCreates proper output: " + passed);

        System.out.println("---equals()");
        passed = t.equals(new Tile(5, 8));
        if (passed) totalPassedCount++;
        System.out.println("\tEquals same Tile object: " + passed);

        passed = t.equals(new BreakableTile(5, 8));
        if (passed) totalPassedCount++;
        System.out.println("\tEquals similar BreakableTile object: " + passed);

        System.out.println();
    }

    private static void BreakableTile() {
        // totalTestCount += 0;
        System.out.println("\n***GameElements.BreakableTile***");
        System.out.println("\tCurrently tested in the Tile tests");

        System.out.println();
    }

    private static void TileCollection() {
        totalTestCount += 5;
        System.out.println("\n***GameElements.TileCollection***");
        TileCollection tc = new TileCollection(1, 3, 2, 2);
        ArrayList<Tile> btc = new TileCollection(0, 0, 2, 3, true).getTileArr();

        System.out.println("---Constructor, breakable=true");
        BreakableTile b1 = (BreakableTile) btc.get(0);
        BreakableTile b2 = (BreakableTile) btc.get(5);
        passed = (b1.bottommost && b1.leftmost && !b1.rightmost && !b1.topmost
                    && b2.topmost && b2.rightmost && !b2.leftmost && !b2.bottommost);
        if (passed) totalPassedCount++;
        System.out.println("\tCorrect initial position values: " + passed);

        System.out.println("---toString()");
        passed = tc.toString().equals("(1, 3) to (3, 5)");
        if (passed) totalPassedCount++;
        System.out.println("\tProper toString assembly: " + passed);

        System.out.println("---contains(int x, int y)");
        passed = tc.contains(1, 4);
        if (passed) totalPassedCount++;
        System.out.println("\tCorrectly identifies coordinates: " + passed);

        System.out.println("---contains(GameElements.Tile t)");
        passed = tc.contains(new Tile(2, 3));
        if (passed) totalPassedCount++;
        System.out.println("\tCorrectly identifies tile: " + passed);

        passed = !tc.contains(new Tile(0, 0));
        if (passed) totalPassedCount++;
        System.out.println("\tDiscards uncontained tile: " + passed);

        System.out.println("---createTileSet()\n\tTested with the contains methods.");

        System.out.println();
    }

    private static void StandablePlatform() {
        // totalTestCount += 0;
        System.out.println("\n***GameElements.StandablePlatform***");

        System.out.println("---standing(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println();
    }

    private static void SolidPlatform() {
        // totalTestCount += 0;
        System.out.println("\n***GameElements.SolidPlatform***");

        System.out.println("---slidingLeft(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println("---slidingRight(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println("---hittingBottom(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println();
    }

    private static void BreakablePlatform() {
        totalTestCount += 4;
        System.out.println("\n***GameElements.BreakablePlatform***");
        BreakablePlatform bp = new BreakablePlatform(1, 3, 2, 2);

        System.out.println("---destroyTile(GameElements.Tile t)");
        passed = !bp.destroyTile(new Tile(0, 0));
        if(passed) totalPassedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);

        Tile t1 = new Tile(2, 3);
        passed = (bp.destroyTile(t1) && !bp.destroyTile(t1));
        if(passed) totalPassedCount++;
        System.out.println("\tCorrectly removes in bounds tile: " + passed);

        System.out.println("---destroyTile(int x, int y)");
        passed = !bp.destroyTile(0, 0);
        if(passed) totalPassedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);

        passed = (bp.destroyTile(1, 4) && !bp.destroyTile(1, 4));
        if (passed) totalPassedCount++;
        System.out.println("\tCorrectly removes in bounds tile: " + passed);

        System.out.println();
    }

    private static void Entity() {
        totalTestCount += 2;
        System.out.println("\n***GameElements.Entity***");
        Entity e = new Entity(10.5, 2.8, 1.2, 2.4, 0.1, 0);
        e.setPos(5.5, 3.8);
        e.setVel(0.5, 0.08);

        System.out.println("---setPos(double x, double y)");
        passed = e.getX() == 5.5 && e.getY() == 3.8;
        if (passed) totalPassedCount++;
        System.out.println("\tProperly sets the position: " + passed);

        System.out.println("---setVel(double vx, double vy)");
        passed = e.getvX() == 0.5 && e.getvY() == 0.08;
        if (passed) totalPassedCount++;
        System.out.println("\tProperly sets the velocity: " + passed);

        System.out.println();
    }

    private static void Player() {
        // totalTestCount += 0;
        System.out.println("\n***GameElements.Player***");
        //Player p = new Player(1, 1);

        System.out.println("---jump()");
        System.out.println("\nTest to be implemented");

        System.out.println();
    }
}
