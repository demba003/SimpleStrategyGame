package ot.game.models.buildings;

public class BuildingFactory {
    public static Building build(Buildings buildings){
        switch (buildings) {
            case SAWMILL:
                return new Sawmill();
            case MINT:
                return new Mint();
            case MINE:
                return new Mine();
            case QUARRY:
                return new Quarry();
            case LUMBERJACK_HUT:
                return new LumberjackHut();
            default:
                return null;
        }
    }
}
