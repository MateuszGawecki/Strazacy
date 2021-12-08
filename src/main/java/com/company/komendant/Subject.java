package com.company.komendant;

import com.company.jrg.Observer;
import com.company.my_event.MyEvent;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public boolean notifyObservers(MyEvent event);
}
