package ot.game.models.buildings;

public class Sawmill extends Building {
    Sawmill() {
        super();
        this.cost = 3000;
        this.revenue = 500;
    }

    @Override
    public String toString() {
        return "Sawmill";
    }

    @Override
    public void buildFloor() {
        System.out.println("Building floor of " + toString());
    }

    @Override
    public void buildWalls() {
        System.out.println("Building walls of " + toString());
    }

    @Override
    public void buildRoof() {
        System.out.println("Building roof of " + toString());
    }
}
