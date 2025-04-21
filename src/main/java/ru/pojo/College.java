package ru.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Иван Иванович");
        student.setGroup(4);
        student.setDateOfReceipt(new Date());

        System.out.println(student.getFio() + " Обучающийся в группе номер " + student.getGroup() + " поступил: " + student.getDateOfReceipt());
    }
}
