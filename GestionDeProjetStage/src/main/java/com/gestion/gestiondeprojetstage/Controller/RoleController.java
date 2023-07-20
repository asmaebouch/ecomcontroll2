package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Role;
import com.gestion.gestiondeprojetstage.dao.RoleDao;
import com.gestion.gestiondeprojetstage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    private RoleDao roleDao;
    @PostMapping
            ({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role){
     return roleService.createNewRole(role);
    }
    @GetMapping({"/roles"})
    public ResponseEntity<?> getRoles() {
        Iterable<Role> roles = roleDao.findAll();
        return ResponseEntity.ok(roles);
    }

}
