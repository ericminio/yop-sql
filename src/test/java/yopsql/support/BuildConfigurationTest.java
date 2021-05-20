package yopsql.support;

import org.junit.Before;
import org.junit.Test;
import yopsql.domain.Configuration;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BuildConfigurationTest {

    BuildConfiguration buildConfiguration;
    Configuration configuration;

    @Before
    public void sut() throws IOException {
        buildConfiguration = new BuildConfiguration();
        configuration = buildConfiguration.please(new Read().
                file("src/test/resources/configuration.json"));
    }

    @Test
    public void url() {
        assertThat(configuration.getUrl(), equalTo("this-url"));
    }

    @Test
    public void username() {
        assertThat(configuration.getUsername(), equalTo("this-username"));
    }

    @Test
    public void password() {
        assertThat(configuration.getPassword(), equalTo("this-password"));
    }
}
