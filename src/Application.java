import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Application
 * Created by cheddar262.
 */
public class Application extends javafx.application.Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Random rand = new Random();

        primaryStage.setTitle("Multiplayer Snake");

        Group root = new Group();
        Scene scene = new Scene(root);

        Position2D canvasSize = new Position2D(800, 600);
        Canvas canvas = new Canvas(canvasSize.getHorizontal(), canvasSize.getVertical());
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Position2D boardSize = new Position2D(40, 30);
        Position2D tileSize = canvasSize.divide2D(boardSize);

        primaryStage.setScene(scene);
        primaryStage.show();

        GameplayLoop gpLoop = new GameplayLoop(gc, canvasSize, boardSize, tileSize, rand);
    }
}
