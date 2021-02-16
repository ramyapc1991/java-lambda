package com.lambda.unit1;

import java.util.function.BiConsumer;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] someNumbers = {1,2,3,4,5};
        int key =2;
        System.out.println("Using function");
        process(someNumbers,key);

        // using lambda expression
        System.out.println("Using lambda expression");
        processLambda(someNumbers,key, (v,k) -> System.out.println(v+k));

        //This will throw the exception
       // processLambda(someNumbers, 0, (v,k)-> System.out.println(v/k));


        System.out.println("wrapping lambda by another lambda and has the behavior inside the wrapper lambda");
        processLambda(someNumbers, 2, wrapperLambda((v,k) -> System.out.println(v/k)));

        // handle the exception by wrapping up the lambda with another lambda
        System.out.println("Exception handling");
        processLambda(someNumbers, 0, wrapperLambda((v,k) -> System.out.println(v/k)));

    }

    private static void process(int[] someNumbers, int key) {
        for(int i : someNumbers)
            System.out.println(i+key);
    }

    private static void processLambda(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for(int i : someNumbers)
            consumer.accept(i,key);
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
        //return consumer; // just bi pass the consumer, sent the consumer reference
        //return (v,k) -> System.out.println(v+k); // this will do addition since the perform is mentioned here.
//        return (v,k) -> {
//            consumer.accept(v,k); // this will get the passing function which  is division
//        };
        return (v,k) -> {
            try{
                consumer.accept(v,k);
            }catch (ArithmeticException e){
                System.out.println("ArithmeticException occurred");
            }
        };
    }
}
