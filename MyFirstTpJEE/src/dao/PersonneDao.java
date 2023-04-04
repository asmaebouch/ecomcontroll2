package dao;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component("dao")
public class PersonneDao implements IDao<Personne,Long>{
    public  static Set<Personne> BDPersonne()
    {
        return new HashSet<Personne>(
                Arrays.asList(
                        //    public Personne(Long id, int year, String nomUtilisateur, String prenomUtilisateur,int islamicYear,int month,int day){
                        new Personne(1L,2002,"Bouchekara","Asmae",null,1,28),
                       new Personne(2L,2001,"Chmamse dine ","Moncif",null,12,11))

        );
    }

    @Override
    public Personne trouverParId(Long aLong) {
        System.out.println("[DAO -DS volatile] trouver le peersonne" + aLong);
        return BDPersonne().stream().filter(personne -> personne.getId()==aLong).findFirst().orElse(null);
    }
}
