import GameElements.BreakablePlatform;
import GameElements.Tile;
import GameElements.TileCollection;

public class Testing {
    public static void main(String[] args) {
        int totalPassed = 0;
        int totalTestCount = 0;
        System.out.println("Test Cases [Platformer]:");

        totalPassed += Tile();
        totalTestCount += 0;

        totalPassed += TileCollection();
        totalTestCount += 4;

        totalPassed += StandablePlatform();
        totalTestCount += 0;

        totalPassed += SolidPlatform();
        totalTestCount += 0;

        totalPassed += BreakablePlatform();
        totalTestCount += 4;

        System.out.println("" + totalPassed + " passed of " + totalTestCount);
    }

    private static int Tile() {
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
        return 0;
    }

    private static int SolidPlatform() {
        return 0;
    }

    private static int BreakablePlatform() {
        // Total Tests = 4
        BreakablePlatform bp = new BreakablePlatform(1, 3, 2, 2);
        Tile t1 = new Tile(2, 3);
        Tile t2 = new Tile(0, 0);
        boolean passed;
        int passedCount = 0;

        System.out.println("\n***GameElements.BreakablePlatform***");

        System.out.println("---destroyTile(GameElements.Tile t)");
        passed = !bp.destroyTile(t2);
        if(passed) passedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);
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
