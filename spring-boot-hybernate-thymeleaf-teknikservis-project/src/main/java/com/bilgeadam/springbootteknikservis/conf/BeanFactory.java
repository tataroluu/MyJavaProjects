package com.bilgeadam.springbootteknikservis.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.bilgeadam.springbootteknikservis.converters.ProductConverter;

@Component
public class BeanFactory implements WebMvcConfigurer
{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("*.jpg", "*.png").addResourceLocations( "classpath:/static/images/", "file:///C:/teknik/", "file:///C:/Nexon/");
		registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("*.js").addResourceLocations("classpath:/static/js/");
	}

	@Bean // (name = "SessionLocaleResolver")
	public SessionLocaleResolver localeResolver()
	{
		// CookieLocaleResolver da olabilir
		SessionLocaleResolver slr = new SessionLocaleResolver();
		return slr;
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor()
	{
		// lang şeklinde bir query parameter geldiğinde locale değişsin
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		registry.addConverter(new ProductConverter());
				
	}
}
