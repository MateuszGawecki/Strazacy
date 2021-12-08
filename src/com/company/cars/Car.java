package com.company.cars;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Car {
    private int id;
    private boolean isFree;

    public Car() {
        IdxCar id = new IdxCar();
        this.id = id.getId();
        this.isFree = true;
    }

    public void make(boolean isReal){

        this.setFree(false);
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(random.nextInt(4));

            if(isReal){
                TimeUnit.SECONDS.sleep(random.nextInt(20) + 5);
            }

            TimeUnit.SECONDS.sleep(random.nextInt(4));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Skonczylem: "+ this.getId());
        this.setFree(true);
    }
}
