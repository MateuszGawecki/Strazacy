package com.company;

import com.company.komendant.Komendant;
import com.company.my_event.MyEvent;

import java.util.concurrent.TimeUnit;

public class Simulation {
    public Simulation() throws InterruptedException {
        Komendant komendant = new Komendant();
        Prepare.prepare(komendant);

        for(;;){
            TimeUnit.SECONDS.sleep(1); // częstośc zgłoszeń
            if(!komendant.notifyObservers(new MyEvent())) break;
        }
    }
}
