package com.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.exception.ExceptionHandle;
import com.app.security.filter.CORSFilter;
import com.app.security.filter.JWTAuthenticationFilter;
import com.app.security.filter.JWTLoginFilter;
import static com.app.security.SecurityConstants.SIGN_IN_URL;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityConf(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SIGN_IN_URL, "/v2/api-docs",
				"/configuration/ui",
				"/swagger-resources/**",
				"/configuration/security",
				"/swagger-ui.html",
				"/webjars/**").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.POST, "/account").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.POST, "/role").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.GET, "/product").permitAll().and()
				.authorizeRequests().antMatchers("/image/**").permitAll().and()
				.authorizeRequests().antMatchers("/cart/**").permitAll().and()
				.authorizeRequests().antMatchers(HttpMethod.POST, "/user/register").permitAll().anyRequest()
				.authenticated().and().addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class)
				.addFilterBefore(new JWTLoginFilter(SIGN_IN_URL, authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception, ExceptionHandle {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}
