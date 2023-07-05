package com.gestion.gestiondeprojetstage.Entity;

import org.springframework.data.rest.core.config.Projection;
//personnaliser par eexemple je veux que le code
@Projection(name="P1",types = Client.class)
public interface ClientProjection {
    public StatutClient getStatutClient();
}
