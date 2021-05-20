package yopsql.support;

import yopsql.domain.Configuration;

import java.util.List;

public class BuildConfiguration {

    public Configuration please(List<String> lines) {
        Configuration configuration = new Configuration();
        configuration.setUrl(valueOf("url", lines));
        configuration.setUsername(valueOf("username", lines));
        configuration.setPassword(valueOf("password", lines));
        return configuration;
    }

    private String valueOf(String key, List<String> lines) {
        for (String line:lines) {
            if (line.indexOf(key) >=0 ) {
                line = line.substring(line.indexOf(key) + key.length()).trim();
                line = line.substring(line.indexOf(":")+1).trim();
                if (line.endsWith(",")) {
                    line = line.substring(0, line.length()-1);
                }
                if (line.endsWith("\"")) {
                    line = line.substring(0, line.length()-1);
                }
                if (line.startsWith("\"")) {
                    line = line.substring(1);
                }
                return line;
            }
        }
        return null;
    }
}
