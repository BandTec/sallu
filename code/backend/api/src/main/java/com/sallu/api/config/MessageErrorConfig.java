package com.sallu.api.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class MessageErrorConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource message = new ReloadableResourceBundleMessageSource();
        message.setBasename("classpath:error-message");
        message.setDefaultEncoding("ISO-8859-1");
        message.setDefaultLocale(Locale.getDefault());

        return message;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean messageValue = new LocalValidatorFactoryBean();
        messageValue.setValidationMessageSource(messageSource());

        return messageValue;
    }
}