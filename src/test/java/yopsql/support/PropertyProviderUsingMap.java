package yopsql.support;

import yopsql.domain.PropertyProvider;

import java.util.HashMap;

public class PropertyProviderUsingMap extends HashMap<String, String> implements PropertyProvider {

    @Override
    public String getValue(String key) {
        return this.get(key);
    }

    public void setConfig(String value) {
        put("yop.config", value);
    }

    public void setInput(String value) {
        put("yop.input", value);
    }

    public void setOutput(String value) {
        put("yop.output", value);
    }
}
