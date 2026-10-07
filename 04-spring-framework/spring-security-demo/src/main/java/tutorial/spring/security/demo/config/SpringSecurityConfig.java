package tutorial.spring.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//it imports WebSecurityConfiguration.class, HttpSecurityConfiguration.clss etc...
public class SpringSecurityConfig {

    /*
these are all the filters which gets added when we build the HttpSecurity builder object.
SecurityContextHolderFilter
LogoutFilter
UsernamePasswordAuthenticationFilter
RequestCacheAwareFilter
AnonymousAuthenticationFilter
ExceptionTranslationFilter
AuthorizationFilter
     */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(
                csrf -> csrf.disable()
        ).authorizeHttpRequests(
                auth -> auth.requestMatchers(
                        "/pub/**"
                ).permitAll()
                        .requestMatchers("/auth/**")
                        .hasRole("ROLE_USER")
                        .anyRequest()
                        .permitAll()
                        .requestMatchers("/auth/**")
                        .hasRole("ROLE_ADMIN")
                        .anyRequest()
                        .permitAll()
        ).httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

/*
POST /login
      |
      V
UsernamePasswordAuthenticationFilter

      |
      V

UsernamePasswordAuthenticationToken
(authenticated=false)

      |
      V

AuthenticationManager

      |
      V

DaoAuthenticationProvider

      |
      V

UserDetailsService

      |
      V

Database

      |
      V

PasswordEncoder.matches()

      |
      V

Authentication
(authenticated=true)

      |
      V

SecurityContext

      |
      V

SecurityContextHolder

      |
      V

AuthorizationFilter

      |
      V

Controller
 */
