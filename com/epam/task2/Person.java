package com.epam.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private final String name;
    private final String second_name;
    private final int passport_number;


    public Person (String name, String second_name, int passport_number) {
        this.name = name;
        this.second_name = second_name;
        this.passport_number = passport_number;
    }



    public String getName() {
        return name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public int getPassport_number() {
        return passport_number;
    }

    @Override
    public String toString() {
        return "Person : " +
                "name = " + name +
                ", second_name = " + second_name +
                ", passport_number = " + passport_number;
    }
}
