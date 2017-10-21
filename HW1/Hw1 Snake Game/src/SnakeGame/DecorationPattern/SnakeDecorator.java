package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.List;

public abstract class SnakeDecorator implements Snake {
    protected Snake snake;

    public SnakeDecorator(Snake snake)
    {
        this.snake = snake;
    }

    @Override
    public boolean getIsSnakeAlive() {
        return snake.getIsSnakeAlive();
    }

    @Override
    public void setSnakeIsAlive(boolean snakeIsAlive) {
        snake.setSnakeIsAlive(snakeIsAlive);
    }

    @Override
    public Spot getHead() {
        return snake.getHead();
    }

    @Override
    public void up() {
        snake.up();
    }

    @Override
    public void right() {
        snake.right();
    }

    @Override
    public void left() {
        snake.left();
    }

    @Override
    public void down() {
        snake.down();
    }

    @Override
    public void moveOn(boolean isEatingFood) {
        snake.moveOn(isEatingFood);
    }

    @Override
    public void changeDirection(int xDirection, int yDirection) {
        snake.changeDirection(xDirection,yDirection);
    }

    @Override
    public void addNewPoint(int x, int y) {
        snake.addNewPoint(x,y);
    }

    @Override
    public List<Spot> getSnake() {
        return snake.getSnake();
    }

    @Override
    public Color getSnakeColor() {
        return snake.getSnakeColor();
    }

    @Override
    public Color getDeadSnakeColor() {
        return snake.getDeadSnakeColor();
    }


    @Override
    public int increaseOneSnakeLength() { return snake.increaseOneSnakeLength(); }

}
