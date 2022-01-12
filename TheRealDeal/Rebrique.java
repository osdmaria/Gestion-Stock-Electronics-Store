import java.util.ArrayList;

public class Rebrique {
    
    public ArrayList<Product> rebriques = new ArrayList<>();
    String reb_N; 

    public Rebrique(String name){
        reb_N = name;
    }


    public void remiseDispo(){ //boolean type tho
        //verifies from the client if he has un montant cumulé dans les rebriques, si oui we apply le taux dans la fonction suivante
    }

    public int remiseTaux(){
        DataBase db = new DataBase();
        int taux_Remise = 0;
        if(this.reb_N == db.rebrique1.reb_N){
            taux_Remise = 5;
        }
        if(this.reb_N == db.rebrique2.reb_N){
            taux_Remise = 10;
        }
        if(this.reb_N == db.rebrique3.reb_N){
            taux_Remise = 15;
        }
        return taux_Remise;
    }

    public int prixApresRemise(Product produit, int remise){   //return le nouveau prix du PRODUIT
        return produit.prix*remise*(1/100) + produit.prix;      
    }

}
