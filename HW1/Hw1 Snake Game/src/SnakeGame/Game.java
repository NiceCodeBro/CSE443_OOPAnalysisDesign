package SnakeGame;

import SnakeGame.DecorationPattern.*;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Game extends Thread {
    private GameScreen gameScreen;
    private GraphicsContext graphicsContext;
    private double totalScore = 0;
    private final double scoreForOneFood = 10;
    public double jobOffer = 0;
    private boolean roundFlag = true;
    private ArrayList<Boolean> roundFlags = new ArrayList<Boolean>();
    private final double levelFactorForOneRound = 5.0;
    private int roundSpeedAdjustment = 10;
    private int power = 2500;
    double highScore = 0;
    public Game(int width, int height, GraphicsContext graphicsContext)
    {
        this.graphicsContext = graphicsContext;
        this.gameScreen = new GameScreen(width,height);
    }
    public Game(int width, int height, GraphicsContext graphicsContext, int snakeType)
    {
        this.graphicsContext = graphicsContext;
        this.gameScreen = new GameScreen(width,height,snakeType);
    }


    public GameScreen getGameScreen() {
        return gameScreen;
    }

    @Override
    public void run()
    {
        calculateHighScore();
        int fps = 0;
        while (true)
        {
            ++fps;
            long start_time = System.currentTimeMillis();

            if(roundFlag) {



                if(power > 0)
                    --power;
                else
                    gameScreen.getSnake().setSnakeIsAlive(false);

                if (gameScreen.getSnake().getIsSnakeAlive()) {
                    if (fps % roundSpeedAdjustment == 0)
                        gameScreen.getSnake().moveOn(false);


                  //  gameScreen.boardUpdate();
                   // gameScreen.paintTable(graphicsContext);
                    gameScreen.isSnakeAlive();


                    gameScreen.checkCollisionSnakeWithFoods();
                    if (gameScreen.produceNewRandomFood(1)) {
                        totalScore += scoreForOneFood * gameScreen.getSnake().getScoreMultiplier();
                       // System.out.println(totalScore);
                        //System.out.println(gameScreen.getSnake().getScoreMultiplier());
                        ++jobOffer ;
                        power += gameScreen.getSnake().getScoreMultiplier();
                    }
                    if(jobOffer%5.0==0.0)
                    {
                        writeNewHighScoreToFile(this.totalScore);
                        updateLevel();
                    }

                }

                gameScreen.boardUpdate();
                gameScreen.paintTable(graphicsContext);


            //   graphicsContext.setTextAlign(TextAlignment.CENTER);
           //     graphicsContext.setTextBaseline(VPos.CENTER);

                if(gameScreen.getSnake().getIsSnakeAlive())
                {
                    graphicsContext.setFill(Color.BLACK);
                    graphicsContext.fillText(
                            "  Round: " + ((int) (this.jobOffer / 5) + 1) + "    Score: " + this.totalScore +  "    High Score: " + highScore + "    Score Factor: x" +
                                    this.gameScreen.getSnake().getScoreMultiplier() + "   Power: " + power ,

                            0,
                            620
                    );
                }
                else
                {
                    graphicsContext.setFill(Color.RED);
                    graphicsContext.fillText(
                            "                             GAME OVER !!!       ",

                            0,
                            620
                    );
                }

            }

            while ((System.currentTimeMillis() - start_time) < 20) ;
        }

    }

    public void updateLevel()
    {

        if(jobOffer == levelFactorForOneRound && roundFlags.size() == ((jobOffer/levelFactorForOneRound)-1))
        {
            increaseRound();
            roundFlag = false;
            roundFlags.add(roundFlag);

            Platform.runLater(new Runnable() {
                @Override
                public void run()
                {
                    Boolean result = SnakeDecorationOptionBox.askDecoration("Round 1 ended. Please choice one decoration..", CourseDecoration.decoratorName , InternshipDecoration.decoratorName);
                    if(result == true)
                        gameScreen.setSnake(new CourseDecoration (gameScreen.getSnake()));
                    else
                        gameScreen.setSnake(new InternshipDecoration (gameScreen.getSnake()));

                    roundFlag = true;
                }
            });
        }
        else if(jobOffer == (levelFactorForOneRound*2) && roundFlags.size() == (int)((jobOffer/(levelFactorForOneRound))-1))
        {
            increaseRound();
            roundFlag = false;
            roundFlags.add(roundFlag);

            Platform.runLater(new Runnable() {
                @Override
                public void run()
                {
                    Boolean result = SnakeDecorationOptionBox.askDecoration("Round 2 ended. Please choice one decoration..", ForeignLanguagesDecoration.decoratorName , TrainingCertificatesDecorations.decoratorName);
                    if(result == true)
                        gameScreen.setSnake(new ForeignLanguagesDecoration (gameScreen.getSnake()));
                    else
                        gameScreen.setSnake(new TrainingCertificatesDecorations (gameScreen.getSnake()));

                    roundFlag = true;
                }
            });
        }
        else if(jobOffer == (levelFactorForOneRound*3) && roundFlags.size() == (int)((jobOffer/(levelFactorForOneRound))-1))
        {
            increaseRound();
            roundFlag = false;
            roundFlags.add(roundFlag);

            Platform.runLater(new Runnable() {
                @Override
                public void run()
                {
                    Boolean result = SnakeDecorationOptionBox.askDecoration("Round 3 ended. Please choice one decoration..", HealthInsuranceDecoration.decoratorName , JavaDecoration.decoratorName);
                    if(result == true)
                        gameScreen.setSnake(new HealthInsuranceDecoration (gameScreen.getSnake()));
                    else
                        gameScreen.setSnake(new JavaDecoration (gameScreen.getSnake()));

                    roundFlag = true;
                }
            });
        }

        else if(jobOffer == (levelFactorForOneRound*4) && roundFlags.size() == (int)((jobOffer/(levelFactorForOneRound))-1))
        {
            increaseRound();
            roundFlag = false;
            roundFlags.add(roundFlag);

            Platform.runLater(new Runnable() {
                @Override
                public void run()
                {
                    Boolean result = SnakeDecorationOptionBox.askDecoration("Round 4 ended. Please choice one decoration..",SportDecoration.decoratorName , MasterDecoration.decoratorName);
                    if(result == true)
                        gameScreen.setSnake(new SportDecoration (gameScreen.getSnake()));
                    else
                        gameScreen.setSnake(new MasterDecoration (gameScreen.getSnake()));

                    roundFlag = true;
                }
            });
        }
        else if(jobOffer == (levelFactorForOneRound*5) && roundFlags.size() == (int)((jobOffer/(levelFactorForOneRound))-1))
        {
            increaseRound();
            roundFlag = false;
            roundFlags.add(roundFlag);

            Platform.runLater(new Runnable() {
                @Override
                public void run()
                {
                    Boolean result = SnakeDecorationOptionBox.askDecoration("Round 5 ended. Please choice one decoration..",LottaryDecoration.decoratorName , FantasticDecoration.decoratorName);
                    if(result == true)
                        gameScreen.setSnake(new LottaryDecoration (gameScreen.getSnake()));
                    else
                        gameScreen.setSnake(new FantasticDecoration (gameScreen.getSnake()));

                    roundFlag = true;
                }
            });
        }

    }

    private void increaseRound()
    {
        if(this.roundSpeedAdjustment>2)
            this.roundSpeedAdjustment -= 2;
    }

    private void calculateHighScore()
    {
        try {
            File file = new File("highscore.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String _score;
            while ((_score = bufferedReader.readLine()) != null) {
                highScore = Double.parseDouble(_score);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeNewHighScoreToFile(double score)
    {
       // System.out.println(score);
        if(score > this.highScore)
        {
            String _score = "" + score;
            File file = new File("highscore.txt");
            try {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file,false));

                fileWriter.write(_score);

                fileWriter.close();

            } catch (IOException ex) {
            }
        }

    }
}
//https://www.gamedev.net/forums/topic/311331-how-do-i-set-30-fps-in-a-java-game-loop/