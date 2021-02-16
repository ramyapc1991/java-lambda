package com.lambda.unit1;

public class GoodMorningGreeting implements Greeting{
    @Override
    public void perform() {
        System.out.println("Good Morning Greeting from GoodMorningGreeting");
    }
}
