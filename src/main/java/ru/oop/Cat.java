package ru.oop;

public class Cat {

    private String food;
    private String nickName;

    public void show() {
        System.out.println("Имя кошки: " + this.nickName);
        System.out.println("Еда: " + this.food);
    }

    public void giveNick(String nick) {
        this.nickName = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("Информация о кошке Gav:");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();

        System.out.println("Информация о кошке Black:");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();

        System.out.println("Информация о кошке Nick:");
        Cat name = new Cat();
        name.giveNick("Nick");
        name.eat("Жидкий корм");
        name.show();
    }
}





