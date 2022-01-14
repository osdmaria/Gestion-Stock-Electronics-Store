import java.util.ArrayList;
import java.util.Scanner;

import database.ASCIIArtGenerator;
import database.ASCIIArtGenerator.ASCIIArtFont;

public class Store {

    public static int choixUser() {
        Scanner keyboard = new Scanner(System.in);
        // System.out.println("Taper le chiffre de votre choix:\n");
        int choice = keyboard.nextInt();
        return choice;
    }

    public static String userinput() {
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.next();
        return userInput;
    }

    public static void main(String[] args) throws Exception {
        DataBaseP db = new DataBaseP();
        DataBaseC dbC = new DataBaseC();
        Scanner s = new Scanner(System.in);

        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt("BIENVENUE DANS", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_SANS_SERIF, "#");
        System.out.println();
        System.out.println();
        artGen.printTextArt("NOTRE B O U T I Q U E !", ASCIIArtGenerator.ART_SIZE_SMALL,
                ASCIIArtFont.ART_FONT_SANS_SERIF, "#");
        System.out.println();

        System.out.println("Voulez vous executer le programme en tant que:");
        System.out.println("1- Magasiner");
        System.out.println("2- Agent Commercial");
        System.out.println("3- Client\n");
        System.out.println("4- Responsable Commercial\n");
        System.out.println("0- Quitter");
        // Take user input
        int choice;
        do {
            choice = choixUser();
        } while (choice != 1 && choice != 2 && choice != 3 && choice !=0);

        switch (choice) {

            case 1: // Start executing Magasinier stuff: say Hello... option: Ajouter un produit au
                    // stock

                System.out.println("Salutations cher magasinier!");
                System.out.println("Que voulez vous faire aujourd'hui");
                System.out.println("1- Ajouter un produit au stock");
                int c1;
                do {
                    c1 = choixUser();
                } while (c1 != 1);
                System.out.println("Dans quelle categories voudrier vous l'ajouter");
                System.out.println(
                        "1 - Informatique \n2- Mobiles \n3- Electronique \n4- Electromenager \n5- Kit Scolaire");
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
                if (db.search_In_DB(product.ref).ref == product.ref) {
                    System.out.println("Voici le produit que vous avez entré au stock:");
                    product.affiche_produit();
                }
                System.out.println("Merci! Passez une bonne journée");

                break;

            case 2:// start executing Agent Commercial stuff: say Hello.. options: - Vendre un
                   // produit - Retourner un produit -Creer une compte fidélité à un client -
                   // Checker la caisse
                System.out.println("Salutations cher Agent Commercial!");
                System.out.println("Que voulez vous faire aujourd'hui");
                System.out.println(
                        "1- Vendre un produit. \n2- Retourner un produit. \n3- Créer un compte fidelite à un client. \n4- Checker la caisse");
                int c2;
                int caisse = 0;
                int ref_C;
                int sum = 0;
                CompteClient cclient = new CompteClient();
                do {
                    c2 = choixUser();
                } while (c2 != 1 && c2 != 2 && c2 != 3 && c2 != 4);
                switch (c2) {
                    case 1:
                        System.out.println("Vendre un produit.");
                        int choix1 = 0;
                        do {
                            System.out.println("Le client, a-t-il un compte fidélité:");
                            System.out.println("1- Oui \n2- Non");
                            choix1 = choixUser();

                        } while (choix1 != 1 && choix1 != 2);

                        if (choix1 == 1) {
                            System.out.println("Entrer la reference du client"); // utiliser la ref du client pour le
                                                                                 // trouver
                            ref_C = s.nextInt();
                            cclient = dbC.searchClient(ref_C);
                            if (cclient != null) {
                                cclient.AfficheCompte();
                            }
                        }

                        System.out.println("Entrer le nombre de produits à acheter");
                        int n = s.nextInt();
                        ArrayList<Product> achats = new ArrayList<>();
                        for (int i = 1; i <= n; i++) {
                            System.out.println("Entrer la reference de produit " + i);
                            int ref = s.nextInt();
                            if (db.search_In_DB(ref) == null) {
                                System.out.println("Le produit n'existe pas dans le stock");
                            } else if (db.search_In_DB(ref).verifier_Produit_Dispo() == true
                                    && db.search_In_DB(ref).quantite > 0) {
                                System.out.println("Voici le produit recherche:");
                                db.search_In_DB(ref).affiche_produit();
                                achats.add(db.search_In_DB(ref));
                            } else if (db.search_In_DB(ref).verifier_Produit_Dispo() == false) {
                                System.out.println("Le produit est en rupture de stock");
                            }
                        }
                        if (achats.isEmpty() == false) {
                            System.out.println("Voici le panier du client");
                            for (Product p : achats) {
                                System.out.println("- Nom du produit:" + p.name);
                                System.out.println("      Prix:" + p.prix);
                            }

                            if (choix1 == 1 && cclient != null) {
                                if (cclient.getmontantcumule().get(0).montant_cumule_de_rebrique
                                        + cclient.getmontantcumule().get(1).montant_cumule_de_rebrique
                                        + cclient.getmontantcumule().get(2).montant_cumule_de_rebrique == 0) {
                                    System.out.println(
                                            "Le client ne peut pas belificier d'une remise car il n'a pas de montant cumulé");
                                    sum = db.vendreSansRemise(achats);
                                } else {
                                    System.out.println(
                                            "Le client peut benificier d'une remise, voudrait-il l'appliquer?");
                                    int choix2 = 0;
                                    do {
                                        System.out.println("1- Oui \n2- Non");
                                        choix2 = s.nextInt();

                                    } while (choix2 != 1 && choix2 != 2);
                                    if (choix2 == 1) {
                                        for (Product pr : achats) {
                                            if (db.search_Rebrique_DB(pr.ref).reb_N == cclient.getmontantcumule()
                                                    .get(0).reb_N) {
                                                if (cclient.getmontantcumule().get(0).montant_cumule_de_rebrique > 0) {
                                                    sum = pr.prixApresRemise(cclient.getmontantcumule()
                                                            .get(0).montant_cumule_de_rebrique, 5) + sum;
                                                    cclient.getmontantcumule().get(0).montant_cumule_de_rebrique = 0;
                                                } else {
                                                    sum = +pr.prix;
                                                }
                                            }
                                            if (db.search_Rebrique_DB(pr.ref).reb_N == cclient.getmontantcumule()
                                                    .get(1).reb_N) {
                                                if (cclient.getmontantcumule().get(1).montant_cumule_de_rebrique > 0) {
                                                    sum = pr.prixApresRemise(cclient.getmontantcumule()
                                                            .get(1).montant_cumule_de_rebrique, 10) + sum;
                                                    cclient.getmontantcumule().get(1).montant_cumule_de_rebrique = 0;
                                                } else {
                                                    sum = +pr.prix;
                                                }
                                            }
                                            if (db.search_Rebrique_DB(pr.ref).reb_N == cclient.getmontantcumule()
                                                    .get(2).reb_N) {
                                                if (cclient.getmontantcumule().get(2).montant_cumule_de_rebrique > 0) {
                                                    sum = pr.prixApresRemise(cclient.getmontantcumule()
                                                            .get(2).montant_cumule_de_rebrique, 15) + sum;
                                                    cclient.getmontantcumule().get(2).montant_cumule_de_rebrique = 0;
                                                } else {
                                                    sum = +pr.prix;
                                                }
                                            }
                                        }

                                    } else {
                                        sum = db.vendreSansRemise(achats);
                                    }
                                }

                                for (Product p : achats) {
                                    p.setQuantite(p.quantite--);
                                    if (db.search_Rebrique_DB(p.ref).reb_N == cclient.getmontantcumule().get(0).reb_N) {
                                        cclient.getmontantcumule().get(0).montant_cumule_de_rebrique = +p.prix;
                                    }
                                    if (db.search_Rebrique_DB(p.ref).reb_N == cclient.getmontantcumule().get(1).reb_N) {
                                        cclient.getmontantcumule().get(1).montant_cumule_de_rebrique = +p.prix;
                                    }
                                    if (db.search_Rebrique_DB(p.ref).reb_N == cclient.getmontantcumule().get(2).reb_N) {
                                        cclient.getmontantcumule().get(2).montant_cumule_de_rebrique = +p.prix;
                                    }

                                }
                            }
                            int choix = 0;
                            do {
                                System.out.println("Presser sur 1 pour confirmer");
                                choix = s.nextInt();

                            } while (choix != 1);
                            caisse = +sum;
                            System.out.println("La vente est confirmée!");
                            System.out.println("La caisse a ete mise a jour:" + caisse + "DA");

                        } else {
                            System.out.println("Aucun produit n'est disponible");
                        }

                        break;

                    case 2:
                        DataBaseP D = new DataBaseP();

                        System.out.println("Retourner un produit");

                        System.out.println("Donner le ref du produit que vous voulez retourner");
                        int refp = choixUser();
                        Product p = D.search_In_DB(refp);
                        System.out.println("Ce produit va etre retourné:  " + p.getName());
                        int temp;
                        do {
                            System.out.println("Taper 1 pour confirmer");
                            temp = s.nextInt();
                            
                        } while (temp !=1);
                        int qt = p.getQuantite();
                        D.update_Quantity(refp, qt++);
                        caisse = caisse + p.getPrix();
                        System.out.println("Le produit a ete retourne . ");

                        break;

                    case 3:
                        DataBaseC DD = new DataBaseC();

                        System.out.println("Creer un compte client");
                        AgentCommercial AC = new AgentCommercial();
                        CompteClient cc = AC.createCompteClient();
                        cc.AfficheCompte();
                        DD.addCClient(cc);

                        break;
                    case 4:
                        System.out.println("Bienvenue dans votre caisse: ");
                        System.out.println("Votre caisse contient: " + caisse);
                        break;

                }
                break;

            case 3:
                System.out.println("Bienvenue cher client");
                System.out.println("Que voulez vous faire ?");
                System.out.println("1-Checker le showroom");
                System.out.println("2-Recherche d'un produit");
                System.out.println("3-Login");
                System.out.println("4-Reserver");
                // Client part: options: -Checker tout le stock (via categories)
                int c3;

                do {
                    c3 = choixUser();
                } while (c3 != 1 && c3 != 2 && c3 != 3 && c3 != 4 && c3 != 5 && c3 != 6);

                switch (c3) {

                    case 1:// on va afficher les produits dans le stock pour le client
                        System.out.println("Choisissez une categorie ");
                        System.out.println(
                                "1 - Mobiles \n2- Informatique \n3- Electronique \n4- Electromenager \n5- Kit Scolaire");

                        int cat;

                        do {
                            cat = choixUser();
                        } while (cat != 1 && cat != 2 && cat != 3 && cat != 4 && cat != 5);

                        switch (cat) {
                            case 1:
                                Categories categorie = db.DB_stock.categories.get(0);
                                for (Product produit : categorie.products) {
                                    System.out.println("les noms des produits : " + produit.getName());
                                }

                                System.out.println("voulez vous d'autre informations sur les produits ?");
                                System.out.println("tapez 1 pour oui 0 sinon .");

                                int info;// take the value of yes or no
                                do {
                                    info = choixUser();
                                } while (info != 1 && info != 0);

                                switch (info) {
                                    case 1:
                                        for (Product produit : categorie.products) {
                                            produit.affiche_produit();
                                        }
                                        break;

                                    case 0:
                                        System.out.println("merci pour la visite ");
                                        break;
                                }
                                break;

                            case 2:
                                Categories categorie1 = db.DB_stock.categories.get(1);
                                for (Product produit : categorie1.products) {
                                    System.out.println("le nom du produit : " + produit.getName());
                                }

                                System.out.println("voulez vous d'autre informations sur les produits ?");
                                System.out.println("tapez 1 pour oui 0 sinon .");

                                int info1;// take the value of yes or no
                                do {
                                    info1 = choixUser();
                                } while (info1 != 1 && info1 != 0);

                                switch (info1) {
                                    case 1:
                                        for (Product produit : categorie1.products) {
                                            produit.affiche_produit();

                                        }
                                        break;

                                    case 0:
                                        System.out.println("merci pour la visite ");
                                        break;
                                }
                                break;

                            case 3:
                                Categories categorie2 = db.DB_stock.categories.get(2);
                                for (Product produit : categorie2.products) {
                                    System.out.println("le nom du produit : " + produit.getName());
                                }

                                System.out.println("voulez vous d'autre informations sur les produits ?");
                                System.out.println("tapez 1 pour oui 0 sinon .");

                                int info2;// take the value of yes or no
                                do {
                                    info2 = choixUser();
                                } while (info2 != 1 && info2 != 0);

                                switch (info2) {
                                    case 1:
                                        for (Product produit : categorie2.products) {
                                            produit.affiche_produit();

                                        }
                                        break;

                                    case 0:
                                        System.out.println("merci pour la visite ");
                                        break;
                                }
                                break;

                            case 4:
                                Categories categorie3 = db.DB_stock.categories.get(3);
                                for (Product produit : categorie3.products) {
                                    System.out.println("le nom du produit : " + produit.getName());
                                }

                                System.out.println("voulez vous d'autre informations sur les produits ?");
                                System.out.println("tapez 1 pour oui 0 sinon .");

                                int info3;// take the value of yes or no
                                do {
                                    info3 = choixUser();
                                } while (info3 != 1 && info3 != 0);

                                switch (info3) {
                                    case 1:
                                        for (Product produit : categorie3.products) {
                                            produit.affiche_produit();

                                        }
                                        break;

                                    case 0:
                                        System.out.println("merci pour la visite ");
                                        break;
                                }
                                break;

                            case 5:
                                Categories categorie4 = db.DB_stock.categories.get(4);
                                for (Product produit : categorie4.products) {
                                    System.out.println("le nom du produit : " + produit.getName());
                                }

                                System.out.println("voulez vous d'autre informations sur les produits ?");
                                System.out.println("tapez 1 pour oui, 0 sinon .");

                                int info4;// take the value of yes or no
                                do {
                                    info4 = choixUser();
                                } while (info4 != 1 && info4 != 0);

                                switch (info4) {
                                    case 1:
                                        for (Product produit : categorie4.products) {
                                            produit.affiche_produit();

                                        }
                                        break;

                                    case 0:
                                        System.out.println("merci pour la visite ");
                                        break;
                                }
                                break;
                        }
                        break;

                    case 2:// Recherche de produit par reference (verifier la disponibilite)
                        System.out.println("Recherche de produit par reference");
                        System.out.println("Veuillez donner la reference du produit que vous chercher");
                        DataBaseP data = new DataBaseP();
                        Product produit = new Product();
                        int reference = choixUser();
                        produit = data.search_In_DB(reference);
                        if (produit.verifier_Produit_Dispo()) {
                            System.out.println("Ce produit est disponible chez nous");
                            produit.affiche_produit();
                        } else {
                            System.out.println("On s'excuse ce produit n'est pas disponible.");
                        }

                        break;

                    case 3: // faire le login pour verifier le compte
                        System.out.println("Login");
                        System.out.println("Donner votre nom ");
                        String s1 = s.nextLine();
                        System.out.println("Donner votre prenom");
                        String s2 = s.nextLine();
                        System.out.println("Donner votre mot de passe ");
                        String s3 = s.nextLine();
                        CompteClient cmp = dbC.LoginClient(s1, s2, s3);
                        if (cmp != null) {
                            System.out.println("there's your account");
                            cmp.AfficheCompte();
                        } else {
                            System.out.println("Votre compte n'existe pas");
                        }

                        break;

                    case 4:
                        System.out.println("Reserver des produits");
                        DataBaseP Da = new DataBaseP();
                        ArrayList<Product> panier = new ArrayList<>();
                        Product prd;
                        int refp;
                        int ccc;
                        do {
                            ccc = 1;
                            System.out.println("Donner la reference du produit ");
                            refp = choixUser();
                            prd = Da.search_In_DB(refp);
                            if (prd != null) {
                                panier.add(prd);
                            } else {
                                System.out.println("lepppp");
                            }

                            System.out.println("voulez vous reserver autre chose ? \n 1 pour oui 0 pour non");

                            ccc = choixUser();
                        } while (ccc == 1);

                        System.out.println("Voulez vous voir ce vous avez reserver\n 1 pour voir 0 pour non");
                        int es = choixUser();
                        if (es == 1) {
                            if (panier != null) {
                                System.out.println("Votre panier");
                                for (Product pr : panier) {
                                    pr.affiche_produit();
                                    System.out.println();
                                }
                                System.out.println("Vous avez 2 jour pour venir recuperer vos produits");
                            }
                        }

                        break;

                }
                case 4:
                    System.out.println("");
                    break;
                case 0:
                System.out.println(".");;
                    break;
        }
        artGen.printTextArt("Merci pour votre visite", ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_SANS_SERIF,"#");
    }
}
