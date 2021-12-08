package com.company.cars;

public class IdxCar {
    private static int id = 0;

    public int getId(){
        id++;
        return id;
    }
}
