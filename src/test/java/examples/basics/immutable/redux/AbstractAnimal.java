package examples.basics.immutable.redux;

import java.util.Objects;

public abstract class AbstractAnimal {

    private String name;
    private int age;
    
    protected AbstractAnimal(AbstractBuilder builder) {
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
    
    public static abstract class AbstractBuilder {
        private String name;
        private int age;

        public AbstractBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AbstractBuilder withAge(int age) {
            this.age = age;
            return this;
        }
        
// won't compile!
//        public AbstractAnimal build() {
//            return new AbstractAnimal(this);
//        }
    }
}
