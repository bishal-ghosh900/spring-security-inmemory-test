package com.example.spring_security_inmemory_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfig {

    private final String EMPLOYEE_API="/employees/**";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, EMPLOYEE_API.substring(0, EMPLOYEE_API.length()-3))
                            .hasAnyRole("MANAGER", "LEADER")
                        .requestMatchers(HttpMethod.GET, EMPLOYEE_API)
                            .hasAnyRole("EMPLOYEE", "MANAGER", "LEADER")
                        .requestMatchers(HttpMethod.POST, EMPLOYEE_API)
                            .hasAnyRole("MANAGER", "LEADER")
                        .requestMatchers(HttpMethod.PATCH, EMPLOYEE_API)
                            .hasAnyRole("MANAGER", "LEADER")
                        .requestMatchers(HttpMethod.DELETE, EMPLOYEE_API)
                            .hasAnyRole("LEADER")
                        .anyRequest().authenticated()
                    )
                    .csrf(csrfConfigurer -> csrfConfigurer.ignoringRequestMatchers("/employees/**"))
                    .httpBasic(Customizer.withDefaults())
                    .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails suzan = User.builder()
                .username("suzan")
                .password("{noop}1234")
                .roles("EMPLOYEE", "MANAGER", "LEADER")
                .build();
        return new InMemoryUserDetailsManager(john, mary, suzan);
    }
}
