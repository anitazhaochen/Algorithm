package com.enjoyms.Factory;

public class Main {
    public static void main(String[] args) {

        // 以前创建对象的方式
        Dog dog = new Dog();
        Pig pig = new Pig();
        dog.eat();
        pig.eat();

        // 使用工厂方法模式创建对象
        /*
        * 1. 工厂方法模式中抽象工厂类负责定义创建对象的接口。
        *   创建 AnimalFactory 接口。
        *
        *
        *
        * */

        System.out.println("-----------");
        DogFactory dogFactory = new DogFactory();
        Dog dog1 = (Dog) dogFactory.createAnimal();
        PigFactory pigFactory = new PigFactory();
        Pig pig1 = (Pig) pigFactory.createAnimal();
        dog1.eat();
        pig1.eat();

        // 创建对象，通过静态工厂类创建

        Dog dog3 = AnimalFactoryStatic.createDog();
        Pig pig3 = AnimalFactoryStatic.createPig();



    }
}
