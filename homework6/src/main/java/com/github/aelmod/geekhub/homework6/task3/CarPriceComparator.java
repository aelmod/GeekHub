package com.github.aelmod.geekhub.homework6.task3;

import java.util.Comparator;

/**
 * Created by aelmod-notebook on 01.12.2016.
 */
public class CarPriceComparator implements Comparator<Car> {
    public int compare(Car a, Car b) {
        if (a.getPrice() > b.getPrice())
            return 1;
        else if (a.getPrice() < b.getPrice())
            return -1;
        else
            return 0;
    }
}
