package ru.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int available = count;
        String lastHappy = null;

        while (available > 0) {
            Customer customer = queue.poll();
            lastHappy = customer.name();
            available--;
        }

        return lastHappy;
    }

    public String getFirstUpsetCustomer() {
        int available = count;

        while (available > 0) {
            queue.poll();
            available--;
        }
        return queue.poll().name();
    }
}
