package saves;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    public List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int index){
        Memento memento = mementoList.get(index);
        mementoList.remove(index+1);
        return memento;
    }
}