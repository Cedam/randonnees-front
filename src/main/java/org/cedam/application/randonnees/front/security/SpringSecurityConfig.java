package org.cedam.application.randonnees.front.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	  @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
	  }
//	  
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.inMemoryAuthentication()
//                    .withUser("springuser").password(passwordEncoder().encode("spring123"))
//                    .roles("USER")
//                    .and()
//                    .withUser("springadmin").password(passwordEncoder().encode("admin123"))
//                    .roles("ADMIN", "USER");
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .antMatchers("/admin").hasRole("ADMIN")
//                    .antMatchers("/user").hasRole("USER")
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin();
//                    //.and()
//                    //.oauth2Login().clientRegistrationRepository(new InMemoryClientRegistrationRepository(googleClientRegistration()));
//                    //.oauth2Login().clientRegistrationRepository();
//
//        }
//
//    private ClientRegistration googleClientRegistration() {
//        return CommonOAuth2Provider.GOOGLE.getBuilder("google")
//                .clientId("INSERT_APP_ID")
//                .clientSecret("INSERT_CLIENT_ID")
//                .scope("email",
//                        "profile",
//                        "openid",
//                        "https://www.googleapis.com/auth/user.addresses.read",
//                        "https://www.googleapis.com/auth/user.phonenumbers.read",
//                        "https://www.googleapis.com/auth/user.birthday.read",
//                        "https://www.googleapis.com/auth/user.emails.read")
//                .build();
//    }
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }


}
