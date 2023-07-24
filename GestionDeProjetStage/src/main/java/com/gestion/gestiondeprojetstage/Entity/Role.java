package com.gestion.gestiondeprojetstage.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id

    private String roleName;
    private String roleDescription;
    @ElementCollection
    private List<String> roles;
    @JsonCreator
    public Role(@JsonProperty("roleName") String roleName) {
        this.roleName = roleName;
    }
}
