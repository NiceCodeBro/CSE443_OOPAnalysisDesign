package SnakeGame.DecorationPattern;


import SnakeGame.Spot;
import javafx.scene.paint.Color;
import java.util.List;

public class TrainingCertificatesDecorations extends SnakeDecorator {
    public static String decoratorName = "TrainingCertificatesDecorations";
    private static double scoreFactor = 3;
    public TrainingCertificatesDecorations(Snake snake) {super(snake);}

    @Override
    public double getScoreMultiplier() {
        return scoreFactor * super.snake.getScoreMultiplier();
    }



}

