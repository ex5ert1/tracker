package ru.bank;

import java.util.*;

/**
 * Сервис для работы с банковскими операциями.
 * Хранит информацию о пользователях и их счетах,
 * предоставляет методы для выполнения операций.
 */
public class BankService {
    /**
     * Карта для хранения пользователей и их счетов.
     * Ключ - объект User, значение - список счетов пользователя.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему.
     * Если пользователь уже существует, метод ничего не делает.
     *
     * @param user объект пользователя для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя по номеру паспорта.
     *
     * @param passport номер паспорта удаляемого пользователя
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Добавляет счет пользователю по номеру паспорта.
     * Счет добавляется только если его еще нет у пользователя.
     *
     * @param passport    номер паспорта пользователя
     * @param account     счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по номеру паспорта.
     *
     * @param passport номер паспорта для поиска
     * @return найденный объект User или null если не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Находит счет пользователя по номеру паспорта и реквизитам.
     *
     * @param passport    номер паспорта пользователя
     * @param requisite   реквизиты счета
     * @return найденный объект Account или null если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Выполняет перевод денег между счетами.
     *
     * @param sourcePassport    паспорт отправителя
     * @param sourceRequisite   реквизиты счета отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount            сумма перевода
     * @return true если перевод выполнен успешно, false в противном случае
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || destinationAccount == null || sourceAccount.getBalance() < amount) {
            return false;
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;
    }

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user пользователь
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.getOrDefault(user, Collections.emptyList());
    }
}