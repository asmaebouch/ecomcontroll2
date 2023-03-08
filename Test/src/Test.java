public class Test extends Object {

Test(String s){
    super();
}
public static double find(double x) {
    if(x==0){
         new E2("Erreur");
    }
    return x;
}

    public static void main(String[] args) throws Exception {
        new Test("errer");
        try {
            find(0);
        }catch (Exception e)
        {
            e.getMessage();
        }

    }
}
