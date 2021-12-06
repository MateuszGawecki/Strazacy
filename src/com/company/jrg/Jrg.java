package com.company.jrg;

import com.company.cars.Car;
import com.company.my_event.MyEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Jrg implements Observer{
    private int id;
    private double x;
    private double y;
    private List<Car> cars;

    public int getFreeCarsCount(){
        int count =0;
        for (Car car : cars){
            if(car.isFree()){
                count++;
            }
        }

        return count;
    }

    public Jrg(double x, double y, int id) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.cars = new ArrayList<>();

        for(int i=0; i<5; i++){
            cars.add(new Car());
        }
    }

    @Override
    public void update(MyEvent event, int numberOfCars) {

        for (Car car: cars) {

            if(car.isFree()){
                car.setFree(false);
                numberOfCars--;
                System.out.println("Dzialam: "+ car.getId() + " Zdarzenie id: " + event.getId());
                new Thread( () -> car.make(event)).start();

                if(numberOfCars == 0) break;
            }

        }
    }
}
