package io.github.tacehex.jadmin.spring.autoconfigure;

import io.github.tacehex.jadmin.core.registry.EntityRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(EntityRegistry.class)
public class JAdminAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JAdminAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public EntityRegistry entityRegistry() {
        log.info("JAdmin EntityRegistry bean created");
        return new EntityRegistry();
    }
}