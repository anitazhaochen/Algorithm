package com.enjoyms.Factory;

public class AnimalFactoryStatic {

    public static Dog createDog() {
        Dog dog = new Dog();
        return dog;
    }

    public static Pig createPig(){
        Pig pig = new Pig();
        return pig;
    }
}
