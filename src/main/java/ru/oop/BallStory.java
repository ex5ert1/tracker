package ru.oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        System.out.println("Колобок встретил зайца:");
        hare.tryEat(ball);

        System.out.println("Колобок встретил волка:");
        wolf.tryEat(ball);

        System.out.println("Колобок встретил лису:");
        fox.tryEat(ball);
    }
}
