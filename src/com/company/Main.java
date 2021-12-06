package com.company;

import com.company.cars.Car;
import com.company.jrg.Jrg;
import com.company.komendant.Komendant;
import com.company.my_event.MyEvent;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Jrg jrg1 = new Jrg(50.060026506499206,19.942913687967124,1);
        Jrg jrg2 = new Jrg(50.03381017495707, 19.937377226612714,2);
        Jrg jrg3 = new Jrg(50.084966689684386, 19.863450590629313,3);
        Jrg jrg4 = new Jrg(50.0378530292807, 20.005756855014358,4);
        Jrg jrg5 = new Jrg(50.09234339349529, 19.922380485906324,5);
        Jrg jrg6 = new Jrg(50.0164523302028, 20.017011360064917,6);
        Jrg jrg7 = new Jrg(50.09411730070909, 19.977544822836308,7);

        Jrg SA = new Jrg(50.07841255948872, 20.036627991006,8);
        Jrg Skawina = new Jrg(49.99067039026655, 19.736245522102028,9);
        Jrg LSP = new Jrg(50.08267540079839, 19.813889338168238,10);

        Komendant komendant = new Komendant();
        komendant.registerObserver(jrg1);
        komendant.registerObserver(jrg2);
        komendant.registerObserver(jrg3);
        komendant.registerObserver(jrg4);
        komendant.registerObserver(jrg5);
        komendant.registerObserver(jrg6);
        komendant.registerObserver(jrg7);

        komendant.registerObserver(SA);
        komendant.registerObserver(Skawina);
        komendant.registerObserver(LSP);


        //komendant.notifyObservers(new MyEvent());
        for(;;){
            //TimeUnit.SECONDS.sleep(1);
            if(!komendant.notifyObservers(new MyEvent())) break;
        }

    }
}
