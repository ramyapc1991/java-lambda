package com.lambda.unit1;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // normal function
        printMessage();

        // using threads and lambda expression
        Thread t = new Thread(() -> printMessage());
        t.start();

        // using method reference
        Thread t1 = new Thread(MethodReferenceExample::printMessage);
        t1.start();
    }

    private static void printMessage() {
        System.out.println("Hello");
    }
}
