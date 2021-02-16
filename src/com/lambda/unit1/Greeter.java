package com.lambda.unit1;

public class Greeter {
    public void greet(Greeting greeting) {
       greeting.perform();
    }
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);
        GoodMorningGreeting goodMorningGreeting = new GoodMorningGreeting();
        greeter.greet(goodMorningGreeting);

        // using lambda expression
        Greeting lambdaGreeting = () -> System.out.println("Hello world from lambda expression");
        helloWorldGreeting.perform();
        lambdaGreeting.perform();

        // using inner classes
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Greeting from Inner class");
            }
        };
        innerClassGreeting.perform();
    }
}
