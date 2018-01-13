package models.buildings;

public class ChatkaDrwala extends Building {
    public ChatkaDrwala() {
        super();
        this.cost = 1500;
        this.revenue = 300;
    }

    @Override
    public String toString() {
        return "Chałpa drwala";
    }

    @Override
    public void buildFloor() {
        System.out.println("Buduję podłogę Chałpy Drwala");
    }

    @Override
    public void buildWalls() {
        System.out.println("Buduję ściany Chałpy Drwala");
    }

    @Override
    public void buildRoof() {
        System.out.println("Buduję dach Chałpy Drwala");
    }
}
