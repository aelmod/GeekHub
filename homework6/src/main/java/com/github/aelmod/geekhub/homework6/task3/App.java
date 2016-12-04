package com.github.aelmod.geekhub.homework6.task3;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Євгеній on 28.11.2016.
 */
public class App {
    public static void main(String[] args) {
        Comparator<Car> pcomp = new CarNameComparator().thenComparing(new CarPriceComparator());
        //Comparator<Car> pcomp = new CarPriceComparator();
        List<Car> cars = new ArrayList<Car>((Collection<? extends Car>) pcomp);
        cars.add(new Car("a",33));
        cars.add(new Car("b",22));
        cars.add(new Car("c",55));

        for(Car car : cars){
            System.out.println(car.getName() + " " + car.getPrice());
        }
    }
}
