import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Client{
    private static final Client Client = null;
    private String nom;
    private String prenom;
    private int refc;
    private String adresse;

    

     Scanner userInput = new Scanner (System.in);
    /*public void toString() {
        return "nom"+this.getnom+"prenom"+this.getprenom+" ref"+this.getref+" adresse"+this.getadresse;
    }*/
    public Client (){}
    
    public Client(String nom,String prenom,int refc,String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.refc = refc;
        this.adresse = adresse;
    }

    void affich(){
        System.out.println("nom :"+nom+" prenom :"+prenom+" ref :"+refc+" adresse :"+adresse);
    }

    public String getnom() {
        return nom;
        }

    public String getprenom() {
        return prenom;
    }
    
    public int getref() {
        return refc;
    }


    public String getadresse() {
        return adresse;
    }

    public Client getClient() {
        return Client;
    }

    
   



     /*public void Affcompte(int refc){

         CompteClient compte = new CompteClient();

         for(int i=0;i<clients.size();i++){
             if(clients.get(i).getref().equals(refc)){
                //compte.AfficheCompte();
                System.out.println("its here");
             }
         }*/



     }



