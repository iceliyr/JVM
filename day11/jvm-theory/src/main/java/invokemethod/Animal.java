package invokemethod;

import java.io.IOException;

//-XX:-UseCompressedOops
public abstract class Animal {

    public abstract void eat();

    @Override
    public String toString() {
        return "Animal";
    }

    public static void main(String[] args) throws IOException {
        Animal animal = new Cat();
        animal.eat();
        System.in.read();
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

    void jump() {
        System.out.println("猫跳了一下");
    }

}


class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}

