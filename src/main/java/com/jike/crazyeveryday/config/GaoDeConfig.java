package com.jike.crazyeveryday.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "amap")
public class GaoDeConfig {

    private String key;

    private String geocodeurl;

    private String aroundurl;


}
