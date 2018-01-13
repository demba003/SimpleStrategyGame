import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import models.Board;
import views.BoardPane;
import models.buildings.*;
import models.Player;
import saves.CareTaker;
import saves.Originator;
import saves.State;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable, EventHandler<ActionEvent>{
    @FXML private Pane boardPaneHolder;
    @FXML private Button button_mennica;
    @FXML private Button button_kopalnia;
    @FXML private Button button_tartak;
    @FXML private Button button_kamieniolom;
    @FXML private Button button_chatka;
    @FXML private Button button_back;
    @FXML private Text player_gold;
    //@FXML private Text player_revenue;

    private Buildings active;
    private Thread buildingUpdater;
    private Originator originator;
    private CareTaker careTaker;
    private int movecount = -1;

    private ArrayList<Building> buildings;
    private Player player;
    private BoardPane boardPane;
    private Board board;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildings = new ArrayList<>();
        player = new Player();
        originator = new Originator();
        careTaker = new CareTaker();
        board = new Board();

        boardPane = new BoardPane(this);
        boardPaneHolder.getChildren().add(boardPane);

        button_chatka.setOnAction(event -> active = Buildings.ChatkaDrwala);

        button_kamieniolom.setOnAction(event -> active = Buildings.Kamieniolom);

        button_tartak.setOnAction(event -> active = Buildings.Tartak);

        button_kopalnia.setOnAction(event -> {
            if (Controller.this.hasRequiredBuildings()) {
                active = Buildings.Kopalnia;
            }
        });

        button_mennica.setOnAction(event -> {
            if (Controller.this.hasRequiredBuildings()) {
                active = Buildings.Mennica;
            }
        });

        button_back.setOnAction(event -> {
            if(movecount > 0){
                movecount--;
                originator.getStateFromMemento(careTaker.get(movecount));

                buildings = (ArrayList<Building>) Copier.copy(originator.getState().getBuildings());
                board = (Board) Copier.copy(originator.getState().getBoardPane());
                player = (Player) Copier.copy(originator.getState().getPlayer());

                boardPane.loadBoard(board);
            }

            updateBuildings();
        });

        buildingUpdater = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(careTaker.mementoList);
                    for (Building building : buildings){
                        player.addMoney(building.getRevenue());
                    }
                    updateBuildings();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        buildingUpdater.start();

        originator.setState(new State((ArrayList<Building>) Copier.copy(buildings), (Player) Copier.copy(player), (Board) Copier.copy(board)));
        careTaker.add(originator.saveStateToMemento());
        movecount++;
    }

    private boolean hasRequiredBuildings(){
        boolean hasTartak = false, hasKamieniolom = false, hasChatka = false;
        for (Building building : buildings) {
            if(building instanceof ChatkaDrwala) hasChatka = true;
            if(building instanceof Kamieniolom) hasKamieniolom = true;
            if(building instanceof Tartak) hasTartak = true;
        }
        return (hasChatka && hasKamieniolom && hasTartak);
    }

    private void updateBuildings() {
        player_gold.setText(String.valueOf(player.getMoney()));

        if(player.getMoney() >= 10000 && hasRequiredBuildings()) button_mennica.setDisable(false);
        else button_mennica.setDisable(true);

        if(player.getMoney() >= 5000 && hasRequiredBuildings()) button_kopalnia.setDisable(false);
        else button_kopalnia.setDisable(true);

        if(player.getMoney() >= 3000) button_tartak.setDisable(false);
        else button_tartak.setDisable(true);

        if(player.getMoney() >= 500) button_kamieniolom.setDisable(false);
        else button_kamieniolom.setDisable(true);

        if(player.getMoney() >= 1500) button_chatka.setDisable(false);
        else button_chatka.setDisable(true);
    }

    @Override
    public void handle(ActionEvent event) {
        if(active != null){
            Building building = BuildingFactory.build(active);
            if (player.buy(building.getCost())){
                Button button = (Button) event.getSource();
                button.setText(building.toString());
                button.setDisable(true);
                buildings.add(building);
                active = null;
                board.set(
                        boardPane.getRow((Button)event.getSource()),
                        boardPane.getColumn((Button) event.getSource()),
                        building);

                originator.setState(new State((ArrayList<Building>) Copier.copy(buildings), (Player) Copier.copy(player), (Board) Copier.copy(board)));
                careTaker.add(originator.saveStateToMemento());
                movecount++;
                System.out.println(movecount);
                updateBuildings();
            }
        }
    }

    public void onWindowClose() {
        buildingUpdater.interrupt();
    }
}


