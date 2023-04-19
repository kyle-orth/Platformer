public class Testing {
    public static void main(String[] args) {
        System.out.println("Test Cases [Platformer]:");

        int totalPassed = 0;
        totalPassed += TileCollection();

        int totalTestCount = 4;
        System.out.println("" + totalPassed + " passed of " + totalTestCount);
    }

    private static int TileCollection() {
        TileCollection tc = new TileCollection(1, 3, 2, 2);
        Tile t1 = new Tile(2, 3);
        Tile t2 = new Tile(0, 0);
        boolean passed;
        int passedCount = 0;

        System.out.println();
        System.out.println("***TileCollection***");

        System.out.println("---destroyTile(Tile t)");
        passed = !tc.destroyTile(t2);
        if(passed) passedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);
        passed = (tc.destroyTile(t1) && !tc.destroyTile(t1));
        if(passed) passedCount++;
        System.out.println("\tCorrectly removes in bounds tile: " + passed);

        System.out.println("---destroyTile(int x, int y)");
        passed = !tc.destroyTile(0, 0);
        if(passed) passedCount++;
        System.out.println("\tIgnores out of bounds tile removal: " + passed);
        passed = (tc.destroyTile(1, 4) && !tc.destroyTile(1, 4));
        if (passed) passedCount++;
        System.out.println("\tCorrectly removes in bounds tile: " + passed);

        System.out.println();
        return passedCount;
    }
}
