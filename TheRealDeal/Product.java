
public class Product{
    protected String name;
    protected int ref;
    protected String description;
    protected String[] caracteristics;
    protected int prix;
    protected int quantite;

    Product(){

    }
    Product(String name, int ref, String description, String[] caracteristics, int prix, int quantite){
        this.name = name;
        this.ref = ref;
        this.description = description;
        this.caracteristics = caracteristics;
        this.prix= prix;
        this.quantite = quantite;
    }

    //getters
    public String getName(){
        return name;}
    
    public int getRef(){
        return ref;
    }
    public int getPrix(){
        return prix;
    }
    public int getQuantite(){
        return quantite;
    }
    

    //setters

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }
    public void setPrix(int prix){
        this.prix = prix;
    }

    public void affiche_produit(){
        System.out.println("Nom Du Produit:" + this.name + "\n" +
        "Reference:" + this.ref + "\n" +
        "Description:" + this.description);
        System.out.println("Caractéristiques:");
        for(String element: caracteristics){
            System.out.println(" -" + element);
        }
        System.out.println("Prix:"+ this.prix + "\n"
        + "Quantité:" + this.quantite);
        
    }



    public Boolean verifier_Produit_Dispo(){
        if(this.quantite==0){
            System.out.println("Vous ne pouvez pas le réserver, il est en rupture de stock. Revenez ulterieurement.");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
         String[] caracteristics = new String[]{"this", "that", "dccc"};
        Product p = new Product("kfj", 1354, "ldkfmsl",caracteristics, 1000, 13);

        p.affiche_produit();
    }
}