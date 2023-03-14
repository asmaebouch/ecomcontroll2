package dao;

public class Personne {
    private Long id;
    private int year;
    private String nomUtilisateur ;
    private String prenomUtilisateur;
    private int islamicYear;


    public Personne(Long id, int year, String nomUtilisateur, String prenomUtilisateur,int islamicYear){
        this.id=id;
        this.nomUtilisateur=nomUtilisateur;
        this.prenomUtilisateur=prenomUtilisateur;
        this.year=year;
        this.islamicYear=islamicYear;
    }

    public int getYear() {
        return year;
    }

    public Long getId() {
        return id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setIslamicYear(int islamicYear) {
        this.islamicYear = islamicYear;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", year=" + year +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", prenomUtilisateur='" + prenomUtilisateur + '\'' +
                ", Islamic Year =' " +islamicYear+
                '}';
    }
}
