package ot.game.saves;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("careTakerComponent")
public class CareTaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int index){
        Memento memento = mementoList.get(index);
        mementoList.remove(index+1);
        return memento;
    }
}