package bean;

import dao.DaoFactory;
import model.Client;
import model.Role;
import model.Ville;

import java.util.ArrayList;

public class ClientBean {

    private ArrayList<Client> listeClients;


    public ClientBean() {
        listeClients = DaoFactory.getClientDAO().getAll();
    }


    public boolean isValidConnection(String mail, String mdp){
        Client client = DaoFactory.getClientDAO().searchConnexion(mail, mdp);
        if (client == null){
            return false;
        }
        return true;
    }

    public ArrayList<Client> getListeClients() {
        return listeClients;
    }

    public void setListeClients(ArrayList<Client> listeClients) {
        this.listeClients = listeClients;
    }
}
