package com.lambda.unit1;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Ramya","Sanketh", 29),
                new Person("Chandru","PS", 64),
                new Person("Prema","Chandru", 55),
                new Person("Sanketh","Ramya", 31),
                new Person("Dhanvi","Sanketh", 2),
                new Person("Giri","Raj", 53)
        );

        //print using for loop
        System.out.println("Print using for loop");
        for(int i=0;i<people.size();i++)
            System.out.println(people.get(i));

        //using for in loop
        System.out.println("Print using for in loop");
        for(Person p: people)
            System.out.println(p);

        //using java 8 for each
        System.out.println("Print using for each loop");
        people.forEach(p -> System.out.println(p));

        //using java 8 for each with method reference
        System.out.println("Print using for each loop with method reference");
        people.forEach(System.out::println);

        // streams
        System.out.println("Streams");
        people.stream().forEach(p -> System.out.println(p.getFirstName()));

        // streams with filter
        System.out.println("Streams filter");
        people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println);

        System.out.println("Streams count");
        long count=people.stream().filter(p -> p.getFirstName().startsWith("R")).count();
        System.out.println(count);

        System.out.println("Parallel Streams count");
        long count1=people.parallelStream().filter(p -> p.getFirstName().startsWith("R")).count();
        System.out.println(count1);
    }
}
