package ru.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> uniqueAccounts = new HashSet<>();
        uniqueAccounts.addAll(accounts);
        return uniqueAccounts;
    }
}
