package ru.tumasoff.keycloakdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Value("${spring.security.oauth2.resourceserver.opaque.introspection-uri}")
  String introspectionUri;

  @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-id}")
  String clientId;

  @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-secret}")
  String clientSecret;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .cors()
      .and()
      .authorizeRequests(auth -> auth
        .antMatchers(HttpMethod.GET, "/anonymous/**").permitAll()
        .anyRequest()
        .authenticated())
      .oauth2ResourceServer(oauth2 ->
        oauth2.opaqueToken(token -> token
          .introspectionUri(this.introspectionUri)
          .introspectionClientCredentials(this.clientId, this.clientSecret)));
  }
}