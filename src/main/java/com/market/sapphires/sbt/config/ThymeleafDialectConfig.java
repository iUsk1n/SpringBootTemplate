package com.market.sapphires.sbt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.market.sapphires.sbt.util.CustomTagDialect;

@Configuration
public class ThymeleafDialectConfig {

    @Bean
    public CustomTagDialect customTagDialect() {
        return new CustomTagDialect();
    }

}
