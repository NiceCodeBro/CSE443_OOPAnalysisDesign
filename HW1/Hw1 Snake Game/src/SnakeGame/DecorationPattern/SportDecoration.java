package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;


public class SportDecoration extends SnakeDecorator {
    public static String decoratorName = "SportDecoration";
    private static double scoreFactor = 5;
    public SportDecoration(Snake snake) {super(snake);}


    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }

}
