package ru.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> orderMap = new HashMap<>();
        for (Order order : orders) {
            orderMap.put(order.getNumber(), order);
        }
        return orderMap;
    }
}
