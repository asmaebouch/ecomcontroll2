import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Voiture extends Vehicule{
  public  int f(int x){return(x+4);}
    public int g(int x){return(x+8);}
    public void afficher(){
        System.out.println("Voi");
    }
    public static void main(String[] args) {

Voiture d=  new Voiture();
d.afficher();
Vehicule a= d;
a.afficher();
        System.out.println(a.f(2)*a.g(3));
    }
}
