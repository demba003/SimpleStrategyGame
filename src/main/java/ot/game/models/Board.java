package ot.game.models;

import org.springframework.stereotype.Component;
import ot.game.models.buildings.Building;

import java.io.Serializable;

@Component
public class Board implements Serializable {
    private int sizeX, sizeY;
    private Building[][] board;

    public Board() {
        this(7,5);
    }

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        board = new Building[sizeY][sizeX];
    }

    public void set(int row, int column, Building building){
        board[row][column] = building;
    }

    public Building get(int row, int column){
        return board[row][column];
    }
}
