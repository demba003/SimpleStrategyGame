package models.buildings;

public class BuildingFactory {
    public static Building build(Buildings buildings){
        switch (buildings){
            case Tartak:
                return new Tartak();
            case Mennica:
                return new Mennica();
            case Kopalnia:
                return new Kopalnia();
            case Kamieniolom:
                return new Kamieniolom();
            case ChatkaDrwala:
                return new ChatkaDrwala();
        }
        return null;
    }
}
