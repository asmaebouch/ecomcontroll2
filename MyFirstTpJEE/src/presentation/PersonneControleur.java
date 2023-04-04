package presentation;

import metier.IMetier;
import metier.PersonneMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller

public class PersonneControleur implements IPersonneControleur{

    @Autowired
            @Qualifier("metier")
    IMetier ageMetier;
    public IMetier setCreditMetier(IMetier metier2){
        return this.ageMetier=metier2;
    }
    private PersonneMetier personneMetier;

    public void setPersonneMetier(PersonneMetier personneMetier) {
        this.personneMetier = personneMetier;
    }
    public PersonneControleur() {
        this.ageMetier = ageMetier;
    }
    public PersonneMetier getPersonneMetier() {
        return personneMetier;
    }
    @Override
    public void afficher_Age(Long idPersonne) throws Exception {
        var yeearIslamic =ageMetier.clculer_Age(idPersonne);
        System.out.println(yeearIslamic);
    }
}
