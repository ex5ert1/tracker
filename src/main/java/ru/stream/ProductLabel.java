package ru.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> {
                    int daySLeft = product.getStandard() - product.getActual();
                            return daySLeft >= 0 && daySLeft <= 3;
                })
                .map(product -> {
                    float discountPrice = product.getPrice() * 0.5f;
                    return new Label(product.getName(), discountPrice);
                })
                .map(Label::toString)
                .collect(Collectors.toList());

    }
}
