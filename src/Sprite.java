
import javafx.scene.canvas.GraphicsContext;

/**
 * Sprite
 * Created by cheddar262.
 */
public abstract class Sprite {
    public Sprite(){

    }

    public abstract void update(Position2D direction);
    public abstract void render(GraphicsContext gc);
}
