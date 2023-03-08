package com.example.basictemplate.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
//prefix(前缀):用于区分同名配置
@ConfigurationProperties(prefix = "school")
public class ConfigInfo {
    private String name;

    private String website;
}
