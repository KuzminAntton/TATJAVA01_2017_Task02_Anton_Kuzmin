package com.epam.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Simulates the behavior of a person,
 * having three fields : name, second name passport number.
 */
public class Person {
    private final String name;
    private final String secondName;
    private final int passportNumber;

    public Person(String name, String second_name, int passport_number) {
        this.name = name;
        this.secondName = second_name;
        this.passportNumber = passport_number;
    }

    public String getName() {
        return name;
    }

    public String getSecond_name() {
        return secondName;
    }

    public int getPassport_number() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return  "Name : " + name +
                ", Second name : " + secondName +
                ", Passport number : " + passportNumber;
    }
}