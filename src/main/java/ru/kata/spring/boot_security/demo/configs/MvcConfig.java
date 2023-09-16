package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

import java.util.List;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("users");
        registry.addViewController("/user").setViewName("user");
    }
//    public class MvcCog extends HttpEntityMethodProcessor {
//        public MvcCog(List<HttpMessageConverter<?>> converters) {
//            super(converters);
//        }
//
//        public MvcCog(List<HttpMessageConverter<?>> converters, ContentNegotiationManager manager) {
//            super(converters, manager);
//        }
//
//        public MvcCog(List<HttpMessageConverter<?>> converters, List<Object> requestResponseBodyAdvice) {
//            super(converters, requestResponseBodyAdvice);
//        }
//
//        public MvcCog(List<HttpMessageConverter<?>> converters, ContentNegotiationManager manager, List<Object> requestResponseBodyAdvice) {
//            super(converters, manager, requestResponseBodyAdvice);
//        }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }
}