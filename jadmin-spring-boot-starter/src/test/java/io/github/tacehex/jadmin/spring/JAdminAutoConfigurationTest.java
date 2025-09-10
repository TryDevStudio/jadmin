package io.github.tacehex.jadmin.spring;

import io.github.tacehex.jadmin.core.registry.EntityRegistry;
import io.github.tacehex.jadmin.spring.autoconfigure.JAdminAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class JAdminAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    void shouldCreateEntityRegistryBeanWhenAutoConfigurationEnabled() {
        this.contextRunner
            .withUserConfiguration(JAdminAutoConfiguration.class)
            .run(context -> {
                assertThat(context).hasSingleBean(EntityRegistry.class);
                assertThat(context.getBean(EntityRegistry.class)).isNotNull();
            });
    }
}