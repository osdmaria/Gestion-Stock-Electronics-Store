
import java.util.List;
import java.util.ArrayList;
public class DataBaseC{
 
    
public List<CompteClient> DB_client;
public   List<Client> DBC;






public DataBaseC(){
ArrayList<Rebrique> rebriques = new ArrayList<>();
DataBase db = new DataBase();
rebriques = db.rebriques;
ArrayList<CompteClient> c_clients = new ArrayList<CompteClient>();
c_clients.add(new CompteClient("Saadi","Mahdi",1325647,"El Achour",rebriques));
c_clients.get(0).getmontantcumule().get(0).montant_cumule_de_rebrique= 1000;   //We set le montant cumulé de la rebrique 1 de Saadi Mahdi à 1000 DA

c_clients.add(new CompteClient("Oussadi","Maria",2547869,"idk",rebriques));
c_clients.add(new CompteClient("Eren","Jager",142536,"Paradise Island",rebriques));
c_clients.add(new CompteClient("Gon","Freecss",417852,"Whale Island",rebriques));
this.DB_client=c_clients;
List<Client> clients = new ArrayList<Client>();
clients.add(new Client("Saadi","Mahdi",1325647,"22072002","El Achour"));
clients.add(new Client("Oussadi","Maria",2547869,"12345698","idk"));
clients.add(new Client("Eren","Jager",142536,"freedom","Paradise Island"));
clients.add(new Client("Gon","Freecss",417852,"myfatherisgone","Whale Island"));
this.DBC=clients ;
}

  public List<Client> getClients(){
      return this.DBC;
  }

  public List<CompteClient> getCClients(){
      return this.DB_client;
  }





  public  CompteClient LoginClient(String nom ,String prenom,String mdp){
      

    for(int i=0;i<DBC.size();i++){
              if(nom==DBC.get(i).getnom() && prenom==DBC.get(i).getprenom() && DBC.get(i).getmdp()==mdp){ 
                    return DB_client.get(i);
              }  
      }
     return null;
  }

   public CompteClient searchClient(int ref){
       for(int i=0; i<DB_client.size();i++){
           if(DB_client.get(i).getref()==ref){
            return DB_client.get(i);
           }
       }
       System.out.println("Compte client n'existe pas dans la base de donnee");
       return null;
   }

   public void addCClient(CompteClient client){
    DB_client.add(client);
}

public static void main(String[] args){

   DataBaseC db = new DataBaseC();
    //CompteClient compte = db.search(2547869);
    /*if(compte!=null){
        System.out.println("trouver");
        compte.AfficheCompte();
    }*/
   
  //  Client client = new Client("Saadi","Mahdi",1325647,"22072002","El Achour");
    

    CompteClient compte =   db.LoginClient("Gon","Freecss","myfatherisgone");

    if(compte!=null){
        System.out.println("there's your account") ;
        compte.AfficheCompte();
    }else{
        System.out.println("pfff");
    }
     
}
}