package ru.tumasoff.keycloakdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .cors()
      .and()
      .authorizeRequests(auth -> auth
        .antMatchers(HttpMethod.GET, "/anonymous/**").permitAll()
        .anyRequest()
        .authenticated())
      .oauth2ResourceServer()
      .jwt();
  }
}