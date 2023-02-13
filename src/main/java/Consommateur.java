import java.util.List;
import java.util.Random;

public class Consommateur extends Thread {
    List<String> produits;
    public Consommateur(List<String> produits) {
        this.produits = produits;
    }

    Random rand = new Random();

    public void run() {
        while (true) {
            synchronized (produits) {
                if ( ! produits.isEmpty()) {
                    int last = produits.size() - 1;
                    System.out.println(getName() + "tente de lire le produit :" + last);
                    String produit = produits.get(last);
                    System.out.println(getName() + " a lu le produit : " + produit);
                    System.out.println(getName() + " tente d'enlever le produit : " + produit);
                    produits.remove(last);
                    System.out.println(getName() + " a enlevé le produit : " + produit);
                }
            }
            int temps = rand.nextInt(5000);
            System.out.println("Attente Producteur" + temps);
            try { sleep(temps) ; } catch (InterruptedException e) { };
        }
    }
}
