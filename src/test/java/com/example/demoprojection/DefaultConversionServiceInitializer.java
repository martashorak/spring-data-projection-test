package com.example.demoprojection;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DefaultConversionServiceInitializer {
    @PostConstruct
    public void afterPropertiesSet() {
        DefaultConversionService conversionService = (DefaultConversionService) DefaultConversionService.getSharedInstance();
        conversionService.addConverter(new ReportFormat.ReportFormatConverter());
    }
}