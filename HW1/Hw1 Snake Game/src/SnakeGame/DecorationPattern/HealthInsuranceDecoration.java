package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;


public class HealthInsuranceDecoration extends SnakeDecorator {
    public static String decoratorName = "HealthInsuranceDecoration";
    private static double scoreFactor = 4;
    public HealthInsuranceDecoration(Snake snake) {super(snake);}




    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }


}
