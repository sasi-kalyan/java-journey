package tutorial.spring.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

@Configuration
//it imports WebSecurityConfiguration.class, HttpSecurityConfiguration.class etc.
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(
                csrf -> csrf.disable()
        ).authorizeHttpRequests(
                auth -> auth.requestMatchers(
                        "/api/user/**"
                ).permitAll()
                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
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
