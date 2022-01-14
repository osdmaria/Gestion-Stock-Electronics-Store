
import java.util.List;
import java.util.ArrayList;
public class DataBaseC{
 
    
public List<CompteClient> DB_client;
public   List<Client> DBC;






public DataBaseC(){
ArrayList<Rebrique> rebriques = new ArrayList<>();
DataBaseP db = new DataBaseP();
rebriques = db.rebriques;
ArrayList<CompteClient> c_clients = new ArrayList<CompteClient>();
c_clients.add(new CompteClient("Saadi","Mahdi",1325647,"22072002","El Achour",rebriques));
c_clients.get(0).getmontantcumule().get(0).montant_cumule_de_rebrique= 0;   //We set le montant cumulé de la rebrique 1 de Saadi Mahdi à 1000 DA


c_clients.add(new CompteClient("Oussadi","Maria",2547869,"12345698","Bordj El Kiffan",rebriques));
c_clients.get(1).getmontantcumule().get(2).montant_cumule_de_rebrique= 3000;     //Oussadi Maria a desormais un montant cumulé de 3000 da dans la 3eme rebrique
c_clients.get(1).getmontantcumule().get(1).montant_cumule_de_rebrique= 1000;        //un montant cumulé de 1000 DA dans la 2eme rebrique

c_clients.add(new CompteClient("Eren","Jager",142536,"freedom","Paradise Island",rebriques));
c_clients.get(2).getmontantcumule().get(2).montant_cumule_de_rebrique= 2500;  

c_clients.add(new CompteClient("Gon","Freecss",417852,"myfatherisgone","Whale Island",rebriques));
c_clients.get(3).getmontantcumule().get(0).montant_cumule_de_rebrique= 2500;  
c_clients.get(3).getmontantcumule().get(1).montant_cumule_de_rebrique= 1000;  
c_clients.get(3).getmontantcumule().get(2).montant_cumule_de_rebrique= 500;  

this.DB_client=c_clients;
List<Client> clients = new ArrayList<Client>();
clients.add(new Client("Saadi","Mahdi",1325647,"El Achour"));
clients.add(new Client("Oussadi","Maria",2547869,"Bordj El Kiffan"));
clients.add(new Client("Eren","Jager",142536,"Paradise Island"));
clients.add(new Client("Gon","Freecss",417852,"Whale Island"));
this.DBC=clients ;
}

  public List<Client> getClients(){
      return this.DBC;
  }

  public List<CompteClient> getCClients(){
      return this.DB_client;
  }





  public  CompteClient LoginClient(String nom ,String prenom,String mdp){
    for(CompteClient client : this.DB_client){
        if (client.getnom().equals(nom) && client.getprenom().equals(prenom) && client.getMpd().equals(mdp)){
            return client;
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


}