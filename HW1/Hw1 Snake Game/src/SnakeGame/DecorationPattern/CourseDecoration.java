package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;


public class CourseDecoration extends SnakeDecorator {
    public static String decoratorName = "CourseDecoration";
    private static double scoreFactor = 2;
    public CourseDecoration(Snake snake) {super(snake);}
    @Override
    public boolean getIsSnakeAlive() {
        return snake.getIsSnakeAlive();
    }



    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }


}
