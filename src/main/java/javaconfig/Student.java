package javaconfig;


public class Student {

    private Sugar sugar;

    public Student(Sugar sugar) {
        this.sugar = sugar;
    }

    public void display(){
        this.sugar.display();
        System.out.println("studying");
    }

}

