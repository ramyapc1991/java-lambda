package com.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1ExerciseInJava8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ramya", "Sanketh", 29),
                new Person("Chandr", "PS", 64),
                new Person("Prema", "Chandru", 55),
                new Person("Sanketh", "Ramya", 31),
                new Person("Dhanvi", "Sanketh", 2),
                new Person("Giri", "Raj", 53)
        );

        //sorting based on last name
        Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));

        //print all using conditionally using lambda
        System.out.println("print all using conditionally using lambda");
        printConditionally(people, p ->true, p -> System.out.println(p));

        //print conditionally using lambda expression java 8
        System.out.println("last name beginning with C using lambda expression");
        printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        System.out.println("first name beginning with R using lambda expression");
        printConditionally(people, p -> p.getFirstName().startsWith("R"), p -> System.out.println(p));



    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for(Person p : people)
            if(predicate.test(p))
                consumer.accept(p);
    }
}
