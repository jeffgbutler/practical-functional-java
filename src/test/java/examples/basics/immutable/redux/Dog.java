package examples.basics.immutable.redux;

import java.util.Objects;

public class Dog extends BetterAbstractAnimal {
    
    private String akcRegistrationNumber;
    
    private Dog(Builder builder) {
        super(builder);
        akcRegistrationNumber = Objects.requireNonNull(builder.akcRegistrationNumber);
    }
    
    public String getAkcRegistrationNumber() {
        return akcRegistrationNumber;
    }

    @Override
    public String sayHello() {
        return "woof";
    }

    public static class Builder extends AbstractBuilder<Builder> {
        private String akcRegistrationNumber;
        
        public Builder withAkcRegistrationNumber(String akcRegistrationNumber) {
            this.akcRegistrationNumber = akcRegistrationNumber;
            return this;
        }
        
        @Override
        public Builder getThis() {
            return this;
        }
        
        public Dog build() {
            return new Dog(this);
        }
    }
}
