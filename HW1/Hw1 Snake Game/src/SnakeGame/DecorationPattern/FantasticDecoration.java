package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;




public class FantasticDecoration extends SnakeDecorator {
    public static String decoratorName = "FantasticDecoration";
    private static double scoreFactor = 2;
    public FantasticDecoration(Snake snake) {super(snake);}
    @Override
    public boolean getIsSnakeAlive() {
        return snake.getIsSnakeAlive();
    }



    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }

}
