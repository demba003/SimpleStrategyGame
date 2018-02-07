package models.buildings;

public class Mine extends Building{
    Mine() {
        super();
        this.cost = 5000;
        this.revenue = 100;
    }

    @Override
    public String toString() {
        return "Gold Mine";
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
