package SnakeGame;

import javafx.scene.paint.Color;

public class Food {
    private boolean isEaten = false;
    public static final Color color = Color.GREEN;
    private Spot food;
    public Food(Spot food)
    {
        this.food = food;
    }

    public Spot getFood() {
        return food;
    }

    public void setFood(Spot food) {
        this.food = food;
    }

    public boolean getIsEaten(){ return isEaten;}
}
