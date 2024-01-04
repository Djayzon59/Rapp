package bean;

import dao.DaoFactory;
import model.Etablissement;

import java.util.ArrayList;

public class EtablissementBean {

    private ArrayList<Etablissement> listeEtablissements;


    public EtablissementBean() {


        Etablissement etablissement = new Etablissement();

        etablissement.setLibelleEtablissement("L'Elysée");
        etablissement.setNumeroRueEtablissement("11");
        etablissement.setLibelleRueEtablissement("Boulevard des Champs Elysée");
        etablissement.setComplementAdresseEtablissement("Appartement 4");
        etablissement.setCodePostalEtablissement("75000");
        etablissement.setNumeroIdentification("FR987978799");
        etablissement.setLatitude("12.14.505.6");
        etablissement.setLongitude("09.56.780.8");
        etablissement.setNumMobileEtablissement("0612131415");
        etablissement.setNumFixeEtablissement("0340789035");
        etablissement.getEmploye().setId_employe(20);
        etablissement.getClient().setId_client(7);
        etablissement.getVille().setId_ville(2);
        DaoFactory.getEtablissementDAO().insert(etablissement);
    }

    public ArrayList<Etablissement> getListeEtablissements() {
        return listeEtablissements;
    }

    public void setListeEtablissements(ArrayList<Etablissement> listeEtablissements) {
        this.listeEtablissements = listeEtablissements;
    }
}
