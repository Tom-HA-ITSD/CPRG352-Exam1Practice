package models;

import java.io.Serializable;

public class Person implements Serializable{
    private String name;
    private double age;
    
    public Person(){}
    
    public Person(String name, double age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }
}
