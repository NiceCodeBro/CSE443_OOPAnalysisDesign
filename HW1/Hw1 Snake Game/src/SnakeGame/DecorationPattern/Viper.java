package SnakeGame.DecorationPattern;


import SnakeGame.Spot;
import javafx.scene.paint.Color;

public class Viper extends AbstractSnake{

    public static final Color color = Color.LIGHTBLUE;
    public static final Color deadSnakeColor = Color.RED;


    public Viper(int xDirection, int yDirection, Spot head)
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
