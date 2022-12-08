package org.ppke.itk.appointmentmanager.controller;

import java.security.Principal;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UiApplicationController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    /*
     * @Configuration
     * 
     * @Order(SecurityProperties.BASIC_AUTH_ORDER)
     * protected static class SecurityConfiguration extends
     * WebSecurityConfigurerAdapter {
     * 
     * @Override
     * protected void configure(HttpSecurity http) throws Exception {
     * http
     * .httpBasic()
     * .and()
     * .authorizeRequests()
     * .antMatchers("/index.html", "/", "/home", "/login", "/appointments",
     * "/bookings").permitAll()
     * .anyRequest().authenticated();
     * }
     * }
     */
}
