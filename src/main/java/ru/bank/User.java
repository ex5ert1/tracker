package ru.bank;

import java.util.Objects;

/**
 * Представляет пользователя банковской системы.
 * Содержит основные данные пользователя: паспортные данные и имя.
 */
public class User {
    /**
     * Номер паспорта пользователя.
     * Является уникальным идентификатором пользователя в системе.
     */
    private String passport;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Создает нового пользователя.
     *
     * @param passport номер паспорта пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя.
     *
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает новый номер паспорта пользователя.
     *
     * @param passport новый номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает новое имя пользователя.
     *
     * @param username новое имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает два объекта User на равенство.
     * Пользователи считаются равными, если у них одинаковые паспортные данные.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код объекта на основе номера паспорта.
     *
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}