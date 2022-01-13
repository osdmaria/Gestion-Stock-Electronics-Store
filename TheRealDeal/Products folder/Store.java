import java.util.ArrayList;
import java.util.Scanner;

import database.ASCIIArtGenerator;
import database.ASCIIArtGenerator.ASCIIArtFont;

public class Store {

    public static int choixUser(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Taper le chiffre de votre choix:\n");
        int choice = keyboard.nextInt();
        return choice;
    }
    
    public static void main(String[] args) throws Exception {
        DataBase db = new DataBase();
        DataBaseC dbC = new DataBaseC();
        Scanner s = new Scanner(System.in);

        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt("BIENVENUE DANS", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_SANS_SERIF,"*");
        System.out.println();
        System.out.println();
        artGen.printTextArt("NOTRE B O U T I Q U E !", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_SANS_SERIF,"*");
        System.out.println();

        System.out.println("Voulez vous executer le programme en tant que:");
        System.out.println("1- Magasiner");
        System.out.println("2- Agent Commercial");
        System.out.println("3- Client");
        // Take user input
        int choice;
        do {
            choice = choixUser();
        } while (choice != 1 && choice!=2 && choice !=3);

        switch (choice) {




            case 1: //Start executing Magasinier stuff: say Hello... option: Ajouter un produit au stock 
                
                System.out.println("Salutations cher magasinier!");
                System.out.println("Que voulez vous faire aujourd'hui");
                System.out.println("1- Ajouter un produit au stock");
                int c1;
                do {
                    c1 = choixUser();
                } while (c1 != 1);
                System.out.println("Dans quelle categories voudrier vous l'ajouter");
                System.out.println("1 - Mobiles \n2- Informatique \n3- Electronique \n4- Electromenager \n5- Kit Scolaire");
                do {
                    c1 = choixUser();
                } while (c1 != 1 && c1 != 2 && c1 != 3 && c1 != 4 && c1 != 5);
                Product product = new Product();
                product = product.ajoutProduct();

                switch (c1) {
                    case 1:
                        Categories categorie = db.DB_stock.categories.get(0);    
                        db.addProduct(product, categorie);
                        break;
                    
                    case 2:
                        Categories categorie1 = db.DB_stock.categories.get(1);    
                        db.addProduct(product, categorie1);
                        break;

                    case 3:
                        Categories categorie2 = db.DB_stock.categories.get(2);    
                        db.addProduct(product, categorie2);
                        break;

                    case 4:
                        Categories categorie3 = db.DB_stock.categories.get(3);    
                        db.addProduct(product, categorie3);
                        break;

                    case 5:
                        Categories categorie4 = db.DB_stock.categories.get(4);    
                        db.addProduct(product, categorie4);
                        break;
                    
                }
                if(db.search_In_DB(product.ref).ref == product.ref){
                    System.out.println("Voici le produit que vous avez entré au stock:");
                    product.affiche_produit();
                }

                break;









            case 2://start executing Agent Commercial stuff: say Hello.. options: - Vendre un produit   - Retourner un produit   -Creer une compte fidélité à un client    - Checker la caisse
            System.out.println("Salutations cher Agent Commercial!");
            System.out.println("Que voulez vous faire aujourd'hui");
            System.out.println("1- Vendre un produit. \n2- Retourner un produit. \n3- Créer un compte fidelite à un client. \n4- Checker la caisse");
            int c2;
            int caisse = 0;
            int ref_C;
            CompteClient cclient = new CompteClient();
            do {
                c2 = choixUser();
            } while (c2 != 1 && c2 != 2 && c2 != 3 && c2 != 4 );
            switch (c2) {
                case 1:
                    System.out.println("Vendre un produit.");
                    int choix1 = 0;
                    do {
                        System.out.println("Le client, a-t-il un compte fidélité:");
                        System.out.println("1- Oui \n2- Non");
                        choix1 = choixUser();
                        
                    } while (choix1 != 1 && choix1 != 2);
                    
                    if(choix1 ==1){
                        System.out.println("Entrer la reference du client");  //utiliser la ref du client pour le trouver 
                        ref_C = s.nextInt();
                        cclient = dbC.searchClient(ref_C);
                        cclient.AfficheCompte();
                    }

                    System.out.println("Entrer le nombre de produits à acheter");
                    int n = s.nextInt();
                    ArrayList<Product> achats = new ArrayList<>();
                    for(int i = 1; i<=n;i++){
                        System.out.println("Entrer la reference de produit " + i);
                        int ref = s.nextInt();
                        if (db.search_In_DB(ref)==null){
                            System.out.println("Le produit n'existe pas dans le stock");
                        } else
                        if(db.search_In_DB(ref).verifier_Produit_Dispo()==true && db.search_In_DB(ref).quantite>0){
                            System.out.println("Voici le produit recherche:");
                            db.search_In_DB(ref).affiche_produit();
                            achats.add(db.search_In_DB(ref));
                        }
                        else if(db.search_In_DB(ref).verifier_Produit_Dispo()==false){
                            System.out.println("Le produit est en rupture de stock");
                        }
                    }
                    if(achats.isEmpty() == false){
                        System.out.println("Voici le panier du client" );
                        for(Product p : achats){
                            if(choix1 == 1){
                                if(db.search_Rebrique_DB(p.ref).reb_N == cclient.getmontantcumule().get(0).reb_N){
                                    cclient.getmontantcumule().get(0).montant_cumule_de_rebrique =+ p.prix;
                                }
                                if(db.search_Rebrique_DB(p.ref).reb_N == cclient.getmontantcumule().get(1).reb_N){
                                    cclient.getmontantcumule().get(1).montant_cumule_de_rebrique =+ p.prix;
                                }
                                if(db.search_Rebrique_DB(p.ref).reb_N == cclient.getmontantcumule().get(2).reb_N){
                                    cclient.getmontantcumule().get(2).montant_cumule_de_rebrique =+ p.prix;
                                }

                            }
                            
                        System.out.println("- " + p.name);
                        
                        }
                        
                        int choix= 0;
                        do {
                            System.out.println("Presser sur 1 pour confirmer");
                            choix= s.nextInt();
                            
                        } while (choix != 1);
                        System.out.println("La vente est confirmée!");

                    }
                    
                    
                    
                    

                    break;
                case 2:
                    
                    break;    
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                
            }
                break;










            case 3://Client part: options: -Checker tout le stock (via categories) 
                                                // peut reserver un produit (ajouté au panier)
                                                // peut acheter un produit
                                                // recherche
                                                // Checker le panier
                                    //Faire le login    ->   Checker son compte
                                    //- Beneficier d'une remise

                break;
        }
            

    }

}
