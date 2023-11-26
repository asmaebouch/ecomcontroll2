package com.example.demo.domaine;

import com.example.demo.model.Stade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "articleDTO", types = Stade.class)

public interface stadeDTO {

    Long getId();
    @Value("#{target.Nom}")
    String getNom();
    Double getPrice();
    @Value("#{target.Address}")
    String getAddress();
    @Value("#{target.Capacite_stock}")
    int getCapacite_stock();
    @Value("#{target.information_contrat}")
    String getinformation_contrat();
    @Value("#{target.Plan_stock}")
    String getPlan_stock();

}
