package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Role;
import com.gestion.gestiondeprojetstage.Entity.SignUp;
import com.gestion.gestiondeprojetstage.Entity.User2;
import com.gestion.gestiondeprojetstage.dao.RoleDao;
import com.gestion.gestiondeprojetstage.dao.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        roleDao.save(userRole);

        Role userRole2 = new Role();
        userRole2.setRoleName("ChefDeProjet");
        roleDao.save(userRole2);

        User2 adminUser = new User2();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setRoles(adminRole);

        User2 user = new User2();
        user.setUserName("raj123");
        user.setUserPassword(getEncodedPassword("raj@123"));
        user.setUserFirstName("raj");
        user.setUserLastName("sharma");
       user.setRoles(userRole);
       userDao.save(user);
       userDao.save(adminUser);
       // Userr.setRoles((List<Role>) userRole);

    }
    public User2 registerNewUser(SignUp jwtResponse) {
        User2 user = new User2();
        String roleName = jwtResponse.getRoles().getRoleName();
        Role role = roleDao.findByRoleName(roleName);

        if (role == null) {
            // Role does not exist in the database, create a new one
            role = new Role(roleName);
            role = roleDao.save(role);
        }

        // Set the fetched Role object in the User2 entity
        user = new User2(
                        jwtResponse.getUserName(),
                        jwtResponse.getEmail(),
                        jwtResponse.getUserLastName(),
                        jwtResponse.getUserFirstName(),
                        jwtResponse.getDateNaissance(),
                        jwtResponse.getTelephone(),
                        jwtResponse.getDateDeRecrutement(),
                role,
                jwtResponse.getSexe(),
                        this.passwordEncoder.encode(jwtResponse.getUserPassword()));
        //   user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }
    public List<User2> getUser2()
    {

        return (List<User2>) userDao.findAll();
    }
    @Transactional

    public void deleteUser(String userName) {
        System.out.println("hola2");
        userDao.deleteByuserName(userName);
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
    @Transactional
    public User2 updateUser(User2 client){
        String id = client.getUserName();
        User2 client1 = userDao.findById(id).get();

        if (client1 == null) {
            System.out.println("eerrrorrr client no found");
        }

        // Update client properties if client1 is not null
        if (client1 != null) {
            client1.setUserName(client.getUserName());
            client1.setUserFirstName(client.getUserFirstName());
            client1.setUserLastName(client.getUserLastName());
            client1.setSexe(client.getSexe());
            client1.setEmail(client.getEmail());
            client1.setTelephone(client.getTelephone());
            client1.setDateNaissance(client.getDateNaissance());
            client1.setDateDeRecrutement(client.getDateDeRecrutement());
            client1.setRoles(client.getRoles());
            return userDao.save(client1);
        }

        return null;
    }

}
