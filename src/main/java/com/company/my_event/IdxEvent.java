package com.company.my_event;

public class IdxEvent {
    private static int id=0;

    public int getId(){
        id++;
        return id;
    }
}
