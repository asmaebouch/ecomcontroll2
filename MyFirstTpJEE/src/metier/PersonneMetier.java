package metier;

import dao.IDao;
import dao.Personne;
import dao.PersonneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service("metier")

public class PersonneMetier implements IMetier {
 @Autowired
    @Qualifier("dao")

    IDao<Personne,Long> ageDao;
    public IDao<Personne, Long> setCreditDao(IDao<Personne,Long> dao2){
        return this.ageDao=dao2;
    }
    private PersonneDao personneDao;

    public void setPersonneDao(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    public PersonneDao getPersonneDao() {
        return personneDao;
    }

    @Override
    public Personne clculer_Age(Long idPersonne) throws Exception {
        var age = ageDao.trouverParId(idPersonne);
        if (age == null) throw new Exception("L'id du personne est incrorreecte :: [Personne non trouve]");
        else {

            LocalDate gregorianDate = LocalDate.of(age.getYear(), age.getMonth(), age.getDay());
            HijrahDate hijriDate = HijrahChronology.INSTANCE.date(gregorianDate);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("en"));
            String formattedHijriDate = formatter.format(hijriDate);
           // System.out.println(formattedHijriDate);

         age.setIslamicYear(formattedHijriDate);
         /////////////////////////////
           // Calendar islamicCalendar = new GregorianCalendar();
            //islamicCalendar.set(Calendar.YEAR, islamicCalendar.get(Calendar.YEAR));

            // Get the current year in the Gregorian calendar
           // int currentGregorianYear = Year.now().getValue();

// Calculate the current year in the Islamic calendar
          //  int currentIslamicYear = (int) ((currentGregorianYear - 622) * 0.970223);

// Display the current year in the Islamic calendar
        //    System.out.println("Current year in the Islamic calendar: " + currentIslamicYear);

          //int agecurreent =currentIslamicYear -Islamic_year;

         //   System.out.println("your age is "+agecurreent+" ^_^");
            /////////////////////////s
          return age;
        }

    }
}
