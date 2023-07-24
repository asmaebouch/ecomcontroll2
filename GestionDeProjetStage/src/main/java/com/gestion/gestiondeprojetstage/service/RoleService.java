package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.Client;
import com.gestion.gestiondeprojetstage.Entity.Role;
import com.gestion.gestiondeprojetstage.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role createNewRole(Role role){
    return  roleDao.save(role);
    }
    public List<Role> getRoles()
    {
        return (List<Role>) roleDao.findAll();
    }
}
