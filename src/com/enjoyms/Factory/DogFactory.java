package com.enjoyms.Factory;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        Dog dog = new Dog();
        dog.setColor("黄色");
        dog.setName("小黄");
        return dog;
    }
}
