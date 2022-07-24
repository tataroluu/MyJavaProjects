package com.bilgeadam.springbootteknikservis.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SeConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
		http.authorizeRequests().and().formLogin().loginPage("/login").defaultSuccessUrl("/index");
		http.authorizeRequests().and().logout().logoutSuccessUrl("/index");
		http.authorizeRequests().antMatchers("/sale/add").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/booking").hasRole("USER");
		http.authorizeRequests().antMatchers("/booking/list").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/buy").hasRole("USER");
		http.authorizeRequests().antMatchers("/proposal").hasRole("USER");
//		AccessDeniedHandler myHandler=new AccessDeniedHandler()
//		{
//			@Override
//			public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException
//			{				
//				response.sendRedirect("/index");
//			}
//		};
		http.authorizeRequests().and().exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> response.sendRedirect("/index"));
		http.authorizeRequests().anyRequest().permitAll();
	}

}