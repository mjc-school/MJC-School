package org.example.exceptions;

public class ArrayManager {
    public void printArrayResult(){
        try{
            int[] a = new int[3];
            a[0] = 10;
            a[1] = 20;
            a[2] = 30;
            System.out.println("Printing value of index 0: " + a[0]);
            System.out.println("Printing value of index 1: " + a[1]);
            System.out.println("Printing value of index 2: " + a[2]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Other Exception occurs");
        }
        finally {
            System.out.println("Print Very Essential Code: 1020");
        }
    }
}
