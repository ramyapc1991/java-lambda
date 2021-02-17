package com.lambda.unit1;

public class ThisReferenceExample {
    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        // using anonymous inner class
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is "+i);
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "This is the anonymous inner class";
            }
        });

        // using lambda
        doProcess(10, i -> {
            System.out.println("Value if i is "+ i);
           // System.out.println(this); // error cannot be referenced from a static context
        });

        thisReferenceExample.execute();
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }

    public void execute(){ // should not be static method
        doProcess(10, i ->{
            System.out.println("Value of i is "+i);
            System.out.println(this);
        });
    }

    @Override
    public String toString() {
        return "This is the ThisReferenceExample class ref";
    }
}
