package bean;

import dao.DaoFactory;
import model.Client;
import model.Role;
import model.Ville;

import java.util.ArrayList;

public class ClientBean {

    private ArrayList<Client> listeClients;


    public ClientBean() {
        Client client1 = new Client();

        client1.setDenominationSociale("Occaz'en Nord");
        client1.setMailClient("jasonbailleul59@laposte.net");
        client1.setNumeroRueCLient("50");
        client1.setLibelleRueClient("Boulevard de la Tour");
        client1.setComplementAdresseClient("Appt 3");
        client1.setCodePostalClient("59100");
        client1.setNumeroTva("FR123245898390");
        client1.setNumTelClient("0780552023");
        client1.setPassword("password");

        client1.getRole().setId_role(2);
        client1.setVille(new Ville("Paris"));
        client1.getVille().getPays().setId_pays(20);
        DaoFactory.getVilleDAO().insert(client1.getVille());
        DaoFactory.getClientDAO().insert(client1);

    }


    public ArrayList<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(ArrayList<Client> listeClients) {
        this.listeClients = listeClients;
    }
}
