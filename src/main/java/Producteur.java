import java.util.List;
import java.util.Random;

public class Producteur extends Thread {

    List<String> produits;
    public Producteur(List<String> produits) {
        this.produits = produits;
    }

    Random rand = new Random();

    public void run() {
        while (true) {
            synchronized (produits){
                System.out.println(getName() + " a ajouté le produit numéro " + produits.size());
                produits.add("numéro " + produits.size());
            }
            int temps = rand.nextInt(5000);
            System.out.println("Attente Producteur" + temps);
            try { sleep(temps) ; } catch (InterruptedException e) { };
        }
    }
}
