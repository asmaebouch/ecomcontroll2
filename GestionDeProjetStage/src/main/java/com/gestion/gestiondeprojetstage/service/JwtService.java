package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.JwtRequest;
import com.gestion.gestiondeprojetstage.Entity.JwtResponse;
import com.gestion.gestiondeprojetstage.Entity.Role;
import com.gestion.gestiondeprojetstage.Entity.User2;
import com.gestion.gestiondeprojetstage.configuration.util.JwtUtil;
import com.gestion.gestiondeprojetstage.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
         UserDetails userDetails = loadUserByUsername(userName);
        String newGenrtedToken = jwtUtil.generateToken(userDetails);
        User2 user = userDao.findById(userName).get();
        return new JwtResponse(user, newGenrtedToken);

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User2 user = userDao.findById(username).get();
        if (user != null) {
            return new User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)

            );
        } else {
            throw new UsernameNotFoundException("Username is not valid ");
        }
    }

    private Set getAuthority(User2 user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRoles().getRoleName()));

        return authorities;
    }



    private Authentication authenticate(String userName, String userPassword) throws Exception {
        User2 user = userDao.findById(userName).orElse(null);
        if (user != null && passwordEncoder.matches(userPassword, user.getUserPassword())) {
            return new UsernamePasswordAuthenticationToken(userName, userPassword, getAuthority(user));
        } else {
            throw new Exception("Invalid credentials");
        }
    }
}
 /*   private void authenticate(String userName, String userPassword) throws Exception {
        // Perform your authentication logic here
        // You can use any custom authentication logic or skip it if not required
        // Example:
        if (!"admin".equals(userName) || !"password".equals(userPassword)) {
            throw new BadCredentialsException("Invalid credentials");
        }
    }*/
