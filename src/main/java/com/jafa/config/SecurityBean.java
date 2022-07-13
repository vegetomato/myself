package com.jafa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.jafa.security.CustomNoopPassowrdEncoder;

@Configuration
public class SecurityBean {

	@Autowired
	DataSource dataSource;

	/*
	 * @Bean public AuthenticationSuccessHandler loginSuccessHandler() { return new
	 * CustomLoginSuccessHandler(); }
	 */

	/*
	 * @Bean public UserDetailsService userDetailsService() { return new
	 * CustomUserDetailService(); }
	 */

	@Bean(value = "뽈롱")
	public PasswordEncoder bcryPwEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public PasswordEncoder noopEncoder() {
		return new CustomNoopPassowrdEncoder();
	}
	/*
	 * @Bean public AuthenticationFailureHandler failureHandler() {
	 * LoginFailureHandler loginFailureHandler = new LoginFailureHandler();
	 * loginFailureHandler.setLoginId("loginId");
	 * loginFailureHandler.setLoginPw("loginPw");
	 * loginFailureHandler.setErrorMessage("errorMessage");
	 * loginFailureHandler.setDefaultFailureUrl("/customLogin"); return
	 * loginFailureHandler; }
	 */

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
}
