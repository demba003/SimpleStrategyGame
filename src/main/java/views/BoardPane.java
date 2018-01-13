package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import models.Board;


import java.io.Serializable;


public class BoardPane extends Pane implements Serializable{
    private int sizeX = 7, sizeY = 5;
    private Button[][] buttons = new Button[sizeY][sizeX];

    public BoardPane(EventHandler<ActionEvent> buttonHandler) {
        for (int row = 0; row < sizeY; row++) {
            for (int column = 0; column < sizeX; column++){
                buttons[row][column] = new Button();
                buttons[row][column].setPrefSize(100,100);
                buttons[row][column].setLayoutX(column * 100);
                buttons[row][column].setLayoutY(row * 100);
                buttons[row][column].setStyle("-fx-background-color: chartreuse; -fx-background-radius: 0; -fx-border-color: black");
                buttons[row][column].setOnAction(buttonHandler);
            }
        }

        for (int row = 0; row < sizeY; row++){
            this.getChildren().addAll(buttons[row]);
        }
    }

    public void loadBoard(Board board){
        for (int row = 0; row < sizeY; row++) {
            for (int column = 0; column < sizeX; column++){
                if(board.get(row, column) != null) {
                    buttons[row][column].setText(board.get(row, column).toString());
                    buttons[row][column].setDisable(true);
                }
                else {
                    buttons[row][column].setText("");
                    buttons[row][column].setDisable(false);
                }

            }
        }
    }

    public int getRow(Button button) {
        for (int row = 0; row < sizeY; row++) {
            for (int column = 0; column < sizeX; column++) {
                if (buttons[row][column] == button) return row;
            }
        }
        return -1;
    }

    public int getColumn(Button button) {
        for (int row = 0; row < sizeY; row++) {
            for (int column = 0; column < sizeX; column++) {
                if (buttons[row][column] == button) return column;
            }
        }
        return -1;
    }
}