package xml.model;

import java.util.Objects;

public class Attribute implements Comparable<Attribute>{
    
    private String name;
    private String value;

    private Attribute(String name, String value) {
        this.name = Objects.requireNonNull(name);
        this.value = Objects.requireNonNull(value);
    }

    public String name() {
        return name;
    }

    public String value() {
        return value;
    }

    @Override
    public int compareTo(Attribute other) {
        return this.name.compareTo(other.name);
    }
    
    public static Attribute of(String name, String value) {
        return new Attribute(name, value);
    }
}
