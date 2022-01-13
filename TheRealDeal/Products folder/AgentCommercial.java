
import java.util.Scanner;
public class AgentCommercial{
    private int id;

     Scanner userInput = new Scanner (System.in);
    


    public AgentCommercial(int id){
        this.id =id;
        
    }

    
public CompteClient createCompteClient () {
    
    
    CompteClient client1 = new CompteClient();

     System.out.println("Add new client: ");
        
                System.out.println("donner les informations du client: ");

                System.out.println("donner le nom du client :");
                client1.setnom(userInput.next());

                System.out.println("donner le prenom du client :");
                client1.setprenom(userInput.next());

                System.out.println("donner la ref du client :");
                client1.setref(userInput.nextInt());

                System.out.println("donner l'adresse du client :");
                client1.setadresse(userInput.next());

                
                // client1.setmontant();

                System.out.println("Votre compte a ete creer .");

        return client1;
}

}
