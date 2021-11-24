package io.system.heeseong.common.config;

import io.system.heeseong.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/smartEditor/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/**").permitAll()
                .and()
                    .csrf()
                    .disable();
//        http.authorizeRequests()
//                //.antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/**").permitAll()
//            .and()
//                .formLogin()
//                .loginPage("/users/login/perform")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/portfolio/main")
//                .failureUrl("/")
//            .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login/logout")
//                .invalidateHttpSession(true)
//            .and()
//                .exceptionHandling().accessDeniedPage("/login/denied")
//            .and()
//                .authenticationProvider(customAuthenticationProvider)
//            .headers()
//                .frameOptions().disable()
//            .and()
//                .csrf()
//                .ignoringAntMatchers("/boards/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoginService loginService() {
        return new LoginService();
    }
}
