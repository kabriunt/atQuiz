package ATS.atquiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import ATS.atquiz.service.User.MyUserDetailsService;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public UserDetailsService mongoUserDetails() {
        return new MyUserDetailsService();
    }
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = mongoUserDetails();
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/home").permitAll()
		.antMatchers("/api/question/admin**").hasRole("ADMIN")
		.antMatchers("/api/quiz/admin**").hasRole("ADMIN")
		.antMatchers("/api/user/admin**").hasRole("ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/candidate").hasAnyRole("CANDIDATE","ADMIN")
		.antMatchers("/api/quiz/candidate").hasAnyRole("CANDIDATE","ADMIN")
		.antMatchers("/api/quiz/generated").hasAnyRole("CANDIDATE","ADMIN")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}

}