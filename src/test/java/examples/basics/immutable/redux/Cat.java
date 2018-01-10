package examples.basics.immutable.redux;

import java.util.Objects;

public class Cat extends BetterAbstractAnimal {
    
    private String cfaRegistrationNumber;
    
    private Cat(Builder builder) {
        super(builder);
        cfaRegistrationNumber = Objects.requireNonNull(builder.cfaRegistrationNumber);
    }
    
    public String getCfaRegistrationNumber() {
        return cfaRegistrationNumber;
    }

    @Override
    public String sayHello() {
        return "meow";
    }

    public static class Builder extends AbstractBuilder<Builder> {
        private String cfaRegistrationNumber;
        
        public Builder withCfaRegistrationNumber(String cfaRegistrationNumber) {
            this.cfaRegistrationNumber = cfaRegistrationNumber;
            return this;
        }
        
        @Override
        public Builder getThis() {
            return this;
        }
        
        public Cat build() {
            return new Cat(this);
        }
    }
}
