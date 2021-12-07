package com.company;

import com.company.cars.Car;
import com.company.jrg.Jrg;
import com.company.komendant.Komendant;
import com.company.my_event.MyEvent;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
	// write your code here

        try {

            new Simulation();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
