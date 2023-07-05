package ma.securetest.securetest.Config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.OAuth2ResourceServerDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    private RsakeysConfig rsakeysConfig;

    private PasswordEncoder passwordEncoder;
    //injeection via le constructeur
    public SecurityConfig(RsakeysConfig rsakeysConfig,PasswordEncoder passwordEncoder){
        this.rsakeysConfig=rsakeysConfig;
        this.passwordEncoder=passwordEncoder;
    }
  //  @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService){
      var authProvider=  new DaoAuthenticationProvider();
      authProvider.setPasswordEncoder(passwordEncoder);
      authProvider.setUserDetailsService(userDetailsService);
      return new ProviderManager(authProvider);
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsManager(){
    return new InMemoryUserDetailsManager(
            User.withUsername("admin").password(passwordEncoder.encode("1234")).
                    authorities("SECRETAIRE,MEDECIN").build(),
            User.withUsername("user1").password(passwordEncoder.encode("1234")).
                    authorities("SECRETAIRE").build(),
            User.withUsername("user2").password(passwordEncoder.encode("1234")).
                    authorities("MEDECIN").build()
    )    ;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                csrf(csrf->csrf.disable())
                .authorizeRequests(auth->auth.requestMatchers("/token/**").permitAll())
                .authorizeRequests(auth-> auth.anyRequest().
                        authenticated()).
                sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .httpBasic(Customizer.withDefaults()).build();
    }
    //generer les token
    @Bean
    public  JwtEncoder jwtEncoder()
    {
       JWK jwk =new RSAKey.Builder(rsakeysConfig.publicKey()).privateKey(rsakeysConfig.privateKey()).build();
        JWKSource<SecurityContext> jwkSource=new ImmutableJWKSet<>(new JWKSet(jwk));
       return new NimbusJwtEncoder(jwkSource);
    }
    @Bean
    public JwtDecoder jwtDecoder(){
return NimbusJwtDecoder.withPublicKey(rsakeysConfig.publicKey()).build();
    }

}
