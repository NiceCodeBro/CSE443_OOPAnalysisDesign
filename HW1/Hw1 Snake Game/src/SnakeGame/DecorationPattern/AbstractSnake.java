package SnakeGame.DecorationPattern;

import SnakeGame.Spot;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class AbstractSnake implements Snake {
    private int xDirection; // it might be 1 -1 0
    private int yDirection; //it might be  1 -1 0
    public List<Spot> snakeSpots; //that keeps cordinates of snake's every spot
    private Spot head;
    private static final Color color = Color.LIGHTBLUE;
    private static final Color deadSnakeColor = Color.RED;
    private boolean SnakeIsAlive = true;
    private int lenght = 1;
    public AbstractSnake(int xDirection, int yDirection, Spot head)
    {
        snakeSpots = new LinkedList<Spot>();
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.head = head;
        snakeSpots.add(head);

    }
    public boolean getIsSnakeAlive() {
        return SnakeIsAlive;
    }
    public int increaseOneSnakeLength(){ return ++lenght;};
    public void setSnakeIsAlive(boolean snakeIsAlive) {
        SnakeIsAlive = snakeIsAlive;
    }

    public Spot getHead()
    {
        return head;
    }
    public void up()
    {
        if(yDirection!=1 && yDirection!=-1)
        {
            xDirection = 0;
            yDirection = -1;
            moveOn(false);
        }
    }

    public void right()
    {
        if(xDirection!=-1 && xDirection!= 1)
        {
            xDirection = 1;
            yDirection = 0;
            moveOn(false);
        }
    }

    public void left()
    {
        if(xDirection!=1 && xDirection!=-1 )
        {
            xDirection = -1;
            yDirection = 0;
            moveOn(false);
        }
    }

    public void down()
    {
        if( yDirection!=-1 && yDirection!= 1)
        {
            xDirection = 0;
            yDirection = 1;
            moveOn(false);
        }

    }


    public void moveOn(boolean isEatingFood)
    {
        if(!isEatingFood)
            snakeSpots.remove(0);
        if(xDirection == -1 && head.getX() == 0)
            head = new Spot((head.getX() + xDirection) + 30,head.getY() + yDirection);
        else if(xDirection == 1 && head.getX() == 29)
            head = new Spot((head.getX() + xDirection)%30,head.getY() + yDirection);
        else if(yDirection == -1 && head.getY() == 0)
            head = new Spot(head.getX() + xDirection,(head.getY() + yDirection) + 30);
        else if(yDirection == 1  && head.getY() == 29)
            head = new Spot(head.getX() + xDirection,(head.getY() + yDirection)%30);
        else
            head = new Spot(head.getX() + xDirection,head.getY() + yDirection);
        snakeSpots.add(new Spot(head.getX(),head.getY()));

    }
    public void changeDirection(int xDirection, int yDirection)
    {
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }
    public void addNewPoint(int x, int y)
    {
        snakeSpots.add(new Spot(x,y));
    }
    public List<Spot> getSnake()
    {
        return snakeSpots;
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
