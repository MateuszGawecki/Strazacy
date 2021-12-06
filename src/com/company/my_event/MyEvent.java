package com.company.my_event;

import lombok.Getter;

import java.util.Random;

@Getter
public class MyEvent {
    private int id;
    private boolean pozar;
    private double x;
    private double y;

    public MyEvent() {
        double maxX = 50.154564013341734;
        double minX = 49.95855025648944;
        double maxY = 20.02470275868903;
        double minY = 19.688292482742394;

        Idx idx = new Idx();

        this.id= idx.getId();

        Random random = new Random();

        this.pozar= random.nextInt(10) < 3;

        this.x = random.nextDouble() * (maxX-minX) + minX;
        this.y = random.nextDouble() * (maxY-minY) + minY;
    }
}
