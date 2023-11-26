package com.gestion.gestiondeprojetstage.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FormWithClientsDTO {
    private String formName;
    private List<Client> clients;
}

