package SnakeGame.DecorationPattern;


import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;

public class MasterDecoration extends SnakeDecorator {
    public static String decoratorName = "MasterDecoration";
    private static double scoreFactor = 5;
    public MasterDecoration(Snake snake) {super(snake);}


    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }


}

