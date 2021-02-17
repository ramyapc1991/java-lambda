package com.lambda.unit1;

public class ClosureExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        //using anonymous inner class
        doProcess(a, new Process() {
            @Override
            public void process(int i) {
               // System.out.println(i);
                System.out.println(i+b); // b is effective final variable
            }
        });

        //using lambda expression
        doProcess(a, i -> System.out.println(i+b));
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process{
    void process(int i);
}
