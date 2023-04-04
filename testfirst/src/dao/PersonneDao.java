package dao;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Component("dao")
public class PersonneDao implements IDao<Personne,Long>{
    public  static Set<Personne> BDPersonne()
    {
        return new HashSet<Personne>(
                Arrays.asList(
                        new Personne(1L,2002,"Bouchekara","Asmae",0))

        );
    }
    @Override
    public Personne trouverParId(Long aLong) {
        System.out.println("[DAO -DS volatile] trouver le peersonne" + aLong);
        return BDPersonne().stream().filter(personne -> personne.getId()==aLong).findFirst().orElse(null);
    }
}
