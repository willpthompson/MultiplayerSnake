import java.util.Random;

/**
 * Position2D
 * Created by cheddar262.
 */
public class Position2D {
    private int horizontal;
    private int vertical;

    public Position2D(Random random, Position2D bounds){
        this.horizontal = random.nextInt(bounds.getHorizontal());
        this.vertical = random.nextInt(bounds.getVertical());
    }

    public Position2D(int horizontal, int vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public Position2D add2D(Position2D other){
        return new Position2D(horizontal + other.horizontal, vertical + other.vertical);
    }

    public Position2D mult2D(Position2D other){
        return new Position2D(horizontal * other.horizontal, vertical * other.vertical);
    }

    public Position2D divide2D(Position2D other){
        return new Position2D(horizontal / other.horizontal, vertical / other.vertical);
    }

    @Override
    public String toString() {
        return horizontal + " ; " + vertical;
    }
}
