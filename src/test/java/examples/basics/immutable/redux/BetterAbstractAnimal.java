package examples.basics.immutable.redux;

import java.util.Objects;

public abstract class BetterAbstractAnimal {

    private String name;
    private int age;
    
    protected BetterAbstractAnimal(AbstractBuilder<?> builder) {
        name = Objects.requireNonNull(builder.name);
        age = builder.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public abstract String sayHello();
    
    public static abstract class AbstractBuilder<T extends AbstractBuilder<T>> {
        private String name;
        private int age;

        public T withName(String name) {
            this.name = name;
            return getThis();
        }

        public T withAge(int age) {
            this.age = age;
            return getThis();
        }
        
        protected abstract T getThis();
    }
}
