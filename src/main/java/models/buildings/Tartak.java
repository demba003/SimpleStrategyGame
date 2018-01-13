package models.buildings;

public class Tartak extends Building {
    public Tartak() {
        super();
        this.cost = 3000;
        this.revenue = 500;
    }

    @Override
    public String toString() {
        return "Tartak";
    }

    @Override
    public void buildFloor() {
        System.out.println("Buduję podłogę Tartaku");
    }

    @Override
    public void buildWalls() {
        System.out.println("Buduję ściany Tartakua");
    }

    @Override
    public void buildRoof() {
        System.out.println("Buduję dach Tartakua");
    }
}
