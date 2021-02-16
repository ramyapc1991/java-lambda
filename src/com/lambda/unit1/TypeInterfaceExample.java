package com.lambda.unit1;

public class TypeInterfaceExample {
    public static void main(String[] args) {
        StringLengthLambda mylambda = (String s) -> s.length();
        System.out.println(mylambda.getLength("Hello world"));

        // lambda expression can be reduced to
        StringLengthLambda mylambda1 = s -> s.length();
        System.out.println(mylambda1.getLength("Hello world 123"));

        //passing lambda as a method arg
        printLambda(s -> s.length());
    }
    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Hello Hi"));
    }
}

interface StringLengthLambda{
    int getLength(String s);
}
