import java.util.ArrayList;

public class Rebrique {
    
    public ArrayList<Product> rebriques = new ArrayList<>();
    String reb_N; 
    int montant_cumule_de_rebrique;

    public Rebrique(String name, int mt){
        reb_N = name;
        montant_cumule_de_rebrique = mt;
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

    


    
}
