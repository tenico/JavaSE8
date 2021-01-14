package com.example;

public class Cat extends Animal implements Pet {
    
    public Cat(int legs) {
        super(legs);
        
    }
    public Cat(String name) {
        super(4);
       
    }
    public Cat(){
        this("Fluffy");
    }
    
 

    public String name;

    @Override
    public String getName() {
       
        return name;
    }

    @Override
    public void setName(String name) {
       
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + " likes to play with string");
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish");

    }
}
