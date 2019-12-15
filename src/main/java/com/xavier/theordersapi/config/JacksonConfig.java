package com.xavier.theordersapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xavier.theordersapi.model.Cash;
import com.xavier.theordersapi.model.CreditCard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(CreditCard.class);
                objectMapper.registerSubtypes(Cash.class);
                super.configure(objectMapper);

            };
        };

        return builder;

    }
}
