package ru.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void displayErrorInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        System.out.println("Default Error:");
        defaultError.displayErrorInfo();

        Error customError = new Error(true, 404, "Page not found");
        System.out.println("Custom Error:");
        customError.displayErrorInfo();

        Error anotherError = new Error(false, 500, "Internal server error");
        System.out.println("Another Error:");
        anotherError.displayErrorInfo();
    }
}
