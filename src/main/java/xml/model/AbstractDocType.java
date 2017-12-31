package xml.model;

public abstract class AbstractDocType {
    private String dtdLocation;
    
    protected AbstractDocType(AbstractBuilder<?> builder) {
        this.dtdLocation = builder.dtdLocation;
    }
    
    public String dtdLocation() {
        return dtdLocation;
    }
    
    public abstract <R> R accept(DocTypeVisitor<R> visitor);
    
    public abstract static class AbstractBuilder<T extends AbstractBuilder<T>> {
        private String dtdLocation;
        
        public T withDtdLocation(String dtdLocation) {
            this.dtdLocation = dtdLocation;
            return getThis();
        }
        
        protected abstract T getThis();
    }
}
