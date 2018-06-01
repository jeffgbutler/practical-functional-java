package solutions.basics.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExercises {

    public List<String> toUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    
    // return a string like Fred ordered 1 Baseball and 1 glove
    public String calculateOrderSummary(List<Order> orders) {
        return orders.stream()
                .map(this::toOrderSummary)
                .collect(Collectors.joining("\n"));
    }
    
    private String toOrderSummary(Order order) {
        return order.getCustomerName()
                + " ordered "
                + getProductDetail(order);
    }
    
    private String getProductDetail(Order order) {
        return order.getProducts()
                .map(p -> p.getQuantity() + " " + p.getProductName())
                .collect(Collectors.joining(" and "));
    }

    public int calculateTotalOrdered(List<Order> orders, String productName) {
        return orders.stream()
                .flatMap(Order::getProducts)
                .filter(p -> p.getProductName().equals(productName))
                .mapToInt(Product::getQuantity)
                .sum();
    }
}
