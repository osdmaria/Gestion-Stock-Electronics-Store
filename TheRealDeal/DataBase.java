import java.util.ArrayList;


public class DataBase {

    Stock DB_stock = new Stock();
    Rebrique rebrique1 = new Rebrique("Rebrique 01");
    Rebrique rebrique2 = new Rebrique("Rebrique 02");
    Rebrique rebrique3 = new Rebrique("Rebrique 03");

    public Stock getStock(){
        return this.DB_stock;
    }
    public void setStock(Stock stock){
        this.DB_stock = stock;
    }

    //constructor 

    public DataBase() {
        Categories Informatique = new Categories("Informatique");
        Categories Mobiles = new Categories("Mobiles");
        Categories Electronique = new Categories("Electronique");
        Categories Electromenager = new Categories("Electromenager");
        Categories Kits_scolaires = new Categories("kit scolaires");

        Stock stock = new Stock();

        Rebrique reb1= new Rebrique("Rebrique 01");
        Rebrique reb2= new Rebrique("Rebrique 02");
        Rebrique reb3= new Rebrique("Rebrique 03");

        //Categorie informatique
        stock.categories.add(Informatique);

        String[] caracteristics = new String[]{"this", "that", "dccc"};
        Informatique.products.add(new Product("kfj", 1442, "ddddd",caracteristics, 1000, 13));

        reb1.rebriques.addAll(Informatique.products);

        //Categorie Mobiles
        stock.categories.add(Mobiles);

        String[] caracteristics1 = new String[]{"fgggg", "kkkk", "zzzzzz"};
        Mobiles.products.add(new Product("der", 1111, "aaaaa",caracteristics1, 1100, 15));

    
        //Categorie Electronique
        stock.categories.add(Electronique);

        String[] caracteristics2 = new String[]{"ttttt", "gggg", "bbbb"};
        Electronique.products.add(new Product("uki", 1776, "ggggg",caracteristics2, 1200, 1));
        

        // Categorie Electromenager
        stock.categories.add(Electromenager);

        String[] caracteristics3 = new String[]{"55555", "g5kg", "kob"};
        Electromenager.products.add(new Product("uki", 1455, "ggggg",caracteristics3, 1520, 10));

        //Kts scolaires
        stock.categories.add(Kits_scolaires);

        String[] caracteristics4 = new String[]{"aaaas", "scsdf", "cxvv"};
        Kits_scolaires.products.add(new Product("uki", 1475, "ggggg",caracteristics4, 1422, 22));

        this.DB_stock = stock;


        reb1.rebriques.addAll(Informatique.products);
        reb1.rebriques.addAll(Mobiles.products);
        reb2.rebriques.addAll(Electronique.products);
        reb2.rebriques.addAll(Electromenager.products);
        reb3.rebriques.addAll(Kits_scolaires.products);
        
        this.rebrique1 = reb1;
        this.rebrique2 = reb2;
        this.rebrique3 = reb3;


        // A print test

        // System.out.println("Produits informatique:");
        // for(Product product : Informatique.products){
        //     product.affiche_produit();
        // }
        // System.out.println("Produits mobiles:");
        // for(Product product : Mobiles.products){
        //     product.affiche_produit();
        // }
        // System.out.println("Produits electroniques:");
        // for(Product product : Electronique.products){
        //     product.affiche_produit();
        // }
        // System.out.println("Produits electromenagers:");
        // for(Product product : Electromenager.products){
        //     product.affiche_produit();
        // }
        // System.out.println("Produits kits scolaires:");
        //  for(Product product : Kits_scolaires.products){
        //     product.affiche_produit();
        // }

    }

    public Product search_In_DB(int ref){
        Stock stock = this.DB_stock;
        for (Categories categorie : stock.categories){
            for(Product product : categorie.products){
                if(product.ref == ref){
                    return product;
                }
            }
        }
        return null;
    }

    public Categories search_Category_DB(int ref){
        Stock stock = this.DB_stock;
        for (Categories categorie : stock.categories){
            for(Product product : categorie.products){
                if(product.ref == ref){
                    return categorie;
                }
            }
        }
        return null;
    }
    


    public void update_Quantity(int ref, int quantity){
        if(this.search_In_DB(ref) != null){
            this.search_In_DB(ref).quantite = quantity;
        }
    }
    public void update_Price(int ref, int price){
        if(this.search_In_DB(ref) != null){
            this.search_In_DB(ref).prix = price;
        }
    }

    public void addProduct(Product product, Categories categorie){
        for(Categories categorie0 : this.DB_stock.categories){
            if(categorie0.ctg_name == categorie.ctg_name){
                categorie0.products.add(product);
            }
        }
    }
    //we display the products first and then he chooses one of em, and he'll have the possiblity of reserving them.
    // in the main function, we create un panier (a list of products) and we add the reserved products to it.
    public void reserve(){

    }

    //Pour l'affichage du panier on prend la liste et on etire dessus puis utilise la méthode afficherProduit()

    //Methode vendre
    public int vendreSansRemise(ArrayList<Product> products){
        int sum = 0;
        for(Product product : products){
            sum = sum + product.prix;
            product.quantite--;
        }
        return sum;
    }
    //add the summ to la caisse

    public int retournerProduit(ArrayList<Product> products){
        int sum = 0;
        for(Product product : products){
            sum = sum + product.prix;
            search_In_DB(product.ref).quantite++;
        }
        return sum;
    }  //and then we substract the sum from la caisse

    

    
}

