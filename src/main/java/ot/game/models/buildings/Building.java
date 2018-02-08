package ot.game.models.buildings;

import java.io.Serializable;

public abstract class Building implements Serializable{
    protected int cost;
    protected int revenue;

    public Building(){
        build();
    }

    public int getRevenue() {
        return revenue;
    }

    public int getCost() {
        return cost;
    }

    protected abstract void buildFloor();
    protected abstract void buildWalls();
    protected abstract void buildRoof();

    void build(){
        buildFloor();
        buildWalls();
        buildRoof();
    }
}
