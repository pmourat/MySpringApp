package com.myexample.configs;

import com.myexample.services.CustomerConverter;
import com.myexample.services.CustomerDtoConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class AppConfig {

    @Bean
    public ConversionService conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new CustomerConverter());
        conversionService.addConverter(new CustomerDtoConverter());
        return conversionService;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}