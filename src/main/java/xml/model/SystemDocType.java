package xml.model;

public class SystemDocType extends AbstractDocType {
    
    private SystemDocType(Builder builder) {
        super(builder);
    }

    @Override
    public <R> R accept(DocTypeVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
    public static SystemDocType of(String dtdLocation) {
        return new Builder()
                .withDtdLocation(dtdLocation)
                .build();
    }

    public static class Builder extends AbstractDocType.AbstractBuilder<Builder> {
        @Override
        protected Builder getThis() {
            return this;
        }
        
        public SystemDocType build() {
            return new SystemDocType(this);
        }
    }
}
