package ot.game.saves;

import ot.game.models.Board;
import ot.game.models.Player;
import ot.game.models.buildings.Building;

import java.util.List;

public class State {
    private List<Building> buildings;
    private Player player;
    private Board board;

    public State(List<Building> buildings, Player player, Board board) {
        this.buildings = buildings;
        this.player = player;
        this.board = board;
    }

    public List<Building> getBuildings() {
        return this.buildings;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Board getBoardPane() {
        return this.board;
    }
}
