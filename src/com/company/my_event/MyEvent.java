package com.company.my_event;

import com.company.my_event.states.Fire;
import com.company.my_event.states.LocalDanger;
import com.company.my_event.states.State;
import lombok.Getter;

import java.util.Random;

@Getter
public class MyEvent implements State{
    private int id;
//    private boolean pozar;
    private State state;
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

        if(random.nextInt(10) < 3){
            this.state = new Fire();
        }else{
            this.state = new LocalDanger();
        }

        this.x = random.nextDouble() * (maxX-minX) + minX;
        this.y = random.nextDouble() * (maxY-minY) + minY;
    }

    @Override
    public boolean doAction() {
        return this.getState().doAction();
    }
}
