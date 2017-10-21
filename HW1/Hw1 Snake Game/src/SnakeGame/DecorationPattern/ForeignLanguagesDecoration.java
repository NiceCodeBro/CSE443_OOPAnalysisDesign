package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;



public class ForeignLanguagesDecoration extends SnakeDecorator {
    public static String decoratorName = "ForeignLanguagesDecoration";
    private static double scoreFactor = 3;
    public ForeignLanguagesDecoration(Snake snake) {super(snake);}

    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }

}

