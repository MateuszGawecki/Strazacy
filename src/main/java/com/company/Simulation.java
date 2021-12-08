package com.company;

import com.company.komendant.Komendant;
import com.company.my_event.MyEvent;

import java.util.concurrent.TimeUnit;

public class Simulation {
    public Simulation() throws InterruptedException {
        Komendant komendant = new Komendant();
        Prepare.prepare(komendant);

        do {
            TimeUnit.SECONDS.sleep(1); // częstośc zgłoszeń
        } while (komendant.notifyObservers(new MyEvent()));

        System.out.println("\n\tSymulacja zakończona - brak wozów!");
    }
}
