package SnakeGame;


import SnakeGame.DecorationPattern.Anaconda;
import SnakeGame.DecorationPattern.Piton;
import SnakeGame.DecorationPattern.Snake;
import SnakeGame.DecorationPattern.Viper;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.*;

public class GameScreen {
    private static final Color color = Color.BLACK;
    private static final int BACKGROUND = 0;
    private static final int SNAKE = 1;
    private static final int FOOD = -1;

    private List<Food> foods;
    private Snake snake;
    private int WIDTH, HEIGHT;
    private static final int SIZE = 20;
    private int[][] table;




    public GameScreen(int width, int height)
    {
        WIDTH = width;
        HEIGHT = height;
        snake = new Viper(0,0,new Spot(10,10));
        table = new int[HEIGHT/SIZE][WIDTH/SIZE];
        foods = new ArrayList<Food>();
    }

    public GameScreen(int width, int height, int snakeType)
    {
        WIDTH = width;
        HEIGHT = height;
        table = new int[HEIGHT/SIZE][WIDTH/SIZE];
        foods = new ArrayList<Food>();

        if(snakeType==0)
        {
            snake = new Viper(0,0,new Spot(10,10));
        }
        else if(snakeType == 1)
        {
            snake = new Anaconda(0,0,new Spot(10,10));
        }
        else //if(snakeType == 2)
        {
            snake = new Piton(0,0,new Spot(10,10));
        }
    }

    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }
    public void paintTable(GraphicsContext context)
    {
        for(int i = 0; i < HEIGHT/SIZE; ++i)
        {
            for(int j = 0; j < WIDTH/SIZE; ++j)
            {
                if(table[i][j] == BACKGROUND) // it means background
                {
                    context.setFill(GameScreen.color);
                    context.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                }
                else if(table[i][j] == SNAKE) //it means viper
                {
                    if(this.snake.getIsSnakeAlive())
                        context.setFill(snake.getSnakeColor());
                    else
                        context.setFill(snake.getDeadSnakeColor());
                    context.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                }
                else if(table[i][j] == FOOD) //it means food
                {
                    context.setFill(Food.color);
                    context.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
                }

            }
        }

        context.setFill(Color.WHITE);
        context.fillRect(0,HEIGHT,WIDTH,HEIGHT+50);

    }

    public Snake getSnake()
    {
        return snake;
    }
    public void checkCollisionSnakeWithFoods()
    {
        for(int i = 0; i < this.foods.size(); ++i)
        {
            Food food = this.foods.get(i);
            if(getSnake().getHead().equals(food.getFood()))
            {
                snake.moveOn(true);
                foods.remove(i);
                return;
            }
        }


    }
    public boolean isSnakeAlive()
    {
        if(this.snake.getSnake().size()>1 )
        {
            List<Spot> tempSnake = new LinkedList<Spot>(this.snake.getSnake());
            tempSnake.remove(tempSnake.size()-1);

           if(tempSnake.contains(this.snake.getHead()))
           {
               this.getSnake().setSnakeIsAlive(false);
               return false;
           }

        }
        this.getSnake().setSnakeIsAlive(true);
        return true;

    }
    public void boardUpdate()
    {
        //snake cordinates update
        for(int i = 0; i < HEIGHT/SIZE;++i)
            Arrays.fill(table[i],0);
        for(Spot spot: snake.getSnake())
        {
            table[spot.getX()][spot.getY()] = SNAKE;
        }

        for(Food food:foods)
        {
            table[food.getFood().getX()][food.getFood().getY()] = FOOD;
        }
    }

    public boolean produceNewRandomFood(int nFood)
    {

        int x,y;
        Random random = new Random();

        boolean flag;
        if(foods.size()<nFood)
        {
            do
            {
                flag = false;
                x = random.nextInt(WIDTH/SIZE);
                y = random.nextInt(HEIGHT/SIZE);
                for(Spot spott: snake.getSnake())
                {
                    if(spott.equals(new Spot(x,y)))
                        flag = true;
                }
                for(Food food:foods)
                {
                    if(food.equals(new Spot(x,y)))
                        flag = true;
                }
            }while (flag && foods.size()<nFood);

            //table[x][y] = FOOD;
            foods.add(new Food(new Spot(x,y)));

            return true;
        }


        return false;
    }

}
