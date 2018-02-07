package ot.game.models.buildings;

public class Mint extends Building {
    Mint() {
        super();
        this.cost = 10000;
        this.revenue = 3000;
    }

    @Override
    public String toString() {
        return "Mint";
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
