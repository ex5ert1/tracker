package ru.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        if (users == null) {
            throw new InvalidArgumentException("Массив пользователей не может быть null");
        }
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь с именем " + login + " не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null) {
            throw new UserInvalidException("Пользователь не может быть null");
        }
        String username = user.getUsername();
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь невалиден");
        }
        if (username == null || username.length() < 3) {
            throw new UserInvalidException("Имя пользователя должно содержать не менее 3 символов");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ivan Ivanov", true)
        };

        try {
            User user = findUser(users, "Ivan Ivanov");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.err.println("Пользователь не найден: " + e.getMessage());
        }
    }
}

