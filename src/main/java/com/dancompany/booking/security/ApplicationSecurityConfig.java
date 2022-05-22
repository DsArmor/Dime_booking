package com.dancompany.booking.security;

import com.dancompany.booking.view.LoginPage;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LoginPage.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
        super.configure(auth);
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/images/**"
        );
        super.configure(web);
    }

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Vaadin handles CSRF internally
//        http.csrf().disable()
//
//                // Register our CustomRequestCache, which saves unauthorized access attempts, so the user is redirected after login.
//                .requestCache().requestCache(new CustomRequestCache())
//
//                // Restrict access to our application.
//                .and().authorizeRequests()
//
//                // Allow all Vaadin internal requests.
//                .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll()
//
//                // Allow all requests by logged-in users.
//                .anyRequest().authenticated()
//
//                // Configure the login page.
//                .and().formLogin()
//                .loginPage(LOGIN_URL).permitAll()
//                .loginProcessingUrl(LOGIN_PROCESSING_URL)
//                .failureUrl(LOGIN_FAILURE_URL)
//
//                // Configure logout
//                .and().logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/", "/registration/**", "/room/**").permitAll()
//                    .antMatchers("/hotel/{hotelId}/**")
//                        .access("@userSecurity.hasUserId(authentication, #hotelId) and hasAuthority('HOTEL')")
//                    .antMatchers("/backpacker/{backpackerId}/**")
//                        .access("@userSecurity.hasUserId(authentication, #backpackerId) and hasAuthority('USER')")
//                    .anyRequest().authenticated()
//                .and().formLogin()
//                    .loginPage(LOGIN_URL).permitAll()
//                    .loginProcessingUrl(LOGIN_PROCESSING_URL)
//                    .failureUrl(LOGIN_FAILURE_URL)
//                .and()
//                    .logout().permitAll();
//    }
}