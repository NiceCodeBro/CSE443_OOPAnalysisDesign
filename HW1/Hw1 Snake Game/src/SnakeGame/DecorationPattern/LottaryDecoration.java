package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;



public class LottaryDecoration extends SnakeDecorator {
    public static String decoratorName = "LottaryDecoration";
    private static double scoreFactor = 2;
    public LottaryDecoration(Snake snake) {super(snake);}

    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }

}
