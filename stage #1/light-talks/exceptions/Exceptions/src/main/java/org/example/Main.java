package org.example;





public class Main {
    public static void main(String[] args) {

    }

    public static int calculateFactorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * calculateFactorial(n-1);
    }
}