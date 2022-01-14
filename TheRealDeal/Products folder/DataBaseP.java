import java.util.ArrayList;


public class DataBaseP {

    Stock DB_stock = new Stock();
    ArrayList<Rebrique> rebriques = new ArrayList<>(); 
    Rebrique rebrique1 = new Rebrique("Rebrique 01", 0);
    Rebrique rebrique2 = new Rebrique("Rebrique 02", 0);
    Rebrique rebrique3 = new Rebrique("Rebrique 03", 0);

    public Stock getStock(){
        return this.DB_stock;
    }
    public void setStock(Stock stock){
        this.DB_stock = stock;
    }

    //constructor 

    public DataBaseP() {
        

        Categories Informatique = new Categories("Informatique");
        Categories Mobiles = new Categories("Mobiles");
        Categories Electronique = new Categories("Electronique");
        Categories Electromenager = new Categories("Electromenager");
        Categories Kits_scolaires = new Categories("kit scolaires");

        Stock stock = new Stock();

        Rebrique reb1= new Rebrique("Rebrique 01", 0);
        Rebrique reb2= new Rebrique("Rebrique 02", 0);
        Rebrique reb3= new Rebrique("Rebrique 03", 0);

        //Categorie informatique
        stock.categories.add(Informatique);

        String[] caracteristics = new String[]{"Proccessor : Ryzen AMD", "RAM : 16 GB", "Disque Dur : 512 GB SSD " ,"Carte graphique : Asus GTX 1660 "};
        Informatique.products.add(new Product("Ordinateur Gamer", 1001, "Ceci est un PC, puissant et très conseillé aux gamers",caracteristics, 161000, 7));

        String[] caracteristics0 = new String[]{"Proccessor intel CORE i7 8th Gen", "RAM 8 GB ", "Disque Dur : 1T HDD","Carte graphique : nvidia"};
        Informatique.products.add(new Product("Ordinateur de Bureau", 1002, "Ceci est un PC, puissant et très conseillé aux gamers",caracteristics0, 172500, 11));

        String[] caracteristics01 = new String[]{"Proccessor : M1 ", "RAM 8 Go ", "Disque Dur : 256 Go","Carte graphique : Integre"};
        Informatique.products.add(new Product("PC Portable APPLE MacBook Pro 2020", 1003, "Ceci est un PC, puissant et très conseillé aux gamers",caracteristics01, 2800, 4));



        //Categorie Mobiles
        stock.categories.add(Mobiles);

        String[] caracteristics1 = new String[]{"Processor : Exynos 990 Samsung", "Camera : 108 MPx", "Taille de l'ecran : 6.9 pouces", "RAM : 12Go","Batterie : 5000 mAh"};
        Mobiles.products.add(new Product("Samsung Galaxy S20 Ultra", 2001, "ceci est un telephone très puissant et performant",caracteristics1, 60000, 22));

        String[] caracteristics11 = new String[]{"Processor : A13 Bionic Apple", "Camera : 12 MPx", "Taille de l'ecran : 6.5 pouces", "RAM : 4 Go","Batterie : 3969 mAh"};
        Mobiles.products.add(new Product("IPhone Pro Max ", 2002, "Un smartphone avec un design tres chic et moderne, parfait pour toutes sortes d'utilisations",caracteristics11, 50400, 20));

    
        //Categorie Electronique
        stock.categories.add(Electronique);

        String[] caracteristics2 = new String[]{"Taille : 50 Pouces ", "Categorie :LED","Definition : UHD 4K", "Resolution : 3840x2160 px"};
        Electronique.products.add(new Product("Television LG ", 3001, "Un televiseurs pour les familles avec un prix tres interessant",caracteristics2, 42000, 17));

        String[] caracteristics21 = new String[]{"Taille : 50 Pouces ","Categorie :LED", "Definition : UHD 4K", "Resolution : 3840x2160 px"};
        Electronique.products.add(new Product("Television Samsung ", 3002, "Un televiseurs pour les familles avec un prix tres interessant",caracteristics21, 47000, 19));
        

        // Categorie Electromenager
        stock.categories.add(Electromenager);

        String[] caracteristics3 = new String[]{ "Largeur/Hauteur/Profondeur : 88.5/28.5/20.5","Poids : 10" ,"Categorie : Split", "Capacite de chauffage et refroidissement : 12000 Btu", " "};
        Electromenager.products.add(new Product("Climatiseur LG", 4001, "Un climatiseurs pour refroidir vos mois d'été, pour plus de fraicheur",caracteristics3, 15200, 9));

        String[] caracteristics31 = new String[]{"Largeur/Hauteur/Profondeur : 73.5/187/267.5","Categorie : 2 portes","Capacite total : 499 Litres (Refrigerateur: 354L / Congelateur: 95L) ", };
        Electromenager.products.add(new Product("Refrigerateur Brandt",4002,"Un refrigerateur de haute gamme, parfait pour les familles nombreuse",caracteristics31,23000,9));

        //Kts scolaires
        stock.categories.add(Kits_scolaires);

        String[] caracteristics4 = new String[]{"Puissance nominale : 20 W", "Tension nominale : 12 V", "Courant : 1.11 A ","Duree de vie : > a 15 ans "};
        Kits_scolaires.products.add(new Product("Panneau solaire ",5001 , "Paneau solaire effecti pour toute puissance de lumières ",caracteristics4, 20000, 16));

        String[] caracteristics41 = new String[]{"Tension : 12 V", "Capacite : 100 Ah", "Duree de vie : 900 cycles "};
        Kits_scolaires.products.add(new Product("Batterie solaire ",5002 , "Elle fait un truc",caracteristics41, 10020, 14));


        this.DB_stock = stock;


        reb1.rebriques.addAll(Informatique.products);
        reb1.rebriques.addAll(Mobiles.products);
        reb2.rebriques.addAll(Electronique.products);
        reb2.rebriques.addAll(Electromenager.products);
        reb3.rebriques.addAll(Kits_scolaires.products);
        

        this.rebrique1 = reb1;
        this.rebrique2 = reb2;
        this.rebrique3 = reb3;
        //create an arraylist of rebriques
        this.rebriques.add(reb1);
        this.rebriques.add(reb2);
        this.rebriques.add(reb3);
 

        

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

    public Rebrique search_Rebrique_DB(int ref){
        for (Product pr : this.rebrique1.rebriques){
            if(pr.ref == ref){
                return rebrique1;
            }
        }
        for (Product pr : this.rebrique2.rebriques){
            if(pr.ref == ref){
                return rebrique2;
            }
        }
        for (Product pr : this.rebrique3.rebriques){
            if(pr.ref == ref){
                return rebrique3;
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

