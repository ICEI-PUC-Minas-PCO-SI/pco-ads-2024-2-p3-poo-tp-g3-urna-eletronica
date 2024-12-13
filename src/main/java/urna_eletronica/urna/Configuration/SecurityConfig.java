package urna_eletronica.urna.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll()  // Permite o acesso público a todas as URLs
            .and()
            .csrf().disable()  // Desabilita CSRF para facilitar o desenvolvimento
            .headers().frameOptions().disable();  // Permite que o H2 console use frames

        return http.build();
    }
}
