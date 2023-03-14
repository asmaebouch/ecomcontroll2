package presentation;

import metier.IMetier;

public class PersonneControleur implements IPersonneControleur{
    IMetier ageMetier;
    public IMetier setCreditMetier(IMetier metier){
        return this.ageMetier=metier;
    }

    @Override
    public void afficher_Age(Long idPersonne) throws Exception {
        var yeearIslamic =ageMetier.clculer_Age(idPersonne);
        System.out.println(yeearIslamic);
    }
}
