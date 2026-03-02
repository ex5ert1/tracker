package ru.stream;

import ru.bank.Account;
import ru.bank.User;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public record BankService(Map<User, List<Account>> users) {
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> Objects.equals(user.getPassport(), passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        return users.get(user)
                .stream()
                .filter(account -> account != null)
                .filter(account -> Objects.equals(account.getRequisite(), requisite))
                .findFirst()
                .orElse(null);
    }
}