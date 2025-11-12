package com.email_template_engine.config;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VelocityConfig {
    
    @Bean
    public VelocityEngine velocityEngine() {
        Properties props = new Properties();
        props.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        props.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        props.setProperty(RuntimeConstants.ENCODING_DEFAULT, "UTF-8");
    props.setProperty(RuntimeConstants.INPUT_ENCODING, "UTF-8");
    props.setProperty("runtime.output.encoding", "UTF-8");

        VelocityEngine engine = new VelocityEngine();
        engine.init(props);
        return engine;
         }
}
