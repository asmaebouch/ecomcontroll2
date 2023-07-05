package ma.securetest.securetest.web;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestController {
    @GetMapping("/datatest")
    @PreAuthorize("hasAuthority('SCOPE_SECRETAIRE')")
    public Map<String, Object> dataTest
            (Authentication authentication) {
        return Map.of("message", "Daata test"
                ,
                "username", authentication.getName(),
                "authorities", authentication.getAuthorities());
    }

    @PostMapping("/savedata")
    @PreAuthorize("hasAuthority('SCOPE_MEDECIN')")

    public Map<String, Object> saveData(String data) {
        return Map.of("dataSaavdd", data);


    }
}
