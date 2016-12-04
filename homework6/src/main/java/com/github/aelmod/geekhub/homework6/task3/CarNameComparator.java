package com.github.aelmod.geekhub.homework6.task3;

import java.util.Comparator;

/**
 * Created by aelmod-notebook on 01.12.2016.
 */
public class CarNameComparator implements Comparator<Car> {
        public int compare(Car a, Car b){
            return a.getName().compareTo(b.getName());
        }
}
