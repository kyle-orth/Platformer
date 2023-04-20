import GameElements.BreakablePlatform;
import GameElements.BreakableTile;
import GameElements.Tile;
import GameElements.TileCollection;

public class Testing {
    public static void main(String[] args) {
        int totalPassed = 0;
        int totalTestCount = 0;
        System.out.println("Test Cases [Platformer]:");

        totalPassed += GameElements();
        totalTestCount += 11;

        System.out.println("Total [Platformer]: " + totalPassed + " passed of " + totalTestCount);
    }

    private static int GameElements() {
        // Total Tests = 11
        int totalPassed = 0;
        int totalTestCount = 0;
        System.out.println("\nTests for GameElements:");

        totalPassed += Tile();
        totalTestCount += 3;

        totalPassed += BreakableTile();
        //totalTestCount += 0;

        totalPassed += TileCollection();
        totalTestCount += 4;

        totalPassed += StandablePlatform();
        totalTestCount += 0;

        totalPassed += SolidPlatform();
        totalTestCount += 0;

        totalPassed += BreakablePlatform();
        totalTestCount += 4;

        System.out.println("GameElements result: " + totalPassed + " passed of " + totalTestCount);
        return totalPassed;
    }

    private static int Tile() {
        // Total Tests = 3
        Tile t = new Tile(5, 8);
        boolean passed;
        int passedCount = 0;
        System.out.println("\n***GameElements.Tile***");

        System.out.println("---toString()");
        passed = t.toString().equals("(5, 8)");
        if (passed) passedCount++;
        System.out.println("\tCreates proper output: " + passed);

        System.out.println("---equals()");
        passed = t.equals(new Tile(5, 8));
        if (passed) passedCount++;
        System.out.println("\tEquals same Tile object: " + passed);

        passed = t.equals(new BreakableTile(5, 8));
        if (passed) passedCount++;
        System.out.println("\tEquals similar BreakableTile object: " + passed);

        System.out.println();
        return passedCount;
    }

    private static int BreakableTile() {
        // Total Tests = 0
        // boolean passed;
        // int passedCount = 0;
        System.out.println("\n***GameElements.BreakableTile***");
        System.out.println("\tCurrently tested in the Tile tests");

        System.out.println();
        return 0;
    }

    private static int TileCollection() {
        // Total Tests = 4
        TileCollection tc = new TileCollection(1, 3, 2, 2);
        boolean passed;
        int passedCount = 0;
        System.out.println("\n***GameElements.TileCollection***");

        System.out.println("---toString()");
        passed = tc.toString().equals("(1, 3) to (3, 5)");
        if (passed) passedCount++;
        System.out.println("\tProper toString assembly: " + passed);

        System.out.println("---contains(int x, int y)");
        passed = tc.contains(1, 4);
        if (passed) passedCount++;
        System.out.println("\tCorrectly identifies coordinates: " + passed);

        System.out.println("---contains(GameElements.Tile t)");
        passed = tc.contains(new Tile(2, 3));
        if (passed) passedCount++;
        System.out.println("\tCorrectly identifies tile: " + passed);

        passed = !tc.contains(new Tile(0, 0));
        if (passed) passedCount++;
        System.out.println("\tDiscards uncontained tile: " + passed);

        System.out.println("---createTileSet()\n\tTested with the contains methods.");

        System.out.println();
        return passedCount;
    }

    private static int StandablePlatform() {
        boolean passed;
        int passedCount = 0;
        System.out.println("\n***GameElements.StandablePlatform***");

        System.out.println("---standing(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println();
        return passedCount;
    }

    private static int SolidPlatform() {
        boolean passed;
        int passedCount = 0;
        System.out.println("\n***GameElements.SolidPlatform***");

        System.out.println("---slidingLeft(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println("---slidingRight(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println("---hittingBottom(Entity e)");
        System.out.println("\tTest to be implemented.");

        System.out.println();
        return passedCount;
    }

    private static int BreakablePlatform() {
        // Total Tests = 4
        BreakablePlatform bp = new BreakablePlatform(1, 3, 2, 2);
        boolean passed;
        int passedCount = 0;
        System.out.println("\n***GameElements.BreakablePlatform***");

        System.out.println("---destroyTile(GameElements.Tile t)");
        passed = !bp.destroyTile(new Tile(0, 0));
        if(passed) passedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);

        Tile t1 = new Tile(2, 3);
        passed = (bp.destroyTile(t1) && !bp.destroyTile(t1));
        if(passed) passedCount++;
        System.out.println("\tCorrectly removes in bounds tile: " + passed);

        System.out.println("---destroyTile(int x, int y)");
        passed = !bp.destroyTile(0, 0);
        if(passed) passedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);

        passed = (bp.destroyTile(1, 4) && !bp.destroyTile(1, 4));
        if (passed) passedCount++;
        System.out.println("\tCorrectly removes in bounds tile: " + passed);

        System.out.println();
        return passedCount;
    }
}
