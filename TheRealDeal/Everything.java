import java.util.ArrayList;
import java.util.Scanner;

import database.ASCIIArtGenerator;
import database.ASCIIArtGenerator.ASCIIArtFont;
import java.util.Scanner;


public class Everything {

    public int choixUser(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Taper le chiffre de votre choix:\n");
        int choice = keyboard.nextInt();
        keyboard.close();
        return choice;
    }


    public static void main(String[] args) throws Exception {

        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt("BIENVENUE DANS", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_SANS_SERIF,"*");
        System.out.println();
        System.out.println();
        try {
            artGen.printTextArt("NOTRE B O U T I Q U E !", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_SANS_SERIF,"*");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println();
        //to get the name of the category
        DataBase db = new DataBase();
        String ct = db.rebrique1.reb_N;
        System.out.println(ct);



        // Product p = db.rebrique1.rebrique.get(1);
        // p.affiche_produit();



        
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println("Entrer les informations du produit:");
        // System.out.println("Nom:\n");
        // String name = keyboard.nextLine();

        // System.out.println("Reference:\n");
        // int ref = keyboard.nextInt();
        // keyboard.nextLine();

        
        // String[] caracteristics = new String[3];
        // System.out.println("Caracteristics: (3 only)\n");
        // for(int i=0; i<3; i++){
        //     caracteristics[i] = keyboard.nextLine();
        // }  

        // System.out.println("Description:\n");
        // String description1 = keyboard.nextLine();

        
        // System.out.println("Prix:\n");
        // int prix = keyboard.nextInt();

        // System.out.println("Quantite:\n");
        // int quantite = keyboard.nextInt();

        // DataBase db = new DataBase();
        // Product pr = db.search_In_DB(100);
        // if (pr!=null){
        //     System.out.println("Trouvé!");
        //     pr.affiche_produit();
        // }
        // keyboard.close();
        // Product produit = new Product(name, ref, description1, caracteristics, prix, quantite);
        // produit.affiche_produit();
    }

    
}
