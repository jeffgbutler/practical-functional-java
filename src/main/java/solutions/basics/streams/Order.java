package solutions.basics.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Order {
    private String customerName;
    private List<Product> products;

    private Order(Builder builder) {
        customerName = Objects.requireNonNull(builder.customerName);
        products = Objects.requireNonNull(builder.products);
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public Stream<Product> getProducts() {
        return products.stream();
    }
    
    public static class Builder {
        private String customerName;
        private List<Product> products = new ArrayList<>();
        
        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }
        
        public Builder withProduct(Product product) {
            products.add(product);
            return this;
        }
        
        public Order build() {
            return new Order(this);
        }
    }
}
