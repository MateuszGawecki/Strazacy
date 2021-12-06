package com.company.jrg;

import com.company.my_event.MyEvent;

public interface Observer {
    public void update(MyEvent event, int numberOfCars);
}
