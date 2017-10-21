package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

public class Piton extends AbstractSnake{
    public static final Color color = Color.CYAN;
    public static final Color deadSnakeColor = Color.RED;


    public Piton(int xDirection, int yDirection, Spot head)
    {
        super(xDirection,yDirection,head);

    }

    @Override
    public Color getSnakeColor() {
        return color;
    }

    @Override
    public Color getDeadSnakeColor() {
        return deadSnakeColor;
    }
    @Override
    public double getScoreMultiplier() {
        return 1.0;
    }
}
