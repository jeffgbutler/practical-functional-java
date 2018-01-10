package exercises.basics.streams;

import java.util.Objects;

public class Product {

    private String productName;
    private Integer quantity;
    
    private Product(Builder builder) {
        productName = Objects.requireNonNull(builder.productName);
        quantity = Objects.requireNonNull(builder.quantity);
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public static class Builder {
        private String productName;
        private Integer quantity;

        public Builder withProductName(String productName) {
            this.productName = productName;
            return this;
        }
        
        public Builder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }
        
        public Product build() {
            return new Product(this);
        }
    }
}
