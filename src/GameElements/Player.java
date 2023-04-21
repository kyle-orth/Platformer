package GameElements;

/**
 * Player is an Entity that can jump, and has variable size and jump power.
 */
public class Player extends Entity {
    protected double jumpPower;

    public Player(int x, int y, double width, double height, double jumpPower) {
        super(x, y, width, height);
        setJumpPower(jumpPower);
    }
    public Player(int x, int y) {this(x, y, 0.7, 1.2, 3);}

    public Player(int x, int y, double width, double height) {this(x, y, width, height, 3);}

    public Player(int x, int y, double jumpPower) {this(x, y, 0.7, 1.2, jumpPower);}

    public void jump() {
        vY = jumpPower;
    }

    public void setJumpPower(double jumpPower) { this.jumpPower = jumpPower;}

    public void changeSize(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
