package com.shop.config;

import com.shop.services.SneakersShopUserService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

     private final SneakersShopUserService sneakersShopUserService;
     private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(SneakersShopUserService sneakersShopUserService, PasswordEncoder passwordEncoder) {
        this.sneakersShopUserService = sneakersShopUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(sneakersShopUserService).
                passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().
                cors().disable().
                authorizeRequests().
                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                        antMatchers("/home", "/users/login", "/users/register", "/sneakers/api").permitAll().
                        antMatchers("/sneakers/add").hasRole("ADMIN").
                        antMatchers("/sneakers/order").hasAnyRole("USER", "ADMIN").
                        antMatchers("/**").authenticated().
                and().
                        formLogin().
                        loginPage("/users/login").
                        usernameParameter("username").
                        passwordParameter("password").
                        defaultSuccessUrl("/home").
                        failureForwardUrl("/users/login-error").
                and().
                        logout().
                // which endpoint performs logout, e.g. http://localhost:8080/logout (!this should be POST request)
                        logoutUrl("/logout").
                // where to land after logout
                        logoutSuccessUrl("/").
                // remove the session from the server
                        invalidateHttpSession(true).
                // delete the session cookie
                        deleteCookies("JSESSIONID");

    }
}
