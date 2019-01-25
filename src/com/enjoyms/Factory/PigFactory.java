package com.enjoyms.Factory;

public class PigFactory implements AnimalFactory{
    @Override
    public Animal createAnimal() {
        Pig pig = new Pig();
        return pig;
    }
}
