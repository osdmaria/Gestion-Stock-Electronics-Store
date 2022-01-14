import java.util.Scanner;

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
        System.out.println("Caracteristiques:");
        for(String element: caracteristics){
            System.out.println(" -" + element);
        }
        System.out.println("Prix:"+ this.prix + "\n"
        + "Quantite:" + this.quantite);
        
    }



    public Boolean verifier_Produit_Dispo(){
        if(this.quantite==0){
            return false;
        }
        return true;
    }


    public int prixApresRemise(int montant_cumule, int remise){   //return le nouveau prix du PRODUIT
        return (int) (this.prix - (montant_cumule*remise*(0.01)) );      
    }


    
    public Product ajoutProduct(){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Entrer les informations du produit:");
        System.out.println("Nom:\n");
        String name = keyboard.nextLine();

        System.out.println("Reference:\n");
        int ref = keyboard.nextInt();
        keyboard.nextLine();

        
        String[] caracteristics = new String[3];
        System.out.println("Caracteristics: (3 only)\n");
        for(int i=0; i<3; i++){
            caracteristics[i] = keyboard.nextLine();
        }  

        System.out.println("Description:\n");
        String description1 = keyboard.nextLine();

        
        System.out.println("Prix:\n");
        int prix = keyboard.nextInt();

        System.out.println("Quantite:\n");
        int quantite = keyboard.nextInt();

        Product produit = new Product(name, ref, description1, caracteristics, prix, quantite);

        return produit;
    }

}