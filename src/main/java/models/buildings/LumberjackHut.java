package models.buildings;

public class LumberjackHut extends Building {
    LumberjackHut() {
        super();
        this.cost = 1500;
        this.revenue = 300;
    }

    @Override
    public String toString() {
        return "Lumberjack hut";
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
