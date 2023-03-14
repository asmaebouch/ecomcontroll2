package metier;

import dao.Personne;

public interface IMetier {
    Personne clculer_Age(Long idPersonne) throws Exception;
}
