package com.company.jrg;

import com.company.cars.Car;
import com.company.my_event.MyEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;



@Getter
public class Jrg implements Observer{
    private String name;
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

    public Jrg(double x, double y, int id, String name) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name=name;
        this.cars = new ArrayList<>();

        for(int i=0; i<5; i++){
            cars.add(new Car());
        }
    }

    @Override
    public void update(MyEvent event, int numberOfCars, boolean isReal) {

        for (Car car: cars) {
            if(numberOfCars == 0) break;

            if(car.isFree()){
                numberOfCars--;
                sendCar(event,isReal,car);
            }

        }
    }

    private void sendCar(MyEvent event, boolean isReal, Car car) {
        car.setFree(false);
        System.out.println("Dzialam: "+ car.getId() + " Zdarzenie id: " + event.getId());
        new Thread( () -> car.make(isReal)).start();
    }
}
