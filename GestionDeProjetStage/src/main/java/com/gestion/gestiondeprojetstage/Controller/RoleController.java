package com.gestion.gestiondeprojetstage.Controller;

import com.gestion.gestiondeprojetstage.Entity.Role;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.dao.RoleDao;
import com.gestion.gestiondeprojetstage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getRoles() {
        List<Role> secteurs = roleService.getRoles();
        List<String> secteurNames = new ArrayList<>();

        for (Role secteur : secteurs) {
            secteurNames.add(secteur.getRoleName());
        }

        return secteurNames;
    }

}
