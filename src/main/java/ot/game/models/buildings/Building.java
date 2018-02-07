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

    public abstract void buildFloor();
    public abstract void buildWalls();
    public abstract void buildRoof();

    void build(){
        buildFloor();
        buildWalls();
        buildRoof();
    }
}
