package lesson40.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@Configuration
@EnableMapRepositories("lesson40.repository")
@ConditionalOnProperty(value = "application.nosql.type", havingValue = "redis")
public class RedisConfig {
}
