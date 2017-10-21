package SnakeGame.DecorationPattern;


import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;


public class JavaDecoration extends SnakeDecorator {
    public static String decoratorName = "JavaDecoration";
    private static double scoreFactor = 4;
    public JavaDecoration(Snake snake) {super(snake);}



    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }


}
