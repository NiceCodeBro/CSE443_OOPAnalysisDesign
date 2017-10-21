package SnakeGame;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SnakeDecorationOptionBox {
    static boolean selection = false;
    public static boolean askDecoration(String message, String firstDecorativeName, String secondDecorativeName)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Snake Decoration Options");
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        Button firstSelection = new Button(firstDecorativeName);
        Button secondSelection = new Button(secondDecorativeName);

        firstSelection.setOnAction(e->{
            selection = false;
            window.close();
        });
        secondSelection.setOnAction(e->{
            selection = true;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,firstSelection,secondSelection);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return selection;
    }
}
