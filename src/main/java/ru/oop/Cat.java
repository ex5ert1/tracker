package ru.oop;

public class Cat {

    private String food;
    private String nickName;

    public void show() {
        System.out.println(this.food);
        System.out.println(this.nickName);
    }

    public void giveNick(String nick) {
        this.nickName = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.show();
        Cat name = new Cat();
        name.giveNick("nick");
        name.show();
    }
}





