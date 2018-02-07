package models.buildings;

public class Quarry extends Building {
    Quarry() {
        super();
        this.cost = 500;
        this.revenue = 200;
    }

    @Override
    public String toString() {
        return "Quarry";
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
