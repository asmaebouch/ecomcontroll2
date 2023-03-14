package metier;

import dao.IDao;
import dao.Personne;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PersonneMetier implements IMetier {
    IDao<Personne,Long> ageDao;
    public IDao<Personne, Long> setCreditDao(IDao<Personne,Long> dao){
        return this.ageDao=dao;
    }

    @Override
    public Personne clculer_Age(Long idPersonne) throws Exception {
        var age = ageDao.trouverParId(idPersonne);
        if (age == null) throw new Exception("L'id du personne est incrorreecte :: [Personne non trouve]");
        else {

           Integer Islamic_year = (int) ((age.getYear() - 622) * 0.970223);
         age.setIslamicYear(Islamic_year);
         /////////////////////////////
            Calendar islamicCalendar = new GregorianCalendar();
            islamicCalendar.set(Calendar.YEAR, islamicCalendar.get(Calendar.YEAR));

            // Get the current year in the Gregorian calendar
            int currentGregorianYear = Year.now().getValue();

// Calculate the current year in the Islamic calendar
            int currentIslamicYear = (int) ((currentGregorianYear - 622) * 0.970223);

// Display the current year in the Islamic calendar
            System.out.println("Current year in the Islamic calendar: " + currentIslamicYear);

          int agecurreent =currentIslamicYear -Islamic_year;

            System.out.println("your age is "+agecurreent+" ^_^");
            /////////////////////////
            return age;
        }

    }
}
