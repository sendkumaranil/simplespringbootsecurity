package com.spring.boot.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfigure extends WebSecurityConfigurerAdapter {

    //Handle Authentication by Authentication Manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("anilkumar").password("Welcome123").roles("USER")
                .and()
                .withUser("anilverma").password("password1234").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPassWordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //Handle Authorization resource by HttpSecurity
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }
}
