package co.com.pt.security;

import co.com.pt.security.JWT.JwtEntryPoint;
import co.com.pt.security.JWT.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@DependsOn("passwordEncoder")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    JwtFilter jwtFilter;
    @Autowired
    private JwtEntryPoint accessDenyHandler;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requiresChannel()
                .anyRequest()
                .requiresSecure();
    }*/

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://sapp.com.co");
            }
        };
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable()
                .authorizeRequests()

                .antMatchers("/profile/**").authenticated()
                // .antMatchers("/favorite/**").access("hasAnyRole('PROVIDER')")

                .antMatchers("/message/project/**/provider/**").access("hasAnyRole('CLIENT')")
                .antMatchers("/message/question/project/**").access("hasAnyRole('CLIENT')")
                .antMatchers("/message/answer/project/**").access("hasAnyRole('CLIENT')")
                .antMatchers("/offer/**").access("hasAnyRole('CLIENT', 'MANAGER')")
                .antMatchers("/offer/new").access("hasAnyRole('CLIENT')")
                // .antMatchers("/offerDetail/**").access("hasAnyRole('CLIENT', 'MANAGER')")
                // .antMatchers("/project/**").access("hasAnyRole('CLIENT', 'MANAGER')")
                // .antMatchers("/project/guest").access("hasAnyRole('GUEST')")
                .antMatchers("/profiles/**").authenticated()
                .antMatchers("/client/project/new").access("hasAnyRole('CLIENT, MANAGER')")
                .antMatchers("/project/**/state/**").access("hasAnyRole('CLIENT, MANAGER')")
                .antMatchers("/client/**/delete").access("hasAnyRole( 'MANAGER')")
                .antMatchers("/client/**").access("hasAnyRole('CLIENT', 'MANAGER')")
                .anyRequest().permitAll()

                .and()
                .exceptionHandling().authenticationEntryPoint(accessDenyHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
