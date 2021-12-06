package com.company.cars;

import com.company.my_event.MyEvent;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Car {
    private int id;
    private boolean isFree;
    private int counter;

    public Car() {
        idx id = new idx();
        this.id = id.getId();
        this.isFree = true;
        this.counter = 0;
    }

    public void make(MyEvent event){

        //System.out.println("Dzialam: "+ this.getId());
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Skonczylem: "+ this.getId());
        this.setFree(true);

//        if(counter < 31){
//            counter++;
//        }
//        else{
//            counter = 0;
//            setFree(true);
//        }
    }
}
