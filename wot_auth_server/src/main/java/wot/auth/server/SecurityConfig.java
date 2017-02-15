package wot.auth.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
	private CommonPasswordEncoder commonPasswordEncoder;
    
    @Autowired
	private UserDetailsService userDetailsService;
    
    //@Autowired
    //private Oauth2LogoutHandler oauth2LogoutHandler;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	//auth.userDetailsService(userDetailsService).passwordEncoder(commonPasswordEncoder);
    	 auth
         .jdbcAuthentication().dataSource(dataSource)
         .usersByUsernameQuery("select username, password, actived from users where username=?")
         .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
        
        http.authorizeRequests()
                .antMatchers("/login.jsp").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login.jsp")
                    .loginProcessingUrl("/j_spring_security_check")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                .and()
                    .logout()
                    .logoutUrl("/j_spring_security_logout");
                    //.logoutSuccessHandler(oauth2LogoutHandler);
    }
    
    
}
