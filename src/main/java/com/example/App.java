
package com.example;

public class App {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Result: " + app.add(10, 20));
    }
}
