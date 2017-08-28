import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * GameplayLoop
 * Created by cheddar262.
 */
public class GameplayLoop extends AnimationTimer {
    private final int START_LENGTH = 3;
    private long previousNow;
    private Position2D tileSize;
    private Position2D boardSize;
    private Position2D canvasSize;
    private GraphicsContext gc;
    private ConcurrentHashMap<String, Snake> snakes = new ConcurrentHashMap<>();
    private ConcurrentLinkedQueue<Apple> apples = new ConcurrentLinkedQueue<>();
    private Random random;

    public GameplayLoop(GraphicsContext gc, Position2D canvasSize, Position2D boardSize, Position2D tileSize, Random random){
        previousNow = System.nanoTime();
        this.gc = gc;
        this.boardSize = boardSize;
        this.tileSize = tileSize;
        this.canvasSize = canvasSize;
        this.random = random;

        snakes.put("Will", new Snake(Color.GREEN, new Position2D(5,5), tileSize, START_LENGTH));
        start();
    }

    @Override
    public void handle(long now) {
        //calculate update time
        long elapsedTimeMillis = (now - previousNow)/1000000;

        //Game logic
        if(elapsedTimeMillis > 1000){
            for(Snake snake: snakes.values()){
                snake.update(new Position2D(1, 0));
                System.out.println(snake.getHeadPos());
                System.out.println(snake.getTailPos());
            }
            previousNow = now;
        }

        //Render updates
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvasSize.getVertical(), canvasSize.getHorizontal());
        for(Snake snake: snakes.values()){
            snake.render(gc);
        }
    }
}
