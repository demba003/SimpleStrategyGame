package ot.game.models;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Player implements Serializable {
    private int money;

    public Player() {
        this.money = 2000;
    }

    public int getMoney(){
        return money;
    }

    public void addMoney(int money) {
        if(money >= 0) {
            this.money += money;
        }
    }

    public boolean buy(int cost){
        if (cost <= money) {
            money -= cost;
            return true;
        }
        return false;
    }
}
