import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.LinkedList;


/**
 * Snake
 * Created by cheddar262.
 */
public class Snake extends Sprite{
    private Color color;
    private Position2D tileSize;
    private int length;
    private LinkedList<Position2D> parts = new LinkedList<>();
    private int toExtend;

    public Snake(Color color, Position2D startingPos, Position2D tileSize, int length){
        this.color = color;
        this.length = length;
        this.tileSize = tileSize;

        for (int piece = 0; piece < length; piece++) {
            parts.addLast(new Position2D(startingPos.getHorizontal() - piece, startingPos.getVertical()));
        }
    }

    @Override
    public void update(Position2D direction){
        parts.addFirst(parts.get(0).add2D(direction));
        if(toExtend <= 0) {
            parts.removeLast();
        } else {
            toExtend--;
            length++;
        }
    }

    public void setToExtend(int amount){
        if(amount > 0) {
            toExtend += amount;
        }
    }

    @Override
    public void render(GraphicsContext gc){
        for (Position2D part: parts) {
            Position2D canvasPos = part.mult2D(tileSize);
            gc.setFill(color);
            gc.setStroke(Color.BLACK);
            gc.fillRect(canvasPos.getHorizontal(), canvasPos.getVertical(), tileSize.getHorizontal(), tileSize.getVertical());
            gc.strokeRect(canvasPos.getHorizontal(), canvasPos.getVertical(), tileSize.getHorizontal(), tileSize.getVertical());
        }
    }

    public Position2D getHeadPos(){
        return parts.getFirst();
    }

    public Position2D getTailPos() { return parts.getLast(); }

    public int getScore(){
        return length;
    }
}
