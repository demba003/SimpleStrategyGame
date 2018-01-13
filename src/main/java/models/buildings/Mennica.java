package models.buildings;

public class Mennica extends Building {
    public Mennica() {
        super();
        this.cost = 10000;
        this.revenue = 3000;
    }

    @Override
    public String toString() {
        return "Mennica";
    }

    @Override
    public void buildFloor() {
        System.out.println("Buduję podłogę Mennicy");
    }

    @Override
    public void buildWalls() {
        System.out.println("Buduję ściany Mennicy");
    }

    @Override
    public void buildRoof() {
        System.out.println("Buduję dach Mennicy");
    }
}
