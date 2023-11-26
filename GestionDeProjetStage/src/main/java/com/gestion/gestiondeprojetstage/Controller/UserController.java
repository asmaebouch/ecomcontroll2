package com.gestion.gestiondeprojetstage.Controller;


import com.gestion.gestiondeprojetstage.Entity.SignUp;
import com.gestion.gestiondeprojetstage.Entity.User2;
import com.gestion.gestiondeprojetstage.configuration.util.JwtUtil;
import com.gestion.gestiondeprojetstage.dao.RoleDao;
import com.gestion.gestiondeprojetstage.dao.UserDao;
import com.gestion.gestiondeprojetstage.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
@Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    RoleDao roleDao;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initRolesAndUsers() {
        userService.initRolesAndUser();
    }

     @PostMapping(value = "/registerNewUser")
         public User2 registerNewUser (@RequestBody SignUp user){
         System.out.println("bloub");
         user.setRoles(user.getRoles());
         User2 user2= userService.registerNewUser(user);
        // jwtUtil.generateToken((UserDetails) user);
       //  user2.setUserPassword(jwtUtil.generateToken( user2));
         return user2;

     }
    @GetMapping("/getCollaborateur")
    @PreAuthorize("hasRole('Admin')")

    public List<User2> userList(){

        return userService.getUser2() ;
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
    @DeleteMapping("/deleteCollborateur")
    @PreAuthorize("hasRole('Admin')")
    public void deleteUser(@RequestParam String userName){
        System.out.println("holaa");
        userService.deleteUser(userName);
    }
    @PutMapping("/updateUser")
    @PreAuthorize("hasRole('Admin')")
    public User2 updateUser(@RequestBody User2 client){

        return   userService.updateUser(client);

    }

   /* @PostMapping(value = "/registerNewUser", consumes = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<String> registerNewUser(@RequestBody User2 signUpRequest) {


         /*   if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Email is already in use!"));
            }*/

        // Create new user's account
       /*     User2 user
                    = new User2(signUpRequest.getUserName(),
                    signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getUserPassword()));

        Set<Role> strRoles = signUpRequest.getRoles();
            Set<Role> roles = new HashSet<>();

            if (strRoles == null) {
                Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    if (role.equals("admin")) {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    } else if (role.equals("mod")) {
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    } else {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                });
            }

            user.setRoles(roles);
            userRepository.save(user);

            return ResponseEntity.ok("okk not goodd ");
        }
*/


    @GetMapping({"/forAdmin"})
   // @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to admin";
    }
    @GetMapping({"/forUser"})
   // @PreAuthorize("hasRole('User')")

    public String forUser(){
        return "This UrRL is only accessiblee to th user";
    }
    @GetMapping("/UserList")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public List<String> getUser() {
        List<User2> secteurs = userService.getUser2();
        List<String> secteurNames = new ArrayList<>();

        for (User2 secteur : secteurs) {
            secteurNames.add(secteur.getUserName());
        }

        return secteurNames;
    }

}
