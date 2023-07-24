package com.gestion.gestiondeprojetstage.service;

import com.gestion.gestiondeprojetstage.Entity.FormJuridique;
import com.gestion.gestiondeprojetstage.Entity.SecateursActivity;
import com.gestion.gestiondeprojetstage.Repository.FormJuridiqueRpository;
import com.gestion.gestiondeprojetstage.Repository.SecteurActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FormJuridiqueService {
    @Autowired
    private FormJuridiqueRpository formJuridiqueRpository;
    public FormJuridique registreForm(FormJuridique secateursActivity){
        return formJuridiqueRpository.save(secateursActivity);
    }
    public List<FormJuridique> getForm(){
        return formJuridiqueRpository.findAll();
    }
    public void deleteForme(Integer id)
    {

        formJuridiqueRpository.deleteById(Long.valueOf(id));
    }

}
