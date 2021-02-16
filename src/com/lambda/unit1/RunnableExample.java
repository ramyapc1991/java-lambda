package com.lambda.unit1;

public class RunnableExample {
    public static void main(String[] args) {
        //using the anonymous class creation
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });
        myThread.run();

        //using lambda expression
        Thread myThreadLambda = new Thread(() -> System.out.println("Printed inside lambda expression"));
        myThreadLambda.run();
    }
}
