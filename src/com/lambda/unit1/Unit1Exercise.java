package com.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class Unit1Exercise {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ramya","Sanketh", 29),
                new Person("Chandr","PS", 64),
                new Person("Prema","Chandru", 55),
                new Person("Sanketh","Ramya", 31),
                new Person("Dhanvi","Sanketh", 2),
                new Person("Giri","Raj", 53)
        );

        // sort based on lastName
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });

        //print all elements in the list
        System.out.println("print all elements in the list");
        printAll(people);

        //print last name beginning with C
        System.out.println("last name beginning with C");
        printLastNameBeginningWithC(people);

        //print conditionally
        System.out.println("last name beginning with C using Conditionally inner class Impl");
        printConditionally(people, new Conditional() {
            @Override
            public boolean test(Person p) {
               return p.getLastName().startsWith("C");
            }
        });

        //print conditionally using lambda expression java 8
        System.out.println("last name beginning with C using lambda expression");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("first name beginning with R using lambda expression");
        printConditionally(people, p -> p.getFirstName().startsWith("R"));
    }

    private static void printConditionally(List<Person> people, Conditional condition) {
        for(Person p : people)
            if(condition.test(p))
                System.out.println(p);
    }

    private static void printLastNameBeginningWithC(List<Person> people) {
        for (Person p:people)
            if (p.getLastName().startsWith("C"))
                System.out.println(p);
    }

    private static void printAll(List<Person> people) {
        for(Person p:people){
            System.out.println(p);
        }
    }
}

interface Conditional{
    boolean test(Person p);
}
