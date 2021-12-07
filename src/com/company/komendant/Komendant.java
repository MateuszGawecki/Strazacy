package com.company.komendant;

import com.company.jrg.Jrg;
import com.company.jrg.Observer;
import com.company.komendant.strategy.LocalDangerStrategy;
import com.company.komendant.strategy.PozarStrategy;
import com.company.my_event.MyEvent;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Komendant implements Subject{
    private List<Observer> observers;

    public Komendant() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int observerIndex = observers.indexOf(o); //Do I have this observer?
        if (observerIndex >= 0) {
            observers.remove(observerIndex);
        }
    }

    @Override
    public boolean notifyObservers(MyEvent event) {
        HashMap<Jrg, Double> dists = new HashMap<>();

        for(Observer observer : observers){
            dists.put((Jrg) observer, getDist(observer,event));
        }

        sortByValue(dists);

        int neededCars = doOperation(event);

        System.out.println(event.doAction()
                ? "Pozar: " + event.getId() + " neededCars: " + neededCars
                : "Miejscowe zagrozenie: " + event.getId() + " neededCars: " + neededCars);

        boolean isReal = new Random().nextInt(100) < 5;

        for(Jrg jrg : dists.keySet()){
            if(jrg.getFreeCarsCount()>= neededCars){
                jrg.update(event,neededCars, isReal);
                neededCars = 0;
                break;
            }else{
                neededCars -= jrg.getFreeCarsCount();
                jrg.update(event,jrg.getFreeCarsCount(), isReal);
            }
        }

        return neededCars == 0;
    }

    private double getDist(Observer observer, MyEvent event){
        Jrg jrg = (Jrg) observer;

        return sqrt(pow((jrg.getX() - event.getX()),2) + pow((jrg.getY() - event.getY()),2));
    }

    public int doOperation(MyEvent event) {
        if(event.getState().doAction()){
            return new PozarStrategy().doOperation();
        }else{
            return new LocalDangerStrategy().doOperation();
        }
    }

    //Sortowanie mapy po value
    public HashMap<Jrg, Double> sortByValue(HashMap<Jrg, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Jrg, Double> > list
                = new LinkedList<Map.Entry<Jrg, Double> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<Jrg, Double> temp
                = new LinkedHashMap<Jrg, Double>();
        for (Map.Entry<Jrg, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
