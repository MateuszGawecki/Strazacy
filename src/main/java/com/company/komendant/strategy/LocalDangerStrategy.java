package com.company.komendant.strategy;

import com.company.my_event.MyEvent;

public class LocalDangerStrategy implements Strategy{
    @Override
    public int doOperation() {
        return 3;
    }
}
