package ru.bank;

import java.util.Objects;

/**
 * Представляет банковский счет.
 * Содержит реквизиты счета и текущий баланс.
 */
public class Account {
    /**
     * Реквизиты счета.
     * Уникальный идентификатор банковского счета.
     */
    private String requisite;

    /**
     * Текущий баланс счета.
     * Хранит информацию о денежных средствах на счете.
     */
    private double balance;

    /**
     * Создает новый банковский счет.
     *
     * @param requisite реквизиты счета
     * @param balance начальный баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счета.
     *
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает новые реквизиты счета.
     *
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает текущий баланс счета.
     *
     * @return текущий баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс счета.
     *
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает два объекта Account на равенство.
     * Счета считаются равными, если у них одинаковые реквизиты.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код объекта на основе реквизитов счета.
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}