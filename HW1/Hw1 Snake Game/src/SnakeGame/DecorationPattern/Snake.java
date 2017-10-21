package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public interface Snake {
    public boolean getIsSnakeAlive();
    public void setSnakeIsAlive(boolean snakeIsAlive);
    public Spot getHead();
    public void up();
    public void right();
    public void left();
    public void down();
    public void moveOn(boolean isEatingFood);
    public void changeDirection(int xDirection, int yDirection);
    public void addNewPoint(int x, int y);
    public List<Spot> getSnake();
    public Color getSnakeColor();
    public Color getDeadSnakeColor();
    public double getScoreMultiplier();
    public int increaseOneSnakeLength();


}
