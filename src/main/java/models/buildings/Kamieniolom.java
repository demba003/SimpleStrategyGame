package models.buildings;

public class Kamieniolom extends Building {
    public Kamieniolom() {
        super();
        this.cost = 500;
        this.revenue = 200;
    }

    @Override
    public String toString() {
        return "Berga";
    }

    @Override
    public void buildFloor() {
        System.out.println("Kopię dół");
    }

    @Override
    public void buildWalls() {
        System.out.println("Buduję ściany Bergi");
    }

    @Override
    public void buildRoof() {
        System.out.println("Buduję zadaszenie nad Bergą");
    }
}
