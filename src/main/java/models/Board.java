package models;

import models.buildings.Building;

import java.io.Serializable;

public class Board implements Serializable {
    private int sizeX = 7, sizeY = 5;
    private Building[][] board = new Building[sizeY][sizeX];

    public Board() {
    }

    public void set(int row, int column, Building building){
        board[row][column] = building;
    }

    public Building get(int row, int column){
        return board[row][column];
    }
}