package com.akanksha.springcore.ci;

public class Addition {

    private int a;
    private int b;

    public Addition(double a, double b) {

        this.a = (int) a;
        this.b =(int) b;
        System.out.println("constructor double");
    }
    public Addition(int a, int b) {
        System.out.println("constructor int int");
        this.a = a;
        this.b = b;
    }

    public Addition(String a, String b) {
        System.out.println("constructor string");
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        System.out.println("value of a"+a);
        System.out.println("value of b"+b);
    }



    public void sum(){
        System.out.println("sum is"+ (this.a+this.b));
    }


}
