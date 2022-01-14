import java.util.ArrayList;

public class CompteClient{
    private String nom;
    private String prenom;
    private int ref;
    private String adresse;
    private ArrayList<Rebrique> m_rebriques;

    public CompteClient(){}
    
    
    public CompteClient(String nom, String prenom, int ref, String adresse, ArrayList<Rebrique> m_rebriques){
        this.nom = nom;
        this.prenom = prenom;
        this.ref = ref;
        this.adresse = adresse;
        this.m_rebriques = m_rebriques;
    }
     



   
    
     public void AfficheCompte(){
        System.out.println("Nom : "+this.nom+
        " \n Prenom : "+this.prenom+
        " \n Ref : "+this.ref+
        "  \nAdresse : "+this.adresse+
        "  \nmontant Cumule : "+this.m_rebriques);
    }

    public String getnom() {
        return nom;
    }

    public String getprenom() {
        return prenom;
    }

    public int getref() {
        return ref ;
    }

    public String getadresse(){
        return adresse;
    }

    public ArrayList<Rebrique> getmontantcumule(){
        return m_rebriques;
    }
    
    public void setnom(String nom){
        this.nom = nom;
    }

    public void setprenom(String prenom){
        this.prenom = prenom;
    }

    public void setref(int ref){
        this.ref = ref;
    }

    public void setadresse(String adresse){
        this.adresse = adresse;
    }

    public void setmontant(ArrayList<Rebrique> m_rebriques){
        this.m_rebriques= m_rebriques;
    }




}