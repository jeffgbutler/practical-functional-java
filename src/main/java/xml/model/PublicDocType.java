package xml.model;

import java.util.Objects;

public class PublicDocType extends AbstractDocType {
    
    private String dtdName;
    
    private PublicDocType(Builder builder) {
        super(builder);
        this.dtdName = Objects.requireNonNull(builder.dtdName);
    }
    
    public String dtdName() {
        return dtdName;
    }

    @Override
    public <R> R accept(DocTypeVisitor<R> visitor) {
        return visitor.visit(this);
    }
    
    public static class Builder extends AbstractDocType.AbstractBuilder<Builder> {
        private String dtdName;
        
        public Builder withDtdName(String dtdName) {
            this.dtdName = dtdName;
            return this;
        }
        
        public PublicDocType build() {
            return new PublicDocType(this);
        }
        
        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
