package ot.game.saves;

import ot.game.models.Board;
import ot.game.models.Player;
import ot.game.models.buildings.Building;

import java.util.List;

public class State {
    private final List<Building> buildings;
    private final Player player;
    private final Board board;

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
