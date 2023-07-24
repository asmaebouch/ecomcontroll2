package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.JwtResponse;
import com.gestion.gestiondeprojetstage.Entity.Role;
import com.gestion.gestiondeprojetstage.Entity.SignUp;
import com.gestion.gestiondeprojetstage.Entity.User2;
import com.gestion.gestiondeprojetstage.dao.RoleDao;
import com.gestion.gestiondeprojetstage.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("Collaborateur");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        Role userRole2 = new Role();
        userRole2.setRoleName("Chef De Projet");
        userRole2.setRoleDescription("Chef De projet");
        roleDao.save(userRole2);

        User2 adminUser = new User2();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);

        User2 user = new User2();
        user.setUserName("raj123");
        user.setUserPassword(getEncodedPassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
       Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
       user.setRoles(userRoles);
       userDao.save(user);
       // Userr.setRoles((List<Role>) userRole);
        userDao.save(adminUser);

    }
    public User2 registerNewUser(SignUp jwtResponse) {
        User2 user;
        user = new User2(
                jwtResponse.getUserName(),
                jwtResponse.getEmail(),
                jwtResponse.getUserLastName(),
                jwtResponse.getUserFirstName(),
                jwtResponse.getDateNaissance(),
                jwtResponse.getTelephone(),
                jwtResponse.getDateDeRecrutement(),
                (Set<Role>) jwtResponse.getRoles(),
                jwtResponse.getSexe(),

                this.passwordEncoder.encode(jwtResponse.getUserPassword()));


        //   user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
