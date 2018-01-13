package models.buildings;

public class Kopalnia extends Building{
    public Kopalnia() {
        super();
        this.cost = 5000;
        this.revenue = 100;
    }

    @Override
    public String toString() {
        return "Gruba złota";
    }

    @Override
    public void buildFloor() {
        System.out.println("Buduję podłogę Gruby złota");
    }

    @Override
    public void buildWalls() {
        System.out.println("Buduję ściany Gruby złota");
    }

    @Override
    public void buildRoof() {
        System.out.println("Buduję sufit Gruby złota");
    }
}
