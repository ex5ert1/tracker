package ru.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        HashSet<Account> uniqueAccounts = new HashSet<>();
        uniqueAccounts.addAll(accounts);
        return uniqueAccounts;
    }
}
