package com.developerblog.photoapp.api.ApiGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {

    @Bean
    public GlobalFilter secondPreFilter() {

        final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);

        return ((exchange, chain) -> {

            logger.info("My second global pre-filter is executed...");

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("My second global post-filter was executed...");
            }));
        });
    }

    @Bean
    public GlobalFilter thirdPreFilter() {

        final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);

        return ((exchange, chain) -> {

            logger.info("My third global pre-filter is executed...");

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("My third global post-filter was executed...");
            }));
        });
    }

    @Bean
    public GlobalFilter fourthPreFilter() {

        final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);

        return ((exchange, chain) -> {

            logger.info("My fourth global pre-filter is executed...");

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("My fourth global post-filter was executed...");
            }));
        });
    }
}
