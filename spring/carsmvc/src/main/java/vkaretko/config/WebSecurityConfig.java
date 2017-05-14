package vkaretko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import vkaretko.repository.UserDAO;

import javax.sql.DataSource;

/**
 * Class WebSecurityConfig.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 13.05.17 21:15.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("ADMIN")
                .antMatchers("/**").hasAnyRole("USER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
