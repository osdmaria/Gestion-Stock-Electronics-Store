import java.util.ArrayList;

public class CompteClient{
    private String nom;
    private String prenom;
    private int ref;
    private String adresse;
    private String mdp;
    private ArrayList<Rebrique> m_rebriques;

    public CompteClient(){}
    
    
    public CompteClient(String nom, String prenom, int ref, String mdp , String adresse, ArrayList<Rebrique> m_rebriques){
        this.nom = nom;
        this.prenom = prenom;
        this.ref = ref;
        this.mdp = mdp;
        this.adresse = adresse;
        this.m_rebriques = m_rebriques;
    }
     



   
    
     public void AfficheCompte(){
        System.out.println("Nom : "+this.nom+
        "  Prenom : "+this.prenom+
        "  Ref : "+this.ref+
        "  Adresse : "+this.adresse+
        "  montant Cumule : "+this.m_rebriques.get(0).montant_cumule_de_rebrique + this.m_rebriques.get(1).montant_cumule_de_rebrique + this.m_rebriques.get(2).montant_cumule_de_rebrique);
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
    public String getMpd(){
        return mdp;
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