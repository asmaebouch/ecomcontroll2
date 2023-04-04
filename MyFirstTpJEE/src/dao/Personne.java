package dao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor
public class Personne {
    private Long id;
    private int year;
    private int month;
    private int day;
    private String nomUtilisateur ;
    private String prenomUtilisateur;
    private String islamicYear;


    public Personne(Long id, int year, String nomUtilisateur, String prenomUtilisateur,String islamicYear,int month,int day){
        this.id=id;
        this.nomUtilisateur=nomUtilisateur;
        this.prenomUtilisateur=prenomUtilisateur;
        this.year=year;
        this.month=month;
        this.day=day;
        this.islamicYear=islamicYear;

    }

    public int getYear() {
        return year;
    }

    public Long getId() {
        return id;
    }
    public int getDay(){
        return day;
    }
    public int getMonth()
    {
        return month;
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setIslamicYear(String islamicYear) {
        this.islamicYear = islamicYear;
    }



    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", year=" + year +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", prenomUtilisateur='" + prenomUtilisateur + '\'' +
                ", Islamic Year = ' " +islamicYear+
                "'" + '}';
    }
}
