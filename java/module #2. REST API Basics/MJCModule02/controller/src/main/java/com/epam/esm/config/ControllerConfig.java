package com.epam.esm.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan("com.epam.esm")
@EnableWebMvc
@EnableTransactionManagement
public class ControllerConfig {
    public static final String LOCALIZATION_PROPERTIES = "classpath:localization/message";
    public static final String DEFAULT_ENCODING = "UTF-8";


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename(LOCALIZATION_PROPERTIES);
        source.setDefaultEncoding(DEFAULT_ENCODING);
        return source;
    }





}
