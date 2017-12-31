package xml.model;

public class Attribute implements Comparable<Attribute>{
    
    private String name;
    private String value;

    private Attribute(String name, String value) {
        this.name = name;
        this.value = value;
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
