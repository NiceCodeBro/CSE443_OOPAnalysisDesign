package SnakeGame;


import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;


public class Main extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private GraphicsContext graphicsContext;


    @Override
    public void start(Stage primaryStage) throws Exception {
        /*********************/
        //These are about game scene, not menu
       // GameScreen gameScreen = new GameScreen(WIDTH,HEIGHT);
        StackPane stackPane = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT+50);
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        /*********************/

        VBox layout= new VBox(20);

        Label labelfirst= new Label("You can start to game with Ctrl+X shortcut. Default snake Viper. \n Click snake type do you want.");
        Button anacondaButton = new Button("Anaconda");
        Button viperButoon = new Button("Viper");
        Button pitonButton = new Button("Piton");

        // Create MenuBar
        MenuBar menuBar = new MenuBar();
        // Create menus
        Menu fileMenu = new Menu("Start");
        // Create MenuItems
        MenuItem startGame = new MenuItem("Start");
        // Set Accelerator for Exit MenuItem.
        startGame.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        startGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game game = new Game(WIDTH, HEIGHT,graphicsContext);
                canvas.setOnKeyPressed(e -> {
                    keyListenerHelper(e,game.getGameScreen());
                });
                stackPane.getChildren().add(canvas);

                Scene scene = new Scene(stackPane);
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.setTitle("SnakeGame");
                primaryStage.show();
                game.start();
            }
        });


        anacondaButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game game = new Game(WIDTH, HEIGHT,graphicsContext,1);
                canvas.setOnKeyPressed(e -> {
                    keyListenerHelper(e,game.getGameScreen());
                });

                stackPane.getChildren().addAll(canvas);
                Scene scene = new Scene(stackPane);
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.setTitle("SnakeGame");
                primaryStage.show();
                game.start();
            }
        });
        viperButoon.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game game = new Game(WIDTH, HEIGHT,graphicsContext,0);
                canvas.setOnKeyPressed(e -> {
                    keyListenerHelper(e,game.getGameScreen());
                });
                stackPane.getChildren().add(canvas);

                Scene scene = new Scene(stackPane);
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.setTitle("SnakeGame");
                primaryStage.show();
                game.start();
            }
        });

        pitonButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game game = new Game(WIDTH, HEIGHT,graphicsContext,2);
                canvas.setOnKeyPressed(e -> {
                    keyListenerHelper(e,game.getGameScreen());
                });
                stackPane.getChildren().add(canvas);

                Scene scene = new Scene(stackPane);
                primaryStage.setResizable(false);
                primaryStage.setScene(scene);
                primaryStage.setTitle("SnakeGame");
                primaryStage.show();
                game.start();


            }
        });

        fileMenu.getItems().addAll( startGame);
        menuBar.getMenus().addAll(fileMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        layout.getChildren().addAll(root,labelfirst,anacondaButton,viperButoon,pitonButton);

        Scene scene = new Scene(layout, WIDTH, HEIGHT);

        primaryStage.setTitle("SnakeGame");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
            public void handle(WindowEvent e){
                try {
                    Platform.exit();
                    System.exit(0);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }




    public void keyListenerHelper(KeyEvent e, GameScreen gameScreen)
    {
        if(gameScreen.getSnake().getIsSnakeAlive())
            switch (e.getCode()) {
                case UP:
                    //System.out.println("UP");
                    gameScreen.getSnake().up();
                    break;
                case RIGHT:
                    //System.out.println("RIGHT");
                    gameScreen.getSnake().right();
                    break;
                case DOWN:
                   // System.out.println("DOWN");
                    gameScreen.getSnake().down();
                    break;
                case LEFT:
                    //System.out.println("LEFT");
                    gameScreen.getSnake().left();
                    break;
            }
    }
    public static void main(String[] args) {

        Application.launch(args);

    }
}
