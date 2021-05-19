package yopsql.domain;

public class Environment {

    private PropertyProvider propertyProvider;

    public Environment() {
        setPropertyProvider(new PropertyProviderUsingSystemProperty());
    }

    public void setPropertyProvider(PropertyProvider propertyProvider) {
        this.propertyProvider = propertyProvider;
    }

    public PropertyProvider getPropertyProvider() {
        return propertyProvider;
    }

    public String getConfig() {
        return getPropertyProvider().getValue("yop.config");
    }

    public String getInput() {
        return getPropertyProvider().getValue("yop.input");
    }

    public String getOutput() {
        return getPropertyProvider().getValue("yop.output");
    }
}
