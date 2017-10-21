package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;


public class Anaconda extends AbstractSnake{
    private final Color color = Color.BLUE;
    private final Color deadSnakeColor = Color.RED;
    private boolean SnakeIsAlive = true;


    public Anaconda(int xDirection, int yDirection, Spot head)
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
