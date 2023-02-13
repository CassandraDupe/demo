import java.util.ArrayList;
import java.util.List;

public class javaApplication {
    public static void main(String[] args) throws Exception {
        List<String> produits = new ArrayList();
// on remplit la liste

        Consommateur cons = new Consommateur(produits);
        Consommateur cons2 = new Consommateur(produits);
        Producteur prod = new Producteur(produits);
        Producteur prod2 = new Producteur(produits);

        cons.start();
        cons2.start();
        prod.start();
        prod2.start();
    }
}