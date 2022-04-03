package lesson38.config;

import lesson38.security.filter.TokenAuthenticationFilter;
import lesson38.security.handler.AuthenticationHandler;
import lesson38.security.jwt.JwtHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import static lesson38.security.Authorities.ROLE_ADMIN;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final AuthenticationHandler authenticationHandler;
    private final JwtHelper jwtHelper;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/css/**", "/webjars/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/genres", "/api/genres").authenticated()
                .antMatchers("/genre/**", "/api/genres/*"/*, "/secured/jwt"*/).hasAuthority(ROLE_ADMIN)
                .antMatchers("/jwt", "/**").permitAll()
//                .antMatchers("/jwt", "/**").denyAll()
                .and()
                .formLogin()
//                .loginPage("/" + AUTH_ACTION_NAME)
//                .usernameParameter(USER_LOGIN_REQUEST_PARAMETER_NAME)
//                .passwordParameter(USER_PASS_REQUEST_PARAMETER_NAME)
//                .successHandler(authenticationHandler)
//                .failureHandler(authenticationHandler);
                .and()
                .logout()
                .addLogoutHandler(authenticationHandler)
                .and()
                .addFilterAfter(new TokenAuthenticationFilter(jwtHelper), AnonymousAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}