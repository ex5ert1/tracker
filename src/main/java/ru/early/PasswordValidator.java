package ru.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля должна быть в диапазоне [8, 32] символов");
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        if (!hasUpper) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну заглавную букву");
        }
        if (!hasLower) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну строчную букву");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну цифру");
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один специальный символ");
        }
        String lowerCasePassword = password.toLowerCase();
        for (String forbidden : FORBIDDEN) {
            if (lowerCasePassword.contains(forbidden)) {
                throw new IllegalArgumentException("Пароль не должен содержать подстроки: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
